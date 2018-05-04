App
	.controller(
		'registrationController',
		[
			'$scope',
			'$timeout',
			'$http',
			'DivisionService',
			'DesignationService',
			'MinistryService',
			'SectionService',
			'OfficeService',
			'DropDownService',
			'registrationService',
			'userlistService',
			'$timeout',
			'$filter',
			'$location',

			function($scope, $timeout, $http, DivisionService, DesignationService, MinistryService, SectionService, OfficeService, DropDownService, registrationService,
					userlistService,$timeout, $filter,$location) {
				
				$scope.testMsg = "Testing Message";
				$scope.user={};
				/*$scope.user = {
						"office" : "",
						"name" : "",
						//"lmsDivision" : "",
						//"lmsDesignation" : "",
						//"lmsMinistry" : "",
						//"lmsSection" : "",
						"nid" : "",
						"nationality" : "",
						"passport" : "",
						"mobilePersonal" : "",						
						"phone" : "",
						"email" : "",						
						"fax" : "",
						"joiningDate" : "",
						"gender" : "",
						"supervisor_id" : "",						
						"address" : "",
						"insertDate" : "",
						"insertBy" : "",
						"updateDate" : "",
						"updateBy" : "",
						
						
						
						"mobileOffice" : "",	
						"status" : "",
						"password" : "",
						"designation_id" : "",
						"section_id" : "",
						"department_id" : "",						
						"division_id" : "",
						"ministry_id" : "",
						"office_location_id" : "",
													
						
					};*/

				
				$scope.registration = function(){
										
					/*$scope.user.name = $scope.username;
					$scope.user.nid = $scope.nid;
					$scope.user.office = $scope.office;
					$scope.user.division = $scope.division;
					$scope.user.designation = $scope.designation;
					$scope.user.ministry = $scope.ministry;
					$scope.user.section = $scope.section;
					$scope.user.nationality = $scope.nationality;
					$scope.user.passport = $scope.passport;
					$scope.user.mobile = $scope.mobile;
					$scope.user.telephone = $scope.telephone;
					$scope.user.email = $scope.email;
					$scope.user.fax = $scope.fax;
					$scope.user.joiningdate = new Date($('#joiningDate').val());
					$scope.user.gender = $scope.gender;
					$scope.user.supervisoremail = $scope.supervisoremail;
					$scope.user.address = $scope.address;*/
						
					console.log($scope.user.username);
					
					$scope.user.nationality = $scope.nationality.text;
					
					registrationService.registration($scope.user).then(
							function(d) {
								$scope.testMsg = d.message;
								console.log("Success.",d.message);
								$scope.showSuccessMessage("Registration Successfull.");
							},
							function(e) {
								$scope.testMsg = e.data.message;								
								console.error(e.data.message);
								$scope.showErrorMessage("Registration Failed.");
							});
				};
				
				$scope.getDivisionData = function(){
					DivisionService.getAllDivision().then(
							function(d) {
						$scope.divisionNames = d;
					}, function(errResponse) {
						console.log("Failed to get Drop Down.");
					});
				}
				
				
				$scope.getDesignationData = function(){
					DesignationService.getAllDesignation().then(function(d) {
						$scope.designationNames = d;
					}, function(errResponse) {
						console.log("Failed to get Drop Down.");
					});
				}
				
				
				$scope.getMinistryData = function(){
					MinistryService.getAllMinistry().then(function(d) {
						$scope.ministryNames = d;
					}, function(errResponse) {
						console.log("Failed to get Drop Down.");
					});
				}
				
				
				$scope.getSectionData = function(){
					SectionService.getAllSection().then(function(d) {
						$scope.sectionNames = d;
					}, function(errResponse) {
						console.log("Failed to get Drop Down.");
					});
				}
				
				
				$scope.getOfficeData = function(){
					OfficeService.getAllOffice().then(function(d) {
						$scope.officeNames = d;
					}, function(errResponse) {
						console.log("Failed to get Drop Down.");
					});
				}
				
				
				$scope.getDropdownData = function(){
					DropDownService.getAllDropdown().then(function(d) {
						$scope.dropdownNames = d;
					}, function(errResponse) {
						console.log("Failed to get Drop Down.");
					});
				}
				
				$scope.getDropdownDataNationality = function(dropdownname){
					DropDownService.getNationalityOption(dropdownname).then(function(d) {
						$scope.dropdownNationalityNames = d.listLmsDropdown;
					}, function(errResponse) {
						console.log("Failed to get Drop Down.");
					});
				}
				
				$scope.getDropdownDataGender = function(dropdownname){
					DropDownService.getGenderOption(dropdownname).then(function(d) {
						$scope.dropdownGenderNames = d.listLmsDropdown;
					}, function(errResponse) {
						console.log("Failed to get Drop Down.");
					});
				}
				
				$scope.loadUserListDropDown = function(){
					$scope.dDName = "";
					userlistService.getUserList()
					.then(
						function(d) {
						$scope.userData = d;
					}, function(errResponse) {
						console.log("Failed to get User Drop Down.");
					});
				}
				
				$scope.showSuccessMessage = function(message) {

					$scope.successMessages = message;
					$timeout(function() {
						$scope.successMessages = null;
						$scope.errorMessages = null;
					}, 6000);
				};

				/* Show Error Message */
				$scope.showErrorMessage = function(message) {

					$scope.errorMessages = message;
					$timeout(function() {
						$scope.successMessages = null;
						$scope.errorMessages = null;
					}, 6000);
				};
				
				
				$scope.clearAll = function(){
					// for dropdown set to zero
					//$scope.mobileNoDropDown = '0';
					// for text filed set to empty
					//$scope.mobileNoText = "";
					// for check button set false;
					//$scope.formSignVerified = false;
					$scope.user.name = "";
					$scope.user.lmsDivision = '0';
					$scope.email = "";
					
				};
				
			} ]);