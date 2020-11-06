package com.project.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.entity.Login;

@Component
public class EditLoginDetailsDao 
{
	@Autowired
	SessionFactory sf;
	
	@Autowired
	LoginDao infoLog;
	
	@Transactional
	public int editLoginInfo(String id, String username, String passsword) 
	{
		try 
		{
			infoLog.logActivities("in EditLoginDetailsDao-editLoginInfo:got= "+id+" "+username+" "+passsword);
			
			Session session= sf.getCurrentSession();
			String hashStr=BCrypt.hashpw(passsword, BCrypt.gensalt());
			Query q1=session.createQuery("update Login set username= :u, password= :p where id= :i");
			q1.setParameter("u", username);
			q1.setParameter("p", hashStr);
			q1.setParameter("i", id);

			int res= q1.executeUpdate();
			infoLog.logActivities("in EditLoginDetailsDao-editLoginInfo:found= "+res+"<b>hash generated= "+hashStr);
			return res;
		}
		catch(Exception e)
		{
			infoLog.logActivities("in EditLoginDetailsDao-editLoginInfo: "+e);
			return 0;
		}
	}

}
