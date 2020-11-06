package com.project.controller.receptionist;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.dao.LoginDao;
import com.project.dao.doctor.PatientHistoryDao;
import com.project.dao.opd.DeleteOpdDao;
import com.project.dao.receptionist.PatientPrescriptionDao;
import com.project.entity.OpdDetails;

@Controller
public class PatientPrescriptionController 
{
	@Autowired
	PatientPrescriptionDao dao;
	
	@Autowired
	DeleteOpdDao dao1;
	
	@Autowired
	PatientHistoryDao dao2;
	
	@Autowired
	LoginDao infoLog;
	
	@RequestMapping(value="/prescriptionQueueView.html")
	public ModelAndView prescriptionQueue()
	{	
		try {
			infoLog.logActivities("in PatientPrescriptionController-prescriptionQueue:");
			
			List<String[]> prescriptionList= dao.getPrescriptionList();
			
			if(! prescriptionList.equals(null))
			{
				ModelAndView mv= new ModelAndView();
				mv.setViewName("receptionist/PrescriptionQueueView");
				mv.addObject("prescriptionList", prescriptionList);
				mv.addObject("prescriptionsCount", dao.prescriptionPrintCount());  //for receptionist only
				return mv;
			}
			else
			{   throw new Exception();  }
		}
		catch(Exception e)
		{
			infoLog.logActivities("in PatientPrescriptionController-prescriptionQueue: "+e);
			ModelAndView mv= new ModelAndView();
			mv.setViewName("failure");
			mv.addObject("error",e);
			return mv;
		}
	}
	
	@RequestMapping("/printPrescription.html")
	public ModelAndView print(@RequestParam("pid")String pid, @RequestParam("opdid")String opdid)
	{	
		try 
		{
			infoLog.logActivities("in PatientPrescriptionController-print: got="+pid+" "+opdid);
			int opdId=Integer.parseInt(opdid);
			
			String name=dao.getPatientName(pid);
			infoLog.logActivities("returned to PatientPrescriptionController-print: got="+name);
			
			OpdDetails data=dao2.showHistory(opdId);
			infoLog.logActivities("returned to PatientPrescriptionController-print: got="+data);
			
			if( (! name.equals(null)) && (data.getOpdid()!=0 ) )
			{
				ModelAndView mv= new ModelAndView();
				mv.setViewName("receptionist/PrescriptionPrintView");
				mv.addObject("patientName", name);
				mv.addObject("prescription", data);
				return mv;
			}
			else
			{   throw new Exception();  }
		}
		catch(Exception e)
		{
			infoLog.logActivities("in PatientPrescriptionController-print: "+e);
			ModelAndView mv= new ModelAndView();
			mv.setViewName("failure");
			mv.addObject("error",e);
			return mv;
		}
	
	}
	
	@RequestMapping(value = "/prescriptionPrintDone.html", method = RequestMethod.POST)
	public ModelAndView delete(@RequestParam("pid")String pid)
	{
		try 
		{
			infoLog.logActivities("in PatientPrescriptionController-delete: got="+pid);
			
			int i=dao1.prescriptionPrintDone(pid);
			infoLog.logActivities("returned to PatientPrescriptionController-delete: got="+i);
			
			if(i==1)
			{
				List<String[]> prescriptions= dao.getPrescriptionList();
				int count=dao.prescriptionPrintCount();
				
				if(! prescriptions.equals(null))
				{
					ModelAndView mv= new ModelAndView();
					mv.setViewName("receptionist/PrescriptionQueueView");
					mv.addObject("prescriptionList", prescriptions);
					mv.addObject("prescriptionsCount", count);  //for receptionist only
					return mv;
				}
				else
				{   throw new Exception();  }
				
			}
			else
			{   throw new Exception();  }
		}
		catch(Exception e)
		{
			infoLog.logActivities("in PatientPrescriptionController-delete: "+e);
			ModelAndView mv= new ModelAndView();
			mv.setViewName("failure");
			mv.addObject("error",e);
			return mv;
		}
	}
	
}
