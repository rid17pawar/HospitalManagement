package com.project.dao.receptionist;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.dao.LoginDao;
import com.project.entity.Address;
import com.project.entity.Name;

@Component
public class EditPatientDao 
{
	@Autowired
	SessionFactory sf;
	@Autowired
	LoginDao infoLog;

	@Transactional
	public int edit(String pid, Name name, String birthdate, String gender, String emailId, Long mobileNo, Long adharNo,String country, String state, String city, Address address, String bloodGroup, String chronicDiseases,String medicineAllergy, String doctorId) 
	{
		//only enabled fields values is updated ..
		infoLog.logActivities("in EditPatientDao-edit: got= "+pid+" "+name+" "+birthdate+" "+gender+" "+emailId+" "+mobileNo+" "+adharNo+" "+country+" "+state+" "+city+" "+address+" "+bloodGroup+" "+chronicDiseases+" "+medicineAllergy+" "+doctorId);
				
		Session session= sf.getCurrentSession();
		Query q1=session.createQuery("update Patient set name.firstName= :t1, name.middleName= :t2, name.lastName= :t3, birthdate= :t4, emailId= :t5, mobileNo= :t6, country= :t7, state= :t8, city=:t9, address.residentialAddress= :t10, chronicDiseases= :t13, medicineAllergy= :t14, doctorId= :t15 where pid= :id");
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
		q1.setParameter("t13", chronicDiseases);
		q1.setParameter("t14", medicineAllergy);
		q1.setParameter("t15", doctorId);
		q1.setParameter("id", pid);

		try{
			int res= q1.executeUpdate();
			infoLog.logActivities("in EditPatientDao-edit: update status="+res);
			return res;
			}
		catch(Exception e)
		{
			infoLog.logActivities("in EditPatientDao-edit: "+e);
			return 0;
		}
	}
	
}
