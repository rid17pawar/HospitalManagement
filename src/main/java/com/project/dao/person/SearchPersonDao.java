package com.project.dao.person;

import com.project.dao.LoginDao;
import com.project.entity.Employee;
import com.project.entity.Patient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class SearchPersonDao {

    @Autowired
    SessionFactory sf;
    @Autowired
    LoginDao infoLog;

    @Transactional
    public Object searchId(String type,Object id)
    {
        Session session = sf.getCurrentSession();
        Query q1;
        if(type.toLowerCase().equals("employee")) {
            q1 = session.createQuery("from Employee where eid= :i AND status=:s");
            q1.setParameter("s", 1);
        }else{
            q1=session.createQuery("from Patient where pid= :id");
        }
        q1.setParameter("i", id);

        try {
            Object personObject = (Object) q1.uniqueResult();
            infoLog.logActivities("" + personObject);

            if (personObject != null)
                infoLog.logActivities("person found");
            return personObject;
        } catch (Exception e) {
            infoLog.logActivities("error in finding person records " + e);
            return null;
        }
    }

    @Transactional
    public Object searchMobileNo(String type,Object mobileNo)
    {
        Session session = sf.getCurrentSession();
        Query q1;

        if(type.toLowerCase().equals("employee")) {
            q1 = session.createQuery("from Employee where mobileno= :i AND status=:s");
            q1.setParameter("s", 1);
        }else{
            q1=session.createQuery("from Patient where mobileNo= :no");
        }
        q1.setParameter("i", mobileNo);

        try {
            Object personObject = (Object) q1.uniqueResult();
            infoLog.logActivities("" + personObject);

            if (personObject != null)
                infoLog.logActivities("person found");
            return personObject;
        } catch (Exception e) {
            infoLog.logActivities("error in finding person records " + e);
            return null;
        }
    }

    @Transactional
    public Object searchName(String type,String firstName, String lastName)
    {
        Session session= sf.getCurrentSession();
        Query q1;
        if(type.toLowerCase().equals("employee")) {
            q1 = session.createQuery("from Employee where firstName= :f AND lastName= :l AND status=:s");
            q1.setParameter("s", 1);
        }else{
            q1 = session.createQuery("from Patient where firstName= :f AND lastName= :l");
        }
        q1.setParameter("f", firstName);
        q1.setParameter("l", lastName);

        try
        {
            Object personObject= (Object) q1.uniqueResult();
            infoLog.logActivities(""+personObject);

            if(personObject!=null)
                infoLog.logActivities("person found");
            return personObject;
        }
        catch(Exception e)
        {
            infoLog.logActivities("error in finding person records "+e);
            return null;
        }

    }

    @Transactional
    public Object searchAadharNo(String type,Object aadharNo)
    {
        Session session= sf.getCurrentSession();
        Query q1;

        if(type.toLowerCase().equals("employee")) {
            q1 = session.createQuery("from Employee where adharno= :i AND status=:s");
            q1.setParameter("s", 1);
        }else{
            q1 = session.createQuery("from Patient where adharNo= :no");
        }
        q1.setParameter("i", aadharNo);

        try
        {
            Object personObject= (Object) q1.uniqueResult();
            infoLog.logActivities(""+personObject);

            if(personObject!=null)
                infoLog.logActivities("person found");
            return personObject;
        }
        catch(Exception e)
        {
            infoLog.logActivities("error in finding person records "+e);
            return null;
        }
    }

}

