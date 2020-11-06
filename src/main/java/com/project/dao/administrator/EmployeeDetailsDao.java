package com.project.dao.administrator;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.project.dao.LoginDao;
import com.project.entity.Employee;

@Component
public class EmployeeDetailsDao 
{
	@Autowired
	SessionFactory sf;
	
	@Autowired
	LoginDao infoLog;
	
	@Transactional
	public Employee show(String eid)
	{
		infoLog.logActivities("in EmployeeDetailsDao-show: got= "+eid);
		
		Session session= sf.getCurrentSession();
		Query q1=session.createQuery("from Employee where eid= :id");
		q1.setParameter("id", eid);

		try 
		{
			Employee temp= (Employee) q1.uniqueResult();
			infoLog.logActivities("in EmployeeDetailsDao-show: found= "+temp);
			return temp;
		}
		catch(Exception e)
		{
			infoLog.logActivities("in EmployeeDetailsDao-show: "+e);
			return null;
		}
	}

}
