<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>




<script type="text/javascript"
	src="resources/js/app.js/service/homepagegridshowService.js"></script>
<script type="text/javascript"
	src="resources/js/app.js/controller/homepagegridshowController.js"></script>

</head>

<body ng-controller="homepagegridshowController">
	<div ng-init="homepagegridshow();"></div>

	<div class="container-fluid">

		<div>
			<table class="table table-sm">
				<div>
					Test Message: {{testMessage}}
					<table ng-table="tableParams" class="table" show-filter="true">
						<tr ng-repeat="leaveapplication in $data">
							<td title="'Employee name'"
								filter="{'lmsUserByUserId.name': 'text'}" sortable="'name'">{{}}</td>

							<td title="'From Date'" filter="{ type: 'text'}"
								sortable="'lmsLeaveType.fromDate'">{{leaveapplication.fromDate
								| date: YYYY-MM-dd}}</td>

							<td title="'To Date'" filter="{ leaveTotal: 'text'}"
								sortable="'lmsLeaveType.toDate'">{{leaveapplication.toDate
								|date: YYYY-MM-dd}}</td>

							<td title="'Leave Type'" filter="{ 'lmsLeaveType.type': 'text'}"
								sortable="'leaveapplication.lmsLeaveType.type'">{{leaveapplication.lmsLeaveType.type}}</td>

							<td title="'Section'"
								filter="{ 'lmsUserByUserId.lmsSection.name': 'text'}"
								sortable="'name'">{{leaveapplication.lmsUserByUserId.lmsSection.name}}</td>
					</table>
				</div>
			</table>
		</div>

	</div>


</body>
</html>