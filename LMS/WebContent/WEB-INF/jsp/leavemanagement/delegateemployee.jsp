<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ministry Information</title>

<script type="text/javascript"
	src="resources/js/app.js/service/userlistService.js"></script>
<script type="text/javascript"
	src="resources/js/app.js/service/DropDownService.js"></script>
<script type="text/javascript"
	src="resources/js/app.js/service/managedelegationService.js"></script>
<!-- <script type="text/javascript"
	src="resources/js/app.js/service/manageuserService.js"></script> -->


<script type="text/javascript"
	src="resources/js/DatePicker/jquery.datetimepicker.full.js"></script>
<link rel="stylesheet"
	href="resources/css/datetimepicker/jquery.datetimepicker.css" />
<script type="text/javascript"
	src="resources/js/app.js/controller/delegateemployeeController.js"></script>

</head>
<body>
	<br>
	<div ng-controller="delegateemployeeController">
		<div
			ng-init="loadUserListDropDown();getUserInfo('${sessionScope.user.id}')"></div>

		<form class="form-horizontal">
			<div class="form-body">
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label class="control-label col-md-3">User Name</label>
							<div class="col-md-9">
								<input type="text" ng-model="name" class="form-control"
									placeholder="User ID">
							</div>
						</div>
					</div>

					<div class="col-md-6">
						<div class="form-group">
							<label class="control-label col-md-3">Department</label>
							<div class="col-md-9">
								<input type="text" ng-model="departmentname"
									class="form-control" placeholder="User Name">
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label class="control-label col-md-3">Section Name</label>
							<div class="col-md-9">
								<input type="text" ng-model="sectionname" class="form-control"
									placeholder="User ID">
							</div>
						</div>
					</div>

					<div class="col-md-6">
						<div class="form-group">
							<label class="control-label col-md-3">Mobile</label>
							<div class="col-md-9">
								<input type="text" ng-model="mobilePersonal"
									class="form-control" placeholder="User Name">
							</div>
						</div>
					</div>
				</div>
				<br> My Roles
				<div>
					<table class="table table-sm">
						<div>
							<table ng-table="tableParams" class="table" show-filter="true">
								<tr ng-repeat="listLmsWftRoleUserMap in $data">

									<td title="'Role Name'"
										sortable="'listLmsWftRoleUserMap.lmsWftRole.roleName'">{{listLmsWftRoleUserMap.lmsWftRole.roleName}}
									</td>
								</tr>
							</table>
						</div>
					</table>
				</div>

				<br>
				<div class="row">
					<div class="col-sm-6">
						<div class="form-group">
							<label class="control-label col-md-3">Reliever</label>
							<div class="col-md-9">
								<!-- Drop Down list from table -->
								<select class="form-control" id="ddReliever_n"
									ng-model="ddReliever_n"
									ng-options="x as x.name for x in userData track by x.id">
									<option value="test">Select</option>
									<option value="test">Test</option>
								</select>
							</div>
						</div>
					</div>
					Test: {{e}}
					<div class="col-md-6">
						<div class="form-group">
							<label class="control-label col-md-3">User Name</label>
							<div class="col-md-9">
								<input type="text" ng-model="name_n" class="form-control">
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-sm-6">
						<div class="form-group">
							<label class="control-label col-md-3">Department Name</label>
							<div class="col-md-9">
								<input type="text" ng-model="dep_name" class="form-control">
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label class="control-label col-md-3">SectionName</label>
							<div class="col-md-9">
								<input type="text" ng-model="sec_name" class="form-control">
							</div>
						</div>
					</div>
				</div>

				<br> My Reliever
				<div>
					<table class="table table-sm">
						<div>
							<table ng-table="tableParams2" class="table" show-filter="true">
								<tr ng-repeat="RoleUserMap in $data">

									<td title="'Relievr Name'"
										sortable="'RoleUserMap.lmsWftRole.roleName'">{{RoleUserMap.lmsUser.name}}
									</td>
									<td title="'Role Name'"
										sortable="'RoleUserMap.lmsWftRole.roleName'">{{RoleUserMap.lmsWftRole.roleName}}
									</td>
									<td title="'Action'"><button class="btn-primary"
											ng-click="deleteReliever(RoleUserMap.lmsUser.id,RoleUserMap.delegateBy)">Delete</button></td>
								</tr>
							</table>
						</div>
					</table>
				</div>

				<div class="row">
					<button type="submit" class="btn" id="submit"
						ng-click="addReliever()">Add Reliever</button>
					<div class="col-sm-3" style="background-color: white;"></div>
					<div class="col-sm-3" style="background-color: white;">
						<input type="button" class="btn btn-info" value="Cancel">
					</div>
					<div class="col-sm-3" style="background-color: white;"></div>
				</div>

				<div class="row">
					<select class="form-control" id="ddleavetype" ng-required="false"
						ng-model="leavetype"
						ng-options="x as x.name for x in usersList track by x.id">
						<option value="">Select</option>
					</select>
				</div>
			</div>
		</form>
	</div>
</body>
</html>
