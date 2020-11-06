package com.project.dao.administrator;

import org.hibernate.NonUniqueResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.LoginDao;
import com.project.entity.Employee;
import com.project.entity.Login;

@Component
public class SearchEmployeeDao 
{
	@Autowired
	private SessionFactory sf;	//hibernate configuration in springMVC-servlet.xml file
	
	@Autowired
	LoginDao infoLog;
	
	//to manage transaction by itself
	@Transactional
	public Employee searchName(String firstName, String lastName) 
	{
		Session session= sf.getCurrentSession();
		Query q1=session.createQuery("from Employee where firstName= :f AND lastName= :l AND status=:s");
		q1.setParameter("f", firstName);
		q1.setParameter("l", lastName);
		q1.setParameter("s", 1);
		
		try 
		{
				Employee temp= (Employee) q1.uniqueResult();
				infoLog.logActivities(""+temp);
		
				if(temp.getEid()!=null)
					infoLog.logActivities("employee found");
				return temp;
			}
			catch(Exception e)
			{ 
				infoLog.logActivities("error in finding employee records "+e);
			  return null;
			}
			
	}

	@Transactional
	public Employee searchId(String id) 
	{
		Session session= sf.getCurrentSession();
		Query q1=session.createQuery("from Employee where eid= :i AND status=:s");
		q1.setParameter("i", id);
		q1.setParameter("s", 1);
			try 
			{
				Employee temp= (Employee) q1.uniqueResult();
				infoLog.logActivities(""+temp);
		
				if(temp.getEid()!=null)
					infoLog.logActivities("employee found");
				return temp;
			}
			catch(Exception e)
			{ 
				infoLog.logActivities("error in finding employee records "+e);
			  return null;
			}
	}

	@Transactional
	public Employee searchMobileNo(String mobileNo) 
	{
		Session session= sf.getCurrentSession();
		Query q1=session.createQuery("from Employee where mobileno= :i AND status=:s");
		q1.setParameter("i", mobileNo);
		q1.setParameter("s", 1);
		    try 
		    {
				Employee temp= (Employee) q1.uniqueResult();
				infoLog.logActivities(""+temp);
		
				if(temp.getEid()!=null)
					infoLog.logActivities("employee found");
				return temp;
			}
			catch(Exception e)
			{ 
				infoLog.logActivities("error in finding employee records "+e);
			  return null;
			}
	}
	
	@Transactional
	public Employee searchAadharNo(String aadharNo) 
	{
		Session session= sf.getCurrentSession();
		Query q1=session.createQuery("from Employee where adharno= :i AND status=:s");
		q1.setParameter("i", aadharNo);
		q1.setParameter("s", 1);
		    try 
		    {
				Employee temp= (Employee) q1.uniqueResult();
				infoLog.logActivities(""+temp);
		
				if(temp.getEid()!=null)
					infoLog.logActivities("employee found");
				return temp;
			}
			catch(Exception e)
			{ 
				infoLog.logActivities("error in finding employee records "+e);
			  return null;
			}
	}
}
