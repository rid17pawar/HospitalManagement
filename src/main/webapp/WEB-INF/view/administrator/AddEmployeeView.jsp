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
		<% if(l.getRole().equals("administrator")){ %>
			    <a href="addEmployeeView.html">
			    	<span class="text-warning">&nbsp;&nbsp;&nbsp;&nbsp;>&nbsp;&nbsp;Add Employee</span>
			    </a>
				<a href="searchEmployeeView.html">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Search Employee
				</a>
				<a href="allEmployeesView.html">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;All Employees
				</a>
		<%} %>
			</div>
	    </div>
	    
	    <div class="col-sm-12">
	      <!-- display window -->
			<div class="main"><br/><br/>
			<h1>Add New Employee</h1>
				<div class="container grey">
				<form name="addEmp" action="addEmployee.html" method="post" >
				 <div class="form-group"><br/>
			      <label>Name</label>
			        <div class="row">
			        <div class="col-sm-4">
			        <input type="text" class="form-control" id="exampleInputEmail1" name="firstName" placeholder="First Name"
			        required="required" autocomplete="off" maxlength="20">
			        </div>
			        <div class="col-sm-4">
			        <input type="text" class="form-control" id="exampleInputEmail1" name="middleName" placeholder="Middle Name"
			        required="required" autocomplete="off" maxlength="20">
			        </div>
			        <div class="col-sm-4">
			        <input type="text" class="form-control" id="exampleInputEmail1" name="lastName" placeholder="Last Name"
			        required="required" autocomplete="off" maxlength="20">
			        </div>
			    </div>
			
			     <div class="form-group"><br/>
			      <label>Birthdate</label>
			      <input type="date" class="form-control" id="exampleInputEmail1" name="birthdate" placeholder="Choose BirthDate"
			        required="required" max="2020-03-14">
			    </div>
			
			    <div class="form-group">
			      <label>Gender</label>
			      <select class="form-control" id="exampleSelect1" name="gender">
			        <option value="female">Female</option>
			        <option value="male">Male</option>
			        <option value="other">Other</option>
			      </select>
			    </div>
			
			     <div class="form-group">
			      <label>Email address</label>
			      <input type="email" class="form-control" id="exampleInputEmail1" name="email" placeholder="Enter Email"
			        required="required" autocomplete="off" maxlength="30">
			    </div>
			
			     <div class="form-group">
			      <label>Mobile No</label>
			      <input type="text" class="form-control" id="exampleInputEmail1" name="mobileNo" placeholder="Enter Mobile No"
			        required="required" autocomplete="off" minlength="10" maxlength="10">
			    </div>
			
			     <div class="form-group">
			      <label>Adhar No</label>
			      <input type="text" class="form-control" id="exampleInputEmail1" name="adharNo" placeholder="Enter Adhar No"
			        required="required" autocomplete="off" minlength="12" maxlength="12">
			    </div>
			
			     <div class="form-group">
			      <label>Country</label>
			      <input type="text" class="form-control" id="exampleInputEmail1" name="country" placeholder="Enter Country"
			        required="required" autocomplete="off" maxlength="20">
			    </div>
			
			     <div class="form-group">
			      <label>State</label>
			      <input type="text" class="form-control" id="exampleInputEmail1" name="state" placeholder="Enter State"
			        required="required" autocomplete="off" maxlength="20">
			    </div>
			
			    <div class="form-group">
			      <label>City</label>
			      <input type="text" class="form-control" id="exampleInputEmail1" name="city" placeholder="Enter City"
			        required="required" autocomplete="off" maxlength="20">
			    </div>
			
			     <div class="form-group">
			      <label>Residential Address</label>
			      <textarea class="form-control" id="exampleTextarea" rows="2" name="residentialAddress"
			        required="required" autocomplete="off" maxlength="100"></textarea>
			    </div>
			
			     <div class="form-group">
			      <label>Permanent Address</label>
			      <textarea class="form-control" id="exampleTextarea" rows="2"  name="permanentAddress"
			        required="required" autocomplete="off" maxlength="100"></textarea>
			    </div>
			
			    <div class="form-group">
			      <label>Role</label>
			      <select class="form-control" id="exampleSelect1" name="role">
			          <option value="doctor">Doctor</option>
			          <option value="receptionist">Receptionist</option>
			          <option value="administrator">Administrator</option>
			        </select>
			    </div>
			
			    <div class="form-group">
			      <label>Qualification</label>
			      <input type="text" class="form-control" id="exampleInputEmail1" name="qualification" placeholder="Enter Qualification"
			        required="required" autocomplete="off" maxlength="50">
			    </div>
			
			    <div class="form-group">
			      <label>Specialization</label>
			      <input type="text" class="form-control" id="exampleInputEmail1" name="specialization" placeholder="Enter Specialization"
			        required="required" autocomplete="off" maxlength="50">
			    </div>
			    <div  style="text-align:center;">
				    <button type="submit" class="btn btn-primary">Submit</button>
				    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				    <button type="reset" class="btn btn-danger">Clear</button>
			    </div>
			     
			</div><br/><br/>
			</form></div>
			</div>
		</div>
		
	</div>
	</div>
	
</body>
</html> 
<body>