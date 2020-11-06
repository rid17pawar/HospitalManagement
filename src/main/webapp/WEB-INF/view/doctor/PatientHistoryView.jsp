<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="com.project.dao.LoginDao" 
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
   	<%! 
	LoginDao infoLog= new LoginDao();
    %>
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
			<h3> <%=pname %>'s Observations and Prescription</h3><br/>
			
				<div class="card bg-light border-primary mb-3" >
				  <div class="card-header"><h4>Observations</h4>(Only For Doctors)</div>
				  <div class="card-body">
				    <p class="card-text">
		    <%@ page import="com.project.entity.OpdDetails" %>
			<% OpdDetails data=(OpdDetails) request.getAttribute("history"); %>
						<table class="table table-bordered">
							<tbody>
							    <tr>
								    <td>Symptoms</td>
								    <td>
								    	<%
											String temp=data.getSymptoms();
											String[] temp1=temp.split("#");
											for(int i=1; i<temp1.length; i++)
											{  
												out.print("- "+temp1[i]+"<br>");
											}
										%>
								    </td>
							    </tr>
							    <tr><td>Diagnosis</td><td><%= data.getDiagnosis() %></td></tr>
					    	</tbody>
					    </table>
				    </p>
				  </div>
				</div>
					
				<div class="card bg-light border-primary mb-3" >
				  <div class="card-header"><h4>Prescription</h4>(For Patients & Receptionist)</div>
				  <div class="card-body">
				    <p class="card-text">
				    	<table class="table table-bordered">
				    		<tbody>
							    <tr>
							    <td>Medicines and Dosage</td>
							    <td>
							 		<%
							 	
										temp=data.getMedicinesDose();
										temp1=temp.split("#");
								try{
										String[] temp2;
										for(int i=1; i<temp1.length; i++)
										{  
											temp2=temp1[i].split("@");
											out.print("- "+temp2[0]+" ("+temp2[1]+" times) "+"<br>");
										}
							 		}
							 		catch(Exception e)
							 		{
							 			infoLog.logActivities(""+e);
							 			for(int i=1; i<temp1.length; i++)
										{
							 			out.print("- "+temp1[i]+"<br>");
										}
							 		}
									%>
							 	</td>
							    </tr>
							    <tr>
								    <td>Do's</td>
								    <td>
								    	 <%
											temp=data.getDos();
											temp1=temp.split("#");
											for(int i=1; i<temp1.length; i++)
											{  
												out.print("- "+temp1[i]+"<br>");
											}
										%>
								    </td>
							    </tr>
							    <tr>
								    <td>Dont's</td>
								    <td>
								    	<%
											temp=data.getDonts();
											temp1=temp.split("#");
											for(int i=1; i<temp1.length; i++)
											{  
												out.print("- "+temp1[i]+"<br>");
											}
										%>
								    </td>
							    </tr>
							    <tr><td>Investigations</td><td><%= data.getInvestigations() %></td></tr>
							    <tr><td>Follow up date</td><td><%= data.getFollowupDate() %></td></tr>
							    <tr><td>Fees</td><td>Rs. <%= data.getFees() %></td></tr>
					    	</tbody>
					    </table>
				    </p>
				  </div>
				</div><br/>
			</div>
		</div>
		
	</div>
	</div>
	
</body>
</html> 
<body>