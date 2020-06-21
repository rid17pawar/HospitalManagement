package com.project.controller.receptionist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.dao.receptionist.PatientPrescriptionDao;
import com.project.dao.receptionist.SearchPatientDao;
import com.project.entity.Employee;
import com.project.entity.Patient;

@Controller
public class SearchPatientController 
{
	@Autowired
	SearchPatientDao dao;
	
	@Autowired
	PatientPrescriptionDao dao1;
	
	@RequestMapping(value="/searchPatientView.html")
	public ModelAndView view()
	{
		ModelAndView mv= new ModelAndView();
		mv.setViewName("receptionist/SearchPatientView");
		mv.addObject("prescriptionsCount", dao1.prescriptionPrintCount());  //for receptionist only
		mv.addObject("status","true");
		return mv;
	}
	
	@RequestMapping(value="/searchPatientByName.html", method = RequestMethod.POST)
	public ModelAndView searchName(@RequestParam("firstName")String firstName, @RequestParam("lastName")String lastName )
	{
		try {
			System.out.println("in SearchPatientController-searchName: got= "+firstName+" "+lastName);
			Patient p1= dao.searchName(firstName,lastName);
			System.out.println("returned to in SearchPatientController-searchName: got= "+p1);
			
			String doctorAssigned=dao.searchDoctorAssigned(p1.getDoctorId());
			System.out.println("returned to in SearchPatientController-searchName: got= "+doctorAssigned);
	    
			if(!(p1.getPid().equals(null)) && !(doctorAssigned.equals(null)))
			{
	
				ModelAndView mv= new ModelAndView();
				mv.setViewName("receptionist/PatientDetailsView");
				mv.addObject("patient", p1);
				mv.addObject("doctorAssigned", doctorAssigned);
				mv.addObject("prescriptionsCount", dao1.prescriptionPrintCount());  //for receptionist only
				return mv;
			}
			else
			{
				throw new Exception();
			}
	    }
		catch(Exception e)
		{
			System.out.println("in SearchPatientController-searchName: "+e);
			ModelAndView mv= new ModelAndView();
			mv.setViewName("receptionist/SearchPatientView");
			mv.addObject("prescriptionsCount", dao1.prescriptionPrintCount());  //for receptionist only
			mv.addObject("status","false");
			return mv;
		}
	}
	
	@RequestMapping(value="/searchPatientById.html", method = RequestMethod.POST)
	public ModelAndView searchId(@RequestParam("id")String pid)
	{
		try {
			System.out.println("in SearchPatientController-searchId: got= "+pid);
			Patient p1= dao.searchId(pid);
			System.out.println("returned to in SearchPatientController-searchId: got= "+p1);
			
			String doctorAssigned=dao.searchDoctorAssigned(p1.getDoctorId());
			System.out.println("returned to in SearchPatientController-searchId: got= "+doctorAssigned);
	    
			if(!(p1.getPid().equals(null)) && !(doctorAssigned.equals(null)))
			{
	
				ModelAndView mv= new ModelAndView();
				mv.setViewName("receptionist/PatientDetailsView");
				mv.addObject("patient", p1);
				mv.addObject("doctorAssigned", doctorAssigned);
				mv.addObject("prescriptionsCount", dao1.prescriptionPrintCount());  //for receptionist only
				return mv;
			}
			else
			{
				throw new Exception();
			}
	    }
		catch(Exception e)
		{
			System.out.println("in SearchPatientController-searchId: "+e);
			
			ModelAndView mv= new ModelAndView();
			mv.setViewName("receptionist/SearchPatientView");
			mv.addObject("prescriptionsCount", dao1.prescriptionPrintCount());  //for receptionist only
			mv.addObject("status","false");
			return mv;
		}
	}

	@RequestMapping(value="/searchPatientByMobileNo.html", method = RequestMethod.POST)
	public ModelAndView searchMobileNo(@RequestParam("mobileNo")Long mobileNo)
	{
		try {
			System.out.println("in SearchPatientController-searchMobileNo: got= "+mobileNo);
			Patient p1= dao.searchMobileNo(mobileNo);
			System.out.println("returned to in SearchPatientController-searchMobileNo: got= "+p1);
			
			String doctorAssigned=dao.searchDoctorAssigned(p1.getDoctorId());
			System.out.println("returned to in SearchPatientController-searchMobileNo: got= "+doctorAssigned);
	    
			if(!(p1.getPid().equals(null)) && !(doctorAssigned.equals(null)))
			{
	
				ModelAndView mv= new ModelAndView();
				mv.setViewName("receptionist/PatientDetailsView");
				mv.addObject("patient", p1);
				mv.addObject("doctorAssigned", doctorAssigned);
				mv.addObject("prescriptionsCount", dao1.prescriptionPrintCount());  //for receptionist only
				return mv;
			}
			else
			{
				throw new Exception();
			}
	    }
		catch(Exception e)
		{
			System.out.println("in SearchPatientController-searchMobileNo: "+e);
			
			ModelAndView mv= new ModelAndView();
			mv.setViewName("receptionist/SearchPatientView");
			mv.addObject("prescriptionsCount", dao1.prescriptionPrintCount());  //for receptionist only
			mv.addObject("status","false");
			return mv;
		}
	}	
	
	@RequestMapping(value="/searchPatientByAdharNo.html", method = RequestMethod.POST)
	public ModelAndView searchAdharNo(@RequestParam("aadharNo")Long adharNo)
	{
		try {
			System.out.println("in SearchPatientController-searchAdharNo: got= "+adharNo);
			Patient p1= dao.searchAdharNo(adharNo);
			System.out.println("returned to in SearchPatientController-searchAdharNo: got= "+p1);
			
			String doctorAssigned=dao.searchDoctorAssigned(p1.getDoctorId());
			System.out.println("returned to in SearchPatientController-searchAdharNo: got= "+doctorAssigned);
	    
			if(!(p1.getPid().equals(null)) && !(doctorAssigned.equals(null)))
			{
	
				ModelAndView mv= new ModelAndView();
				mv.setViewName("receptionist/PatientDetailsView");
				mv.addObject("patient", p1);
				mv.addObject("doctorAssigned", doctorAssigned);
				mv.addObject("prescriptionsCount", dao1.prescriptionPrintCount());  //for receptionist only
				return mv;
			}
			else
			{
				throw new Exception();
			}
	    }
		catch(Exception e)
		{
			System.out.println("in SearchPatientController-searchAdharNo: "+e);
			
			ModelAndView mv= new ModelAndView();
			mv.setViewName("receptionist/SearchPatientView");
			mv.addObject("prescriptionsCount", dao1.prescriptionPrintCount());  //for receptionist only
			mv.addObject("status","false");
			return mv;
		}
	}
	
}
