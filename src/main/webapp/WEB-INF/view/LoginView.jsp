<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="com.project.dao.LoginDao" 
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
     <%! 
	LoginDao infoLog= new LoginDao();
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Log In</title>
	    <meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="https://fonts.googleapis.com/css?family=Roboto:400,700" rel="stylesheet">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
		<style type="text/css">
			body{
					color: #fff;
					background: #3598dc;
					font-family: 'Roboto', sans-serif;
				}
			    .form-control{
					height: 41px;
					border: primary;
				}
				
			    .form-control, .btn{        
			        border-radius: 3px;
			    }
				.signup-form{
					width: 390px;
					margin: 30px auto;
				}
				.signup-form form{
					color: #999;
					border-radius: 3px;
			    	margin-bottom: 15px;
			        background: #fff;
			        box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
			        padding: 30px;
			    }
				.signup-form h2 {
					color: #333;
					font-weight: bold;
			        margin-top: 0;
			    }
			    .signup-form hr {
			        margin: 0 -30px 20px;
			    }  
				.signup-form input[type="checkbox"]{
					margin-top: 3px;
				}
				.signup-form .row div:first-child{
					padding-right: 10px;
				}
				.signup-form .row div:last-child{
					padding-left: 10px;
				}
			    .signup-form .btn{        
			        font-size: 16px;
			        font-weight: bold;
					border: none;
					min-width: 140px;
			    }
				.signup-form .btn:hover, .signup-form .btn:focus{
			        outline: none;
				}
			    .signup-form a{
					color: #fff;
					text-decoration: underline;
				}
				.signup-form a:hover{
					text-decoration: none;
				}
				.signup-form form a{
					color: #3598dc;
					text-decoration: none;
				}	
				.signup-form form a:hover{
					text-decoration: underline;
				}
			    .signup-form .hint-text {
					padding-bottom: 15px;
					text-align: center;
			    }
		</style>
</head>
<body>
	
	<div class="signup-form">
    <form action="dashboard.html" method="post" autocomplete="off">
		<h2>Sign In</h2>
		<p>Please fill in this form to access your account!</p>
		<hr>
		
		<div class="form-group" style="color: red;">
			<%	
			try{
				String status=(String)request.getAttribute("status");
				infoLog.logActivities("loginview: "+status);
					if(status.equals("false"))
					{  out.print("No such account exists. Please insert valid credentials");  }
				}
			catch(Exception e)
				{infoLog.logActivities("loginview: "+e);}
			%>
		</div>
		
	    <div class="form-group">
	      <label for="role">Role</label>
	      <select class="form-control" name="role" id="exampleSelect1">
	        <option value="doctor">Doctor</option>
	        <option value="receptionist">Receptionist</option>
	        <option value="administrator">Administrator</option>
	      </select>
	    </div>

		<div class="form-group">
	      <label for="username">Username</label>
	      <input type="text" name="username" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Username"
	      required="required">
	    </div>
	    <div class="form-group">
	      <label for="password">Password</label>
	      <input type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="Password"
	      required="required">
	    </div>
	    
		<button type="submit" class="btn btn-primary">Submit</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<button type="reset" class="btn btn-danger">Clear</button>
	    
	    <div style="color:white;">adding a row gap</div>
	    
		<div style="text-align: right;"  onmouseover="myFunction()" onmouseout ="demo()"> Want Help? </div>


		<strong>
		<div class="alert alert-dismissible text-primary">
  			<button type="button" class="close" data-dismiss="alert"></button>
  				<p id="demo"></p>
		</div></strong>
 </form>
 
<!-- javascript code -->
<script>
	function myFunction() 
	{
	  document.getElementById("demo").innerHTML = "Note: Your Default USERNAME is ID and PASSWORD is ADHAR NUMBER";
	}
	
	function demo()
	{
		document.getElementById("demo").innerHTML ="";
	}
</script>
		
</body>
</html>