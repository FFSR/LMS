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
	src="resources/js/app.js/service/divisionService.js"></script>
<script type="text/javascript"
	src="resources/js/app.js/service/updateuserprofileService.js"></script>
<script type="text/javascript"
	src="resources/js/app.js/service/manageuserService.js"></script>
<script type="text/javascript"
	src="resources/js/app.js/service/userlistService.js"></script>
<script type="text/javascript"
	src="resources/js/app.js/controller/manageuserController.js"></script>
<script type="text/javascript"
	src="resources/js/app.js/service/officeService.js"></script>
<script type="text/javascript"
	src="resources/js/app.js/service/designationService.js"></script>
<script type="text/javascript"
	src="resources/js/app.js/service/ministryService.js"></script>
<script type="text/javascript"
	src="resources/js/app.js/service/sectionService.js"></script>
<script type="text/javascript"
	src="resources/js/app.js/service/DropDownService.js"></script>
<script type="text/javascript"
	src="resources/js/app.js/service/RoleService.js"></script>
<script type="text/javascript"
	src="resources/js/app.js/service/WftroleService.js"></script>
<script type="text/javascript"
	src="resources/js/DatePicker/jquery.datetimepicker.full.js"></script>
<link rel="stylesheet"
	href="resources/css/datetimepicker/jquery.datetimepicker.css" />

</head>

<body ng-controller="manageuserController">
	<div>
		<div ng-init="userAuthentication('${sessionScope.user.id}')"></div>
		<div ng-init="getDivisionData()"></div>
		<div ng-init="getOfficeData()"></div>
		<div ng-init="getDesignationData()"></div>
		<div ng-init="getMinistryData()"></div>
		<div ng-init="getSectionData()"></div>
		<div ng-init="getDropdownData('userStatus')"></div>
		<div ng-init="getRoleData()"></div>
		<div ng-init="getWftroleData()"></div>
		<div ng-init="getDropdownDataGender('Sex')"></div>
		<div ng-init="getDropdownDataNationality('Nationality')"></div>
		<div ng-init="loadUserListDropDown()"></div>
		

		<div class="container-fluid">
			<div class="row">
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
		</div>
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
		<form class="form-horizontal" name="updateForm">

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
					<br> <br>
					<br>
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
						<div class="col-sm-6">
						<div class="form-group">
							<label class="control-label col-md-3">Reliever</label>
							<div class="col-md-9">
								<!-- Drop Down list from table -->
								<select class="form-control" id="ddReliever"
									ng-model="user.lmsUser" ng-required="true"
									ng-options="x as x.name for x in userData track by x.id">
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

		</form>
	</div>
</body>

