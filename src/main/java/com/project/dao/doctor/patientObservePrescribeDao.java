package com.project.dao.doctor;

import java.util.Date;

import javax.transaction.Transactional;

import com.project.dao.opd.OpdDetailsDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.dao.LoginDao;
import com.project.entity.Opd;
import com.project.entity.OpdDetails;
import com.project.entity.Patient;

@Component
public class patientObservePrescribeDao 
{
	@Autowired
	SessionFactory sf;
	
	@Autowired
	LoginDao infoLog;

	@Autowired
	OpdDetailsDao opdDetailsDao;
	
	@Transactional
	public int add(OpdDetails patientcase,String pid) 
	{
		infoLog.logActivities("in addpatientcasedao "+patientcase);
		Session session= sf.getCurrentSession();
		Query q1=session.createQuery("from Opd where pid= :i AND status= :s");
		q1.setParameter("i", pid);
		q1.setParameter("s", 1); //pending status
		
		try 
		{
			Opd opd= (Opd) q1.uniqueResult();
			infoLog.logActivities(""+opd);

				int opdid=opd.getOpdId();
				if(opdid!=0)
				{
					opdDetailsDao.savePatientOpdDetails(session,patientcase,opdid);

				return opdid;
				}	
				else
				{
					throw new Exception();
				}
			}
			catch(Exception e)
			{ 
				infoLog.logActivities("error in finding opdid "+e);
			  return 0;
			}		
	     }

}
