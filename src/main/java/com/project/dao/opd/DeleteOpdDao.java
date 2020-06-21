package com.project.dao.opd;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.dao.doctor.PatientHistoryDao;
import com.project.entity.OpdDetails;

@Component
public class DeleteOpdDao 
{
	@Autowired
	SessionFactory sf;
		
	@Transactional
	public int delete(String pid) 
	{
		System.out.println("in DeleteOpdDao-delete: got= "+pid);
		
		Session session= sf.getCurrentSession();
		Query q1=session.createQuery("update Opd set status=0 where pid= :id AND status=1");
		q1.setParameter("id", pid);
		
		try {
			int res= q1.executeUpdate();
			System.out.println("in DeleteOpdDao-delete:update status="+res);
			return res;
			}
		catch(Exception e)
		{
			System.out.println("in DeleteOpdDao-delete: "+e);
			return 0;
		}
		
	}

	@Transactional
	public void prescriptionPrint(String pid) 
	{
		System.out.println("in prescription print dao ");
		Session session= sf.getCurrentSession();
		Query q1=session.createQuery("update Opd set status=2 where pid= :id AND status=1");
		q1.setParameter("id", pid);
		
		int res= q1.executeUpdate();
		System.out.println(res);		
	}

	@Transactional
	public int prescriptionPrintDone(String pid) 
	{
		System.out.println("in DeleteOpdDao-prescriptionPrintDone: got= "+pid);
		
		Session session= sf.getCurrentSession();
		Query q1=session.createQuery("update Opd set status=0 where pid= :id AND status=2");
		q1.setParameter("id", pid);
		
		try {
			int res= q1.executeUpdate();
			return res;
			}
		catch(Exception e)
		{
			System.out.println("in DeleteOpdDao-prescriptionPrintDone:"+e);
			return 0;
		}
	}

}
