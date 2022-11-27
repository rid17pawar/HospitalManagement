package com.project.controller.administrator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.project.utility.ModelAndViewUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.dao.LoginDao;
import com.project.dao.administrator.AddEmployeeDao;
import com.project.entity.Address;
import com.project.entity.Employee;
import com.project.entity.Name;

@Controller
public class AddEmployeeController 
{
	@Autowired
	AddEmployeeDao dao;
	
	@Autowired
	LoginDao infoLog;

	@Autowired
	ModelAndViewUtility modelAndViewUtility;
	
	@RequestMapping("/addEmployeeView.html")
	public ModelAndView view()
	{
		try
		{
			return modelAndViewUtility.returnModelAndView("administrator/AddEmployeeView",null,null);
		}
		catch(Exception e)
		{
			infoLog.logActivities("in AddEmployeeController-view: "+e);
			return modelAndViewUtility.returnModelAndView("failure","error",e);
		}
	}
	
	@RequestMapping(value="/addEmployee.html", method = RequestMethod.POST)
	public ModelAndView add(@RequestParam("firstName")String firstName, @RequestParam("middleName")String middleName, @RequestParam("lastName")String lastName, @RequestParam("birthdate")String birthdate, @RequestParam("gender")String gender, @RequestParam("email")String email, @RequestParam("mobileNo")Long mobileNo, @RequestParam("adharNo")Long adharNo, @RequestParam("country")String country, @RequestParam("state")String state, @RequestParam("city")String city, @RequestParam("residentialAddress")String residentialAddress, @RequestParam("permanentAddress")String permanentAddress, @RequestParam("role")String role, @RequestParam("qualification")String qualification, @RequestParam("specialization")String specialization )
	{	
		try
		{		
			Name n1= new Name(firstName, middleName, lastName);
			Address a1= new Address(residentialAddress,permanentAddress);
			infoLog.logActivities("in AddEmployeeController-add: got= "+n1+" "+birthdate+" "+gender+" "+email+" "+mobileNo+" "+adharNo+" "+country+" "+state+" "+city+" "+a1+" "+role+" "+qualification+" "+specialization);
			        
			Employee e1= new Employee(null,n1,birthdate,gender,email,mobileNo,adharNo,country,state,city,a1,role,qualification,specialization);
	
			boolean b=dao.add(e1);
			infoLog.logActivities("returned to AddEmployeeController-add: got="+b);
			
			if(b)
			{
				return modelAndViewUtility.returnModelAndView("successPage",null,null);
			}
			else
			{   throw new Exception();  }
		}
		catch(Exception e)
		{
			infoLog.logActivities("in AddEmployeeController-add: "+e);
			return modelAndViewUtility.returnModelAndView("failure","error",e);
		}
	}
	
}
