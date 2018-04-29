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
	src="resources/js/app.js/service/divisionService.js"></script>
<script type="text/javascript"
	src="resources/js/app.js/service/updateuserprofileService.js"></script>
<script type="text/javascript"
	src="resources/js/app.js/service/manageuserService.js"></script>
<script type="text/javascript"
	src="resources/js/app.js/controller/manageuserController.js"></script>
<script type="text/javascript"
	src="resources/js/app.js/controller/registrationController.js"></script>

</head>

<body ng-controller="manageuserController as muc">
	<div ng-init="getDivisionData()"></div>
	<div>
		<div class="container-fluid">
			<br>

			<div class="row">
				<div class="col-sm-3" style="background-color: white;">
					<form role="form">
						<div class="form-group">
							<label for="user_id">Employee ID:</label> <input type="text"
								ng-model="user_id" class="form-control" id="user_id">
						</div>

						<button type="submit" class="btn btn-info" id="search"
							ng-click="manageuser(user_id)">Search</button>
					</form>
					<div style="color: blue">{{user_id}}{{testMsg}}</div>
				</div>
			</div>
			<br>
		</div>
		<br>
		<div>
			<table class="table table-sm">
				<div>
					Test Message: {{testMessage}}
					<table ng-table="tableParams" class="table" show-filter="true">
						<tr ng-repeat="user in $data">
							<td title="'Employee ID'" filter="{ name: 'text'}"
								sortable="'name'">{{user.id}}</td>
							<td title="'Employee name'" filter="{ name: 'text'}"
								sortable="'name'">{{user.name}}</td>

							<td title="'Division'" filter="{ type: 'text'}"
								sortable="'lmsLeaveType.type'">{{user.lmsUser.passport}}</td>

							<td title="'Section'" filter="{ leaveTotal: 'text'}"
								sortable="'totalleave'">{{user.leaveTotal}}</td>

							<td title="'mobile'" filter="{ leavetaken: 'text'}"
								sortable="'takenleave'">{{user.leaveTaken}}</td>

							<td title="'Status'" filter="{ Remainingleave: 'text'}"
								sortable="'remainingTotal'">{{user.leaveBalance}}</td>

							<td title="'Action'">
								<button class="btn-primary" ng-click="showEmpDetails(user)">Details</button>
							</td>
					</table>
				</div>
			</table>
		</div>

		Show: {{test}} <br>
		<div class="container-fluid">
			<div ng-if="showUserDetails">
				<div class="row">
					<div class="col-sm-3" style="background-color: white;">User
						ID</div>
					<div class="col-sm-3" style="background-color: white;">
						<input type="text">
					</div>
					<div class="col-sm-3" style="background-color: white;">Name</div>
					<div class="col-sm-3" style="background-color: white;">
						<input type="text" ng-model="user.name">
					</div>

				</div>
				<br>

				<div class="row">

					<div class="col-sm-3" style="background-color: white;">NID</div>
					<div class="col-sm-3" style="background-color: white;">
						<input type="text" ng-model="user.nid" class="form-control"
							placeholder="nid">
					</div>
					<div class="col-sm-3" style="background-color: white;">Passport
						No</div>
					<div class="col-sm-3" style="background-color: white;">
						<input type="text" ng-model="user.passport" class="form-control"
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
						<input type="text" ng-model="user.email" class="form-control"
							placeholder="Email">
					</div>
					<div class="col-sm-3" style="background-color: white;">Fax</div>
					<div class="col-sm-3" style="background-color: white;">
						<input type="text" ng-model="user.fax" class="form-control"
							placeholder="Fax">
					</div>

				</div>
				<br>
				<div class="row">

					<div class="col-sm-3" style="background-color: white;">Joining
						Date</div>
					<div class="col-sm-3" style="background-color: white;">
						<input type="text" ng-model="user.joining-date"
							class="form-control" placeholder="Joining Date">
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
						<select class="form-control" id="ddAppStatus"
							ng-model="user.lmsDivision"
							ng-options="x as x.name for x in divisionNames track by x.id">
							<option value="">Select</option>
							<!-- <option value="">Hospital</option>
						<option value="">Casual</option> -->
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
		</div>
		<div>Response: {{testMsg}}</div>
	</div>
</body>
</html>
