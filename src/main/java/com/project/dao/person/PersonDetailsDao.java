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
        if(type.toLowerCase().equals("employee")) {
            infoLog.logActivities("in EmployeeDetailsDao-show: got= "+id);

            Session session= sf.getCurrentSession();
            Query q1=session.createQuery("from Employee where eid= :id");
            q1.setParameter("id", id);

            try
            {
                Employee temp= (Employee) q1.uniqueResult();
                infoLog.logActivities("in EmployeeDetailsDao-show: found= "+temp);
                return temp;
            }
            catch(Exception e)
            {
                infoLog.logActivities("in EmployeeDetailsDao-show: "+e);
                return null;
            }
        }else {
            infoLog.logActivities("in PatientDetailsDao-show: got= " + id);

            Session session = sf.getCurrentSession();
            Query q1 = session.createQuery("from Patient where pid= :id");
            q1.setParameter("id", id);

            try {
                Patient temp = (Patient) q1.uniqueResult();
                infoLog.logActivities("in PatientDetailsDao-show: found= " + temp);
                return temp;
            } catch (Exception e) {
                infoLog.logActivities("in PatientDetailsDao-show: " + e);
                return null;
            }
        }
    }
}
