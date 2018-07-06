<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage User</title>


<script type="text/javascript"
	src="resources/js/app.js/service/loginService.js"></script>
<script type="text/javascript"
	src="resources/js/app.js/service/manageuserService.js"></script>
<script type="text/javascript"
	src="resources/js/app.js/controller/subordinatelvblnceController.js"></script>

<script type="text/javascript"
	src="resources/js/app.js/service/leavehistoryService.js"></script>


</head>

<body ng-controller="subordinatelvblnceController">
	
		<div ng-init="userAuthentication('${sessionScope.user.id}')"></div>
		
		<div ng-init="userAccessAuthentication('${sessionScope.user.id}')"></div>

		<div class="container-fluid">

			<br>
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

									<td title="'mobile'" filter="{ leavetaken: 'text'}"
								sortable="'takenleave'">{{user.mobilePersonal}}</td>
								<td title="'Status'" filter="{ Remainingleave: 'text'}"
								sortable="'remainingTotal'">{{user.status}}</td>
							 	 

								<td title="'Action'">
									<button type="button" class="btn-primary"
										ng-click="leavehistoryinfo(user)">Details</button>

								</td>
						</table>
					</div>
				</table>
			</div>
			<br> <br> <br>

          <div ID="DIVPRINT">
			<div class="container-fluid">
				<div ng-if="leavehistoryinfo">
					<form class="form-horizontal" name="updateForm">
						
						<div class="row">
					        <div class="col-md-6">
						        <div class="form-group">
							       <label class="control-label col-md-3">Employee Name</label>
							         <div class="col-md-9">
								       <input type="text" ng-disabled="true" ng-model="employeename"
									class="form-control" placeholder="{{lvbalance.lmsUser.name}}">
							    </div>
						   </div>
					    </div>
					  </div>
						<table ng-table="tableParams2" class="table table-striped"
							show-filter="true">
							<tr ng-repeat="lmsLeaveBalance in $data"> 


								<td title="'Leave Type'" filter="{ type: 'text'}"
									sortable="'lmsLeaveBalance.lmsLeaveType.type'">{{lmsLeaveBalance.lmsLeaveType.type}}</td>

								<td title="'Total Leave'" filter="{ leaveTotal: 'text'}"
									sortable="'lmsLeaveBalance.leaveTotal'">{{lmsLeaveBalance.leaveTotal}}</td>

								<td title="'Taken Leave'" filter="{ leavetaken: 'text'}"
									sortable="'lmsLeaveBalance.leaveTaken'">{{lmsLeaveBalance.leaveTaken}}</td>

								<td title="'Remaining Leave'" filter="{ Remainingleave: 'text'}"
									sortable="'lmsLeaveBalance.leaveBalance'">{{lmsLeaveBalance.leaveBalance}}</td>
								<td title="'Leave Apllied'" filter="{ Remainingleave: 'text'}"
									sortable="'lmsLeaveBalance.leaveBalance'">{{lmsLeaveBalance.leaveApplied}}</td>

								<td title="'Eligibility'" filter="{ eligibility: 'text'}"
									sortable="'lmsLeaveBalance.eligibility'">{{lmsLeaveBalance.eligibility}}</td>
							</tr>
						</table>
					</form>
				</div>

			</div>
       </div>
                 <button type="submit"
				 class="btn btn-success waves-effect waves-light m-r-10"
				 id="cancel" ng-click="CallPrint('DIVPRINT')">Print</button>
						
		</div>
	
</body>

</html>
