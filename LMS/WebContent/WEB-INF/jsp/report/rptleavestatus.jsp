
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
			<!-- By Shourav 29th April 2018 -->

			<div>
				<table class="table table-sm">
				<div>
					Test Message: {{testMessage}}
					<table ng-table="tableParams" class="table" show-filter="true">
						<tr ng-repeat="wfRequestHop in $data">
							<td title="'Leave ID'" >{{wfRequestHop.lmsLeaveApplication.id}}</td>
							<td title="'From Date'" 
								sortable="'lmsLeaveType.type'">{{wfRequestHop.lmsLeaveApplication.fromDate
								| date: YYYY-MM-dd}}</td>

							<td title="'To Date'" 
								sortable="'totalleave'">{{wfRequestHop.lmsLeaveApplication.toDate
								|date: YYYY-MM-dd}}</td>

							<td title="'Leave Type'" 
								sortable="'leaveapplication.lmsLeaveType.type'">{{wfRequestHop.lmsLeaveApplication.lmsLeaveType.type}}</td>

							<td title="'Status'" 
								sortable="'remainingTotal'">{{wfRequestHop.status}}</td>

					</table>
				</div>
			</table>
			</div>

			<!-- By Shourav 29th April 2018 -->

		</div>
	</div>
</body>
</html>
