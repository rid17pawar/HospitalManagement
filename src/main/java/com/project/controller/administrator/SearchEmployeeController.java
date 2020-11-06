package com.project.controller.administrator;

import java.io.FileOutputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.dao.LoginDao;
import com.project.dao.administrator.SearchEmployeeDao;
import com.project.entity.Employee;

@Controller
public class SearchEmployeeController 
{
	@Autowired
	SearchEmployeeDao dao;
	
	@Autowired
	LoginDao infoLog;
	
	@RequestMapping("/searchEmployeeView.html")
	public ModelAndView view()
	{
		ModelAndView mv= new ModelAndView();
		mv.setViewName("administrator/SearchEmployeeView");
		mv.addObject("status","true");
		return mv;
	}

	@RequestMapping(value="/searchEmployeeByName.html", method = RequestMethod.POST)
	public ModelAndView searchName(@RequestParam("firstName")String firstName, @RequestParam("lastName")String lastName )
	{
		Employee e1= dao.searchName(firstName,lastName);
		infoLog.logActivities("searchName"+e1);
	    try {
			if(e1.getEid()!=null)
			{

				ModelAndView mv= new ModelAndView();
				mv.setViewName("administrator/EmployeeDetailsView");
				mv.addObject("employee", e1);
				return mv;
			}
	    }catch(NullPointerException e){
	    	infoLog.logActivities("no employee found "+e);
			ModelAndView mv= new ModelAndView();
			mv.setViewName("administrator/SearchEmployeeView");
			mv.addObject("status","false");
			return mv;
		}
	    return null;
	}
	
	@RequestMapping(value="/searchEmployeeById.html", method = RequestMethod.POST)
	public ModelAndView searchId(@RequestParam("id")String id)
	{
		Employee e1= dao.searchId(id);
		infoLog.logActivities(""+e1);
	    try {
			if(e1.getEid()!=null)
			{

				ModelAndView mv= new ModelAndView();
				mv.setViewName("administrator/EmployeeDetailsView");
				mv.addObject("employee", e1);
				return mv;
			}
	    }catch(NullPointerException e){
	    	infoLog.logActivities("no employee found "+e);
			ModelAndView mv= new ModelAndView();
			mv.setViewName("administrator/SearchEmployeeView");
			mv.addObject("status","false");
			return mv;
		}
	    return null;
	}
	
	@RequestMapping(value="/searchEmployeeByMobileNo.html", method = RequestMethod.POST)
	public ModelAndView searchMobileNo(@RequestParam("mobileNo")String mobileNo)
	{
		Employee e1= dao.searchMobileNo(mobileNo);
		infoLog.logActivities(""+e1);
	    try {
			if(e1.getEid()!=null)
			{

				ModelAndView mv= new ModelAndView();
				mv.setViewName("administrator/EmployeeDetailsView");
				mv.addObject("employee", e1);
				return mv;
			}
	    }catch(NullPointerException e){
	    	infoLog.logActivities("no employee found "+e);
			ModelAndView mv= new ModelAndView();
			mv.setViewName("administrator/SearchEmployeeView");
			mv.addObject("status","false");
			return mv;
		}
	    return null;
	}
	
	@RequestMapping(value="/searchEmployeeByAadharNo.html", method = RequestMethod.POST)
	public ModelAndView searchAadharNo(@RequestParam("aadharNo")String aadharNo)
	{
		Employee e1= dao.searchAadharNo(aadharNo);
		infoLog.logActivities(""+e1);
	    try {
			if(e1.getEid()!=null)
			{

				ModelAndView mv= new ModelAndView();
				mv.setViewName("administrator/EmployeeDetailsView");
				mv.addObject("employee", e1);
				return mv;
			}
	    }catch(NullPointerException e){
	    	infoLog.logActivities("no employee found "+e);
			ModelAndView mv= new ModelAndView();
			mv.setViewName("administrator/SearchEmployeeView");
			mv.addObject("status","false");
			return mv;
		}
	    return null;
	}
}
