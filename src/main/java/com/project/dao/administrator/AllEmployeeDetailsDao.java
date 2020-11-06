package com.project.dao.administrator;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.dao.LoginDao;
import com.project.entity.Employee;
import com.project.entity.Login;

@Component
public class AllEmployeeDetailsDao 
{
	@Autowired
	SessionFactory sf;
	
	@Autowired
	LoginDao infoLog;
	
	@Transactional
	public List<Employee> getAllEmployees()
	{
		try {
			infoLog.logActivities("in AllEmployeeDetailsDao-getAllEmployees: ");
			Session session= sf.getCurrentSession();
			Query q1= session.createQuery("from Employee where status=:s");	//HQL use classname not tablename
			q1.setParameter("s", 1);
			List<Employee> l1=(List<Employee>) q1.list();

			return l1;
		}
		catch(Exception e)
		{
			infoLog.logActivities("in AllEmployeeDetailsDao-getAllEmployees: "+e);
			return null;
		}
	}
	
	
}
