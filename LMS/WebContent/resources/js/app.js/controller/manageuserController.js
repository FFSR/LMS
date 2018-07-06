App
.controller(
		'manageuserController', 
		[
		'$scope',
		'$timeout',
		'$http',
		'loginService',
		'updateuserprofileService',
		'userlistService',
		'manageuserService',
		'OfficeService',
		'DivisionService',
		'DesignationService',
		'MinistryService',
		'SectionService',
		'DropDownService',
		'RoleService',
		'WftroleService',
		'managedelegationService',
		'$filter',
		'NgTableParams',
		'$location',
		'url',

		function($scope, $timeout, $http, 
				loginService, updateuserprofileService,userlistService, manageuserService,
				OfficeService, DivisionService, DesignationService,
				MinistryService, SectionService, DropDownService, RoleService, WftroleService, managedelegationService,
				$filter, NgTableParams, $location, url) {
			
			$scope.testMsg = "Test Message New";
		    $scope.user = {};
		    $scope.supervisor={};
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
								
						var data = d.listLmsuser;

						$scope.tableParams = new NgTableParams({}, {
							dataset : data
						});

				}, function(errResponse) {

					console.error("Error while fetching Currencies");
				});
			};

			$scope.showEmpDetails = function(user) {
				
				$scope.showUserDetails = true;

				$scope.user = user;
				
				$scope.gender = {};
				$scope.gender.name= user.gender;
				
				$scope.status = {};
				$scope.status.name= user.status;
				
				$scope.nationality = {};
				$scope.nationality.name= user.nationality;
								
/*				$scope.lmssupervisor={};
				$scope.lmssupervisor.name= user.lmsUser.name;*/
				
				//$scope.user.lmsUser={};
				if($scope.user.lmsUser!=null){
					$scope.supervisor.name = $scope.user.lmsUser.name;
					$scope.supervisor = $scope.user.lmsUser ;
				}
				
				//$scope.ddlmsRole = {};
				//$scope.ddlmsRole.name= user.ddlmsRole;
				
				new Date($('#joiningDate').val($scope.user));
				
				//Feroj: Tried to show joining date. 24.05.2018 23:00 
				//new Date($('#joiningDate').val())= $scope.user.joiningDate;
				//new Date($('#joiningDate').val())=$scope.user.joiningDate;
				
				$scope.getUserwfRoleInfo(user.id);
				
				$scope.getUserAppRoleInfo(user.id);
			
			};
			
			$scope.getUserwfRoleInfo = function(userid){	

				managedelegationService.getUserwiseRoleInfo(userid)
				.then(
						function(d) {

							var items = d.listLmsWftRoleUserMap;
							$scope.user.wfroles = [];

							for(var i=0;i<items.length;i++){

								var item = items[i].lmsWftRole;

								$scope.user.wfroles.push(item.id);
							}
						},
						function(errResponse) {
							console.error("Error while fetching Currencies");
						});
			};	
			
			$scope.getUserAppRoleInfo = function(userid){	

				managedelegationService.getUserAppRoleInfo(userid)
				.then(
						function(d) {

							var items = d.listLmsUserRoleMap;
							$scope.user.approles = [];

							for(var i=0;i<items.length;i++){

								var item = items[i].lmsRole;
								
								$scope.user.approles.push(item.id);
							}
						},
						function(errResponse) {
							console.error("Error while fetching Currencies");
						});
			};

			    //Feroj: Worked to show set below values. 26.05.2018 15:43
			$scope.setnewStatus = function(user,name){
				
				$scope.user.status = name;
					
			}
			
                $scope.setnewReleiver = function(newsupervisor){
                	
              //  $scope.lmssupervisor=lmssupervisor;
                	/*if($scope.user.lmsUser!=null){
                		$scope.user.lmsUser=lmssupervisor;
                	}*/
                 
				$scope.user.lmsuser = newsupervisor;
				$scope.user.lmsuser.name=newsupervisor.name;
					
			}
			
			
             $scope.setnewNationality = function(user,name){
				
				$scope.user.nationality = name;
					
			 }
             
             $scope.setnewGender = function(user,name){
 				
 				$scope.user.gender = name;
 					
 			 }
               //End 26.05.2018 15:43
             
			$scope.userprofile = function(ddlmsWftrole,ddlmsRole,user) {
		
				$scope.userWrapper ={};
				
				$scope.userWrapper.lmsuser = $scope.user;
				$scope.userWrapper.lmsRoles = $scope.user.approles;
				$scope.userWrapper.lmsWftRoles = $scope.user.wfroles;
				
				updateuserprofileService.updateuserprofile($scope.user.lmsUser, $scope.userWrapper).then(		
				function(d) {

							$scope.showSuccessMessage(d.message);
							$scope.clearAll();
						}, 
						function(errResponse) {

							$scope.showErrorMessage("Failed to Update User Profile.");
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
										
					$scope.approles =d;
					
				}, function(errResponse) {
					console.log("Failed to get Drop Down.");
				});
			}
			// Removed duplicate method of $scope.getRoleData on 02.06.18

			$scope.getWftroleData = function() {
				WftroleService.getAllWftrole()
				.then(function(d) {
									
					$scope.wfroles = d;
					
				}, function(errResponse) {
					console.log("Failed to get Drop Down.");
				});
			}
			
			$scope.loadUserListDropDown = function(){
				$scope.dDName = "";

				userlistService.getUserList()
				.then(
						function(d) {

							$scope.userData=d;
						}, function(errResponse) {
							console.log("Failed to get User Drop Down.");

						});
			};

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
				
			$scope.clearAll = function(){
				
				// close open panel
				$scope.showUserDetails = false;
				
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
				$scope.user.joiningDate = "";
				$scope.gender = '0';
				$scope.ddReliever = '0';
				$scope.user.address = "";
				$scope.user.passport = "";
				$scope.user.password = "";
				$scope.user.nid = "";
				$scope.dateofbirth = "";
				$scope.ddlmsRole='0';
				$scope.ddlmsWftrole='0';
						
			};
			
			
		} ]);
