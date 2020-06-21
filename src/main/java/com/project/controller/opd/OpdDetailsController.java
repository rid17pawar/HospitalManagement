package com.project.controller.opd;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.dao.opd.OpdDetailsDao;
import com.project.dao.receptionist.PatientPrescriptionDao;
import com.project.entity._OpdRecord;

@Controller
public class OpdDetailsController 
{
	@Autowired
	OpdDetailsDao dao;
	
	@Autowired
	PatientPrescriptionDao dao1;
	
	@RequestMapping(value="/opdQueueView.html" )
	public ModelAndView view()
	{
		try {
			System.out.println("in OpdDetailsController-view:");
			
			ArrayList<_OpdRecord> opdQ= dao.opdQueue();
			System.out.println("returned to OpdDetailsController-view: got= ");
			for(_OpdRecord r: opdQ)
			{
				System.out.println(r);
			}
			
				if(! opdQ.equals(null))
				{
					ModelAndView mv= new ModelAndView();
					mv.setViewName("receptionist/opdQueueView");
					mv.addObject("opdQueue", opdQ);
					mv.addObject("prescriptionsCount", dao1.prescriptionPrintCount());  //for receptionist only		
					return mv;
				}
				else
				{   throw new Exception();  }
			}
			catch(Exception e)
			{
				System.out.println("in OpdDetailsController-view: "+e);
				ModelAndView mv= new ModelAndView();
				mv.setViewName("failure");
				mv.addObject("error",e);
				return mv;
			}
	}
	
}
