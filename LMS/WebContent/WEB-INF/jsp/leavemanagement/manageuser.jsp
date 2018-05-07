<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
		
		<script type="text/javascript" src="resources/js/app.js/service/divisionService.js"></script>
		<script type="text/javascript" src="resources/js/app.js/service/updateuserprofileService.js"></script>
		<script type="text/javascript" src="resources/js/app.js/service/manageuserService.js"></script>
		<script type="text/javascript" src="resources/js/app.js/controller/manageuserController.js"></script>
		<script type="text/javascript" src="resources/js/app.js/controller/registrationController.js"></script>
		<script type="text/javascript" src="resources/js/app.js/service/officeService.js"></script>
		<script type="text/javascript" src="resources/js/app.js/service/designationService.js"></script>
		<script type="text/javascript" src="resources/js/app.js/service/ministryService.js"></script>
		<script type="text/javascript" src="resources/js/app.js/service/sectionService.js"></script>
		<script type="text/javascript" src="resources/js/app.js/service/DropDownService.js"></script>
	</head>

	<body ng-controller="manageuserController as muc">
		<div ng-init="getDivisionData()"></div>
		<div ng-init="getOfficeData()"></div>
		<div ng-init="getDesignationData()"></div>
		<div ng-init="getMinistryData()"></div>
		<div ng-init="getSectionData()"></div>
		<div ng-init="getDropdownData()"></div>
		<div>
		<div class="container-fluid">
				<br>

				<div class="row">
					<div class="col-sm-3" style="background-color: white;">
						<form role="form">
							<div class="col-md-9">
								<label for="userName">Employee Name:</label>
								<input type="text" ng-model="userName" class="form-control" id="userName">
								<label for="mobile">Employee Mobile:</label>
								<input type="text" ng-model="mobile" class="form-control" id="mobile">
							</div>

							
						</form>
						<div style="color: blue">{{user_id}}{{testMsg}}</div>
					</div>
				</div>
					<div class="row">
                           <div class="col-md-6">
			                  <div class="form-group">
				                  <label class="control-label col-md-3">Status</label>
				                      <div class="col-md-9">
					                  <select class="form-control" id="ddAppStatus"
											ng-model="status"
											ng-options="x as x.name for x in dropdownNames track by x.id">
											<option value="">Select</option>
										</select>
				                     </div>
			                    </div>
			               </div>
					</div>
					
					<div class="row">
                           <div class="col-md-6">
			                  <div class="form-group">
									<button type="submit" class="btn btn-info" id="search" ng-click="manageuser(userName,mobile,status)">Search</button>
			                    </div>
			               </div>
					</div>
					
					
				<br>
			</div>
		</div>
			<br>
			<div>
				<table class="table table-sm">
					<div>
						Test Message: {{testMessage}}
						<table ng-table="tableParams" class="table" show-filter="true">
							<tr ng-repeat="user in $data">
								<td title="'Employee ID'" filter="{ name: 'text'}" sortable="'name'">{{user.id}}</td>
								<td title="'Employee name'" filter="{ name: 'text'}" sortable="'name'">{{user.name}}</td>
								<td title="'Division'" filter="{ type: 'text'}" sortable="'lmsLeaveType.type'">{{user.lmsDivision.name}}</td>
								<td title="'Section'" filter="{ leaveTotal: 'text'}" sortable="'totalleave'">{{user.lmsSection.name}}</td>
								<td title="'mobile'" filter="{ leavetaken: 'text'}" sortable="'takenleave'">{{user.mobilePersonal}}</td>
								<td title="'Status'" filter="{ Remainingleave: 'text'}" sortable="'remainingTotal'">{{user.status}}</td>
								<td title="'Action'">
									<button class="btn-primary" ng-click="showEmpDetails(user)">Details</button>
								</td>
						</table>
					</div>
				</table>
			</div>
				<br>

				<div class="container-fluid">
				<div ng-if="showUserDetails">
					<div class="row">
					     <div class="col-md-6">
			                  <div class="form-group">
				                  <label class="control-label col-md-3">User ID</label>
				                      <div class="col-md-9">
					                     <input type="text">
				                     </div>
			                    </div>
			             </div>
					     <div class="col-md-6">
			                  <div class="form-group">
				                  <label class="control-label col-md-3">Name</label>
				                      <div class="col-md-9">
					                     <input type="text" ng-model="user.name">
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
					                    <input type="text" ng-model="user.nid" class="form-control" placeholder="nid">
				                     </div>
			                    </div>
			               </div>
                           <div class="col-md-6">
			                  <div class="form-group">
				                  <label class="control-label col-md-3">Passport No</label>
				                      <div class="col-md-9">
					                   <input type="text" ng-model="user.passport" class="form-control" placeholder="passport">
				                     </div>
			                    </div>
			               </div>
					</div>
					<br>
					<div class="row">
						<div class="col-md-6">
			                  <div class="form-group">
				                  <label class="control-label col-md-3">Mobile</label>
				                      <div class="col-md-9">
					                   <input type="text" ng-model="user.mobilePersonal" class="form-control" placeholder="mobile no">
				                     </div>
			                    </div>
			               </div>
						   <div class="col-md-6">
			                  <div class="form-group">
				                  <label class="control-label col-md-3">Telephone</label>
				                      <div class="col-md-9">
					                   <input type="text" ng-model="user.phone" class="form-control" placeholder="Telephone">
				                     </div>
			                    </div>
			               </div>
					</div>
					<br>
					<div class="row">
                          <div class="col-md-6">
			                  <div class="form-group">
				                  <label class="control-label col-md-3">Email</label>
				                      <div class="col-md-9">
					                   <input type="text" ng-model="user.email" class="form-control" placeholder="email">
				                     </div>
			                    </div>
			               </div>
						   <div class="col-md-6">
			                  <div class="form-group">
				                  <label class="control-label col-md-3">Fax</label>
				                      <div class="col-md-9">
					                  <input type="text" ng-model="user.fax" class="form-control" placeholder="Fax">
				                     </div>
			                    </div>
			               </div> 
					</div>
					<br>
					<div class="row">
							<div class="col-md-6">
			                  <div class="form-group">
				                  <label class="control-label col-md-3">Joining Date</label>
				                      <div class="col-md-9">
					                  <input type="text" ng-model="user.joining-date" class="form-control" placeholder="Joining Date">
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
											<!-- <option value="">Hospital</option>
												<option value="">Casual</option> -->
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
					                  <select class="form-control" id="ddAppStatus" ng-model="user.lmsDivision" ng-options="x as x.name for x in divisionNames track by x.id">
											<option value="">Select</option>
											<!-- <option value="">Hospital</option>
									         <option value="">Casual</option> -->
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
											ng-model="user.LmsDropdown"
											ng-options="x as x.name for x in dropdownNames track by x.id">
											<option value="">Select</option>
										</select>
				                     </div>
			                    </div>
			               </div>
         		
                           <div class="col-md-6">
			                  <div class="form-group">
				                  <label class="control-label col-md-3">Gender</label>
				                      <div class="col-md-9">
					                  <select class="form-control" id="ddAppStatus"
											ng-model="user.lmsDropdown"
											ng-options="x as x.name for x in dropdownNames track by x.id">
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
					                  <select class="form-control" id="ddAppStatus"
											ng-model="user.lmsDropdown"
											ng-options="x as x.name for x in dropdownNames track by x.id">
											<option value="">Select</option>
										</select>
				                     </div>
			                    </div>
			               </div>
					</div>
					<br>
						
						<div class="col-sm-3" style="background-color: white;"></div>
						<button type="submit" class="btn" id="submit" ng-click="userprofile()">Update</button>
						<div class="col-sm-3" style="background-color: white;"></div>
						<div class="col-sm-3" style="background-color: white;">
							<input type="button" class="btn btn-info" value="Cancel">
						</div>
					</div>
					<div class="row">
				    <div class="col-md-12">
					<div id="successMssages" class="p-3 mb-2 bg-success text-white"
						data-ng-show="successMessages" data-ng-bind="successMessages"></div>
					<div id="errorMessages" class="p-3 mb-2 bg-danger text-white"
						data-ng-show="errorMessages" data-ng-bind="errorMessages"></div>
				    </div>
			</div>
					
				</div>
			</div>
	</body>
	</html>
