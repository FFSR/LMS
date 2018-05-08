<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript"
	src="resources/js/app.js/service/changepasswordService.js"></script>
<script type="text/javascript"
	src="resources/js/app.js/controller/changepasswordController.js"></script>

</head>

<body>
	<div ng-controller="changepasswordController">
		<div ng-init="getSessionUserDetails('${sessionScope.user.id}');"></div>
		<div class="container-fluid">
			<br>
			<div class="row">
				<div class="col-sm-2" style="background-color: white;">Old
					Password</div>
				<div class="col-sm-2" style="background-color: white;">
					<input type="password" ng-model="oldpassword" class="form-control"
						placeholder="Old Password">
				</div>
			</div>
			<br>

			<div class="row">
				<div class="col-sm-2" style="background-color: white;">New
					Password</div>
				<div class="col-sm-2" style="background-color: white;">
					<input type="password" ng-model="newpassword" class="form-control"
						placeholder="New Password">
				</div>
			</div>
			<br>

			<div class="row">
				<div class="col-sm-2" style="background-color: white;">Confirm
					Password</div>
				<div class="col-sm-2" style="background-color: white;">
					<input type="password" ng-model="confirmpassword"
						class="form-control" placeholder="Confirm Password">
				</div>
			</div>

			<div class="row">
				<button type="submit" class="btn btn-default"
					ng-click="changepassword()">Submit</button>
			</div>

			<div class="row">
				<div class="col-md-12">
					<div id="successMssages" class="p-3 mb-2 bg-success text-white"
						data-ng-show="successMessages" data-ng-bind="successMessages"></div>
					<div id="errorMessages" class="p-3 mb-2 bg-danger text-white"
						data-ng-show="errorMessages" data-ng-bind="errorMessages"></div>
				</div>
				<div class="col-sm-3" style="background-color: white;"></div>
			</div>
		</div>
	</div>
</body>
</html>