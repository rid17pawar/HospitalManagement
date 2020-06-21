<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
   	
<!DOCTYPE html>
<html>
<head>
<title>Dashboard</title>
<meta charset="utf-8">
		  <meta name="viewport" content="width=device-width, initial-scale=1">
		  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
		  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
		  
<style>

<!-- sidenavbar -->
body {
  font-family: "Calibri", sans-serif;
}

.sidenav {
  height: 100%;
  width: 250px;
  position: fixed;
  z-index: 1;
  top: 0;
  left: 0;
  background-color: #F5F5F5;
  overflow-x: hidden;
  padding-top: 20px;
}

.sidenav a {
  padding: 6px 8px 6px 16px;
  text-decoration: none;
  font-size: 20px;
  color: #0000ff;
  display: block;
}

.sidenav a:hover {
  color: #000000;
  text-decoration: none;
}

.main {
  margin-left: 200px; /* Same as the width of the sidenav */
}

</style>
</head>
<body>
	
	<%@ include file="../header.jsp" %>
	
	<div class="container">
	<div class="row">
	    <div class="col-sm-*">
			<!-- sidenavbar -->
			<%@page import="com.project.entity.Login" %>
			<%@page import="org.springframework.web.servlet.ModelAndView" %>
			<% Login l=(Login)session.getAttribute("userInfo");	 %>
			<div class="sidenav">
				<a><br/><br/>
				<div style="background-color: rgba(255,0,0,0.4);">&nbsp;&nbsp;&nbsp;
					<span class="badge badge-pill badge-warning">&nbsp;&nbsp;<%= l.getRole().toUpperCase() %>&nbsp;&nbsp;</span><br/><br/>
					<b>Username:</b> <%= l.getUsername() %><br/><br/>
					<b>Id:</b> <%= l.getId() %><br/>
					<a href="editView.html">
			    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style="text-decoration:underline; color:green;">edit...</span>
			    	</a>
				</div>
				</a><br/>
				
		<% if(!l.getId().equals("EMP100")){ %>
				<a href="personalInfo.html">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Personal Info
				</a>
		<%} %>
				
		<% if(l.getRole().equals("receptionist")){ %>
				<a href="addPatientView.html">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Add Patient
				</a>
				<a href="searchPatientView.html">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Search Patient
				</a>
				<a href="opdQueueView.html">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;OPD Queue
				</a>
				<a href="prescriptionQueueView.html">
					<% String count=""+request.getAttribute("prescriptionsCount"); %>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Prescriptions 
					<span class="badge badge-pill badge-danger"><%=count %></span>
				</a>
		<%} %>
		
			</div>
	    </div>
	    
	    <div class="col-sm-12">
	      <!-- display window -->
			<div class="main"><br/><br/>
			<h1>Edit Patient Details</h1><br/>
			<form action="editPatient.html" method="post">
			<%-- 	fields with disabled attribute are not submitted but readonly r submitted --%> 
			
				<div class="form-group">
			      <label>ID</label>
			      <input type="text" class="form-control" id="exampleInputEmail1" name="pid" value="${ patient.pid }" readonly="readonly">
			    </div>	
			    
				 <div class="form-group">
			      <label>Name</label>
			        <div class="row">
			        <div class="col-sm-4">
			        <input type="text" class="form-control" id="exampleInputEmail1" name="firstName" value="${ patient.name.firstName }"
						 	required="required" autocomplete="off" maxlegth="20">
			        </div>
			        <div class="col-sm-4">
			        <input type="text" class="form-control" id="exampleInputEmail1" name="middleName" value="${ patient.name.middleName }"
						 	required="required" autocomplete="off" maxlegth="20">
			        </div>
			        <div class="col-sm-4">
			        <input type="text" class="form-control" id="exampleInputEmail1" name="lastName" value="${ patient.name.lastName }"
						 	required="required" autocomplete="off" maxlegth="20">
			        </div>
			    </div>
			
			     <div class="form-group">
			      <label>Birthdate</label>
			      <input type="date" class="form-control" id="exampleInputEmail1" name="birthdate" value="${ patient.birthdate }"
			      required="required" max="2020-03-14">
			    </div>
			
			    <div class="form-group">
			      <label>Gender</label>
				  <input type="text" class="form-control" id="exampleInputEmail1" name="gender" value="${ patient.gender }" readonly="readonly">
			    </div>
			
			     <div class="form-group">
			      <label>Email address</label>
			      <input type="email" class="form-control" id="exampleInputEmail1" name="email" value="${ patient.emailID }"
						 	required="required" autocomplete="off" maxlegth="30">
			    </div>
			
			     <div class="form-group">
			      <label>Mobile No</label>
			      <input type="text" class="form-control" id="exampleInputEmail1" name="mobileNo" value="${ patient.mobileNo }"
						 	required="required" autocomplete="off" minlegth="10" maxlegth="10">
			    </div>
			
			     <div class="form-group">
			      <label>Adhar No</label>
			      <input type="text" class="form-control" id="exampleInputEmail1" name="adharNo" value="${ patient.adharNo }" readonly="readonly">
			    </div>
			
			     <div class="form-group">
			      <label>Country</label>
			      <input type="text" class="form-control" id="exampleInputEmail1" name="country" value="${ patient.country }"
						 	required="required" autocomplete="off" maxlegth="20">
			    </div>
			
			     <div class="form-group">
			      <label>State</label>
			      <input type="text" class="form-control" id="exampleInputEmail1" name="state" value="${ patient.state }"
						 	required="required" autocomplete="off" maxlegth="20">
			    </div>
			
			    <div class="form-group">
			      <label>City</label>
			      <input type="text" class="form-control" id="exampleInputEmail1" name="city" value="${ patient.city }"
						 	required="required" autocomplete="off" maxlegth="20">
			    </div>
			
			     <div class="form-group">
			      <label>Residential Address</label>
			      <input type="text" class="form-control" id="exampleInputEmail1" name="residentialAddress" value="${ patient.address.residentialAddress }"
						 	required="required" autocomplete="off" maxlegth="100">
			    </div>
			
			     <div class="form-group">
			      <label>Permanent Address</label>
			      <input type="text" class="form-control" id="exampleInputEmail1" name="permanentAddress" value="${ patient.address.permanentAddress }" readonly="readonly">
			    </div>
			
			     <div class="form-group">
			      <label>Blood Group</label>
			      <input type="text" class="form-control" id="exampleInputEmail1" name="bloodGroup" value="${ patient.bloodGroup }" readonly="readonly">
			    </div>
			    
			    <div class="form-group">
			      <label>Chronic Diseases</label>
			      <input type="text" class="form-control" id="exampleInputEmail1" name="chronicDiseases" value="${ patient.chronicDiseases }"
						 	required="required" autocomplete="off" maxlegth="50">
			    </div>
			
			    <div class="form-group">
			      <label>Medicine Allergy</label>
			      <input type="text" class="form-control" id="exampleInputEmail1" name="medicineAllergy" value="${ patient.medicineAllergy }"
						 	required="required" autocomplete="off" maxlegth="50">
			    </div>
			
			    <div class="form-group">
				      <label>Doctor to be Assigned</label>
				      <div class="row">
				        <div class="col-sm-4">
					        <select class="form-control" id="exampleSelect1" name="doctorId" value="${doctor }">
					        <%@ page import="java.util.List" %>
					        <% List<String[]> d=(List<String[]>) request.getAttribute("doctorsList"); 
					           for(String[] str: d)
					           { %>
					           <option value="<%= str[0] %>"><%= str[1]+" "+str[2]+" "+str[3] %></option>
					         <%} %>
					        </select>
				        </div>
				        </div>
				       </div>
			    <div style="text-align:center;">
				<button type="submit" class="btn btn-primary">Submit</button>
				</div>
			</div>
			</form>
		
			</div>
		</div>
		
	</div>
	</div>
	
</body>
</html> 
<body>