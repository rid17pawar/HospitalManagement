package com.project.controller.doctor;

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
import com.project.entity.Opd;
import com.project.entity.OpdDetails;

@Controller
public class PatientHistoryController 
{
	@Autowired
	PatientHistoryDao dao;
	@Autowired
	LoginDao infoLog;
	
	@RequestMapping("/patientHistoryList.html")
	public ModelAndView showHistoryList(HttpServletRequest request) 
	{
		try
		{
			infoLog.logActivities("in PatientHistoryController-showHistoryList:");
		
			HttpSession session= request.getSession();
			String pid=(String) session.getAttribute("currentPatientId");
			
			List<String[]> historyList=dao.showHistoryList(pid);
			infoLog.logActivities("returned to PatientHistoryController-showHistoryList:");
			
			if(! historyList.equals(null))
			{
				ModelAndView mv= new ModelAndView();
				mv.addObject("historyList",historyList);
				mv.setViewName("doctor/PatientHistoryListView");
				return mv;
			}
			else
			{   throw new Exception();  }
		}
		catch(Exception e)
		{
			infoLog.logActivities("in PatientHistoryController-showHistoryList: "+e);
			ModelAndView mv= new ModelAndView();
			mv.setViewName("failure");
			mv.addObject("error",e);
			return mv;
		}
	}
	
	@RequestMapping(value="/patientHistory.html", method = RequestMethod.POST)
	public ModelAndView showHistory(@RequestParam("opdid")String opdid) 
	{
		try
		{
			infoLog.logActivities("in PatientHistoryController-showHistory: got="+opdid);
			int opdId= Integer.parseInt(opdid);
			
			OpdDetails data=dao.showHistory(opdId);
			infoLog.logActivities("returned to PatientHistoryController-showHistory: got="+data);
			
			if(data.getOpdid()!=0)
			{
				ModelAndView mv= new ModelAndView();
				mv.addObject("history",data);
				mv.setViewName("doctor/PatientHistoryView");
				return mv;
			}
			else
			{   throw new Exception();  }
		}
		catch(Exception e)
		{
			infoLog.logActivities("in PatientHistoryController-showHistory: "+e);
			ModelAndView mv= new ModelAndView();
			mv.setViewName("failure");
			mv.addObject("error",e);
			return mv;
		}
	}
}
