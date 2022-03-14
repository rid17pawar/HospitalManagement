package com.project.dao.receptionist;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.dao.LoginDao;
import com.project.entity.Employee;
import com.project.entity.IdGenerate;
import com.project.entity.Login;
import com.project.entity.Patient;

@Component
public class AddPatientDao 
{
	@Autowired
	private SessionFactory sf;	//hibernate configuration in springMVC-servlet.xml file
	@Autowired
	LoginDao infoLog;
	
	@SuppressWarnings("null")
	@Transactional
	public List<String[]> getDoctors()
	{
		Session session= sf.getCurrentSession();
		Query q1= session.createQuery(" from Employee where role= :r AND status=:s");	//HQL use classname not tablename
		q1.setParameter("r", "doctor");
		q1.setParameter("s", 1);
	    
		try {
			List<Employee> l1=(List<Employee>) q1.list();
			infoLog.logActivities("in AddPatientDao-getDoctors:found= "+l1);
		    
		    List<String[]> doctorList = new ArrayList<String[]>();
		    int i=0,j=0;
		    
			    for(Employee e: l1)
			    {
			    	String[] temp= new String[4];
			    	temp[0]=e.getEid();
			    	temp[1]=e.getName().getFirstName();
			    	temp[2]=e.getName().getMiddleName();
			    	temp[3]=e.getName().getLastName();
			    	doctorList.add(temp);
			    }
			    infoLog.logActivities("in AddPatientDao-getDoctors:found= "+doctorList);
			    
		   	return doctorList;
			}
		catch(Exception e)
		{
			infoLog.logActivities("in AddPatientDao-getDoctors: "+e);
			return null;
		}
	}
	
	@Transactional
	public boolean add(Patient p1) 
	{
		infoLog.logActivities("in AddPatientDao-add: got= "+p1);
		//try {
			Date date= new Date();
			p1.setRegistrationDate(date);  //currentdate is stored
					
			Session session= sf.getCurrentSession();
			session.save(p1);
			
			//incrementing eid of idgenerate table contents
			Query q1=session.createQuery(" from IdGenerate");
			IdGenerate temp= (IdGenerate) q1.uniqueResult();
			
			int pid=temp.getPid();
			infoLog.logActivities("in AddPatientDao-add: pid= "+pid);
			pid++;
			
			q1=session.createQuery("update IdGenerate set pid= :i");
			q1.setParameter("i", pid);
			int res= q1.executeUpdate();
			
			infoLog.logActivities("in AddPatientDao-add: incremented pid= "+pid+" update status="+res);
			return true;
			/*}
			catch(Exception e)
			{
				infoLog.logActivities("in AddPatientDao-add: "+e);
				return false;
			}*/
		
	}

}
