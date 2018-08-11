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
	text-align: center;
}

.ng-table {
    text-align: center;
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
	<div ng-controller="leavehistoryController">
		<div ng-init="getSessionUserDetails('${sessionScope.user.id}');"></div>
		<div class="container-fluid">
			<div id="forgotModal">
				<div class="dialog">
					<!-- Modal content-->
					<div class="content">
						<div class="header"></div>
						<div class="modal-body">
							<form role="form">
								<!--  		<div class="form-group">
									<label for="user_id">Employee ID:</label> <input type="text"
										ng-model="user_id" class="form-control" id="user_id">
								</div> -->
								<p style="font-family: Courier; color: #000; font-size: 20px;">My
									Leave Balance</p>
								<button type="submit"
									class="btn btn_tf btn-success waves-effect waves-light m-r-10"
									id="search" ng-click="leavehistory()">Leave Balance</button>

								<button type="submit"
									class="btn btn_tf btn-info"
									id="cancel" ng-click="gomyPage()">Cancel</button>
							</form>

						</div>
					</div>
				</div>
			</div>
		</div>
		<div>
			<table class="table table-sm">
				<div>

					<table ng-table="tableParams" class="table">
						<tr ng-repeat="lmsLeaveBalance in $data">

							<td title="'Leave Type'" filter=""
								sortable="'lmsLeaveBalance.lmsLeaveType.type'">{{lmsLeaveBalance.lmsLeaveType.type}}</td>

							<td title="'Total Leave'" filter=""
								sortable="'lmsLeaveBalance.leaveTotal'">{{lmsLeaveBalance.leaveTotal}}</td>

							<td title="'Taken Leave'" filter=""
								sortable="'lmsLeaveBalance.leaveTaken'">{{lmsLeaveBalance.leaveTaken}}</td>

							<td title="'Remaining Leave'" filter=""
								sortable="'lmsLeaveBalance.leaveBalance'">{{lmsLeaveBalance.leaveBalance}}</td>
								
							<td title="'Applied Leave'" filter=""
								sortable="'lmsLeaveBalance.leaveBalance'">{{lmsLeaveBalance.leaveApplied}}</td>

							<td title="'Eligibility'" filter=""
								sortable="'lmsLeaveBalance.eligibility'">{{lmsLeaveBalance.eligibility}}</td>
						</tr>
					</table>
				</div>
			</table>
		</div>
	</div>
</body>
</html>