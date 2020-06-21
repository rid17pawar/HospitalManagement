package com.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.dao.EditLoginDetailsDao;
import com.project.entity.Login;


@Controller
public class EditLoginDetailsController 
{
	@Autowired
	EditLoginDetailsDao dao1;
	 
	@RequestMapping(value="/editView.html")
	public ModelAndView editLoginView()
	{
		try
		{
			ModelAndView mv= new ModelAndView();
			mv.setViewName("EditLoginDetailsView");
			mv.addObject("status", "true");
			return mv;
		}
		catch(Exception e)
		{
			System.out.println("in EditLoginDetailsController-editLoginView: "+e);
			ModelAndView mv= new ModelAndView();
			mv.setViewName("failure");
			mv.addObject("error",e);
			return mv;
		}
	}
	
	@RequestMapping(value="/newLoginDetails.html", method = RequestMethod.POST)
	public ModelAndView editLoginView(@RequestParam("username")String username,@RequestParam("password")String password, HttpServletRequest request)
	{
		try {
			System.out.println("in EditLoginDetailsController-editLoginView: got="+username+" "+password);
			 HttpSession session= request.getSession();
			 Login l=(Login)session.getAttribute("userInfo");
			 
			 int i=dao1.editLoginInfo(l.getId(),username,password);
			 System.out.println("returned to EditLoginDetailsController-editLoginView: got= "+i);
			
				if(i==1)
				{	//setting session
					Login l1=new Login(l.getId(),l.getRole(),username,password);
					session.removeAttribute("userInfo");
					session.setAttribute("userInfo",l1);
					
					ModelAndView mv= new ModelAndView();
					mv.setViewName("welcome"); 
					return mv;
				}
				else
				{   throw new Exception();  }
				
			}
			catch(Exception e)
			{
				System.out.println("in EditLoginDetailsController-editLoginView: "+e);	
				ModelAndView mv= new ModelAndView();
				mv.setViewName("EditLoginDetailsView");
				mv.addObject("status", "false");
				return mv;
			} 
			
	}
}
