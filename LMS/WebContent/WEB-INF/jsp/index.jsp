<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<script type="text/javascript"
	src="resources/js/app.js/controller/testController.js"></script>

<!--Start bootstrap stuff -->

<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<script src="resources/js/jquery-3.2.1.slim.min.js"></script>
<script src="resources/js/popper.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>

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
	</div>
</body>
</html>