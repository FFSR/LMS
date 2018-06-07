<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ministry Information</title>

<script type="text/javascript"
	src="resources/js/app.js/service/loginService.js"> </script>
<script type="text/javascript"
	src="resources/js/app.js/service/ministryinfoService.js"></script>
<script type="text/javascript"
	src="resources/js/app.js/controller/ministryinfoController.js"></script>


</head>
<body>
	<br>
	<div ng-controller="ministryinfoController">
		<div ng-init="userAuthentication('${sessionScope.user.id}')"></div>
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-3">Ministry Name</label>
						<div class="col-md-9">
							<input type="text" ng-model="name" class="form-control"
								placeholder="Ministry Name" ng-required=true>
						</div>
					</div>
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