<script>
	$('#jonDate').datetimepicker(
			{
				allowTimes : [ '1:00', '1:01', '1:02', '1:03', '1:04', '1:05',
						'1:06', '1:07', '1:08', '1:09', '1:010', '1:011',
						'1:012', '1:013', '1:014', '1:015', '1:016', '1:017',
						'1:018', '1:019', '1:020', '1:021', '1:022', '1:023',
						'1:024', '1:025', '1:026', '1:027', '1:028', '1:029',
						'1:030', '1:031', '1:032', '1:033', '1:034', '1:035',
						'1:036', '1:037', '1:038', '1:039', '1:040', '1:041',
						'1:042', '1:043', '1:044', '1:045', '1:046', '1:047',
						'1:048', '1:049', '1:050', '1:051', '1:052', '1:053',
						'1:054', '1:055', '1:056', '1:057', '1:058', '1:059',
						'2:00', '2:01', '2:02', '2:03', '2:04', '2:05', '2:06',
						'2:07', '2:08', '2:09', '2:010', '2:011', '2:012',
						'2:013', '2:014', '2:015', '2:016', '2:017', '2:018',
						'2:019', '2:020', '2:021', '2:022', '2:023', '2:024',
						'2:025', '2:026', '2:027', '2:028', '2:029', '2:030',
						'2:031', '2:032', '2:033', '2:034', '2:035', '2:036',
						'2:037', '2:038', '2:039', '2:040', '2:041', '2:042',
						'2:043', '2:044', '2:045', '2:046', '2:047', '2:048',
						'2:049', '2:050', '2:051', '2:052', '2:053', '2:054',
						'2:055', '2:056', '2:057', '2:058', '2:059', '3:00',
						'3:01', '3:02', '3:03', '3:04', '3:05', '3:06', '3:07',
						'3:08', '3:09', '3:010', '3:011', '3:012', '3:013',
						'3:014', '3:015', '3:016', '3:017', '3:018', '3:019',
						'3:020', '3:021', '3:022', '3:023', '3:024', '3:025',
						'3:026', '3:027', '3:028', '3:029', '3:030', '3:031',
						'3:032', '3:033', '3:034', '3:035', '3:036', '3:037',
						'3:038', '3:039', '3:040', '3:041', '3:042', '3:043',
						'3:044', '3:045', '3:046', '3:047', '3:048', '3:049',
						'3:050', '3:051', '3:052', '3:053', '3:054', '3:055',
						'3:056', '3:057', '3:058', '3:059', '4:00', '4:01',
						'4:02', '4:03', '4:04', '4:05', '4:06', '4:07', '4:08',
						'4:09', '4:010', '4:011', '4:012', '4:013', '4:014',
						'4:015', '4:016', '4:017', '4:018', '4:019', '4:020',
						'4:021', '4:022', '4:023', '4:024', '4:025', '4:026',
						'4:027', '4:028', '4:029', '4:030', '4:031', '4:032',
						'4:033', '4:034', '4:035', '4:036', '4:037', '4:038',
						'4:039', '4:040', '4:041', '4:042', '4:043', '4:044',
						'4:045', '4:046', '4:047', '4:048', '4:049', '4:050',
						'4:051', '4:052', '4:053', '4:054', '4:055', '4:056',
						'4:057', '4:058', '4:059', '5:00', '5:01', '5:02',
						'5:03', '5:04', '5:05', '5:06', '5:07', '5:08', '5:09',
						'5:010', '5:011', '5:012', '5:013', '5:014', '5:015',
						'5:016', '5:017', '5:018', '5:019', '5:020', '5:021',
						'5:022', '5:023', '5:024', '5:025', '5:026', '5:027',
						'5:028', '5:029', '5:030', '5:031', '5:032', '5:033',
						'5:034', '5:035', '5:036', '5:037', '5:038', '5:039',
						'5:040', '5:041', '5:042', '5:043', '5:044', '5:045',
						'5:046', '5:047', '5:048', '5:049', '5:050', '5:051',
						'5:052', '5:053', '5:054', '5:055', '5:056', '5:057',
						'5:058', '5:059', '6:00', '6:01', '6:02', '6:03',
						'6:04', '6:05', '6:06', '6:07', '6:08', '6:09',
						'6:010', '6:011', '6:012', '6:013', '6:014', '6:015',
						'6:016', '6:017', '6:018', '6:019', '6:020', '6:021',
						'6:022', '6:023', '6:024', '6:025', '6:026', '6:027',
						'6:028', '6:029', '6:030', '6:031', '6:032', '6:033',
						'6:034', '6:035', '6:036', '6:037', '6:038', '6:039',
						'6:040', '6:041', '6:042', '6:043', '6:044', '6:045',
						'6:046', '6:047', '6:048', '6:049', '6:050', '6:051',
						'6:052', '6:053', '6:054', '6:055', '6:056', '6:057',
						'6:058', '6:059', '7:00', '7:01', '7:02', '7:03',
						'7:04', '7:05', '7:06', '7:07', '7:08', '7:09',
						'7:010', '7:011', '7:012', '7:013', '7:014', '7:015',
						'7:016', '7:017', '7:018', '7:019', '7:020', '7:021',
						'7:022', '7:023', '7:024', '7:025', '7:026', '7:027',
						'7:028', '7:029', '7:030', '7:031', '7:032', '7:033',
						'7:034', '7:035', '7:036', '7:037', '7:038', '7:039',
						'7:040', '7:041', '7:042', '7:043', '7:044', '7:045',
						'7:046', '7:047', '7:048', '7:049', '7:050', '7:051',
						'7:052', '7:053', '7:054', '7:055', '7:056', '7:057',
						'7:058', '7:059', '8:00', '8:01', '8:02', '8:03',
						'8:04', '8:05', '8:06', '8:07', '8:08', '8:09',
						'8:010', '8:011', '8:012', '8:013', '8:014', '8:015',
						'8:016', '8:017', '8:018', '8:019', '8:020', '8:021',
						'8:022', '8:023', '8:024', '8:025', '8:026', '8:027',
						'8:028', '8:029', '8:030', '8:031', '8:032', '8:033',
						'8:034', '8:035', '8:036', '8:037', '8:038', '8:039',
						'8:040', '8:041', '8:042', '8:043', '8:044', '8:045',
						'8:046', '8:047', '8:048', '8:049', '8:050', '8:051',
						'8:052', '8:053', '8:054', '8:055', '8:056', '8:057',
						'8:058', '8:059', '9:00', '9:01', '9:02', '9:03',
						'9:04', '9:05', '9:06', '9:07', '9:08', '9:09',
						'9:010', '9:011', '9:012', '9:013', '9:014', '9:015',
						'9:016', '9:017', '9:018', '9:019', '9:020', '9:021',
						'9:022', '9:023', '9:024', '9:025', '9:026', '9:027',
						'9:028', '9:029', '9:030', '9:031', '9:032', '9:033',
						'9:034', '9:035', '9:036', '9:037', '9:038', '9:039',
						'9:040', '9:041', '9:042', '9:043', '9:044', '9:045',
						'9:046', '9:047', '9:048', '9:049', '9:050', '9:051',
						'9:052', '9:053', '9:054', '9:055', '9:056', '9:057',
						'9:058', '9:059', '10:00', '10:01', '10:02', '10:03',
						'10:04', '10:05', '10:06', '10:07', '10:08', '10:09',
						'10:010', '10:011', '10:012', '10:013', '10:014',
						'10:015', '10:016', '10:017', '10:018', '10:019',
						'10:020', '10:021', '10:022', '10:023', '10:024',
						'10:025', '10:026', '10:027', '10:028', '10:029',
						'10:030', '10:031', '10:032', '10:033', '10:034',
						'10:035', '10:036', '10:037', '10:038', '10:039',
						'10:040', '10:041', '10:042', '10:043', '10:044',
						'10:045', '10:046', '10:047', '10:048', '10:049',
						'10:050', '10:051', '10:052', '10:053', '10:054',
						'10:055', '10:056', '10:057', '10:058', '10:059',
						'11:00', '11:01', '11:02', '11:03', '11:04', '11:05',
						'11:06', '11:07', '11:08', '11:09', '11:010', '11:011',
						'11:012', '11:013', '11:014', '11:015', '11:016',
						'11:017', '11:018', '11:019', '11:020', '11:021',
						'11:022', '11:023', '11:024', '11:025', '11:026',
						'11:027', '11:028', '11:029', '11:030', '11:031',
						'11:032', '11:033', '11:034', '11:035', '11:036',
						'11:037', '11:038', '11:039', '11:040', '11:041',
						'11:042', '11:043', '11:044', '11:045', '11:046',
						'11:047', '11:048', '11:049', '11:050', '11:051',
						'11:052', '11:053', '11:054', '11:055', '11:056',
						'11:057', '11:058', '11:059', '12:00', '12:01',
						'12:02', '12:03', '12:04', '12:05', '12:06', '12:07',
						'12:08', '12:09', '12:010', '12:011', '12:012',
						'12:013', '12:014', '12:015', '12:016', '12:017',
						'12:018', '12:019', '12:020', '12:021', '12:022',
						'12:023', '12:024', '12:025', '12:026', '12:027',
						'12:028', '12:029', '12:030', '12:031', '12:032',
						'12:033', '12:034', '12:035', '12:036', '12:037',
						'12:038', '12:039', '12:040', '12:041', '12:042',
						'12:043', '12:044', '12:045', '12:046', '12:047',
						'12:048', '12:049', '12:050', '12:051', '12:052',
						'12:053', '12:054', '12:055', '12:056', '12:057',
						'12:058', '12:059', '13:00', '13:01', '13:02', '13:03',
						'13:04', '13:05', '13:06', '13:07', '13:08', '13:09',
						'13:010', '13:011', '13:012', '13:013', '13:014',
						'13:015', '13:016', '13:017', '13:018', '13:019',
						'13:020', '13:021', '13:022', '13:023', '13:024',
						'13:025', '13:026', '13:027', '13:028', '13:029',
						'13:030', '13:031', '13:032', '13:033', '13:034',
						'13:035', '13:036', '13:037', '13:038', '13:039',
						'13:040', '13:041', '13:042', '13:043', '13:044',
						'13:045', '13:046', '13:047', '13:048', '13:049',
						'13:050', '13:051', '13:052', '13:053', '13:054',
						'13:055', '13:056', '13:057', '13:058', '13:059',
						'14:00', '14:01', '14:02', '14:03', '14:04', '14:05',
						'14:06', '14:07', '14:08', '14:09', '14:010', '14:011',
						'14:012', '14:013', '14:014', '14:015', '14:016',
						'14:017', '14:018', '14:019', '14:020', '14:021',
						'14:022', '14:023', '14:024', '14:025', '14:026',
						'14:027', '14:028', '14:029', '14:030', '14:031',
						'14:032', '14:033', '14:034', '14:035', '14:036',
						'14:037', '14:038', '14:039', '14:040', '14:041',
						'14:042', '14:043', '14:044', '14:045', '14:046',
						'14:047', '14:048', '14:049', '14:050', '14:051',
						'14:052', '14:053', '14:054', '14:055', '14:056',
						'14:057', '14:058', '14:059', '15:00', '15:01',
						'15:02', '15:03', '15:04', '15:05', '15:06', '15:07',
						'15:08', '15:09', '15:010', '15:011', '15:012',
						'15:013', '15:014', '15:015', '15:016', '15:017',
						'15:018', '15:019', '15:020', '15:021', '15:022',
						'15:023', '15:024', '15:025', '15:026', '15:027',
						'15:028', '15:029', '15:030', '15:031', '15:032',
						'15:033', '15:034', '15:035', '15:036', '15:037',
						'15:038', '15:039', '15:040', '15:041', '15:042',
						'15:043', '15:044', '15:045', '15:046', '15:047',
						'15:048', '15:049', '15:050', '15:051', '15:052',
						'15:053', '15:054', '15:055', '15:056', '15:057',
						'15:058', '15:059', '16:00', '16:01', '16:02', '16:03',
						'16:04', '16:05', '16:06', '16:07', '16:08', '16:09',
						'16:010', '16:011', '16:012', '16:013', '16:014',
						'16:015', '16:016', '16:017', '16:018', '16:019',
						'16:020', '16:021', '16:022', '16:023', '16:024',
						'16:025', '16:026', '16:027', '16:028', '16:029',
						'16:030', '16:031', '16:032', '16:033', '16:034',
						'16:035', '16:036', '16:037', '16:038', '16:039',
						'16:040', '16:041', '16:042', '16:043', '16:044',
						'16:045', '16:046', '16:047', '16:048', '16:049',
						'16:050', '16:051', '16:052', '16:053', '16:054',
						'16:055', '16:056', '16:057', '16:058', '16:059',
						'17:00', '17:01', '17:02', '17:03', '17:04', '17:05',
						'17:06', '17:07', '17:08', '17:09', '17:010', '17:011',
						'17:012', '17:013', '17:014', '17:015', '17:016',
						'17:017', '17:018', '17:019', '17:020', '17:021',
						'17:022', '17:023', '17:024', '17:025', '17:026',
						'17:027', '17:028', '17:029', '17:030', '17:031',
						'17:032', '17:033', '17:034', '17:035', '17:036',
						'17:037', '17:038', '17:039', '17:040', '17:041',
						'17:042', '17:043', '17:044', '17:045', '17:046',
						'17:047', '17:048', '17:049', '17:050', '17:051',
						'17:052', '17:053', '17:054', '17:055', '17:056',
						'17:057', '17:058', '17:059', '18:00', '18:01',
						'18:02', '18:03', '18:04', '18:05', '18:06', '18:07',
						'18:08', '18:09', '18:010', '18:011', '18:012',
						'18:013', '18:014', '18:015', '18:016', '18:017',
						'18:018', '18:019', '18:020', '18:021', '18:022',
						'18:023', '18:024', '18:025', '18:026', '18:027',
						'18:028', '18:029', '18:030', '18:031', '18:032',
						'18:033', '18:034', '18:035', '18:036', '18:037',
						'18:038', '18:039', '18:040', '18:041', '18:042',
						'18:043', '18:044', '18:045', '18:046', '18:047',
						'18:048', '18:049', '18:050', '18:051', '18:052',
						'18:053', '18:054', '18:055', '18:056', '18:057',
						'18:058', '18:059', '19:00', '19:01', '19:02', '19:03',
						'19:04', '19:05', '19:06', '19:07', '19:08', '19:09',
						'19:010', '19:011', '19:012', '19:013', '19:014',
						'19:015', '19:016', '19:017', '19:018', '19:019',
						'19:020', '19:021', '19:022', '19:023', '19:024',
						'19:025', '19:026', '19:027', '19:028', '19:029',
						'19:030', '19:031', '19:032', '19:033', '19:034',
						'19:035', '19:036', '19:037', '19:038', '19:039',
						'19:040', '19:041', '19:042', '19:043', '19:044',
						'19:045', '19:046', '19:047', '19:048', '19:049',
						'19:050', '19:051', '19:052', '19:053', '19:054',
						'19:055', '19:056', '19:057', '19:058', '19:059',
						'20:00', '20:01', '20:02', '20:03', '20:04', '20:05',
						'20:06', '20:07', '20:08', '20:09', '20:010', '20:011',
						'20:012', '20:013', '20:014', '20:015', '20:016',
						'20:017', '20:018', '20:019', '20:020', '20:021',
						'20:022', '20:023', '20:024', '20:025', '20:026',
						'20:027', '20:028', '20:029', '20:030', '20:031',
						'20:032', '20:033', '20:034', '20:035', '20:036',
						'20:037', '20:038', '20:039', '20:040', '20:041',
						'20:042', '20:043', '20:044', '20:045', '20:046',
						'20:047', '20:048', '20:049', '20:050', '20:051',
						'20:052', '20:053', '20:054', '20:055', '20:056',
						'20:057', '20:058', '20:059', '21:00', '21:01',
						'21:02', '21:03', '21:04', '21:05', '21:06', '21:07',
						'21:08', '21:09', '21:010', '21:011', '21:012',
						'21:013', '21:014', '21:015', '21:016', '21:017',
						'21:018', '21:019', '21:020', '21:021', '21:022',
						'21:023', '21:024', '21:025', '21:026', '21:027',
						'21:028', '21:029', '21:030', '21:031', '21:032',
						'21:033', '21:034', '21:035', '21:036', '21:037',
						'21:038', '21:039', '21:040', '21:041', '21:042',
						'21:043', '21:044', '21:045', '21:046', '21:047',
						'21:048', '21:049', '21:050', '21:051', '21:052',
						'21:053', '21:054', '21:055', '21:056', '21:057',
						'21:058', '21:059', '22:00', '22:01', '22:02', '22:03',
						'22:04', '22:05', '22:06', '22:07', '22:08', '22:09',
						'22:010', '22:011', '22:012', '22:013', '22:014',
						'22:015', '22:016', '22:017', '22:018', '22:019',
						'22:020', '22:021', '22:022', '22:023', '22:024',
						'22:025', '22:026', '22:027', '22:028', '22:029',
						'22:030', '22:031', '22:032', '22:033', '22:034',
						'22:035', '22:036', '22:037', '22:038', '22:039',
						'22:040', '22:041', '22:042', '22:043', '22:044',
						'22:045', '22:046', '22:047', '22:048', '22:049',
						'22:050', '22:051', '22:052', '22:053', '22:054',
						'22:055', '22:056', '22:057', '22:058', '22:059',
						'23:00', '23:01', '23:02', '23:03', '23:04', '23:05',
						'23:06', '23:07', '23:08', '23:09', '23:010', '23:011',
						'23:012', '23:013', '23:014', '23:015', '23:016',
						'23:017', '23:018', '23:019', '23:020', '23:021',
						'23:022', '23:023', '23:024', '23:025', '23:026',
						'23:027', '23:028', '23:029', '23:030', '23:031',
						'23:032', '23:033', '23:034', '23:035', '23:036',
						'23:037', '23:038', '23:039', '23:040', '23:041',
						'23:042', '23:043', '23:044', '23:045', '23:046',
						'23:047', '23:048', '23:049', '23:050', '23:051',
						'23:052', '23:053', '23:054', '23:055', '23:056',
						'23:057', '23:058', '23:059' ],
				format : 'Y-m-d H:i',
				timepickerScrollbar : false
			});
</script>

</html>
