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
<br>

<div class="container-fluid">
			
			<div class="row">
				<div class="col-sm-1" style="background-color: white;">Year</div>
				<div class="col-sm-3" style="background-color: white;"><input type="text"></div>
				<div class="col-sm-1" style="background-color: white;">EmployeeID</div>
				<div class="col-sm-1" style="background-color: white;"><input type="text"></div>
			</div>
			<br>
			<div class="row">
				<div class="col-sm-1" style="background-color: white;">Start Date</div>
				<div class="col-sm-3" style="background-color: white;"><input type="text"></div>
				<div class="col-sm-1" style="background-color: white;">End Date</div>
				<div class="col-sm-1" style="background-color: white;"><input type="text"></div>
			</div>
						
</div>

<br>
		<a href="http://localhost:8080/LMS/leavehistoryresult" class="btn btn-info" role="button">Search</a>
		<button type="button" class="btn">Clear</button>
		
</body>
</html>