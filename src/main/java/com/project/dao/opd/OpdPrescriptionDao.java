package com.project.dao.opd;

import com.project.dao.LoginDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class OpdPrescriptionDao {

    @Autowired
    SessionFactory sf;

    @Autowired
    LoginDao infoLog;

    @Transactional
    public void prescriptionPrint(String pid)
    {
        infoLog.logActivities("in prescription print dao ");
        Session session= sf.getCurrentSession();
        Query q1=session.createQuery("update Opd set status=2 where pid= :id AND status=1");
        q1.setParameter("id", pid);

        int res= q1.executeUpdate();
        infoLog.logActivities(""+res);
    }

    @Transactional
    public int prescriptionPrintDone(String pid)
    {
        infoLog.logActivities("in DeleteOpdDao-prescriptionPrintDone: got= "+pid);

        Session session= sf.getCurrentSession();
        Query q1=session.createQuery("update Opd set status=0 where pid= :id AND status=2");
        q1.setParameter("id", pid);

        try {
            int res= q1.executeUpdate();
            return res;
        }
        catch(Exception e)
        {
            infoLog.logActivities("in DeleteOpdDao-prescriptionPrintDone:"+e);
            return 0;
        }
    }
}
