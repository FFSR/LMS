<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


<link rel="stylesheet"
	href="resources/css/bootstrap.min.css">
<script
	src="resources/js/jquery-3.2.1.slim.min.js"></script>
<script
	src="resources/js/popper.min.js"></script>
<script
	src="resources/js/bootstrap.min.js"></script>
	
</head>

<body>


<div class="container-fluid"> <br>

	<div class="row">		
  		<div class="col-sm-1" style="background-color: white;">User Name</div> 
		<div class="col-sm-1" style="background-color: white;"><input type="text"></div>
	</div><br>	
	
	
	<div class="row">
		<div class="col-sm-1" style="background-color: white;">Password</div>
		<div class="col-sm-1" style="background-color: white;"><input type="password" id = "inputPassword"></div> 	
	</div>

      
    <br><br>
		<button type="button" class="btn">Login</button>
		<button type="button" class="btn">Cancel</button>
		<br>
		<a href="#" class="btn btn-default" >Forget Password?</a>		
		<a href="http://localhost:8080/LMS/changepassword" class="btn btn-default" >Change Password</a> <br>
		<a href="http://localhost:8080/LMS/registration" class="btn btn-default" >Registration</a>


</div>


</body>
</html>