package com.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.project.utility.ModelAndViewUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.dao.EditLoginDetailsDao;
import com.project.entity.Login;
import com.project.dao.LoginDao;


@Controller
public class EditLoginDetailsController 
{
	@Autowired
	EditLoginDetailsDao dao1;
	
	@Autowired
	LoginDao infoLog;

	@Autowired
	ModelAndViewUtility modelAndViewUtility;
	 
	@RequestMapping(value="/editView.html")
	public ModelAndView editLoginView()
	{
		try
		{
			return modelAndViewUtility.returnModelAndView("EditLoginDetailsView","status", "true");
		}
		catch(Exception e)
		{
			infoLog.logActivities("in EditLoginDetailsController-editLoginView: "+e);
			return modelAndViewUtility.returnModelAndView("failure","error",e);
		}
	}
	
	@RequestMapping(value="/newLoginDetails.html", method = RequestMethod.POST)
	public ModelAndView editLoginView(@RequestParam("username")String username,@RequestParam("password")String password, HttpServletRequest request)
	{
		try {
			infoLog.logActivities("in EditLoginDetailsController-editLoginView: got="+username+" "+password);
			 HttpSession session= request.getSession();
			 Login l=(Login)session.getAttribute("userInfo");
			 
			 int i=dao1.editLoginInfo(l.getId(),username,password);
			 infoLog.logActivities("returned to EditLoginDetailsController-editLoginView: got= "+i);
			
				if(i==1)
				{	//setting session
					Login l1=new Login(l.getId(),l.getRole(),username,password);
					session.removeAttribute("userInfo");
					session.setAttribute("userInfo",l1);

					return modelAndViewUtility.returnModelAndView("welcome",null,null);
				}
				else
				{   throw new Exception();  }
				
			}
			catch(Exception e)
			{
				infoLog.logActivities("in EditLoginDetailsController-editLoginView: "+e);
				return modelAndViewUtility.returnModelAndView("EditLoginDetailsView","status", "false");
			} 
			
	}
}
