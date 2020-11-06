package com.project.dao.administrator;

import java.util.Date;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.dao.LoginDao;
import com.project.entity.Address;
import com.project.entity.Employee;
import com.project.entity.Name;

@Component
public class EditEmployeeDao 
{
	@Autowired
	SessionFactory sf;
	
	@Autowired
	LoginDao infoLog;
	
	@Transactional
	public int edit(String eid, Name name, String birthdate, String gender, String emailId, Long mobileNo, Long adharNo, String country, String state, String city, Address address, String role, String qualification, String specialization)
	{
		//only enabled fields values is updated ..
		infoLog.logActivities("in EditEmployeeDao-edit: got= "+eid+" "+name+" "+birthdate+" "+gender+" "+emailId+" "+mobileNo+" "+adharNo+" "+country+" "+state+" "+city+" "+address+" "+role+" "+qualification+" "+specialization);
		
		Session session= sf.getCurrentSession();
		Query q1=session.createQuery("update Employee set name.firstName= :t1, name.middleName= :t2, name.lastName= :t3, birthdate= :t4, emailId= :t5, mobileNo= :t6, country= :t7, state= :t8, city=:t9, address.residentialAddress= :t10, qualification= :t12, specialization= :t13 where eid= :id");
		q1.setParameter("t1", name.getFirstName());
		q1.setParameter("t2", name.getMiddleName());
		q1.setParameter("t3", name.getLastName());
		q1.setParameter("t4", birthdate);
		q1.setParameter("t5", emailId);
		q1.setParameter("t6", mobileNo);
		q1.setParameter("t7", country);
		q1.setParameter("t8", state);
		q1.setParameter("t9", city);
		q1.setParameter("t10", address.getResidentialAddress());
		q1.setParameter("t12", qualification);
		q1.setParameter("t13", specialization);
		q1.setParameter("id", eid);
		
		try {
			int res= q1.executeUpdate();
			infoLog.logActivities("in EditEmployeeDao-edit: found= "+res);
			return res;
			}
		catch(Exception e)
		{
			infoLog.logActivities("in logindao-validate: "+e);
			return 0;
		}
	}
	
}
