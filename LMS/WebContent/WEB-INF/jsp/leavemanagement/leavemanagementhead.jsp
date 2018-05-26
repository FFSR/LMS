<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Leave Approve Page</title>

<script type="text/javascript"
	src="resources/js/app.js/service/updateuserleaveService.js"></script>
<script type="text/javascript"
	src="resources/js/app.js/service/manageleaveService.js"></script>
<script type="text/javascript"
	src="resources/js/app.js/controller/manageleaveController.js"></script>
<script type="text/javascript"
	src="resources/js/app.js/service/leavehistoryService.js"></script>

</head>
<body ng-controller="manageleaveController">
	<div ng-init="loadLeaveApplications('${sessionScope.userID}');"></div>
	<div>
		<br>
		<div>
			<table class="table table-sm">
				<div>
					<p style="font-family: Courier; color: #000; font-size: 20px;">My
						Approval Pending List</p>
					<table ng-table="tableParams" class="table" show-filter="true">
						<tr ng-repeat="wfRequestHop in $data">
							<td title="'Leave ID'" filter="{ id: 'text'}" sortable="'id'">{{wfRequestHop.lmsWfRequest.lmsLeaveApplication.id}}</td>
							<td title="'Employee name'"
								filter="{ 'lmsUserByUserId.name': 'text'}"
								sortable="'leaveapplication.lmsUserByUserId.name'">{{wfRequestHop.lmsWfRequest.lmsUser.name}}</td>

							<td title="'From Date'" filter="{ type: 'text'}"
								sortable="'lmsLeaveType.type'">{{wfRequestHop.lmsWfRequest.lmsLeaveApplication.fromDate
								| date: YYYY-MM-dd}}</td>

							<td title="'To Date'" filter="{ leaveTotal: 'text'}"
								sortable="'totalleave'">{{wfRequestHop.lmsWfRequest.lmsLeaveApplication.toDate
								| date: YYYY-MM-dd}}</td>

							<td title="'Leave Type'" filter="{ 'lmsLeaveType.type': 'text'}"
								sortable="'leaveapplication.lmsLeaveType.type'">{{wfRequestHop.lmsWfRequest.lmsLeaveApplication.lmsLeaveType.type}}</td>

							<td title="'Reason'" filter="{ Remainingleave: 'text'}"
								sortable="'remainingTotal'">{{wfRequestHop.lmsWfRequest.lmsLeaveApplication.reasonForLeave}}</td>
							<td title="'Status'" filter="{ Remainingleave: 'text'}"
								sortable="'remainingTotal'">{{wfRequestHop.lmsWfRequest.status}}</td>

							<td title="'Action'"><button class="btn-primary"
									ng-click="showLeaveApplicationDetails(wfRequestHop)">Details</button></td>
					</table>
				</div>
			</table>
		</div>
		<br> <br> <br> <br>
		<div class="container-fluid">
			<div ng-show="showLeaveDetails">
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label class="control-label col-md-3">User ID</label>
							<div class="col-md-9">
								<input type="text" ng-disabled="true"
									ng-model="wfRequestHop.lmsWfRequest.lmsUser.id"
									class="form-control">
							</div>
						</div>
					</div>

					<div class="col-md-6">
						<div class="form-group">
							<label class="control-label col-md-3">Name</label>
							<div class="col-md-9">
								<input type="text" ng-disabled="true"
									ng-model="wfRequestHop.lmsWfRequest.lmsUser.name"
									class="form-control">
							</div>
						</div>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label class="control-label col-md-3">Leave Type</label>
							<div class="col-md-9">
								<input type="text" ng-disabled="true"
									ng-model="wfRequestHop.lmsWfRequest.lmsLeaveApplication.lmsLeaveType.type"
									class="form-control">
							</div>
						</div>
					</div>

					<div class="col-md-6">
						<div class="form-group">
							<label class="control-label col-md-3">Reason For Leave</label>
							<div class="col-md-9">
								<input type="text" ng-disabled="true"
									ng-model="wfRequestHop.lmsWfRequest.lmsLeaveApplication.reasonForLeave"
									class="form-control">
							</div>
						</div>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label class="control-label col-md-3">Yearly Leave
								Eligibility</label>
							<div class="col-md-9">
								<input type="text" ng-disabled="true"
									ng-model="wfRequestHop.lmsWfRequest.lmsLeaveApplication.eligibility"
									class="form-control">
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label class="control-label col-md-3">Leave Allready
								Taken</label>
							<div class="col-md-9">
								<input type="text" ng-disabled="true"
									ng-model="wfRequestHop.lmsWfRequest.lmsLeaveApplication.leaveTaken"
									class="form-control">
							</div>
						</div>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label class="control-label col-md-3">Leave Remaining</label>
							<div class="col-md-9">
								<input type="text" ng-disabled="true"
									ng-model="wfRequestHop.lmsWfRequest.lmsLeaveApplication.leaveBalance"
									class="form-control">
							</div>
						</div>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label class="control-label col-md-3">From Date</label>
							<div class="col-md-9">
								<input type="text" ng-disabled="true"
									ng-model="wfRequestHop.lmsWfRequest.lmsLeaveApplication.fromDate | date: YYYY-MM-dd"
									class="form-control">
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label class="control-label col-md-3">To Date</label>
							<div class="col-md-9">
								<input type="text" ng-disabled="true"
									ng-model="wfRequestHop.lmsWfRequest.lmsLeaveApplication.toDate | date: YYYY-MM-dd"
									class="form-control">
							</div>
						</div>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label class="control-label col-md-3">Total Days Count</label>
							<div class="col-md-9">
								<input type="text" ng-disabled="true"
									ng-model="wfRequestHop.lmsWfRequest.lmsLeaveApplication.totalDayCount"
									class="form-control">
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label class="control-label col-md-3">Tasks Need to be
								Performed</label>
							<div class="col-md-9">
								<input type="text" ng-disabled="true"
									ng-model="wfRequestHop.lmsWfRequest.lmsLeaveApplication.taskNeedToPerformed"
									class="form-control">
							</div>
						</div>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label class="control-label col-md-3">Reliever Email
								Address</label>
							<div class="col-md-9">
								<input type="text" ng-disabled="true"
									ng-model="wfRequestHop.lmsWfRequest.lmsLeaveApplication.lmsUserByReliverEmailAddressUserId.email"
									class="form-control">
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label class="control-label col-md-3">In Station</label>
							<div class="col-md-9">
								<input type="text" ng-disabled="true"
									ng-model="wfRequestHop.lmsWfRequest.lmsLeaveApplication.inStation"
									class="form-control">
							</div>
						</div>
					</div>
				</div>
				<br>
				<div class="row" ng-show="showAttachment">
					<div class="col-md-12 form-group">
						<label class="col-md-2 control-label">Download Files: </label>
						<div class="col-md-10" style="height: 150px; overflow: scroll;">
							<ul class="list-group" ng-repeat="file in fileNames">
								<li class="list-group-item"><a
									href="download?fileName={{file}}">{{file}}</a></li>
							</ul>
						</div>
					</div>
				</div>
				<br> <br>
				<div class="row">
					<div class="col-md-12">
						<div id="successMssages" class="p-3 mb-2 bg-success text-white"
							data-ng-show="successMessages" data-ng-bind="successMessages"></div>
						<div id="errorMessages" class="p-3 mb-2 bg-danger text-white"
							data-ng-show="errorMessages" data-ng-bind="errorMessages"></div>
					</div>
				</div>
				<br>

				<form class="form-horizontal" name="approvalForm">
					<div class="row">
						<div class="col-md-2">
							<div class="form-group">
								<label class="control-label col-md-12">Remarks</label>
							</div>
						</div>
						<div class="col-md-10">
							<div class="form-group">
								<div class="col-md-12">
									<input type="text"
										ng-model="remarks"
										class="form-control" ng-required="status == 'REJECTED'"
										placeholder="Please write your remarks for rejection." />
								</div>
							</div>
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label col-md-3">Action</label>
								<div class="col-md-9">
									<select class="form-control" id="" ng-model="status"
										ng-required="true">
										<option value="">Select</option>
										<option value="ACCEPTED">ACCEPTED</option>
										<option value="REJECTED">REJECTED</option>
									</select>
								</div>
							</div>
						</div>
						<div class="col-md-2"></div>
						<div class="col-md-2">
							<button type="submit" class="btn btn-danger" id="submit"
								ng-click="showConfirmationMessage(status)"
								ng-disabled="approvalForm.$invalid">Submit</button>
						</div>
						<div class="col-md-2">
							<input type="button" class="btn btn-info" value="Cancel"
								id="Cancel" ng-click="gotoHomePage()">
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>