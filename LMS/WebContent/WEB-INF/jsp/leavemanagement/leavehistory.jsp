<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript"
	src="resources/js/app.js/service/leavehistoryService.js"></script>
<script type="text/javascript"
	src="resources/js/app.js/controller/leavehistoryController.js"></script>

</head>
<body>
	<div ng-controller="leavehistoryController">
	<div ng-init="getSessionUserDetails('${sessionScope.user.id}');"></div>
		<div class="container-fluid">
			<div id="forgotModal">
				<div class="dialog">
					<!-- Modal content-->
					<div class="content">
						<div class="header">
							<h4 class="modal-title">My Leave Balance</h4>
						</div>
						<div class="modal-body">
							<form role="form">
						<!--  		<div class="form-group">
									<label for="user_id">Employee ID:</label> <input type="text"
										ng-model="user_id" class="form-control" id="user_id">
								</div> -->

								<button type="submit" class="btn btn-success waves-effect waves-light m-r-10" id="search"
									ng-click="leavehistory()">Leave Balance</button>
									
									<button type="submit" class="btn btn-success waves-effect waves-light m-r-10" id="cancel"
									ng-click="gomyPage()">Cancel</button>
							</form>
							
						</div>
					</div>
				</div>
			</div>
		</div>
		<div>
			<table class="table table-sm">
				<div>
					
					<table ng-table="tableParams" class="table" show-filter="true">
						<tr ng-repeat="lmsLeaveBalance in $data">

							<td title="'Leave Type'" filter="{ type: 'text'}"
								sortable="'lmsLeaveBalance.lmsLeaveType.type'">{{lmsLeaveBalance.lmsLeaveType.type}}</td>

							<td title="'Total Leave'" filter="{ leaveTotal: 'text'}"
								sortable="'lmsLeaveBalance.leaveTotal'">{{lmsLeaveBalance.leaveTotal}}</td>

							<td title="'Taken Leave'" filter="{ leavetaken: 'text'}"
								sortable="'lmsLeaveBalance.leaveTaken'">{{lmsLeaveBalance.leaveTaken}}</td>

							<td title="'Remaining Leave'" filter="{ Remainingleave: 'text'}"
								sortable="'lmsLeaveBalance.leaveBalance'">{{lmsLeaveBalance.leaveBalance}}</td>

							<td title="'Eligibility'" filter="{ eligibility: 'text'}"
								sortable="'lmsLeaveBalance.eligibility'">{{lmsLeaveBalance.eligibility}}</td>
						</tr>
					</table>
				</div>
			</table>
		</div>
	</div>
</body>
</html>