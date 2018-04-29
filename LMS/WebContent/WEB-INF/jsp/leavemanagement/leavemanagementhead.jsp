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
	src="resources/js/app.js/service/updateuserleaveService.js"></script>
<script type="text/javascript"
	src="resources/js/app.js/service/manageleaveService.js"></script>
<script type="text/javascript"
	src="resources/js/app.js/controller/manageleaveController.js"></script>

</head>
<body ng-controller="manageleaveController">

	<div>

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
					<input type="text" ng-model="search.user_name">
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
					<label for="user_id">User ID:</label> <input type="text"
						ng-model="search.user_id" class="form-control" id="user_id">
				</div>

				<button type="submit" class="btn btn-default" id="search"
					ng-click="manageleave(user_id)">Search</button>
			</form>
			<div style="color: blue">{{user_id}}{{testMsg}}</div>
			<div>Response: {{testMsg}}</div>
		</div>



		<a href="http://localhost:8080/LMS/manageusersearch"
			class="btn btn-info" role="button">Search</a>
		<button type="button" class="btn">Clear</button>


		<br>

		<div>
			<table class="table table-sm">
				<div>
					Test Message: {{testMessage}}
					<table ng-table="tableParams" class="table" show-filter="true">
						<tr ng-repeat="leaveapplication in $data">
							<td title="'Leave ID'" filter="{ id: 'text'}" sortable="'id'">{{leaveapplication.id}}</td>
							<td title="'Employee name'"
								filter="{ 'lmsUserByUserId.name': 'text'}"
								sortable="'leaveapplication.lmsUserByUserId.name'">{{leaveapplication.lmsUserByUserId.name}}</td>

							<td title="'From Date'" filter="{ type: 'text'}"
								sortable="'lmsLeaveType.type'">{{leaveapplication.fromDate
								| date: YYYY-MM-dd}}</td>

							<td title="'To Date'" filter="{ leaveTotal: 'text'}"
								sortable="'totalleave'">{{leaveapplication.toDate | date:
								YYYY-MM-dd}}</td>

							<td title="'Leave Type'" filter="{ 'lmsLeaveType.type': 'text'}"
								sortable="'leaveapplication.lmsLeaveType.type'">{{leaveapplication.lmsLeaveType.type}}</td>

							<td title="'Reason'" filter="{ Remainingleave: 'text'}"
								sortable="'remainingTotal'">{{user.leaveBalance}}</td>
							<td title="'Status'" filter="{ Remainingleave: 'text'}"
								sortable="'remainingTotal'">{{user.leaveBalance}}</td>

							<td title="'Action'"><button class="btn-primary"
									ng-click="showLeaveApplicationDetails(leaveapplication)">Details</button></td>
					</table>
				</div>
			</table>
		</div>

		Show: {{test}} <br>
		<div class="container-fluid">
			<div ng-if="showLeaveDetails">
				<div class="row">
					<div class="col-sm-3" style="background-color: white;">User
						ID</div>
					<div class="col-sm-3" style="background-color: white;">
						<input type="text">
					</div>
					<div class="col-sm-3" style="background-color: white;">Name</div>
					<div class="col-sm-3" style="background-color: white;">
						<input type="text"
							ng-model="leaveapplication.lmsUserByUserId.name">
					</div>

				</div>
				<br>

				<div class="row">

					<div class="col-sm-3" style="background-color: white;">Leave
						Type</div>
					<div class="col-sm-3" style="background-color: white;">
						<input type="text" ng-model="leaveapplication.lmsLeaveType.type"
							class="form-control" placeholder="type">
					</div>
					<div class="col-sm-3" style="background-color: white;">Reason
						For Leave</div>
					<div class="col-sm-3" style="background-color: white;">
						<input type="text" ng-model="leaveapplication.reasonForLeave"
							class="form-control" placeholder="reasonForLeave">
					</div>
				</div>
				<br>

				<div class="row">
					<div class="col-sm-3" style="background-color: white;">Yearly
						Leave Eligibility</div>
					<div class="col-sm-3" style="background-color: white;">
						<input type="text" ng-model="leaveapplication.eligibility"
							class="form-control" placeholder="eligibility">
					</div>
					<div class="col-sm-3" style="background-color: white;">Leave
						Allready Taken</div>
					<div class="col-sm-3" style="background-color: white;">
						<input type="text" ng-model="leaveapplication.leaveTaken"
							class="form-control" placeholder="leaveTaken">
					</div>
				</div>
				<br>

				<div class="row">

					<div class="col-sm-3" style="background-color: white;">leave
						Remaining</div>
					<div class="col-sm-3" style="background-color: white;">
						<input type="text" ng-model="leaveapplication.leaveBalance"
							class="form-control" placeholder="leaveBalance">
					</div>

				</div>
				<br>
				<div class="row">

					<div class="col-sm-3" style="background-color: white;">From
						Date</div>
					<div class="col-sm-3" style="background-color: white;">
						<input type="text"
							ng-model="leaveapplication.fromDate
								| date: YYYY-MM-dd"
							class="form-control" placeholder="fromDate">

					</div>
					<div class="col-sm-3" style="background-color: white;">To
						Date</div>
					<div class="col-sm-3" style="background-color: white;">
						<input type="text"
							ng-model="leaveapplication.toDate| date: YYYY-MM-dd"
							class="form-control" placeholder="Fax">
					</div>
				</div>
				<br> <br>
				<div class="row">

					<div class="col-sm-3" style="background-color: white;">Total
						Days Count</div>
					<div class="col-sm-3" style="background-color: white;">
						<input type="text" ng-model="leaveapplication.totalDayCount"
							class="form-control" placeholder="totalDayCount">
					</div>

					<div class="col-sm-3" style="background-color: white;">Task
						Need to be Performed</div>
					<div class="col-sm-3" style="background-color: white;">
						<input type="text" ng-model="leaveapplication.taskNeedToPerformed"
							class="form-control" placeholder="Fax">
					</div>
				</div>

				<br>

				<div class="row">
					<div class="col-sm-3" style="background-color: white;">Reliever
						Email Address</div>
					<div class="col-sm-3" style="background-color: white;">
						<input type="text"
							ng-model="leaveapplication.lmsUserByUserId.email"
							class="form-control" placeholder="Fax">
					</div>
					<div class="col-sm-3" style="background-color: white;">In
						Station</div>
					<div class="col-sm-3" style="background-color: white;">
						<input type="text" ng-model="fax" class="form-control"
							placeholder="Fax">
					</div>
				</div>

				<br>

				<div class="row">

					<div class="dropdown">
						<button class="btn btn-primary dropdown-toggle" type="button"
							data-toggle="dropdown">
							Status <span class="caret"></span>
						</button>
						<ul class="dropdown-menu">
							<div class="col-sm-3" style="background-color: white;">
								<li><a href="#">Approved</a></li>
								<li><a href="#">Reject</a></li>
						</ul>
					</div>
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
					<input type="button" class="btn btn-info" value="Cancel">
				</div>
				<div class="col-sm-3" style="background-color: white;"></div>
				<button type="submit" class="btn" id="submit" ng-click="userleave()">Update</button>
			</div>
			<div>Response: {{testMsg}}</div>
		</div>
	</div>





















	</div>
</body>
</html>