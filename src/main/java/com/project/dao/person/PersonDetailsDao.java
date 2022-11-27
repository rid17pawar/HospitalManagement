package com.project.dao.person;

import com.project.dao.LoginDao;
import com.project.entity.Employee;
import com.project.entity.Patient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class PersonDetailsDao {
    @Autowired
    SessionFactory sf;
    @Autowired
    LoginDao infoLog;

    @Transactional
    public Object show(String type,String id)
    {
        infoLog.logActivities("in PersonDetailsDao-show: got= "+id);

        Session session= sf.getCurrentSession();

        Query q1;
        if(type.toLowerCase().equals("employee")) {
            q1 = session.createQuery("from Employee where eid= :id");
        }else{
            q1 = session.createQuery("from Patient where pid= :id");
        }
        q1.setParameter("id", id);

        try
        {
            Object personObject= (Object) q1.uniqueResult();
            infoLog.logActivities("in PersonDetailsDao-show: found= "+personObject);
            return personObject;
        }
        catch(Exception e)
        {
            infoLog.logActivities("in PersonDetailsDao-show: "+e);
            return null;
        }
    }
}

