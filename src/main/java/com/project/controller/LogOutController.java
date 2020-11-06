package com.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.dao.LoginDao;

@Controller
public class LogOutController 
{
	@Autowired
	LoginDao infoLog;
	
	@RequestMapping(value="/logout.html")
	public ModelAndView removeUserInfo(HttpServletRequest request)
	{
		try
		{
			infoLog.logActivities("in LogOutController-removeUserInfo: ");
			HttpSession session= request.getSession();
			infoLog.logActivities(session.getId());
			session.invalidate();
			
			ModelAndView mv= new ModelAndView();
			mv.setViewName("LoginView");
			mv.addObject("status", "true");
			return mv;
		}
		catch(Exception e)
		{
			infoLog.logActivities("in LogOutController-removeUserInfo: "+e);
			ModelAndView mv= new ModelAndView();
			mv.setViewName("failure");
			mv.addObject("error",e);
			return mv;
		}
	}
}
