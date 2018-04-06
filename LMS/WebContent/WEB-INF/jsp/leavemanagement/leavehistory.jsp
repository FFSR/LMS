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
<<<<<<< HEAD

<!-- NG-Table -->
<link rel="stylesheet" ; href="resources/css/ng-table.min.css">
<script src="resources/js/ng-table.min.js"></script>
<!-- End of NG-Table -->

<script type="text/javascript"
	src="resources/js/app.js/service/leavehistoryService.js"></script>
<script type="text/javascript"
	src="resources/js/app.js/controller/leavehistoryController.js"></script>

</head>
<body>
	<div ng-controller="leavehistoryController">
			
		<div class="container-fluid">
			<div id="forgotModal">
				<div class="dialog">
					<!-- Modal content-->
					<div class="content">
						<div class="header">
							<h4 class="modal-title">Leave History Report...</h4>
						</div>
						<div class="modal-body">
							<form role="form">
								<div class="form-group">
									<label for="user_id">User ID:</label> <input type="text"
										ng-model="user_id" class="form-control" id="user_id">
								</div>

								<button type="submit" class="btn btn-default" id="search"
									ng-click="leavehistory(user_id)">Leave History</button>								
							</form>
							<div style="color: blue">{{user_id}}{{testMsg}}</div>
=======



<script type="text/javascript"
	src="resources/js/app.js/service/leavehistoryService.js"></script>
<script type="text/javascript"
	src="resources/js/app.js/controller/leavehistoryController.js"></script>

</head>
<body>
	<div ng-controller="leavehistoryController as lhc">
			

			
			
		<div class="container-fluid">
			<div id="forgotModal">
				<div class="dialog">
					<!-- Modal content-->
					<div class="content">
						<div class="header">
							<h4 class="modal-title">Leave History Report...</h4>
						</div>
						<div class="modal-body">
							<form role="form">
								<div class="form-group">
									<label for="user_id">User ID:</label> <input type="text"
										ng-model="lhc.user_id" class="form-control" id="user_id">
								</div>

								<button type="submit" class="btn btn-default" id="search"
									ng-click="lhc.leavehistory(lhc.user_id)">Leave History</button>								
							</form>
							<div style="color: blue">{{lhc.user_id}}{{lhc.testMsg}}</div>
>>>>>>> e3eae446a69a66540732f6ec34029e0cf68f87af
						</div>
					</div>
				</div>
			</div>
		</div>
<<<<<<< HEAD
	</div>
	
	<div>
		<table class="table table-bordered">
				<div class="container-fluid" ng-controller="leavehistoryController as lhc">
				Test Message: {{lhgc.testMsg}}
					<div>
						<table ng-table="lhc.tableParams" class="table" show-filter="true">
							<tr ng-repeat="user in $data">
								<td title="'Name'" filter="{ lmsClass.name: 'text'}"
=======
	
	
	<div>
		<table class="table table-bordered">
				
				
					<div>
					Test Message: {{lhc.testMsg1}}
						<table ng-table="lhc.tableParams" class="table" show-filter="true">
							<tr ng-repeat="user in $data">
								<td title="'Name'" filter="{ name: 'text'}"
>>>>>>> e3eae446a69a66540732f6ec34029e0cf68f87af
									sortable="'name'">{{user.lmsUser.name}}</td>
								<td title="'Eligibility'" filter="{ eligibility: 'text'}"
									sortable="'eligibility'">{{user.eligibility}}</td>
								<td title="'LeaveTotal'" filter="{ leaveTotal: 'text'}"
									sortable="'leaveTotal'">{{user.leaveTotal}}</td>
<<<<<<< HEAD
								<td title="'Leave Type'" filter="{ lmsLeaveType.type: 'text'}"
									sortable="'lmsLeaveType.type'">{{user.lmsLeaveType.type}}</td>
								<td title="'Class'" filter="{ lmsClass.name: 'text'}"
=======
								<td title="'Leave Type'" filter="{ type: 'text'}"
									sortable="'lmsLeaveType.type'">{{user.lmsLeaveType.type}}</td>
								<td title="'Class'" filter="{ name: 'text'}"
>>>>>>> e3eae446a69a66540732f6ec34029e0cf68f87af
									sortable="'name'">{{user.lmsUser.lmsDesignation.lmsClass.name}}</td>
							</tr>
						</table>
					</div>
				</div>
			</table>
	</div>
<<<<<<< HEAD
	
=======
	</div>
>>>>>>> e3eae446a69a66540732f6ec34029e0cf68f87af
</body>
</html>