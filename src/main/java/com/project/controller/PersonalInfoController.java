package com.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.project.dao.LoginDao;
import com.project.dao.PersonalInfoDao;
import com.project.dao.receptionist.PatientPrescriptionDao;
import com.project.entity.Employee;
import com.project.entity.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PersonalInfoController 
{
	@Autowired
	PersonalInfoDao dao;
	
	@Autowired
	PatientPrescriptionDao dao1;
	
	@Autowired
	LoginDao infoLog;
	
	@RequestMapping(value="/personalInfo.html")
	public ModelAndView info(HttpServletRequest request)
	{
		try {
			infoLog.logActivities("in PersonalInfoController-info:");
			HttpSession session=request.getSession();
			Login l=(Login)session.getAttribute("userInfo");
			
			Employee e1=dao.info(l.getId());
			infoLog.logActivities("retuned to PersonalInfoController-info: got= "+e1);
			
				if(! e1.getEid().equals(null))
				{
					ModelAndView mv= new ModelAndView();
					mv.setViewName("PersonalInfoView");
					mv.addObject("prescriptionsCount", dao1.prescriptionPrintCount());  //for receptionist only
					mv.addObject("employee",e1);
					return mv;
				}
				else
				{   throw new Exception();  }
			}
			catch(Exception e)
			{
				infoLog.logActivities("in PersonalInfoController-info: "+e);
				ModelAndView mv= new ModelAndView();
				mv.setViewName("failure");
				mv.addObject("error",e);
				return mv;
			}
	}
}
