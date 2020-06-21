package com.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogOutController 
{
	@RequestMapping(value="/logout.html")
	public ModelAndView removeUserInfo(HttpServletRequest request)
	{
		try
		{
			System.out.println("in LogOutController-removeUserInfo: ");
			HttpSession session= request.getSession();
			System.out.println(session.getId());
			session.invalidate();
			
			ModelAndView mv= new ModelAndView();
			mv.setViewName("LoginView");
			mv.addObject("status", "true");
			return mv;
		}
		catch(Exception e)
		{
			System.out.println("in LogOutController-removeUserInfo: "+e);
			ModelAndView mv= new ModelAndView();
			mv.setViewName("failure");
			mv.addObject("error",e);
			return mv;
		}
	}
}
