package com.project.controller.doctor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.dao.doctor.DopdDetailsDao;
import com.project.dao.opd.DeleteOpdDao;
import com.project.dao.opd.OpdDetailsDao;
import com.project.entity.Login;

@Controller
public class DeleteDopdController 
{

	@Autowired
	DeleteOpdDao dao1;
	@Autowired
	DopdDetailsDao dao2;
	
	@RequestMapping(value = "/deleteDopd.html", method = RequestMethod.POST)
	public ModelAndView delete(@RequestParam("pid")String pid, HttpServletRequest request)
	{
		dao1.delete(pid);
		
		HttpSession session= request.getSession();
		Login l=(Login) session.getAttribute("userInfo");
		String doctorId= l.getId();
		
		ModelAndView mv= new ModelAndView();
		mv.setViewName("doctor/DopdDetailsView");
		mv.addObject("patientsQueue", dao2.dopdQueue(doctorId));
		return mv;
	}
}
