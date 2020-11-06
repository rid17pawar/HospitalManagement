package com.project.controller.opd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.dao.LoginDao;
import com.project.dao.opd.DeleteOpdDao;
import com.project.dao.opd.OpdDetailsDao;
import com.project.dao.receptionist.PatientPrescriptionDao;

@Controller
public class DeleteOpdController 
{
	@Autowired
	DeleteOpdDao dao1;
	@Autowired
	OpdDetailsDao dao2;
	@Autowired
	PatientPrescriptionDao dao3;
	@Autowired
	LoginDao infoLog;
	
	@RequestMapping(value = "/deleteOpd.html", method = RequestMethod.POST)
	public ModelAndView delete(@RequestParam("pid")String pid)
	{
		try{
			infoLog.logActivities("in DeleteOpdController-delete: got= "+pid);
			
			int i=dao1.delete(pid);
			infoLog.logActivities("returned to DeleteOpdController-delete: got= "+i);
			
				if(i==1)
				{
					ModelAndView mv= new ModelAndView();
					mv.setViewName("receptionist/opdQueueView");
					mv.addObject("prescriptionsCount", dao3.prescriptionPrintCount());  //for receptionist only
					mv.addObject("opdQueue", dao2.opdQueue());
					return mv;
				}
				else
				{   throw new Exception();  }
			}
			catch(Exception e)
			{
				infoLog.logActivities("in DeleteOpdController-delete: "+e);
				ModelAndView mv= new ModelAndView();
				mv.setViewName("failure");
				mv.addObject("error",e);
				return mv;
			}
			
	}
	
}
