<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>

<script type="text/javascript"
	src="resources/js/app.js/service/divisionService.js"></script>
<script type="text/javascript"
	src="resources/js/app.js/service/designationService.js"></script>
<script type="text/javascript"
	src="resources/js/app.js/service/ministryService.js"></script>
<script type="text/javascript"
	src="resources/js/app.js/service/sectionService.js"></script>
<script type="text/javascript"
	src="resources/js/app.js/service/officeService.js"></script>
<script type="text/javascript"
	src="resources/js/app.js/service/DropDownService.js"></script>
<script type="text/javascript"
	src="resources/js/app.js/service/registrationService.js"></script>
<script type="text/javascript"
	src="resources/js/app.js/controller/registrationController.js"></script>






</head>
<body>
	<br>
	<div ng-controller="registrationController">
		<div ng-init="getDivisionData()"></div>
		<div ng-init="getDesignationData()"></div>
		<div ng-init="getMinistryData()"></div>
		<div ng-init="getSectionData()"></div>
		<div ng-init="getOfficeData()"></div>
		<div ng-init="getDropdownData()"></div>
		<form class="form-horizontal" name="registrationForm">
		<div class="container-fluid">

			<div class="row">
				<!--		<div class="col-sm-3" style="background-color: white;">User ID</div>
				<div class="col-sm-3" style="background-color: white;">
					<input type="text" ng-model="userid" class="form-control"
						placeholder="User ID">-->
			</div>



		</div>

		<br>
		<div class="row">
			<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-3" >Name</label>
						<div class="col-md-9">
							<input type="text" ng-required="true" ng-model="user.name" class="form-control"
								placeholder="User Name">
						</div>
					</div>
				</div>

                <div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-3" >Division</label>
						<div class="col-md-9">
							<select class="form-control" id="ddAppStatus"
					        ng-model="user.lmsDivision"
					        ng-options="x as x.name for x in divisionNames track by x.id">
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
						<label class="control-label col-md-3" >Designation</label>
						<div class="col-md-9">
							<select class="form-control" id="ddAppStatus"
					        ng-model="user.lmsDesignation"
					        ng-options="x as x.name for x in designationNames track by x.id">
					        <option value="">Select</option>
				            </select>
						</div>
					</div>
				</div>
		    <div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-3" >Ministry</label>
						<div class="col-md-9">
							<select class="form-control" id="ddAppStatus"
					        ng-model="user.lmsMinistry"
					        ng-options="x as x.name for x in ministryNames track by x.id">
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
						<label class="control-label col-md-3" >Section</label>
						<div class="col-md-9">
							<select class="form-control" id="ddAppStatus"
					        ng-model="user.lmsSection"
					        ng-options="x as x.name for x in sectionNames track by x.id">
					        <option value="">Select</option>
				            </select>
						</div>
					</div>
			</div>
		    <div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-3" >NID</label>
						<div class="col-md-9">
							<input type="text" ng-model="user.nid" class="form-control" placeholder="NID">
						</div>
					</div>
			</div>
		</div>
		<br>
		<div class="row">
		    <div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-3" >Nationality</label>
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
						<label class="control-label col-md-3" >Passport No</label>
						<div class="col-md-9">
							<input type="text" ng-model="user.passport" class="form-control" placeholder="Passport No">
						</div>
					</div>
			</div>
		</div>
		<br>
		<div class="row">
		    <div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-3" >Mobile</label>
						<div class="col-md-9">
							<input type="text" ng-model="user.mobile_personal" ng-required="true"
					         class="form-control" placeholder="Mobile">
						</div>
					</div>
			</div>
			<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-3" >Telephone</label>
						<div class="col-md-9">
							<input type="text" ng-model="user.mobile_office"
					        class="form-control" placeholder="Telephone">
						</div>
					</div>
			</div>
		</div>
		<br>

		<div class="row">
			<div class="col-sm-3" style="background-color: white;">Email</div>
			<div class="col-sm-3" style="background-color: white;">
				<input type="text" ng-model="user.email" class="form-control" ng-required="true"
					placeholder="Email">
			</div>
			<div class="col-sm-3" style="background-color: white;">Fax</div>
			<div class="col-sm-3" style="background-color: white;">
				<input type="text" ng-model="user.fax" class="form-control"
					placeholder="Fax">
			</div>
		</div>

		<br>

		<div class="row">
			<div class="col-sm-3" style="background-color: white;">Joining
				Date</div>
			<div class="col-sm-3" style="background-color: white;">
				<input type="text" ng-model="user.joining_date" class="form-control" ng-required="true"
					placeholder="Joining Date">
			</div>
			<div class="col-sm-3" style="background-color: white;">Gender</div>
			<div class="col-sm-3" style="background-color: white;">
				<select class="form-control" id="ddAppStatus"
					ng-model="user.lmsDropdown"
					ng-options="x as x.name for x in dropdownNames track by x.id">
					<option value="">Select</option>
				</select>
			</div>
		</div>

		<br>

		<div class="row">
			<div class="col-sm-3" style="background-color: white;">Supervisor
				Email</div>
			<div class="col-sm-3" style="background-color: white;">
				<input type="text" ng-model="supervisoremail" class="form-control" ng-required="true"
					placeholder="Supervisor Email">
			</div>
			<div class="col-sm-3" style="background-color: white;">Address</div>
			<div class="col-sm-3" style="background-color: white;">
				<textarea rows="3" type="textarea" ng-model="user.address"
					class="form-control" placeholder="Address"></textarea>
			
				
	
			</div>
