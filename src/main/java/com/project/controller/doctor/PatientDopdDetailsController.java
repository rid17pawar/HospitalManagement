package com.project.controller.doctor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.dao.LoginDao;
import com.project.dao.receptionist.SearchPatientDao;
import com.project.entity.Patient;

@Controller
public class PatientDopdDetailsController 
{
	@Autowired
	SearchPatientDao dao;
	
	@Autowired
	LoginDao infoLog;
	
	@RequestMapping(value="/viewDopdPatient1.html", method = RequestMethod.POST)
	public ModelAndView view(@RequestParam("pid")String pid, HttpServletRequest request)
	{
		try {
			infoLog.logActivities("in PatientDopdDetailsController-view: got="+pid);
				Patient p1=dao.searchId(pid);
				infoLog.logActivities("returned to PatientDopdDetailsController-view: got= "+p1);
			
				String doctorAssigned=dao.searchDoctorAssigned(p1.getDoctorId());
				infoLog.logActivities("returned to PatientDopdDetailsController-view: got= "+doctorAssigned);
					    
				if(!(p1.getPid().equals(null)) && !(doctorAssigned.equals(null)))
				{
					HttpSession session=request.getSession();
					session.setAttribute("currentPatientId", p1.getPid());
					session.setAttribute("currentPatientName", p1.getName().getFirstName()+" "+p1.getName().getLastName());
		
					ModelAndView mv= new ModelAndView();
					mv.setViewName("doctor/PatientDopdDetailsView");
					mv.addObject("patient", p1);
					mv.addObject("doctorAssigned", doctorAssigned);
					return mv;
				}
				else
				{   throw new Exception();  }
			}
			catch(Exception e)
			{
				infoLog.logActivities("in PatientDopdDetailsController-view: "+e);
				ModelAndView mv= new ModelAndView();
				mv.setViewName("failure");
				mv.addObject("error",e);
				return mv;
			}
	}
	
	@RequestMapping(value="/viewDopdPatient2.html")
	public ModelAndView viewData(HttpServletRequest request)
	{
		try 
		{
			infoLog.logActivities("in PatientDopdDetailsController-viewData: ");
			HttpSession session=request.getSession();
			String pid=(String)session.getAttribute("currentPatientId");
	
			Patient p1=dao.searchId(pid);
			infoLog.logActivities("returned to PatientDopdDetailsController-viewData: got="+p1);
			
			String doctorAssigned=dao.searchDoctorAssigned(p1.getDoctorId());
			infoLog.logActivities("returned to PatientDopdDetailsController-viewData: got="+doctorAssigned);
		    
				if(!(p1.getPid().equals(null)) && !(doctorAssigned.equals(null)))
				{
					ModelAndView mv= new ModelAndView();
					mv.setViewName("doctor/PatientDopdDetailsView");
					mv.addObject("patient", p1);
					mv.addObject("doctorAssigned", doctorAssigned);
					return mv;
				}
				else
				{   throw new Exception();  }
			}
			catch(Exception e)
			{
				infoLog.logActivities("in PatientDopdDetailsController-viewData: "+e);
				ModelAndView mv= new ModelAndView();
				mv.setViewName("failure");
				mv.addObject("error",e);
				return mv;
			}
	}
	
}
