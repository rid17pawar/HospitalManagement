package com.project.dao.receptionist;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.project.entity.Patient;

@Component
public class SearchPatientDao 
{
	@Autowired
	SessionFactory sf;
	
	@Transactional
	public Patient searchName(String firstName, String lastName) 
	{
		System.out.println("in SearchPatientDao-searchName: got= "+firstName+" "+lastName);
		
		Session session= sf.getCurrentSession();
		Query q1=session.createQuery("from Patient where firstName= :f AND lastName= :l");
		q1.setParameter("f", firstName);
		q1.setParameter("l", lastName);
		
		try 
		{
			Patient temp= (Patient) q1.uniqueResult();
			System.out.println("in SearchPatientDao-searchName: found= "+temp);
			return temp;
		}
		catch(Exception e)
		{ 
			System.out.println("in SearchPatientDao-searchName: "+e);
			return null;
		}
			
	}
	
	@Transactional
	public Patient searchId(String pid) 
	{
		System.out.println("in SearchPatientDao-searchId: got= "+pid);
		
		Session session= sf.getCurrentSession();
		Query q1=session.createQuery("from Patient where pid= :id");
		q1.setParameter("id", pid);
		
		try 
		{
			Patient temp= (Patient) q1.uniqueResult();
			System.out.println("in SearchPatientDao-searchId: found= "+temp);
			return temp;
		}
		catch(Exception e)
		{ 
			System.out.println("in SearchPatientDao-searchId: "+e);
			return null;
		}		
	}

	@Transactional
	public Patient searchMobileNo(Long mobileNo) 
	{
		System.out.println("in SearchPatientDao-searchMobileNo: got= "+mobileNo);
		
		Session session= sf.getCurrentSession();
		Query q1=session.createQuery("from Patient where mobileNo= :no");
		q1.setParameter("no", mobileNo);
		
		try 
		{
			Patient temp= (Patient) q1.uniqueResult();
			System.out.println("in SearchPatientDao-searchMobileNo: found= "+temp);
			return temp;
		}
		catch(Exception e)
		{ 
			System.out.println("in SearchPatientDao-searchMobileNo: "+e);
			return null;
		}	
	}
	
	@Transactional
	public Patient searchAdharNo(Long adharNo) 
	{
		System.out.println("in SearchPatientDao-searchAdharNo: got= "+adharNo);
		
		Session session= sf.getCurrentSession();
		Query q1=session.createQuery("from Patient where adharNo= :no");
		q1.setParameter("no", adharNo);
		
		try 
		{
			Patient temp= (Patient) q1.uniqueResult();
			System.out.println("in SearchPatientDao-searchAdharNo: found= "+temp);
			return temp;
		}
		catch(Exception e)
		{ 
			System.out.println("in SearchPatientDao-searchAdharNo: "+e);
			return null;
		}	
	}

	@Transactional
	public String searchDoctorAssigned(String eid)
	{
		try{
			System.out.println("in SearchPatientDao-searchDoctorAssigned: got= "+eid);
			
			Session session= sf.getCurrentSession();
			Query q1=session.createQuery("select name.firstName,name.lastName from Employee where eid= :id");
			q1.setParameter("id", eid);
			String dname="";
			
			Object o[]=(Object[]) q1.uniqueResult();
				for(Object obj:o)
				{
					System.out.println(obj);
					String name=" "+(String) obj;
					dname+=name;
				}
			System.out.println("in SearchPatientDao-searchDoctorAssigned: found= "+dname);	
			return dname;
			}
			catch(Exception e)
			{ 
				System.out.println("in SearchPatientDao-searchDoctorAssigned: "+e);
				return null;
			}
			
	}
		
}
