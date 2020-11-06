package com.project.dao.administrator;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.dao.LoginDao;
import com.project.entity.Employee;

@Component
public class DeleteEmployeeDao 
{
	@Autowired
	SessionFactory sf;
	
	@Autowired
	LoginDao infoLog;
	
	@Transactional
	public int delete(String eid) 
	{
		try
		{
			infoLog.logActivities("in DeleteEmployeeDao-delete: got="+eid);
			
			Session session= sf.getCurrentSession();
			
			Query q1=session.createQuery("update Employee set status=:g where eid= :id");
			q1.setParameter("g", 0);
			q1.setParameter("id", eid);
			q1.executeUpdate(); 

			q1=session.createQuery("delete from Opd where doctorId= :id AND status=1");
			q1.setParameter("id", eid);
			int res= q1.executeUpdate();
			
			//login table
			q1=session.createQuery("delete from Login where id= :id");
			q1.setParameter("id", eid);
			res= q1.executeUpdate();
			 
			 return res;
		}
		catch(Exception e)
		{
			infoLog.logActivities("in DeleteEmployeeDao-delete: "+e);
			return 0;
		} 
	}

}
