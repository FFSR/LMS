App
		.controller(
				'userprofileController',
				[
						'$scope',
						'$timeout',
						'$http',
						'updateprofileService',
						'manageuserService',
						'DivisionService',
						'DepartmentService',
						'DesignationService',
						'MinistryService',
						'SectionService',
						'OfficeService',
						'DropDownService',
						'userlistService',
						'$filter',
						'$location',
						'NgTableParams',
						'url',

						function($scope, $timeout, $http, updateprofileService,
								manageuserService, DivisionService,
								DepartmentService, DesignationService,
								MinistryService, SectionService, OfficeService,
								DropDownService, userlistService, $filter,
								$location, NgTableParams, url) {

							$scope.testMsg = "Testing Message";
							$scope.user = {};
							$scope.userID = "";

							$scope.showEmpDetails = function(userID) {

								manageuserService
										.urmanageuser(userID)
										.then(
												function(d) {
													$scope.testMsg1 = "Test";
													console.log("Success.",
															d.message);
													var data = d;
													$scope.user = data;

													$scope.user.name = data.lmsuser.name;
													$scope.user.lmsDivision = data.lmsuser.lmsDivision;
													$scope.user.lmsDepartment = data.lmsuser.lmsDepartment;
													$scope.user.lmsSection = data.lmsuser.lmsSection;
													$scope.user.lmsDesignation = data.lmsuser.lmsDesignation;
													$scope.user.lmsMinistry = data.lmsuser.lmsMinistry;
													$scope.nationality = data.lmsuser.nationality;
													$scope.user.lmsOfficeLocation = data.lmsuser.lmsOfficeLocation;
													$scope.user.mobilePersonal = data.lmsuser.mobilePersonal;
													$scope.user.mobileOffice = data.lmsuser.mobileOffice;
													$scope.user.email = data.lmsuser.email;
													$scope.user.fax = data.lmsuser.fax;
													$scope.user.passport = data.lmsuser.passport;
													$scope.user.address = data.lmsuser.address;
													$scope.joiningDate = data.lmsuser.joiningDate;
													$scope.gender = data.lmsuser.gender;
													$scope.user.password = data.lmsuser.password;
													// $scope.ddReliever=data.lmsuser.lmsuser.name;
													$scope.user.nid = data.lmsuser.nid;

												},
												function(errResponse) {

													console
															.error("Error while fetching Currencies");
												});

							};

							$scope.getSessionUserDetails = function(userID) {
								$scope.userID = userID;
							}

							$scope.userprofile = function() {

								updateprofileService
										.updateprofile($scope.userID,
												$scope.user)
										.then(
												function(d) {
													// $scope.testMsg =
													// d.message;
													// console.log("Success.",d.message);
													$scope.uploadFile();
													
													$scope.clearAll();

													$scope
															.showSuccessMessage("Update sucessful");
													$window.location.reload();

												},
												function(e) {
													$scope.testMsg = e.data.message;
													// console.error(e.data.message);
													$scope
															.showErrorMessage(e.message);

												});
							};

							$scope.getDivisionData = function() {
								DivisionService
										.getAllDivision()
										.then(
												function(d) {
													$scope.divisionNames = d;
												},
												function(errResponse) {
													console
															.log("Failed to get Drop Down.");
												});
							}

							$scope.getDepartmentData = function() {
								DepartmentService
										.getAllDepartment()
										.then(
												function(d) {
													$scope.departmentNames = d;
												},
												function(errResponse) {
													console
															.log("Failed to get Drop Down.");
												});
							}

							$scope.getDesignationData = function() {
								DesignationService
										.getAllDesignation()
										.then(
												function(d) {
													$scope.designationNames = d;
												},
												function(errResponse) {
													console
															.log("Failed to get Drop Down.");
												});
							}

							$scope.getMinistryData = function() {
								MinistryService
										.getAllMinistry()
										.then(
												function(d) {
													$scope.ministryNames = d;
												},
												function(errResponse) {
													console
															.log("Failed to get Drop Down.");
												});
							}

							$scope.getSectionData = function() {
								SectionService
										.getAllSection()
										.then(
												function(d) {
													$scope.sectionNames = d;
												},
												function(errResponse) {
													console
															.log("Failed to get Drop Down.");
												});
							}

							$scope.getOfficeData = function() {
								OfficeService.getAllOffice().then(function(d) {
									$scope.officeNames = d;
								}, function(errResponse) {
									console.log("Failed to get Drop Down.");
								});
							}

							$scope.getDropdownData = function() {
								DropDownService
										.getAllDropdown()
										.then(
												function(d) {
													$scope.dropdownNames = d;
												},
												function(errResponse) {
													console
															.log("Failed to get Drop Down.");
												});
							}

							$scope.getDropdownDataNationality = function(
									dropdownname) {
								DropDownService
										.getNationalityOption(dropdownname)
										.then(
												function(d) {
													$scope.dropdownNationalityNames = d.listLmsDropdown;
												},
												function(errResponse) {
													console
															.log("Failed to get Drop Down.");
												});
							}

							$scope.getDropdownDataGender = function(
									dropdownname) {
								DropDownService
										.getGenderOption(dropdownname)
										.then(
												function(d) {
													$scope.dropdownGenderNames = d.listLmsDropdown;
												},
												function(errResponse) {
													console
															.log("Failed to get Drop Down.");
												});
							}

							$scope.loadUserListDropDown = function() {
								$scope.dDName = "";
								userlistService
										.getUserList()
										.then(
												function(d) {
													$scope.userData = d;
												},
												function(errResponse) {
													console
															.log("Failed to get User Drop Down.");
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
							
							$scope.uploadFile = function(){
								$scope.processDropzone();
								// $scope.restDropzone();
							}

							$scope.clearAll = function() {

								$scope.formSignVerified = false;
								$scope.user.name = "";
								$scope.user.lmsDivision = '0';
								$scope.user.email = "";
								$scope.user.lmsDepartment = '0';
								$scope.user.lmsSection = '0';
								$scope.user.lmsDesignation = '0';
								$scope.user.lmsMinistry = '0';
								$scope.nationality = "";
								$scope.user.lmsOfficeLocation = '0';
								$scope.user.mobilePersonal = "";
								$scope.user.mobileOffice = "";
								$scope.user.fax = "";
								$scope.joiningDate = "";
								$scope.gender = '0';
								$scope.ddReliever = '0';
								$scope.user.address = "";
								$scope.user.passport = "";
								$scope.user.password = "";
								$scope.user.nid = "";
								$scope.dateofbirth = "";

							};

							$scope.gotoHomePage = function() {

								window.location = "employeehomepage";
							};

						} ]);
