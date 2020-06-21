package com.project.controller.administrator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.dao.administrator.DeleteEmployeeDao;

@Controller
public class DeleteEmployeeController 
{
	@Autowired
	DeleteEmployeeDao dao;
	
	@RequestMapping("/deleteEmployee.html")
	public ModelAndView delete(@RequestParam("eid")String eid)
	{
		try
		{
			System.out.println("in DeleteEmployeeController-delete: got= "+eid);
			int res=dao.delete(eid);
			System.out.println("returned to DeleteEmployeeController-delete: got= "+res);
			
			if(res==1)
			{
				ModelAndView mv= new ModelAndView();
				mv.setViewName("successPage");
				return mv;
			}
			else
			{   throw new Exception();  }
		}
		catch(Exception e)
		{
			System.out.println("in DeleteEmployeeController-delete: "+e);
			ModelAndView mv= new ModelAndView();
			mv.setViewName("failure");
			mv.addObject("error",e);
			return mv;
		}
			
	}

}
