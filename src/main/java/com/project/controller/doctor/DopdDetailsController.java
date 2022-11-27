package com.project.controller.doctor;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.project.utility.ModelAndViewUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.dao.LoginDao;
import com.project.dao.doctor.DopdDetailsDao;
import com.project.entity.Login;
import com.project.entity.Patient;

@Controller
public class DopdDetailsController 
{
	@Autowired
	DopdDetailsDao dao;
	
	@Autowired
	LoginDao infoLog;

	@Autowired
	ModelAndViewUtility modelAndViewUtility;
	
	@RequestMapping("/opdQueueD.html")
	public ModelAndView view(HttpServletRequest request)
	{
		try
		{
			infoLog.logActivities("in DopdDetailsController-view:");
			HttpSession session= request.getSession();
			Login l=(Login)session.getAttribute("userInfo");
			String doctorId=l.getId();
					
			ArrayList<Patient> patients=dao.dopdQueue(doctorId);
			infoLog.logActivities("returned to DopdDetailsController-view:");
			
			if(! patients.equals(null))
			{
				return modelAndViewUtility.returnModelAndView("doctor/DopdDetailsView","patientsQueue", patients);
			}
			else
			{   throw new Exception();  }
		}
		catch(Exception e)
		{
			infoLog.logActivities("in DopdDetailsController-view:"+e);
			return modelAndViewUtility.returnModelAndView("failure","error",e);
		}
	}
}
