package com.project.dao.receptionist;

import javax.transaction.Transactional;

import com.project.dao.person.SearchPersonDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.dao.LoginDao;
import com.project.entity.Patient;

@Component
public class SearchPatientDao extends SearchPersonDao
{
	@Autowired
	SessionFactory sf;
	@Autowired
	LoginDao infoLog;

	@Transactional
	public String searchDoctorAssigned(String eid)
	{
		try{
			infoLog.logActivities("in SearchPatientDao-searchDoctorAssigned: got= "+eid);
			
			Session session= sf.getCurrentSession();
			Query q1=session.createQuery("select name.firstName,name.lastName from Employee where eid= :id");
			q1.setParameter("id", eid);
			String dname="";
			
			Object o[]=(Object[]) q1.uniqueResult();
				for(Object obj:o)
				{
					infoLog.logActivities(""+obj);
					String name=" "+(String) obj;
					dname+=name;
				}
				infoLog.logActivities("in SearchPatientDao-searchDoctorAssigned: found= "+dname);	
			return dname;
			}
			catch(Exception e)
			{ 
				infoLog.logActivities("in SearchPatientDao-searchDoctorAssigned: "+e);
				return null;
			}
			
	}
		
}
