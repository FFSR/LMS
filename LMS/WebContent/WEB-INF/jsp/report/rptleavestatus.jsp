<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript"
	src="resources/js/app.js/service/rptleavestatusService.js"></script>
<script type="text/javascript"
	src="resources/js/app.js/controller/rptleavestatusController.js"></script>

</head>
<body>

	<div ng-controller="rptleavestatusController">

		<div ng-init="getSessionUserDetails('${sessionScope.user.id}');"></div>

		<div class="container-fluid">

			<div class="row">
				<div class="col-sm-3" >Start
					Date</div>
				<div class="col-sm-3">
					<input type="text">
				</div>
				<div class="col-sm-3" >End
					Date</div>
				<div class="col-sm-3" >
					<input type="text">
				</div>
			</div>
			<br>
			
			
			<br>
			<div class="modal-body">
			
			<form role="form">
				<div class="row">
				<button type="submit" class="btn btn-success waves-effect waves-light m-r-10" id="search"
									ng-click="loadrptleavestatus()">Search</button>

				<button type="submit" class="btn btn-success waves-effect waves-light " id="cancel"
									>Cancel</button>
				</div>	</div>
				</form>
			</div>
		
			<!-- By Shourav 29th April 2018 -->

			<div>
				<table class="table table-sm">
					<div>
						Test Message: {{testMessage}}
						<table ng-table="tableParams" class="table" show-filter="true">
							<tr ng-repeat="LmsWfRequest in $data">
								<td title="'Leave ID'" filter="{ id: 'text'}" sortable="'id'">{{wfRequest.lmsLeaveApplication.id}}</td>
								<td title="'Employee name'"
									filter="{ 'lmsUserByUserId.name': 'text'}"
									sortable="'leaveapplication.lmsUserByUserId.name'">{{wfRequestHop.lmsUser.name}}</td>

								<td title="'From Date'" filter="{ type: 'text'}"
									sortable="'lmsLeaveType.type'">{{wfRequestHop.lmsleaveapplication.fromDate
									| date: YYYY-MM-dd}}</td>

								<td title="'To Date'" filter="{ leaveTotal: 'text'}"
									sortable="'totalleave'">{{wfRequestHop.lmsleaveapplication.toDate | date:
									YYYY-MM-dd}}</td>

								<td title="'Leave Type'" filter="{ 'lmsLeaveType.type': 'text'}"
									sortable="'leaveapplication.lmsLeaveType.type'">{{wfRequestHop.lmsLeaveApplication.lmsLeaveType.type}}</td>

								<td title="'Status'" filter="{ Remainingleave: 'text'}"
									sortable="'remainingTotal'">{{wfRequestHop.status}}</td>

								<td title="'Action'"><button class="btn-primary"
										ng-click="showLeaveApplicationDetails(wfRequestHop)">Details</button></td>
						</table>
					</div>
				</table>
			</div>

			<!-- By Shourav 29th April 2018 -->

		</div>
	</div>
</body>
</html>