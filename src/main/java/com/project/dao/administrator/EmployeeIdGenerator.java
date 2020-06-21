package com.project.dao.administrator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class EmployeeIdGenerator implements IdentifierGenerator{

	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException 
    {
        String prefix = "EMP";
        Connection connection = session.connection();

        try {
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery("select eid from hospital.IdGenerate");

            if(rs.next())
            {
                Integer id=rs.getInt(1)+101;	
                String generatedId = prefix + id.toString();
                System.out.println("Generated Id: " + generatedId);
                return generatedId;
            }
        } catch (SQLException e) 
        {	System.out.println(e); }

        return null;
       }
}
