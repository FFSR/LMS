<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Division Information</title>

<script type="text/javascript"
	src="resources/js/app.js/controller/divisioninfoController.js"></script>
<script type="text/javascript"
	src="resources/js/app.js/service/divisioninfoService.js"></script>

<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<script src="resources/js/jquery-3.2.1.slim.min.js"></script>
<script src="resources/js/popper.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>



	
</head>
<body>

	<div ng-controller="divisioninfoController">
		<div class="container-fluid">

			<div class="row">
				<div class="col-sm-3" style="background-color: white;">Division
					Name</div>
				<div class="col-sm-3" style="background-color: white;">
					<input type="text" ng-model="name" class="form-control"
						placeholder="Division Name">
				</div>

			</div>
			<br>
			<div class="row">
				<button type="submit" class="btn" id="submit"
					ng-click="divisioninfo()">Submit</button>
				<div class="col-sm-3" style="background-color: white;"></div>
				<div class="col-sm-3" style="background-color: white;">
					<input type="button" class="btn btn-info" value="Cancel">
				</div>
				<div class="col-sm-3" style="background-color: white;"></div>
			</div>
		</div>
	</div>
</body>
</html>