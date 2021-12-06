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
	
	<%@ include file="header.jsp" %>
	
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
			    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Add Employee
			    </a>
				<a href="searchEmployeeView.html">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Search Employee
				</a>
				<a href="allEmployeesView.html">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;All Employees
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
		
		<% if(l.getRole().equals("doctor")){ %>
				<a href="opdQueueD.html">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;OPD Queue
				</a>
				<a href="searchPatientView.html">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Search Patient
				</a>
				<a class="text-primary">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Patient General Info
				</a>
				<a class="text-primary">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;History
				</a>
				<a class="text-primary">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Observations &<br/>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Prescription
				</a>
		<%} %>
			</div>
	    </div>
	    
	    <div class="col-sm-12">
	      <!-- display window -->
			<div class="main"><br/><br/><br/><br/><br/><br/><br/><br/>
				<h1><div style="text-align:center;">
					Welcome <span style="color: orange;"><%=l.getUsername() %> </span>! <br/>
					 Let's Get Started !
				</div></h1>
		
		<%@page import="java.util.List" %>		
		<% if(l.getRole().equals("administrator")){ 
			List<Integer> users_count=(List<Integer>) request.getAttribute("users_count");
		%>
			<br/><br/>
			<div class="row">
			  <div class="col-sm-3">
			    <div class="card text-white bg-primary mb-3" style="max-width: 20rem;">
				  <div class="card-body">
				    <h4 class="card-title">Doctors</h4>
				    <p class="card-text"><%=users_count.get(0) %></p>
				  </div>
				</div>
			  </div>
			  
			  <div class="col-sm-3">
			    <div class="card text-white bg-primary mb-3" style="max-width: 20rem;">
				  <div class="card-body">
				    <h4 class="card-title">Patients</h4>
				    <p class="card-text"><%=users_count.get(1) %></p>
				  </div>
				</div>
			  </div>
			  
			  <div class="col-sm-3">
			    <div class="card text-white bg-primary mb-3" style="max-width: 20rem;">
				  <div class="card-body">
				    <h4 class="card-title">Employees</h4>
				    <p class="card-text"><%=users_count.get(2) %></p>
				  </div>
				</div>
			 </div>
				
			<div class="col-sm-3">
			    <div class="card text-white bg-primary mb-3" style="max-width: 20rem;">
				  <div class="card-body">
				    <h4 class="card-title">OPD Fees</h4>
				    <p class="card-text">Rs.<%=users_count.get(3) %></p>
				  </div>
				</div>
			  </div>
		<%} %>
		
			</div>
		</div>
				
	</div>
	</div>
	
</body>
</html> 
<body>