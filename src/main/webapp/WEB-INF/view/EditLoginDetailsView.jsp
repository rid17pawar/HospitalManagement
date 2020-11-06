<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="com.project.dao.LoginDao" 
    pageEncoding="ISO-8859-1"%>
    <%! 
	LoginDao infoLog= new LoginDao();
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta charset="utf-8">
		  <meta name="viewport" content="width=device-width, initial-scale=1">
		  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
		  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
		  
</head>
<body>
	
	<div class="container"><br/><br/><br/>
	<div class="row">
		<div class="col-sm-3"></div>
		<div class="col-sm-6">
		
			<div class="card bg-light border-primary mb-3" >
			  <div class="card-header"><h4>Change Login Credentials....</h4></div>
			  <div class="card-body">
			    <p class="card-text">
			    
			    	<form name="editLogin" action="newLoginDetails.html" method="post" autocomplete="off">
			    	<div class="form-group" style="color: red;">
						<%	
						try{
							String status=(String)request.getAttribute("status");
							infoLog.logActivities("editlogindetailsview: "+status);
								if(status.equals("false"))
								{  out.print("No such account exists. Please insert valid credentials");  }
							}
						catch(Exception e)
							{infoLog.logActivities("editlogindetailsview: "+e);}
						%>
					</div>
						 <div class="form-group">
						 	<label>Username</label>
						 	<input type="text" class="form-control" id="exampleInputEmail1" name="username" placeholder="Enter New Username"
						 	required="required" maxlength="20">
						 </div>
						 <div class="form-group">
						 	<label>Password</label>
						 	<input type="password" class="form-control" id="exampleInputEmail1" name="password" placeholder="Enter New Password"
						 	required="required" minlength="8" maxlength="8">
						 </div>
						 <div class="form-group">
						 	<label>Confirm Password</label>
						 	<input type="password" class="form-control" id="exampleInputEmail1" name="passwordAgain" placeholder="Enter New Password Again"
						 	required="required" minlength="8" maxlength="8">
						 </div>
						 <div style="text-align: center;">
				    	<button type="submit" class="btn btn-primary" onclick="return validate()">Submit</button>
				    	</div>
				    </form>
			    </p>
			  </div>
			</div>
			
		</div>
		<div class="col-sm-3"></div>
		</div>
	</div>

<script>
	function validate()
	{
		var pass1=document.editLogin.password.value;
		var pass2=document.editLogin.passwordAgain.value;
		if(pass1 == pass2)
			{   return true;	}
		else
			{  
				alert("password and confirm password must match");
				return false;  
			}
	}
</script>
</body>
</html>