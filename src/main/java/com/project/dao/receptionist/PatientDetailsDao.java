package com.project.dao.receptionist;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.dao.LoginDao;
import com.project.entity.Patient;

@Component
public class PatientDetailsDao 
{
	@Autowired
	SessionFactory sf;
	@Autowired
	LoginDao infoLog;
	
	@Transactional
	public Patient show(String pid)
	{
		infoLog.logActivities("in PatientDetailsDao-show: got= "+pid);
		
		Session session= sf.getCurrentSession();
		Query q1=session.createQuery("from Patient where pid= :id");
		q1.setParameter("id", pid);

		try {
			Patient temp= (Patient) q1.uniqueResult();
			infoLog.logActivities("in PatientDetailsDao-show: found= "+temp);
			return temp;
			}
		catch(Exception e)
		{
			infoLog.logActivities("in PatientDetailsDao-show: "+e);
			return null;
		}
	}

	
}
