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

</head>

<body ng-controller="subordinatelvblnceController">
	<div>
		<div ng-init="userAuthentication('${sessionScope.user.id}')"></div>		

		<div class="container-fluid">
	 <!--		<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-6">Employee Name:</label>
						<div class="col-md-6">
							<input type="text" ng-model="userName" class="form-control"
								id="userName">
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-6">Employee Mobile:</label>
						<div class="col-md-6">
							<input type="text" ng-model="mobile" class="form-control"
								id="mobile">
						</div>
					</div>
				</div>
			</div>
			<br>
	 		<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-6">Status</label>
						<div class="col-md-6">
							<select class="form-control" id="ddAppStatus" ng-model="ddstatus"
								ng-options="x as x.name for x in dropdownNames track by x.id">
								<option value="">Select</option>
							</select>
						</div>
					</div>
				</div>


				<div class="col-md-6">
					<div class="form-group">
						<div class="col-md-6"></div>
						<div class="col-md-6">
							<button type="submit" class="btn btn-info" id="search"
								ng-click="manageuser()">Search</button>
						</div>
					</div>
				</div>
			</div>
		</div> -->
		<br>
		<div>
			<table class="table table-sm">
				<div>
					<table ng-table="tableParams" class="table" show-filter="true">
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
									ng-click="showEmpDetails(user)">Details</button>

							</td>
					</table>
				</div>
			</table>
		</div>
		<br> <br> <br>
<!--  		<form class="form-horizontal" name="updateForm">

			<div class="container-fluid">
				<div ng-if="showUserDetails">
					<div class="row">

						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label col-md-3">Name</label>
								<div class="col-md-9">
									<input type="text" ng-model="user.name" class="form-control"
										placeholder="name">
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label col-md-3">Mobile</label>
								<div class="col-md-9">
									<input type="text" ng-model="user.mobilePersonal"
										class="form-control" placeholder="mobile no">
								</div>
							</div>
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label col-md-3">NID</label>
								<div class="col-md-9">
									<input type="text" ng-model="user.nid" class="form-control"
										placeholder="nid">
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label col-md-3">Passport No</label>
								<div class="col-md-9">
									<input type="text" ng-model="user.passport"
										class="form-control" placeholder="passport">
								</div>
							</div>
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="col-md-3 control-label">Joining Date</label>
								<div class="col-md-9">
									<input type="text"
										ng-model="user.joiningDate| date: YYYY-MM-dd"
										class="form-control" placeholder="Joining Date">

								</div>

							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label col-md-3">Telephone</label>
								<div class="col-md-9">
									<input type="text" ng-model="user.mobileOffice"
										class="form-control" placeholder="Telephone">
								</div>
							</div>
						</div>
					</div>
					<br> <br> <br>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label col-md-3">Email</label>
								<div class="col-md-9">
									<input type="text" ng-model="user.email" class="form-control"
										placeholder="email">
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label col-md-3">Fax</label>
								<div class="col-md-9">
									<input type="text" ng-model="user.fax" class="form-control"
										placeholder="Fax">
								</div>
							</div>
						</div>
					</div>
					<br>
					<div class="row">

						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label col-md-3">Gender</label>
								<div class="col-md-9">
									<select class="form-control" id="ddAppStatus" ng-model="gender"
										ng-change="setnewGender(user,gender.name)"
										ng-options="x as x.name for x in dropdownGenderNames track by x.name">
										<option value="">Select</option>
									</select>
								</div>
							</div>
						</div>

						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label col-md-3">Office</label>
								<div class="col-md-9">
									<select class="form-control" id="ddAppStatus"
										ng-model="user.lmsOfficeLocation"
										ng-options="x as x.name for x in officeNames track by x.id">
										<option value="">Select</option>

									</select>
								</div>
							</div>
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label col-md-3">Division</label>
								<div class="col-md-9">
									<select class="form-control" id="ddAppStatus"
										ng-model="user.lmsDivision"
										ng-options="x as x.name for x in divisionNames track by x.id">
										<option value="">Select</option>

									</select>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label col-md-3">Designation</label>
								<div class="col-md-9">
									<select class="form-control" id="ddAppStatus"
										ng-model="user.lmsDesignation"
										ng-options="x as x.name for x in designationNames track by x.id">
										<option value="">Select</option>
									</select>
								</div>
							</div>
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label col-md-3">Ministry</label>
								<div class="col-md-9">
									<select class="form-control" id="ddAppStatus"
										ng-model="user.lmsMinistry"
										ng-options="x as x.name for x in ministryNames track by x.id">
										<option value="">Select</option>
									</select>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label col-md-3">Section</label>
								<div class="col-md-9">
									<select class="form-control" id="ddAppStatus"
										ng-model="user.lmsSection"
										ng-options="x as x.name for x in sectionNames track by x.id">
										<option value="">Select</option>
									</select>
								</div>
							</div>
						</div>
					</div>
					<br>

					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label col-md-3">Nationality</label>
								<div class="col-md-9">
									<select class="form-control" id="ddAppStatus"
										ng-model="nationality"
										ng-change="setnewNationality(user,nationality.name)"
										ng-options="x as x.name for x in dropdownNationalityNames track by x.name">
										<option value="">Select</option>

									</select>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label col-md-3">Workflow Role</label>
								<div class="col-md-9">
									<select class="form-control" id="ddlmsWftrole"
										ng-model="ddlmsWftrole"
										ng-options="x as x.roleName for x in wftroleNames track by x.id">
										<option value="">Select</option>
									</select>

								</div>
							</div>
						</div>

					</div>
					<br>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label col-md-3">Status</label>
								<div class="col-md-9">
									<select class="form-control" id="ddAppStatus" ng-model="status"
										ng-change="setnewStatus(user,status.name)"
										ng-options="x as x.name for x in dropdownNames track by x.name">
										<option value="">Select</option>
									</select>
								</div>
							</div>
						</div>

						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label col-md-3">Application Role</label>
								<div class="col-md-9">
									<select class="form-control" id="ddlmsRole"
										ng-model="ddlmsRole"
										ng-options="x as x.name for x in roleNames track by x.id">
										<option value="">Select</option>
									</select>

								</div>
							</div>
						</div>

					</div>
					<br>

					<div class="row"></div>
					<br>
					<div class="row">
						<div class="col-sm-3">
							<button type="submit"
								class="btn btn-success waves-effect waves-light m-r-10"
								id="submit" ng-click="userprofile(ddlmsWftrole,ddlmsRole,user)">Update</button>
						</div>
						<div class="col-sm-9">
							<button type="button"
								class="btn btn-inverse waves-effect waves-light"
								ng-click="gotoHomePage()">Cancel</button>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-3">
						<div id="successMssages" class="p-3 mb-2 bg-success text-white"
							data-ng-show="successMessages" data-ng-bind="successMessages"></div>
						<div id="errorMessages" class="p-3 mb-2 bg-danger text-white"
							data-ng-show="errorMessages" data-ng-bind="errorMessages"></div>
					</div>
				</div>
			</div>

		</form> -->
		</div>
	</div>
</body>

</html>
