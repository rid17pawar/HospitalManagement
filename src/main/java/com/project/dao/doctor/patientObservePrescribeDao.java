package com.project.dao.doctor;

import java.util.Date;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.entity.Opd;
import com.project.entity.OpdDetails;
import com.project.entity.Patient;

@Component
public class patientObservePrescribeDao 
{
	@Autowired
	SessionFactory sf;
	
	@Transactional
	public int add(OpdDetails patientcase,String pid) 
	{
		System.out.println("in addpatientcasedao "+patientcase);
		Session session= sf.getCurrentSession();
		Query q1=session.createQuery("from Opd where pid= :i AND status= :s");
		q1.setParameter("i", pid);
		q1.setParameter("s", 1); //pending status
		
		try 
		{
			Opd opd= (Opd) q1.uniqueResult();
				System.out.println(opd);
		
				if(opd.getOpdId()!=0)
				{				
				patientcase.setOpdid(opd.getOpdId());
				
				session.save(patientcase);
				
				int opdid=opd.getOpdId();
				return opdid;
				}	
				else
				{
					throw new Exception();
				}
			}
			catch(Exception e)
			{ 
			  System.out.println("error in finding opdid "+e);
			  return 0;
			}		
	     }

}
