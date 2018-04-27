<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ministry Information</title>


<script type="text/javascript"
	src="resources/js/app.js/service/ministryinfoService.js"></script>
<script type="text/javascript"
	src="resources/js/app.js/controller/ministryinfoController.js"></script>


</head>
<body>
	<br>
	<div ng-controller="ministryinfoController">
		<div class="container-fluid">

			<div class="row">
				<div class="col-sm-3" style="background-color: white;">Ministry Name</div>
				<div class="col-sm-3" style="background-color: white;">
					<input type="text" ng-model="name" class="form-control"
						placeholder="Ministry Name">
				</div>

			</div>		
			<br>
			<div class="row">
				<button type="submit" class="btn" id="submit"
					ng-click="ministryinfo()">Submit</button>
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