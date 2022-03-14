package com.project.dao.opd;

import java.util.Date;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.dao.LoginDao;
import com.project.entity.Employee;
import com.project.entity.Opd;

@Component
public class AddOpdDao 
{
	@Autowired
	SessionFactory sf;
	
	@Autowired
	LoginDao infoLog;
	
	@Transactional
	public int add(Opd q) 
	{
		Date current= new Date();
		q.setVisitDate(current);
		
		infoLog.logActivities("in AddOpdDao-add: got= "+q);
		Session session= sf.getCurrentSession();
		
		try 
		{
			
			Query q2=session.createQuery("select count(eid) from Employee where eid=:e AND status=:s");
			q2.setParameter("e", q.getDoctorId());
			q2.setParameter("s", 1);
			Long i=(Long)q2.uniqueResult();
			infoLog.logActivities("doctor exists: "+i);
			
			if(i==1)
			{
				Query q1= session.createQuery("select count(pid) from Opd where pid=:p AND status= :s");	//HQL use classname not tablename
				q1.setParameter("p", q.getPid());
				q1.setParameter("s", 1);
				Long o=(Long) q1.uniqueResult();
				if(o==0)
				{
					session.save(q);
					return 1;					
				}
				else
				{
					return 2;
				}
			}
			else
			{
				return 3;
			}
		}
		catch(Exception e)
		{
			infoLog.logActivities("in  AddOpdDao-add: "+e);
			return 0;
		}	
	}

	@Transactional
	public String getDoctorId(String pid) 
	{
		infoLog.logActivities("in AddOpdDao-getDoctorId: got="+pid);
		
		Session session= sf.getCurrentSession();
		Query q1=session.createQuery("select doctorId from Patient where pid= :id");
		q1.setParameter("id", pid);
		
		try 
		{
			String doctorId=(String) q1.uniqueResult();
			return doctorId;
		}
		catch(Exception e)
		{
			infoLog.logActivities("in AddOpdDao-getDoctorId: "+e);
			return null;
		}	
	}
	
}
