package com.project.dao.administrator;

import com.project.dao.person.SearchPersonDao;
import org.hibernate.NonUniqueResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.LoginDao;
import com.project.entity.Employee;
import com.project.entity.Login;

@Component
public class SearchEmployeeDao extends SearchPersonDao
{

}
