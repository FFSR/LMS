<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


<script type="text/javascript"
	src="resources/js/app.js/service/DropDownService.js"></script>

<script type="text/javascript"
	src="resources/js/app.js/service/updateuserprofileService.js"></script>
<script type="text/javascript"
	src="resources/js/app.js/controller/updateuserprofileController.js"></script>


	
</head>
<body>

	<div ng-controller="updateuserprofileController">
		<br>
		<div class="container-fluid">

			<div class="row">
				<div class="col-sm-3" style="background-color: white;">User ID</div>
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

				<div class="col-sm-3" style="background-color: white;">NID</div>
				<div class="col-sm-3" style="background-color: white;">
					<input type="text" ng-model="nid" class="form-control"
						placeholder="nid">
				</div>
				<div class="col-sm-3" style="background-color: white;">Passport
					No</div>
				<div class="col-sm-3" style="background-color: white;">
					<input type="text" ng-model="passport" class="form-control"
						placeholder="passport">
				</div>
			</div>
			<br>

			<div class="row">
				<div class="col-sm-3" style="background-color: white;">Mobile</div>
				<div class="col-sm-3" style="background-color: white;">
					<input type="text">
				</div>
				<div class="col-sm-3" style="background-color: white;">Telephone</div>
				<div class="col-sm-3" style="background-color: white;">
					<input type="text">
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
					<input type="text">
				</div>
			</div>
			<br> <br>
			<div class="row">

				<div class="col-sm-3" style="background-color: white;">Office</div>
				<div class="col-sm-3" style="background-color: white;">
					<select class="form-control" id="ddAppStatus" ng-model="appStatus"
						ng-options="x as x.name for x in dropdownData track by x.id">
						<option value="">Select</option>
					</select>
				</div>

				<div class="col-sm-3" style="background-color: white;">Division</div>
				<div class="col-sm-3" style="background-color: white;">
					<select class="form-control" id="ddAppStatus" ng-model="appStatus"
						ng-options="x as x.name for x in dropdownData track by x.id">
						<option value="">Select</option>
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
					</select>
				</div>
				<div class="col-sm-3" style="background-color: white;">Ministry</div>
				<div class="col-sm-3" style="background-color: white;">
					<select class="form-control" id="ddAppStatus" ng-model="appStatus"
						ng-options="x as x.name for x in dropdownData track by x.id">
						<option value="">Select</option>
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
					</select>
				</div>
				<div class="col-sm-3" style="background-color: white;">Nationality</div>
				<div class="col-sm-3" style="background-color: white;">
					<select class="form-control" id="ddAppStatus" ng-model="appStatus"
						ng-options="x as x.name for x in dropdownData track by x.id">
						<option value="">Select</option>
					</select>
				</div>

			</div>

			<br>

			<div class="row">

				<div class="col-sm-3" style="background-color: white;">Gender</div>
				<div class="col-sm-3" style="background-color: white;">
					<select class="form-control" id="ddAppStatus" ng-model="appStatus"
						ng-options="x as x.name for x in dropdownData track by x.id">
						<option value="">Select</option>
					</select>
				</div>

				<div class="col-sm-3" style="background-color: white;">Status
				</div>
				<div class="col-sm-3" style="background-color: white;">
					<select class="form-control" id="ddAppStatus" ng-model="appStatus"
						ng-options="x as x.name for x in dropdownData track by x.id">
						<option value="">Select</option>
					</select>
				</div>
			</div>

			<br>

			<div class="row">

				<div class="col-sm-3" style="background-color: white;"></div>
				<div class="col-sm-3" style="background-color: white;"></div>
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
				<div class="col-sm-3" style="background-color: white;">
					<input type="submit" class="btn btn-info" value="Update">
				</div>
				<div class="col-sm-3" style="background-color: white;"></div>
				<div class="col-sm-3" style="background-color: white;">
					<input type="button" class="btn btn-info" value="Cancel">
				</div>
				<div class="col-sm-3" style="background-color: white;"></div>
				<button type="submit" class="btn" id="submit"
					ng-click="userprofile()">Update</button>
			</div>
		</div>

		<div>Response: {{testMsg}}</div>
		</div>
	
</body>
</html>