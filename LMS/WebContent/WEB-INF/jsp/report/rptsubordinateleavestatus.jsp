
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
	
<style type="text/css">
.custom {
	font-family: Courier;
	color: red;
	font-size: 20px;
}


body {
	font-family:  Arial /*Poppins, sans-serif*/;
	color: #000;
}


body label {
	font-family:  Arial /*Poppins, sans-serif*/;
	color: #000;
	font-weight: bold; 
	margin-left: .5em;
}

.ng-table-header {
	font-family:  Arial /*Poppins, sans-serif*/;
	color: #000;
	font-weight: bold;
}

.line_hight h4 {
	font-family:  Arial;
	color: #000;
	line-height: 35px;
	padding-top: 25px;
}

.btn_tf {
	border-radius: 0px;
	border: thin solid #027C05;
	color: #027C05;
	padding: 0 30px;
    transition: all 0.3s ease 0s;
	-o-transition: all 0.3s ease 0s;
	-ms-transition: all 0.3s ease 0s;
	-moz-transition: all 0.3s ease 0s;
	-webkit-transition: all 0.3s ease 0s;
	padding: 5px 20px;
}

.btn_tf:focus {
	border-radius: 30px;
	background: #02C800;
	color: #fff;
    transition: all 0.6s ease 0s;
	-o-transition: all 0.6s ease 0s;
	-ms-transition: all 0.6s ease 0s;
	-moz-transition: all 0.6s ease 0s;
	-webkit-transition: all 0.6s ease 0s;
}

.btn_tf:hover {
	border-radius: 30px;
	background: #084301;
	color: #fff;
    transition: all 0.6s ease 0s;
	-o-transition: all 0.6s ease 0s;
	-ms-transition: all 0.6s ease 0s;
	-moz-transition: all 0.6s ease 0s;
	-webkit-transition: all 0.6s ease 0s;
}

.btn_tf_red {
	background: #ffo;
}

.link_black a {
	color: #000;
}

</style>
	

</head>
<body>

	<div ng-controller="rptsubordinateleavestatusController">

			<!-- <div ng-init="SubordinateuserList('${sessionScope.user.id}')"></div> -->
			<div ng-init="loadrptleavestatus('${sessionScope.user.id}')"></div>
			

		<form class="form-horizontal" name="rptleavestatusForm">
			<div class="form-body">
							
				<div>
				
					
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

							<table ng-table="tableParams2" class="table" show-filter="true">
								<tr ng-repeat="wfHop in $data">
									<td title="'Status'" filter="{ id: 'text'}" sortable="'id'">{{wfHop.status}}</td>
									<td title="'Updated By'"
										filter="{ 'lmsUserByUserId.name': 'text'}"
										sortable="'leaveapplication.lmsUserByUserId.name'">{{wfHop.lmsUser.name}}</td>
									<td title="'Role Name'"
										filter="{ 'lmsUserByUserId.name': 'text'}"
										sortable="'leaveapplication.lmsUserByUserId.name'">{{wfHop.lmsWftRequestHopRolePageMap.lmsWftRole.roleName}}</td>

									<td title="'Update Date'" filter="{ type: 'text'}"
										sortable="'lmsLeaveType.type'">{{wfHop.updateDate
										| date: YYYY-MM-dd}}</td>
							</table>
						</div>
					</table>      
					</div>
			</div>
		
		</form>

</body>

</html>
