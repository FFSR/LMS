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

<style type="text/css">
.custom {
	font-family: Courier;
	color: red;
	font-size: 25px;
}


body {
	font-family:  Arial /*Poppins, sans-serif*/;
	color: #000;
}


body label {
	font-family:  Arial /*Poppins, sans-serif*/;
	color: #000;
	font-weight: bold; 
	margin-left: .5em;
}

.btn_tf {
	border-radius: 0px;
	border: thin solid #027C05;
	color: #027C05;
	padding: 0 30px;
    transition: all 0.3s ease 0s;
	-o-transition: all 0.3s ease 0s;
	-ms-transition: all 0.3s ease 0s;
	-moz-transition: all 0.3s ease 0s;
	-webkit-transition: all 0.3s ease 0s;
	padding: 5px 20px;
}

.btn_tf:focus {
	border-radius: 30px;
	background: #02C800;
	color: #fff;
    transition: all 0.6s ease 0s;
	-o-transition: all 0.6s ease 0s;
	-ms-transition: all 0.6s ease 0s;
	-moz-transition: all 0.6s ease 0s;
	-webkit-transition: all 0.6s ease 0s;
}

.btn_tf:hover {
	border-radius: 30px;
	background: #084301;
	color: #fff;
    transition: all 0.6s ease 0s;
	-o-transition: all 0.6s ease 0s;
	-ms-transition: all 0.6s ease 0s;
	-moz-transition: all 0.6s ease 0s;
	-webkit-transition: all 0.6s ease 0s;
}

.btn_tf_red {
	background: #ffo;
}

.link_black a {
	color: #000;
}

</style>
</head>

<body>
	<div ng-controller="loginController" style="backgroung: #fff;"">
	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<div class="white-box">
					<h3 class="box-title m-b-0">User Login</h3>
					<!-- <p class="text-muted m-b-30 font-13" color: #000;>Please provide your
						details to login</p> -->
			<h2 style="font-family: Arial; color: #000; font-size: 20px; font-wight: bold; ">Please provide your
						details to login</h2>
					<div class="row">
						<div class="col-sm-12 col-xs-12 link_black">
							<form>
								<div class="form-group">
									<label for="">User Name</label>
									<div class="input-group">
										<div class="input-group-addon">
											<i class="ti-user"></i>
										</div>
										<input type="text" ng-model="username" class="form-control"
											id="" placeholder="Username" ng-required="true">
									</div>
								</div>
								<div class="form-group">
									<label for="exampleInputpwd1">Password</label>
									<div class="input-group">
										<div class="input-group-addon">
											<i class="ti-lock"></i>
										</div>
										<input type="password" ng-model="password"
											class="form-control" id="exampleInputpwd1"
											placeholder="Password" ng-required="true">
									</div>
								</div>
								<button type="submit" ng-click="login(username,password)"
									class="btn btn_tf btn-success waves-effect waves-light m-r-10">Login</button>
								<button type="submit"
									class="btn btn_tf btn-denger waves-effect waves-light">Cancel</button>
							</form>
							<br /> 
							 <!--  <a href="http://123.49.38.94:7070/LMS/forgetpasswd">Forget
								Password
								</a> &nbsp;&nbsp;&nbsp;&nbsp; -->
							 	 <a href="http://localhost:8080/LMS/forgetpasswd">Forget
								Password
								<!-- </a> &nbsp;&nbsp;&nbsp;&nbsp;
								 <a href="http://123.49.38.94:7070/LMS/registration">Registration</a> 
							    &nbsp;&nbsp;&nbsp;&nbsp; -->
							
							 <a href="http://localhost:8080/LMS/registration">Registration</a> 
							&nbsp;&nbsp;&nbsp;&nbsp;

						</div>
					</div>
				</div>
			</div>
			
			<div class="col-md-6">
				<img src="resources/images/login_support_img.png" width="" height="">
				
			</div>

		</div>

		<div class="row">
			<div class="col-md-12">
				<div id="successMssages" class="p-3 mb-2 bg-success text-white"
					data-ng-show="successMessages" data-ng-bind="successMessages"></div>
				<div id="errorMessages" class="p-3 mb-2 bg-danger text-white"
					data-ng-show="errorMessages" data-ng-bind="errorMessages"></div>
			</div>
		</div>
	</div>
	</div>
</body>
</html>