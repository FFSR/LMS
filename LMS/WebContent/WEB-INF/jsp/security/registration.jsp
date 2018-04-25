<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>

<script type="text/javascript"
	src="resources/js/app.js/service/DropDownService.js"></script>
<script type="text/javascript"
	src="resources/js/app.js/service/registrationService.js"></script>
<script type="text/javascript"
	src="resources/js/app.js/controller/registrationController.js"></script>


<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<script src="resources/js/jquery-3.2.1.slim.min.js"></script>
<script src="resources/js/popper.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>



</head>
<body>
	<br>
	<div ng-controller="registrationController">
		<div class="container-fluid">

			<div class="row">
				<div class="col-sm-3" style="background-color: white;">User ID</div>
				<div class="col-sm-3" style="background-color: white;">
					<input type="text" ng-model="userid" class="form-control"
						placeholder="User ID">
				</div>

				<div class="col-sm-3" style="background-color: white;">Office</div>
				<div class="col-sm-3" style="background-color: white;">
					<select class="form-control" id="ddAppStatus" ng-model="appStatus"
						ng-options="x as x.name for x in dropdownData track by x.id">
						<option value="">Select</option>
						<option value="">Hospital</option>
						<option value="">Casual</option>
					</select>

				</div>

			</div>

			<br>
			<div class="row">
				<div class="col-sm-3" style="background-color: white;">Name</div>


				<div class="col-sm-3" style="background-color: white;">
					<input type="text" ng-model="username" class="form-control"
						placeholder="User Name">
				</div>
				<div class="col-sm-3" style="background-color: white;">Division</div>
				<div class="col-sm-3" style="background-color: white;">
					<select class="form-control" id="ddAppStatus" ng-model="appStatus"
						ng-options="x as x.name for x in dropdownData track by x.id">
						<option value="">Select</option>
						<option value="">Hospital</option>
						<option value="">Casual</option>
					</select>
				</div>
			</div>

			<br>

			<div class="row">
				<div class="col-sm-3" style="background-color: white;">Designation</div>
				<div class="col-sm-3" style="background-color: white;">
					<select class="form-control" id="ddAppStatus" ng-model="appStatus"
						ng-options="x as x.name for x in dropdownData track by x.id">
						<option value="">Select</option>
						<option value="">Hospital</option>
						<option value="">Casual</option>
					</select>
				</div>
				<div class="col-sm-3" style="background-color: white;">Ministry</div>
				<div class="col-sm-3" style="background-color: white;">
					<select class="form-control" id="ddAppStatus" ng-model="appStatus"
						ng-options="x as x.name for x in dropdownData track by x.id">
						<option value="">Select</option>
						<option value="">Hospital</option>
						<option value="">Casual</option>
					</select>
				</div>
			</div>

			<br>

			<div class="row">
				<div class="col-sm-3" style="background-color: white;">Section</div>
				<div class="col-sm-3" style="background-color: white;">
					<select class="form-control" id="ddAppStatus" ng-model="appStatus"
						ng-options="x as x.name for x in dropdownData track by x.id">
						<option value="">Select</option>
						<option value="">Hospital</option>
						<option value="">Casual</option>
					</select>
				</div>
				<div class="col-sm-3" style="background-color: white;">NID</div>
				<div class="col-sm-3" style="background-color: white;">
					<input type="text" ng-model="nid" class="form-control"
						placeholder="NID">
				</div>
			</div>

			<br>

			<div class="row">
				<div class="col-sm-3" style="background-color: white;">Nationality</div>
				<div class="col-sm-3" style="background-color: white;">
					<select class="form-control" id="ddAppStatus" ng-model="appStatus"
						ng-options="x as x.name for x in dropdownData track by x.id">
						<option value="">Select</option>
					</select>
				</div>
				<div class="col-sm-3" style="background-color: white;">Passport
					No</div>
				<div class="col-sm-3" style="background-color: white;">
					<input type="text" ng-model="passport" class="form-control"
						placeholder="Passport No">
				</div>
			</div>

			<br>

			<div class="row">
				<div class="col-sm-3" style="background-color: white;">Mobile</div>
				<div class="col-sm-3" style="background-color: white;">
					<input type="text" ng-model="mobile" class="form-control"
						placeholder="Mobile">
				</div>
				<div class="col-sm-3" style="background-color: white;">Telephone</div>
				<div class="col-sm-3" style="background-color: white;">
					<input type="text" ng-model="telephone" class="form-control"
						placeholder="Telephone">
				</div>
			</div>

			<br>

			<div class="row">
				<div class="col-sm-3" style="background-color: white;">Email</div>
				<div class="col-sm-3" style="background-color: white;">
					<input type="text" ng-model="email" class="form-control"
						placeholder="Email">
				</div>
				<div class="col-sm-3" style="background-color: white;">Fax</div>
				<div class="col-sm-3" style="background-color: white;">
					<input type="text" ng-model="fax" class="form-control"
						placeholder="Fax">
				</div>
			</div>

			<br>

			<div class="row">
				<div class="col-sm-3" style="background-color: white;">Joining
					Date</div>
				<div class="col-sm-3" style="background-color: white;">
					<input type="text" ng-model="joiningdate" class="form-control"
						placeholder="Joining Date">
				</div>
				<div class="col-sm-3" style="background-color: white;">Gender</div>
				<div class="col-sm-3" style="background-color: white;">
					<select class="form-control" id="ddAppStatus" ng-model="appStatus"
						ng-options="x as x.name for x in dropdownData track by x.id">
						<option value="">Select</option>
						<option value="">Male</option>
						<option value="">Female</option>
					</select>
				</div>
			</div>

			<br>

			<div class="row">
				<div class="col-sm-3" style="background-color: white;">Supervisor
					Email</div>
				<div class="col-sm-3" style="background-color: white;">
					<input type="text" ng-model="supervisoremail" class="form-control"
						placeholder="Supervisor Email">
				</div>
				<div class="col-sm-3" style="background-color: white;">Address</div>
				<div class="col-sm-3" style="background-color: white;">
					<textarea rows="2" type="textarea" ng-model="address"
						class="form-control" placeholder="Address"></textarea>
				</div>
			</div>

			<br>

			<div class="row">
				<br>
				<div class="col-sm-3" style="background-color: white;"></div>
				<div class="col-sm-3" style="background-color: white;"></div>
				<div class="col-sm-3" style="background-color: white;"></div>
				<div class="col-sm-3" style="background-color: white;"></div>
			</div>

			<br>

			<div class="row">
				<button type="submit" class="btn" id="submit"
					ng-click="registration()">Submit</button>
				<div class="col-sm-3" style="background-color: white;"></div>
				<div class="col-sm-3" style="background-color: white;">
					<input type="button" class="btn btn-info" value="Cancel">
				</div>
				<div class="col-sm-3" style="background-color: white;"></div>
			</div>
		</div>
</body>
</html>