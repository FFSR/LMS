App
.controller(
		'manageuserController', 
		[
		'$scope',
		'$timeout',
		'$http',
		'loginService',
		'updateuserprofileService',
		'manageuserService',
		'OfficeService',
		'DivisionService',
		'DesignationService',
		'MinistryService',
		'SectionService',
		'DropDownService',
		'RoleService',
		'WftroleService',
		'$filter',
		'NgTableParams',
		'$location',
		'url',

		function($scope, $timeout, $http, 
				loginService, updateuserprofileService, manageuserService,
				OfficeService, DivisionService, DesignationService,
				MinistryService, SectionService, DropDownService, RoleService, WftroleService, 
				$filter, NgTableParams, $location, url) {
			
			$scope.testMsg = "Test Message New";
			$scope.user = {};
			$scope.showUserDetails = false;
			
			

			$scope.manageuser = function() {

				$scope.statusFinal = "";

				if ($scope.userName == null || $scope.userName == "") {
					$scope.userNameDummy = "880";
				}else{
					$scope.userNameDummy = $scope.userName;
				}

				if ($scope.mobile == null || $scope.mobile == "") {
					$scope.mobileDummy = "a";
				}else{
					$scope.mobileDummy = $scope.mobile;
				}

				
				if ($scope.ddstatus == null) {
					$scope.statusFinal = "880";

				} else {
					$scope.statusFinal = $scope.ddstatus.text;
				}

				
				//$scope.user.status= $scope.status.name;
				
				manageuserService.getmanageuser($scope.userNameDummy, $scope.mobileDummy, $scope.statusFinal)
					.then(function(d) {
						$scope.testMsg1 = "Test";
						console.log("Success.", d.message);
						var data = d.listLmsuser;
						$scope.tableParams = new NgTableParams({}, {
							dataset : data
						});

				}, function(errResponse) {

					console.error("Error while fetching Currencies");
				});
			};

			$scope.showEmpDetails = function(user) {

				//console.log("User", user);
				
				
				//= user.joiningDate;
				
				$scope.showUserDetails = true;

				$scope.user = user;
				
				//Feroj: Worked to show below values. 26.05.2018 15:43
				$scope.gender = {};
                $scope.gender.name = user.gender;
                
                $scope.nationality={};
                $scope.nationality.name = user.nationality;
                
                
                $scope.status={};
                $scope.status.name= user.status;
                
                // End
                
                //new Date($('#joiningDate').val($scope.user));
				
				//Feroj: Tried to show joining date. 24.05.2018 23:00 
				//new Date($('#joiningDate').val())= $scope.user.joiningDate;
				//new Date($('#joiningDate').val())=$scope.user.joiningDate;
			
			};

		
			$scope.userprofile = function(ddlmsWftrole,ddlmsRole,user) {

				$scope.ddlmsRole = ddlmsRole;
				$scope.ddlmsWftrole = ddlmsWftrole;
				//console.log($scope.ddlmsRole);
				//console.log($scope.ddlmsWftrole);
				
				
				$scope.user.gender= $scope.gender.name;
				$scope.user.nationality = $scope.nationality.name;
				$scope.user.status = $scope.status.name;
				
				//$scope.user.status=$scope.status.name;
				//$scope.user.gender= $scope.gender.name;
				//$scope.user.nationality = $scope.nationality.name;*/
				
				updateuserprofileService.updateuserprofile($scope.ddlmsWftrole, ddlmsRole, $scope.user).then(
						function(d) {
							console.log(d.message);
							console.log("Success.", d.message);
							$scope.showSuccessMessage("Update successful");
						}, function(errResponse) {
							console.log("Failed to Update User Profile.");
							$scope.showErrorMessage("Update Fail");
						});

			}

			$scope.getDivisionData = function() {
				DivisionService.getAllDivision().then(function(d) {
					$scope.divisionNames = d;
				}, function(errResponse) {
					console.log("Failed to get Drop Down.");
				});
			}

			$scope.getOfficeData = function() {
				OfficeService.getAllOffice().then(function(d) {
					$scope.officeNames = d;
				}, function(errResponse) {
					console.log("Failed to get Drop Down.");
				});
			}

			$scope.getDesignationData = function() {
				DesignationService.getAllDesignation().then(function(d) {
					$scope.designationNames = d;
				}, function(errResponse) {
					console.log("Failed to get Drop Down.");
				});
			}

			$scope.getMinistryData = function() {
				MinistryService.getAllMinistry().then(function(d) {
					$scope.ministryNames = d;
				}, function(errResponse) {
					console.log("Failed to get Drop Down.");
				});
			}

			$scope.getSectionData = function() {
				SectionService.getAllSection().then(function(d) {
					$scope.sectionNames = d;
				}, function(errResponse) {
					console.log("Failed to get Drop Down.");
				});
			}

			$scope.getDropdownData = function(userStatus) {
				DropDownService.getAllDropdown(userStatus).then(function(d) {
					$scope.dropdownNames = d.listLmsDropdown;
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
			
			
			$scope.getDropdownDataNationality = function(dropdownname){
				DropDownService.getNationalityOption(dropdownname).then(function(d) {
					$scope.dropdownNationalityNames = d.listLmsDropdown;
				}, function(errResponse) {
					console.log("Failed to get Drop Down.");
				});
			}

			$scope.getRoleData = function() {
				RoleService.getAllRole()
				.then(function(d) {
					$scope.roleNames = d;
				}, function(errResponse) {
					console.log("Failed to get Drop Down.");
				});
			}

			$scope.getWftroleData = function() {
				WftroleService.getAllWftrole()
				.then(function(d) {
					$scope.wftroleNames = d;
				}, function(errResponse) {
					console.log("Failed to get Drop Down.");
				});
			}

			/* Show Success Message */
			$scope.showSuccessMessage = function(message) {

				$scope.successMessages = message;
				$timeout(function() {
					$scope.successMessages = null;
					$scope.errorMessages = null;
				}, 6000);
			}

			/* Show Error Message */
			$scope.showErrorMessage = function(message) {

				$scope.errorMessages = message;
				$timeout(function() {
					$scope.successMessages = null;
					$scope.errorMessages = null;
				}, 6000);
			}

			$scope.gotoHomePage = function() {

				window.location = url + "employeehomepage";
			}
			
			$scope.userAuthentication = function(userid){
				
				// Validate from lms_pages table
				$scope.pageid = 22;
				
				loginService.getauthorised(userid, $scope.pageid)
				.then(function(d) {						
					$scope.showSuccessMessage(d.message);
					
				}, 
				function(e) {
					$scope.showErrorMessage(e.data.message);
					window.location = url + "unauthorised";
				});					
			};

		} ]);
