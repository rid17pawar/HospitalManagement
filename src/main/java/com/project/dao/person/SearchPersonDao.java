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
        if(type.toLowerCase().equals("employee")) {
            Session session = sf.getCurrentSession();
            Query q1 = session.createQuery("from Employee where eid= :i AND status=:s");
            q1.setParameter("i", id);
            q1.setParameter("s", 1);
            try {
                Employee temp = (Employee) q1.uniqueResult();
                infoLog.logActivities("" + temp);

                if (temp.getEmployeeId() != null)
                    infoLog.logActivities("employee found");
                return temp;
            } catch (Exception e) {
                infoLog.logActivities("error in finding employee records " + e);
                return null;
            }
        }else {
            infoLog.logActivities("in SearchPatientDao-searchId: got= "+id);

            Session session= sf.getCurrentSession();
            Query q1=session.createQuery("from Patient where pid= :id");
            q1.setParameter("id", id);

            try
            {
                Patient temp= (Patient) q1.uniqueResult();
                infoLog.logActivities("in SearchPatientDao-searchId: found= "+temp);
                return temp;
            }
            catch(Exception e)
            {
                infoLog.logActivities("in SearchPatientDao-searchId: "+e);
                return null;
            }
        }
    }

    @Transactional
    public Object searchMobileNo(String type,Object mobileNo)
    {
        if(type.toLowerCase().equals("employee")) {
            Session session = sf.getCurrentSession();
            Query q1 = session.createQuery("from Employee where mobileno= :i AND status=:s");
            q1.setParameter("i", mobileNo);
            q1.setParameter("s", 1);
            try {
                Employee temp = (Employee) q1.uniqueResult();
                infoLog.logActivities("" + temp);

                if (temp.getEmployeeId() != null)
                    infoLog.logActivities("employee found");
                return temp;
            } catch (Exception e) {
                infoLog.logActivities("error in finding employee records " + e);
                return null;
            }
        }else {
            infoLog.logActivities("in SearchPatientDao-searchMobileNo: got= "+mobileNo);

            Session session= sf.getCurrentSession();
            Query q1=session.createQuery("from Patient where mobileNo= :no");
            q1.setParameter("no", (Long)mobileNo);

            try
            {
                Patient temp= (Patient) q1.uniqueResult();
                infoLog.logActivities("in SearchPatientDao-searchMobileNo: found= "+temp);
                return temp;
            }
            catch(Exception e)
            {
                infoLog.logActivities("in SearchPatientDao-searchMobileNo: "+e);
                return null;
            }
        }
    }

    @Transactional
    public Object searchName(String type,String firstName, String lastName)
    {
        if(type.toLowerCase().equals("employee")) {
            Session session= sf.getCurrentSession();
            Query q1=session.createQuery("from Employee where firstName= :f AND lastName= :l AND status=:s");
            q1.setParameter("f", firstName);
            q1.setParameter("l", lastName);
            q1.setParameter("s", 1);

            try
            {
                Employee temp= (Employee) q1.uniqueResult();
                infoLog.logActivities(""+temp);

                if(temp.getEmployeeId()!=null)
                    infoLog.logActivities("employee found");
                return temp;
            }
            catch(Exception e)
            {
                infoLog.logActivities("error in finding employee records "+e);
                return null;
            }
        }
        else {
            infoLog.logActivities("in SearchPatientDao-searchName: got= " + firstName + " " + lastName);

            Session session = sf.getCurrentSession();
            Query q1 = session.createQuery("from Patient where firstName= :f AND lastName= :l");
            q1.setParameter("f", firstName);
            q1.setParameter("l", lastName);

            try {
                Patient temp = (Patient) q1.uniqueResult();
                infoLog.logActivities("in SearchPatientDao-searchName: found= " + temp);
                return temp;
            } catch (Exception e) {
                infoLog.logActivities("in SearchPatientDao-searchName: " + e);
                return null;
            }
        }

    }

    @Transactional
    public Object searchAadharNo(String type,Object aadharNo)
    {
        if(type.toLowerCase().equals("employee")) {
            Session session= sf.getCurrentSession();
            Query q1=session.createQuery("from Employee where adharno= :i AND status=:s");
            q1.setParameter("i", aadharNo);
            q1.setParameter("s", 1);
            try
            {
                Employee temp= (Employee) q1.uniqueResult();
                infoLog.logActivities(""+temp);

                if(temp.getEmployeeId()!=null)
                    infoLog.logActivities("employee found");
                return temp;
            }
            catch(Exception e)
            {
                infoLog.logActivities("error in finding employee records "+e);
                return null;
            }
        }
        else {
            infoLog.logActivities("in SearchPatientDao-searchAdharNo: got= " + aadharNo);

            Session session = sf.getCurrentSession();
            Query q1 = session.createQuery("from Patient where adharNo= :no");
            q1.setParameter("no",(Long) aadharNo);

            try {
                Patient temp = (Patient) q1.uniqueResult();
                infoLog.logActivities("in SearchPatientDao-searchAdharNo: found= " + temp);
                return temp;
            } catch (Exception e) {
                infoLog.logActivities("in SearchPatientDao-searchAdharNo: " + e);
                return null;
            }
        }
    }

}
