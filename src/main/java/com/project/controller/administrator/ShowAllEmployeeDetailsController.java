package com.project.controller.administrator;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.utility.ModelAndViewUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.dao.LoginDao;
import com.project.dao.administrator.AllEmployeeDetailsDao;
import com.project.dao.administrator.EmployeeDetailsDao;
import com.project.entity.Employee;

@Controller
public class ShowAllEmployeeDetailsController 
{
	@Autowired
	AllEmployeeDetailsDao dao1;
	@Autowired
	EmployeeDetailsDao dao2;
	@Autowired
	LoginDao infoLog;
	@Autowired
	ModelAndViewUtility modelAndViewUtility;
	
	@RequestMapping("/allEmployeesView.html")
	public ModelAndView view()
	{
		return modelAndViewUtility.returnModelAndView("administrator/AllEmployeeDetailsView","employees", dao1.getAllEmployees());
	}
	
	@RequestMapping(value = "/viewEmployee.html", method = RequestMethod.POST)
	public ModelAndView showEmployeeDetailsViewMethod(@RequestParam("eid")String eid)
	{
		try {
			infoLog.logActivities("in ShowAllEmployeeDetailsController-showEmployeeDetailsViewMethod: got "+eid);
			Employee l=(Employee) dao2.show("employee",eid);
			if(! l.equals(null))
			{
				return modelAndViewUtility.returnModelAndView("administrator/EmployeeDetailsView","employee",l);
			}
			else
			{
				throw new Exception();
			}
		}
		catch(Exception e)
		{
			infoLog.logActivities("in ShowAllEmployeeDetailsController-showEmployeeDetailsViewMethod: "+e);
			return modelAndViewUtility.returnModelAndView("failure","error",e);
		}
	}
	
}
