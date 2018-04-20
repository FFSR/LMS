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
	src="resources/js/app.js/controller/testleaveController.js"></script>
<script type="text/javascript"
	src="resources/js/app.js/service/applicationforleaveService.js"></script>
	
</head>
<body>
	
	<div ng-controller="testleaveController">
		<div class="container-fluid">

			<div class="row">
				<div class="col-sm-3" style="background-color: white;">Yearly Leave Eligibility</div>
				<div class="col-sm-3" style="background-color: white;">
					<input type="text" ng-model="eligibility" class="form-control"
						placeholder="Yearly Leave Eligibility">
				</div>

			</div>
			<br>
			<div class="row">
				<button type="submit" class="btn" id="submit"
					ng-click="testleave()">Submit</button>
				<div class="col-sm-3" style="background-color: white;"></div>
				<div class="col-sm-3" style="background-color: white;">
					<input type="button" class="btn btn-info" value="Cancel">
				</div>
				<div class="col-sm-3" style="background-color: white;"></div>
			</div>
		</div>
	</div>
	</div>
</body>
</html>