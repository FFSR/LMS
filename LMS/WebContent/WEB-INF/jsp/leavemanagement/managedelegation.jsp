<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ministry Information</title>

<script type="text/javascript"
	src="resources/js/app.js/service/DropDownService.js"></script>
<script type="text/javascript"
	src="resources/js/app.js/service/wfManagementService.js"></script>
<script type="text/javascript"
	src="resources/js/app.js/service/leaveapplicationservice.js"></script>
<script type="text/javascript"
	src="resources/js/app.js/service/userlistService.js"></script>


<script type="text/javascript"
	src="resources/js/app.js/controller/managerelieverController.js"></script>

<link href="resources/file-upload/css/dropzone/phase2_dropzone.css"
	rel="stylesheet" />

<script src="resources/file-upload/js/dropzone/dropzone.js"></script>
<script type="text/javascript"
	src="resources/js/app.js/directives/FileUploadDirectives.js"></script>
<script type="text/javascript"
	src="resources/js/app.js/controller/FIleUploadController.js"></script>
<script type="text/javascript"
	src="resources/js/DatePicker/jquery.datetimepicker.full.js"></script>
<link rel="stylesheet"
	href="resources/css/datetimepicker/jquery.datetimepicker.css" />


</head>
<body>
	<br>
	<div ng-controller="managerelieverController">
		<div ng-init="loadLeaveTypeDownDown();"></div>
		<form class="form-horizontal">
			<div class="form-body">



				<br>
				<div class="row">
					<div class="col-sm-6">
						<div class="form-group">
							<label class="control-label col-md-3">Reliever</label>
							<div class="col-md-9">
								<!-- Drop Down list from table -->
								<select class="form-control" id="ddReliever"
									ng-model="ddReliever"
									ng-options="x as x.name for x in userlistInfo track by x.id">
									<option value="">Select</option>
								</select>

							</div>
						</div>
					</div>


					<div class="col-sm-6">
						<div class="form-group">
							<label class="control-label col-md-3">In Station</label>
							<div class="col-md-9">
								<input type="text" ng-model="inStation" class="form-control"
									placeholder="In Station">
							</div>

						</div>
					</div>
				</div>

				<div class="row">
					<button type="submit" class="btn" id="submit"
						ng-click="applicationforleave()">Submit</button>
					<div class="col-sm-3" style="background-color: white;"></div>
					<div class="col-sm-3" style="background-color: white;">
						<input type="button" class="btn btn-info" value="Cancel">
					</div>
					<div class="col-sm-3" style="background-color: white;"></div>
				</div>
				<div>Response: {{testMsg}}</div>

				<div class="row">
					<div class="col-md-12">
						<div id="successMssages" class="p-3 mb-2 bg-success text-white"
							data-ng-show="successMessages" data-ng-bind="successMessages"></div>
						<div id="errorMessages" class="p-3 mb-2 bg-danger text-white"
							data-ng-show="errorMessages" data-ng-bind="errorMessages"></div>
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>
