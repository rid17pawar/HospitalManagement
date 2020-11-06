package com.project.dao.opd;

import java.awt.List;
import java.util.ArrayList;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.dao.LoginDao;
import com.project.dao.receptionist.SearchPatientDao;
import com.project.entity.Opd;
import com.project.entity._OpdRecord;

@Component
public class OpdDetailsDao 
{
	@Autowired
	SessionFactory sf;
	
	@Autowired
	LoginDao infoLog;
	
	@Transactional
	public ArrayList<_OpdRecord> opdQueue() 
	{
		infoLog.logActivities("in OpdDetailsDao-opdQueue:");
		
		Session session= sf.getCurrentSession();
		Query q1= session.createQuery("from Opd where status= :s");	//HQL use classname not tablename
		q1.setParameter("s", 1);
		
		try {
		    ArrayList<Opd> l1=(ArrayList<Opd>) q1.list();
		    
		    ArrayList<_OpdRecord> opdQueue= new ArrayList<_OpdRecord>();
			    for(Opd opd1: l1)
			    {
			    	_OpdRecord r1= new _OpdRecord();
			    	r1.setDoctorId(opd1.getDoctorId());
			    	r1.setDoctorName(searchDoctorAssigned(opd1.getDoctorId()));
			    	r1.setPid(opd1.getPid());
			    	r1.setPatientName(searchPatientName(opd1.getPid()));
			    	
			    	opdQueue.add(r1);
			    }
		   	return opdQueue;
		   	
			}
		catch(Exception e)
		{
			infoLog.logActivities("in OpdDetailsDao-opdQueue: "+e);
			return null;
		}
	}

	@Transactional
	private String searchPatientName(String pid) 
	{
		infoLog.logActivities("in opdDetails searchpatientname");
		Session session= sf.getCurrentSession();
		Query q1=session.createQuery("select name.firstName,name.lastName from Patient where pid= :id");
		q1.setParameter("id", pid);
		String pname="";
		try 
		{
				Object o[]=(Object[]) q1.uniqueResult();
				for(Object obj:o)
				{
					infoLog.logActivities(""+obj);
					String name=" "+(String) obj;
					pname+=name;
				}
			}
			catch(Exception e)
			{ 
				infoLog.logActivities("error in finding patient name "+e);
			  return null;
			}
		return pname;
	}
	
	@Transactional
	public String searchDoctorAssigned(String eid)
	{
		infoLog.logActivities("in searchpatientd searchdoctorname");
		Session session= sf.getCurrentSession();
		Query q1=session.createQuery("select name.firstName,name.lastName from Employee where eid= :id");
		q1.setParameter("id", eid);
		String dname="";
		try 
		{
				Object o[]=(Object[]) q1.uniqueResult();
				for(Object obj:o)
				{
					infoLog.logActivities(""+obj);
					String name=" "+(String) obj;
					dname+=name;
				}
			}
			catch(Exception e)
			{ 
				infoLog.logActivities("error in finding doctor name "+e);
			  return null;
			}
		return dname;
	}

}
