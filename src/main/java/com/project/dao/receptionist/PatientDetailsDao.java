package com.project.dao.receptionist;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.project.entity.Patient;

@Component
public class PatientDetailsDao 
{
	@Autowired
	SessionFactory sf;
	
	@Transactional
	public Patient show(String pid)
	{
		System.out.println("in PatientDetailsDao-show: got= "+pid);
		
		Session session= sf.getCurrentSession();
		Query q1=session.createQuery("from Patient where pid= :id");
		q1.setParameter("id", pid);

		try {
			Patient temp= (Patient) q1.uniqueResult();
			System.out.println("in PatientDetailsDao-show: found= "+temp);
			return temp;
			}
		catch(Exception e)
		{
			System.out.println("in PatientDetailsDao-show: "+e);
			return null;
		}
	}

	
}
