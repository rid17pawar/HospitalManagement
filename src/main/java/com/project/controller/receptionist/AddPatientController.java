package com.project.controller.receptionist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.dao.LoginDao;
import com.project.dao.receptionist.AddPatientDao;
import com.project.dao.receptionist.PatientPrescriptionDao;
import com.project.entity.Address;
import com.project.entity.Name;
import com.project.entity.Patient;

@Controller
public class AddPatientController 
{
	@Autowired
	AddPatientDao dao;
	
	@Autowired
	PatientPrescriptionDao dao1;
	
	@Autowired
	LoginDao infoLog;
	
	@RequestMapping(value="/addPatientView.html")
	public ModelAndView view()
	{	
		try {
			List<String[]> doctors= dao.getDoctors();
			infoLog.logActivities("in AddPatientController-view:got= ");
			for(String[] str: doctors)
			{
				infoLog.logActivities(str[0]+", "+str[1]+", "+str[2]+", "+str[3]+", ");
			}
				if(! doctors.equals(null))
				{
					ModelAndView mv= new ModelAndView();
					mv.setViewName("receptionist/AddPatientView");
					mv.addObject("prescriptionsCount", dao1.prescriptionPrintCount());  //for receptionist only
					mv.addObject("doctorsList", doctors);
					return mv;
				}
				else
				{   throw new Exception();  }
				
			 }
			catch(Exception e)
			{
				infoLog.logActivities("in AddPatientController-view: "+e);	
				ModelAndView mv= new ModelAndView();
				mv.setViewName("failure");
				mv.addObject("error",e);
				return mv;
			}
	}

	@RequestMapping(value="/addPatient.html", method = RequestMethod.POST)
	public ModelAndView add(@RequestParam("firstName")String firstName, @RequestParam("middleName")String middleName, @RequestParam("lastName")String lastName, @RequestParam("birthdate")String birthdate, @RequestParam("gender")String gender, @RequestParam("email")String email, @RequestParam("mobileNo")Long mobileNo, @RequestParam("adharNo")Long adharNo, @RequestParam("country")String country, @RequestParam("state")String state, @RequestParam("city")String city, @RequestParam("residentialAddress")String residentialAddress, @RequestParam("permanentAddress")String permanentAddress, @RequestParam("bloodGroup")String bloodGroup, @RequestParam("chronicDiseases")String chronicDiseases, @RequestParam("medicineAllergy")String medicineAllergy, @RequestParam("doctorId")String doctorId)
	{	
		//try{
			Name n1= new Name(firstName, middleName, lastName);
			Address a1= new Address(residentialAddress,permanentAddress);
			infoLog.logActivities("in AddPatientController-add: got= "+n1+" "+birthdate+" "+gender+" "+email+" "+mobileNo+" "+adharNo+" "+country+" "+state+" "+city+" "+a1+" "+bloodGroup+" "+chronicDiseases+" "+medicineAllergy+" "+doctorId);
	       		
			Patient p1= new Patient(n1,birthdate,gender,email,mobileNo,adharNo,country,state,city,a1,bloodGroup,chronicDiseases,medicineAllergy,doctorId);
			boolean b=dao.add(p1);
			infoLog.logActivities("returned to AddPatientController-add: got= "+b);
				if(b)
				{
					ModelAndView mv= new ModelAndView();
					mv.addObject("prescriptionsCount", dao1.prescriptionPrintCount());  //for receptionist only
					mv.setViewName("successPage");
					return mv;
				}
				//else
				//{   throw new Exception();  }
			/*}
			catch(Exception e)
			{
				infoLog.logActivities("in AddPatientController-add: "+e);
				ModelAndView mv= new ModelAndView();
				mv.setViewName("failure");
				mv.addObject("error",e);
				return mv;
			}*/
				return new ModelAndView();
	}
}
