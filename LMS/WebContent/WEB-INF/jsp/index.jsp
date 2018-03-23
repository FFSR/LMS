F<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<script type="text/javascript"
	src="resources/js/app.js/service/testService.js"></script>
<script type="text/javascript"
	src="resources/js/app.js/controller/testController.js"></script>

<!--Start bootstrap stuff -->

<link rel="stylesheet"
	href="resources/css/bootstrap.min.css">
<script
	src="resources/js/jquery-3.2.1.slim.min.js"></script>
<script
	src="resources/js/popper.min.js"></script>
<script
	src="resources/js/bootstrap.min.js"></script>

<!-- End bootstrap stuff -->


</head>
<body>
	<div ng-controller="TestController">
		<div class="container-fluid">
			<h1>Hello World!</h1>
			<p>Resize the browser window to see the effect.</p>
			<p>The columns will automatically stack on top of each other when
				the screen is less than 576px wide.</p>
			<div class="row">
				<div class="col-sm-3" style="background-color: lavender;">.col-sm-3</div>
				<div class="col-sm-3" style="background-color: lavenderblush;">.col-sm-3</div>
				<div class="col-sm-3" style="background-color: lavender;">.col-sm-3</div>
				<div class="col-sm-3" style="background-color: lavenderblush;">.col-sm-3</div>
			</div>
		</div>
		
		<div class="form-group">
										<label>Network ID:</label>
										<div class="input-group">
											<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
											<input type="text" ng-model="networkId" class="form-control" placeholder="Network ID">
										</div>
									</div>
										
		<div class="form-group">
										<label for="pwd">Password:</label>
										<div class="input-group">
											<span class="input-group-addon"></span>
											<input type="password" ng-model="password" class="form-control" placeholder="Login Password">
										</div>
									</div>
									
		<button type="submit" class="form-control btn btn-primary" id="login"
										ng-click="login(networkId,password)">Login</button>
										
		<div>Response: {{testMsg}}</div>
		
	</div>
</body>
</html>