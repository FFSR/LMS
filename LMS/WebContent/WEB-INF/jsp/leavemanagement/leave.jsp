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
	src="resources/js/app.js/service/leaveService.js"></script>
<script type="text/javascript"
	src="resources/js/app.js/controller/leaveController.js"></script>

</head>
<body>
	<div ng-controller="leaveController as lc">			
			
		<div class="container-fluid">
			<div id="forgotModal">
				<div class="dialog">
					<!-- Modal content-->
					<div class="content">
						<div class="header">
							<h4 class="modal-title">Leave History ...</h4>
						</div>
						<div class="modal-body">
							<form role="form">
								<div class="form-group">
									<label for="user_id">Employee ID:</label> <input type="text"
										ng-model="lc.user_id" class="form-control" id="user_id">
								</div>

								<button type="submit" class="btn btn-default" id="search"
									ng-click="lc.leave(lc.user_id)">Leave History</button>								
							</form>
							<div style="color: blue">{{lc.user_id}}{{lc.testMsg}}</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	
	
	<div>
		<table class="table table-sm">
				
				
					<div>
					Test Message: {{lc.testMsg1}}
						<table ng-table="lc.tableParams" class="table" show-filter="true">
							<tr ng-repeat="user in $data">
								<td title="'Employee Name'" filter="{ name: 'text'}"
									sortable="'name'">{{user.lmsUser.name}}</td>
								
								<td title="'Leave Type'" filter="{ type: 'text'}"
									sortable="'lmsLeaveType.type'">{{user.lmsLeaveType.type}}</td>	
								
								<td title="'From Date'" filter="{ From Date: 'text'}"
									sortable="'fromdate'">{{user.lmsLeaveApplication.leaveTaken}}</td>
									
								<td title="'Taken Leave'" filter="{ leavetaken: 'text'}"
									sortable="'takenleave'">{{user.lmsLeaveApplication.leaveAvailable}}</td>
								
								<td title="'Remaining Leave'" filter="{ Remainingleave: 'text'}"
									sortable="'remainingTotal'">{{user.lmsLeaveApplication.leaveBalance}}</td>
								
								<td title="'Eligibility'" filter="{ eligibility: 'text'}"
									sortable="'eligibility'">{{user.lmsLeaveApplication.eligibility}}</td>
								
							</tr>
						</table>
					</div>				
			</table>
		</div>
	</div>
</body>
</html>