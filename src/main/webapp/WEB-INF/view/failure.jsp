<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
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
<body style="background-color:#f5f5f5; text-decoration: none; text-align: center;">
	
	<br/><br/><br/><br/><br/><br/><br/>
	<h1>Oops ! Something went wrong.....</h1>
	<br/><br/><br/>
	<p>
		Cause: ${ error} 
	</p><br/>
	<form action="login.html" method="post">
		<button type="submit" class="btn btn-primary">&nbsp;&nbsp; Login &nbsp;&nbsp;</button>
	</form>
</body>
</html>