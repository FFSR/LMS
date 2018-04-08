<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


<script type="text/javascript"
	src="resources/js/app.js/service/loginService.js"></script>
<script type="text/javascript"
	src="resources/js/app.js/controller/loginController.js"></script>

<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<script src="resources/js/jquery-3.2.1.slim.min.js"></script>
<script src="resources/js/popper.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>

</head>

<body>
	<div ng-controller="loginController">
		<div class="container-fluid">
			<br> <br>
			<div class="row">
				<div class="col-sm-1" style="background-color: white;">User
					Name</div>
				<div class="col-sm-2" style="background-color: white;">
					<input type="text" ng-model="username" class="form-control"
						placeholder="User Name"> {{username}}
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-sm-1" style="background-color: white;">Password</div>
				<div class="col-sm-2" style="background-color: white;">
					<input type="password" ng-model="password" class="form-control"
						placeholder="Password"> {{password}}
				</div>
			</div>
			<br> <br>
			<button type="submit" class="btn" id="login"
				ng-click="login(username,password)">Login</button>

			<button type="button" class="btn">Cancel</button>
			<br> <a href="http://localhost:8080/LMS/forgetpasswd"
				class="btn btn-default">Forget Password?</a> <a
				href="http://localhost:8080/LMS/changepassword"
				class="btn btn-default">Change Password</a> <br> <a
				href="http://localhost:8080/LMS/registration"
				class="btn btn-default">Registration</a>

			<div>Response: {{testMsg}}</div>
		</div>
	</div>
</body>
</html>