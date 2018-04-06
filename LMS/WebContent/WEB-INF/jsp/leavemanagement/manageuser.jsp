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
	


<script type="text/javascript"
	src="resources/js/app.js/service/manageuserService.js"></script>
<script type="text/javascript"
	src="resources/js/app.js/controller/manageuserController.js"></script>
	
</head>
<body>

	<div ng-controller="manageuserController as muc">

		<div class="container-fluid">
			<br>

			<div class="row">
				<div class="col-sm-1" style="background-color: white;">Employee
					ID</div>
				<div class="col-sm-3" style="background-color: white;">
					<input type="text">
				</div>
				<div class="col-sm-1" style="background-color: white;">Mobile</div>
				<div class="col-sm-1" style="background-color: white;">
					<input type="text">
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-sm-1" style="background-color: white;">Name</div>
				<div class="col-sm-3" style="background-color: white;">
					<input type="text">
				</div>
				<div class="col-sm-1" style="background-color: white;">Email</div>
				<div class="col-sm-1" style="background-color: white;">
					<input type="text">
				</div>
			</div>

		</div>

		<br>
		<div class="modal-body">
			<form role="form">
				<div class="form-group">
					<label for="user_id">Employee ID:</label> <input type="text"
						ng-model="muc.user_id" class="form-control" id="user_id">
				</div>

				<button type="submit" class="btn btn-default" id="search"
					ng-click="muc.manageuser(muc.user_id)">Search</button>
			</form>
			<div style="color: blue">{{lhc.user_id}}{{lhc.testMsg}}</div>
		</div>



		<a href="http://localhost:8080/LMS/manageusersearch"
			class="btn btn-info" role="button">Search</a>
		<button type="button" class="btn">Clear</button>


		<br>

		<div>
			<table class="table table-sm">
				<div>
					Test Message: {{muc.testMessage}}
					<table ng-table="muc.tableParams" class="table" show-filter="true">
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
					</table>
				</div>
			</table>
		</div>
	</div>
</body>
</html>