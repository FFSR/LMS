
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
	src="resources/js/app.js/service/wfrequesthopService.js"></script>

<script type="text/javascript"
	src="resources/js/app.js/controller/rptsubordinateleavestatusController.js"></script>
<script type="text/javascript"
	src="resources/js/app.js/service/manageuserService.js"></script>

<script type="text/javascript"
	src="resources/js/DatePicker/jquery.datetimepicker.full.js"></script>
<link rel="stylesheet"
	href="resources/css/datetimepicker/jquery.datetimepicker.css" />

</head>
<body>

	<div ng-controller="rptsubordinateleavestatusController">

			<div ng-init="SubordinateuserList('${sessionScope.user.id}')"></div>
			

		<form class="form-horizontal" name="rptleavestatusForm">
			<div class="form-body">
					
				<div>
				<table class="table table-sm">
					<div>
						<table ng-table="tableParams1" class="table table-striped"
							show-filter="true">
							<tr ng-repeat="user in $data">
								<td title="'Employee ID'" filter="{ name: 'text'}"
									sortable="'name'">{{user.id}}</td>
								<td title="'Employee name'" filter="{ name: 'text'}"
									sortable="'name'">{{user.name}}</td>
								<td title="'Division'" filter="{ type: 'text'}"
									sortable="'lmsLeaveType.type'">{{user.lmsDivision.name}}</td>
								<td title="'Section'" filter="{ leaveTotal: 'text'}"
									sortable="'totalleave'">{{user.lmsSection.name}}</td>


								<td title="'Action'">
									<button type="button" class="btn-primary"
										ng-click="loadrptleavestatus(user.id)">Details</button>

								</td>
						</table>
					</div>
				</table>
			</div>
						
				
				<div>
				
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label class="control-label col-md-3">Employee Name</label>
							<div class="col-md-9">
								<input type="text" ng-disabled="true" ng-model="employeename"
									class="form-control" placeholder="User ID">
							</div>
						</div>
					</div>
					</div>
					
					<table class="table table-sm">
						<div>
							<table ng-table="tableParams" class="table" show-filter="true">
								<tr ng-repeat="wfRequestHop in $data">
									<td title="'Leave ID'" filter="{ id: 'text'}" sortable="'id'">{{wfRequestHop.lmsLeaveApplication.id}}</td>
									<td title="'Employee name'"
										filter="{ 'lmsUserByUserId.name': 'text'}"
										sortable="'leaveapplication.lmsUserByUserId.name'">{{wfRequestHop.lmsUserByUserId.name}}</td>

									<td title="'From Date'" filter="{ type: 'text'}"
										sortable="'lmsLeaveType.type'">{{wfRequestHop.lmsLeaveApplication.fromDate
										| date: YYYY-MM-dd}}</td>

									<td title="'To Date'" filter="{ leaveTotal: 'text'}"
										sortable="'totalleave'">{{wfRequestHop.lmsLeaveApplication.toDate
										|date: YYYY-MM-dd}}</td>

									<td title="'Leave Type'"
										filter="{ 'lmsLeaveType.type': 'text'}"
										sortable="'leaveapplication.lmsLeaveType.type'">{{wfRequestHop.lmsLeaveApplication.lmsLeaveType.type}}</td>

									<td title="'Status'" filter="{ Remainingleave: 'text'}"
										sortable="'remainingTotal'">{{wfRequestHop.status}}</td>

									<td title="'Remarks'" filter="{ Remainingleave: 'text'}"
										sortable="'remainingTotal'">{{wfRequestHop.lmsLeaveApplication.remarks}}</td>

									<td title="'Action'"><button type="submit" class="btn-primary" id="submit"
											ng-click="showApprovalFlowDetails(wfRequestHop.id)">Approval
											Flow</button></td>
									
							</table>
						</div>
					</table>
				</div>
				
			</div>
		
		</form>

</body>

</html>