</div>

<div class="row">
			<div class="col-sm-3" style="background-color: white;">Office</div>
			<div class="col-sm-3" style="background-color: white;">
				<select class="form-control" id="ddAppStatus"
					ng-model="user.lmsOfficeLocation"
					ng-options="x as x.name for x in officeNames track by x.id">
					<option value="">Select</option>
					<!-- <option value="">Hospital</option>
						<option value="">Casual</option> -->
				</select> Status: {{appStatus}}
			</div>
<div class="col-sm-3" style="background-color: white;">Password:</div>
			<div class="col-sm-3" style="background-color: white;">
				<input type="text" name="password" ng-model="password" class="form-control" ng-required="true" ng-pattern="/^(?=.*[A-Z].*[A-Z])(?=.*[!@#$&*])(?=.*[0-9].*[0-9])(?=.*[a-z].*[a-z].*[a-z]).{8,}$/"
					placeholder="Password"><span ng-show="registrationForm.password.$error.pattern">Ensure string has two uppercase letters, one special case, two digits,three lowercase letters and minimum length 8</span> 
			</div>


		</div>
		<div class=row>
			<div class="col-sm-3" style="background-color: white;">Re-Type Password:</div>
			<div class="col-sm-3" style="background-color: white;">
				<input type="text" ng-model="re_password"  class="form-control" ng-required="true"
					placeholder="Re-Type Password"/> <span ng-if="(password != re_password)"> Password Not Match</span>
			</div>
		</div>

		<br>

		<div class="row">
			<br>
			<div class="col-sm-3" style="background-color: white;"></div>
			<div class="col-sm-3" style="background-color: white;"></div>
			<div class="col-sm-3" style="background-color: white;"></div>
			<div class="col-sm-3" style="background-color: white;"></div>
		</div>

		<br>

		<div class="row">
			<button type="submit" class="btn" id="submit"
				ng-click="registration()">Submit</button>
			<div class="col-sm-3" style="background-color: white;"></div>
			<div class="col-sm-3" style="background-color: white;">
				<input type="button" class="btn btn-info" value="Cancel">
			</div>
			<div class="col-sm-3" style="background-color: white;"></div>
		</div>
		
		</form>
		
		<div class="row">
			<div class="col-md-12">
				<div id="successMssages" class="p-3 mb-2 bg-success text-white"
					
					data-ng-show="successMessages" data-ng-bind="successMessages"></div>
				<div id="errorMessages" class="p-3 mb-2 bg-danger text-white"
					data-ng-show="errorMessages" data-ng-bind="errorMessages"></div>
			</div>
			<div class="col-sm-3" style="background-color: white;"></div>
		</div>
	</div>
</body>
</html>