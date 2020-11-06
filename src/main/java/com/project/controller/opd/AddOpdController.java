package com.project.controller.opd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.dao.LoginDao;
import com.project.dao.opd.AddOpdDao;
import com.project.dao.receptionist.PatientPrescriptionDao;
import com.project.entity.Opd;

@Controller
public class AddOpdController 
{
	@Autowired
	AddOpdDao dao;
	
	@Autowired
	PatientPrescriptionDao dao1;
	
	@Autowired
	LoginDao infoLog;
	
	@RequestMapping(value = "/addOpd.html", method =RequestMethod.POST)
	public ModelAndView add(@RequestParam("pid")String pid)
	{
		try
		{
			infoLog.logActivities("in AddOpdController-add: got= "+pid);
			
			String doctorid=dao.getDoctorId(pid);
			infoLog.logActivities("returned to AddOpdController-add: got= "+doctorid);
			
			if(! doctorid.equals(null))
			{
				Opd q1= new Opd(pid, doctorid, Opd.PENDING);
				
				int b=dao.add(q1);
				infoLog.logActivities("returned to AddOpdController-add: got= "+b);
				
				if(b==1) 
				{
				ModelAndView mv= new ModelAndView();
				mv.setViewName("successPage");
				mv.addObject("prescriptionsCount", dao1.prescriptionPrintCount());  //for receptionist only
				return mv;
				}
				else if(b==2)
				{
					infoLog.logActivities("in AddOpdController-add: ");
					ModelAndView mv= new ModelAndView();
					mv.setViewName("failure");
					mv.addObject("error","<b>patient is aldready added in OPD queue</b>");
					return mv;
				}
				else if(b==3)
				{
					infoLog.logActivities("in AddOpdController-add: ");
					ModelAndView mv= new ModelAndView();
					mv.setViewName("failure");
					mv.addObject("error","<b>Your assigned doctor is not available...plz choose another doctor and then try again</b>");
					return mv;
				}
				else
				{
					throw new Exception();
				}
			}
			else
			{   throw new Exception();  }
		}
		catch(Exception e)
		{
			infoLog.logActivities("in AddOpdController-add: "+e);
			ModelAndView mv= new ModelAndView();
			mv.setViewName("failure");
			mv.addObject("error",e);
			return mv;
		}
			
	}
}
