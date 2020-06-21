package com.project.dao.receptionist;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.project.entity.Employee;
import com.project.entity.Opd;
import com.project.entity.Patient;
import com.project.entity._OpdRecord;

@Component
public class PatientPrescriptionDao 
{
	@Autowired
	SessionFactory sf;
	
	@Transactional
	public int prescriptionPrintCount()
	{
		System.out.println("in PatientPrescriptionDao-prescriptionPrintCount:");
		
		Session session= sf.getCurrentSession();
		Query q1=session.createQuery("from Opd where status= :s");
		q1.setParameter("s", 2);
		
		try 
		{
			List<Opd> temp= (List<Opd>) q1.list();
			int i=0;
			for(Opd o: temp)
			{
				i++;
			}
			System.out.println("in PatientPrescriptionDao-prescriptionPrintCount: found="+i);
			return i;
			
		}catch(Exception e)
		{
			System.out.println("in PatientPrescriptionDao-prescriptionPrintCount: "+e);
			return 0;
		}
	}

	@Transactional
	public List<String[]> getPrescriptionList() 
	{
		System.out.println("in PatientPrescriptionDao-getPrescriptionList: ");
		
		Session session= sf.getCurrentSession();
		Query q1= session.createQuery("from Opd where status= :s");	//HQL use classname not tablename
		q1.setParameter("s", 2);
		
		try {
		    List<Opd> l1=(List<Opd>) q1.list();
		    
		    List<String[]> strarr = new ArrayList<String[]>();
			    for(Opd o: l1)
			    {
			    	String[] temp= new String[3];
			    	temp[0]=o.getPid();
			    	
			    	q1= session.createQuery("from Patient where pid= :i");	//HQL use classname not tablename
					q1.setParameter("i", o.getPid());
			    	Patient p=(Patient) q1.uniqueResult();
			    	temp[1]=p.getName().getFirstName()+" "+p.getName().getMiddleName()+" "+p.getName().getLastName();
			    	strarr.add(temp);
			    	
			    	temp[2]=""+o.getOpdId();
			    }
		    return strarr;
			}
		catch(Exception e)
		{
			System.out.println("in PatientPrescriptionDao-getPrescriptionList: "+e);
			return null;
		}
	}

	@Transactional
	public String getPatientName(String pid) 
	{
		System.out.println("in PatientPrescriptionDao-getPatientName: got="+pid);
		
		Session session= sf.getCurrentSession();
		Query q1= session.createQuery("from Patient where pid= :s");	//HQL use classname not tablename
		q1.setParameter("s", pid);
		
		try
		{
		    Patient p=(Patient) q1.uniqueResult();
		    String str=p.getName().getFirstName()+" "+p.getName().getMiddleName()+" "+p.getName().getLastName();
		    return str;
		}
		catch(Exception e)
		{
			System.out.println("in PatientPrescriptionDao-getPatientName: "+e);
			return null;
		}
	}
	
	
}
