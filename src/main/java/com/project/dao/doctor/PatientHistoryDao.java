package com.project.dao.doctor;

import java.text.SimpleDateFormat;
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
import com.project.dao.receptionist.PatientDetailsDao;
import com.project.dao.receptionist.SearchPatientDao;
import com.project.entity.Employee;
import com.project.entity.Opd;
import com.project.entity.OpdDetails;

@Component
public class PatientHistoryDao 
{
	@Autowired
	private SessionFactory sf;	//hibernate configuration in springMVC-servlet.xml file
	
	@Autowired
	SearchPatientDao dao2;
	
	@Autowired
	LoginDao infoLog;
	
	@Transactional
	public List<String[]> showHistoryList(String pid) 
	{
		infoLog.logActivities("in PatientHistoryDao-showHistoryList: got="+pid);
		
		Session session= sf.getCurrentSession();
		Query q1= session.createQuery(" from Opd where pid= :i AND status= :s ORDER BY opdId DESC");	//HQL use classname not tablename
		q1.setParameter("i", pid);
		q1.setParameter("s", 0);
		
		try
		{
		    List<Opd> l1=(List<Opd>) q1.list();
		    
		    List<String[]> opdHistory = new ArrayList<String[]>();
		    for(Opd opd: l1)
		    {
		    	String[] temp= new String[3];
		    	Date d=opd.getVisitDate();
		    	SimpleDateFormat f= new SimpleDateFormat("yyyy-mm-dd");
		    	temp[0]=(""+d).substring(0, 10);
		    	String did=opd.getDoctorId();
		    	temp[1]=dao2.searchDoctorAssigned(did);
		    	temp[2]=""+opd.getOpdId();
		    	opdHistory.add(temp);
		    }
		    return opdHistory;
		}
		catch(Exception e)
		{
			infoLog.logActivities("in PatientHistoryDao-showHistoryList: "+e);
			return null;
		}

	}

	@Transactional
	public OpdDetails showHistory(int opdid) 
	{
		infoLog.logActivities("in PatientHistoryDao-showHistory: got= "+opdid);
		
		Session session= sf.getCurrentSession();
		Query q1= session.createQuery(" from OpdDetails where opdid= :i");	//HQL use classname not tablename
		q1.setParameter("i", opdid);
		
		try {
				OpdDetails l1=(OpdDetails) q1.uniqueResult();
				return l1;
			}
			catch(Exception e)
			{ 
				infoLog.logActivities("in PatientHistoryDao-showHistory:"+e);
			    return null;
			}
	    
	}

}
