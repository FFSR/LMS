<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<script src="resources/js/jquery-3.2.1.slim.min.js"></script>
<script src="resources/js/popper.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="resources/js/app.js/service/DropDownService.js"></script>
</head>
<body>

	<div class="container-fluid">

		<div class="row">
			<div class="col-sm-3" style="background-color: white;">User
				ID</div>
			<div class="col-sm-3" style="background-color: white;">
				<input type="text">
			</div>
			<div class="col-sm-3" style="background-color: white;">Name</div>
			<div class="col-sm-3" style="background-color: white;">
				<input type="text">
			</div>
		</div>
<br>
		<div class="row">
			<div class="col-sm-3" style="background-color: white;">Leave
				Type</div>
				<div class="col-sm-3">
					<!-- Drop Down list from table -->
					<select class="form-control" id="ddAppStatus" ng-model="appStatus"
						ng-options="x as x.name for x in dropdownData track by x.id">
						<option value="">Select</option>
						<option value="">Hospital</option>
						<option value="">Casual</option>
					</select>
			</div>
			<div class="col-sm-3" style="background-color: white;">Email</div>
			<div class="col-sm-3" style="background-color: white;">
				<input type="text">
			</div>
		</div>

	</div>

<br>
<a href="http://localhost:8080/LMS/leavesearchresult" class="btn btn-info" role="button">Search</a>
		<button type="button" class="btn">Clear</button>

</body>
</html>