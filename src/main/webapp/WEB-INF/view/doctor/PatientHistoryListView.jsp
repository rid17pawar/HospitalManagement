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
		
		<% if(l.getRole().equals("doctor")){ %>
				<a href="opdQueueD.html">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;OPD Queue
				</a>
				<a href="searchPatientView.html">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Search Patient
				</a>
				<a href="viewDopdPatient2.html">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Patient General Info
				</a>
				<a href="patientHistoryList.html">
				<span class="text-warning">&nbsp;&nbsp;&nbsp;&nbsp;>&nbsp;&nbsp;History</span>
				</a>
				<a href="patientObservePrescribe.html">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Observations &<br/>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Prescription
				</a>
				
		<%} %>
			</div>
	    </div>
	    
	     <div class="col-sm-12">
	      <!-- display window -->
			<div class="main"><br/><br/>
			<% String pname= (String)session.getAttribute("currentPatientName"); %>
			<h3> <%=pname %>'s History</h3><br/>
			<%@page import="com.project.entity.Opd, java.util.List" %>
			  <table class="table table-bordered">
				<thead>
					<tr>
					<td>Date</td>
					<td>Doctor Name</td>
					<td>Action</td>
					</tr>
				</thead>
			    <tbody>
			    <%
			    	List<String[]> opds=(List<String[]>) request.getAttribute("historyList");
			    	for(String[] opd: opds)
			    	{
			    %>
		       <tr>
		        <td><%= opd[0] %></td>
		      	<td><%= opd[1] %></td>
		      	<td><span  style="text-align:center;">
		      		<form action="patientHistory.html" method="post">
		      			<input type="text" name="opdid" value="<%= opd[2]%>" hidden="">
		      			<button type="submit" class="btn btn-primary"> View </button>
		      		</form></span>
		      	</td>
			  </tr>
			  <%} %>
			</tbody>
			</table>
			</div>
		</div>
		
	</div>
	</div>
	
</body>
</html> 