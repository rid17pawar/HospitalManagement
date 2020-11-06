package com.project.dao.doctor;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.dao.LoginDao;
import com.project.entity.Opd;
import com.project.entity.Patient;
import com.project.entity._OpdRecord;

@Component
public class DopdDetailsDao 
{
	@Autowired
	SessionFactory sf;
	
	@Autowired
	LoginDao infoLog;
	
	@Transactional
	public ArrayList<Patient> dopdQueue(String doctorId) 
	{
		infoLog.logActivities("in DopdDetailsDao-dopdQueue: got= "+doctorId);
		
		Session session= sf.getCurrentSession();
		Query q1= session.createQuery("select pid from Opd where status=1 AND doctorId= :id");	//HQL use classname not tablename
	    q1.setParameter("id", doctorId);
	    
	    try
	    {
		    ArrayList<String> lst=(ArrayList<String>) q1.list();
		    
		    ArrayList<Patient> patients= new ArrayList<Patient>();
		    for(String pid: lst)
		    {
		      Query q2= session.createQuery("from Patient where pid= :id");	
			  q2.setParameter("id", pid);
			  Patient p= (Patient) q2.uniqueResult();
			  patients.add(p);
		    }
		   	return patients;
	    }
	    catch(Exception e)
		{
	    	infoLog.logActivities("in DopdDetailsDao-dopdQueue: "+e);
			return null;
		}
	}

}
