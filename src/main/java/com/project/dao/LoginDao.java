package com.project.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.project.entity.Login;

@Component
public class LoginDao 
{
	@Autowired
	private SessionFactory sf;	//hibernate configuration in springMVC-servlet.xml file
	
	//to manage transaction by itself
	@Transactional
	public String validate(Login l)
	{
		try 
		{
			System.out.println("in logindao-validate:got= "+l);
				
			Session session= sf.getCurrentSession();
			Query q1=session.createQuery("from Login where role= :r AND username= :u AND password= :p");
			q1.setParameter("r", l.getRole());
			q1.setParameter("u", l.getUsername());
			q1.setParameter("p", l.getPassword());
		
			Login temp= (Login) q1.uniqueResult();
			System.out.println("in logindao-validate:found= "+temp);
			return temp.getId();
		}
		catch(Exception e)
		{
			System.out.println("in logindao-validate: "+e);
			return null;
		}
	}
	
}
