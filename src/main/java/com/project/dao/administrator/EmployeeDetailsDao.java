package com.project.dao.administrator;

import javax.transaction.Transactional;

import com.project.dao.person.PersonDetailsDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.project.dao.LoginDao;
import com.project.entity.Employee;

@Component
public class EmployeeDetailsDao extends PersonDetailsDao
{

}
