package com.project.controller.doctor;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.dao.doctor.DopdDetailsDao;
import com.project.entity.Login;
import com.project.entity.Patient;

@Controller
public class DopdDetailsController 
{
	@Autowired
	DopdDetailsDao dao;
	
	@RequestMapping("/opdQueueD.html")
	public ModelAndView view(HttpServletRequest request)
	{
		try
		{
			System.out.println("in DopdDetailsController-view:");
			HttpSession session= request.getSession();
			Login l=(Login)session.getAttribute("userInfo");
			String doctorId=l.getId();
					
			ArrayList<Patient> patients=dao.dopdQueue(doctorId);
			System.out.println("returned to DopdDetailsController-view:");
			
			if(! patients.equals(null))
			{
				ModelAndView mv= new ModelAndView();
				mv.setViewName("doctor/DopdDetailsView");
				mv.addObject("patientsQueue", patients);
				return mv;
			}
			else
			{   throw new Exception();  }
		}
		catch(Exception e)
		{
			System.out.println("in DopdDetailsController-view:"+e);
			ModelAndView mv= new ModelAndView();
			mv.setViewName("failure");
			mv.addObject("error",e);
			return mv;
		}
	}
}
