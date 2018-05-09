App
	.controller(
		'manageuserController',
		[
			'$scope',
			'$http',
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
			'$timeout',
			'$filter',
			'NgTableParams',
			'$location',

			function($scope, $http, updateuserprofileService, manageuserService, OfficeService, DivisionService, DesignationService, MinistryService,
					SectionService, DropDownService, RoleService, WftroleService, $timeout, $filter,NgTableParams,$location) {
				$scope.testMsg = "Test Message New";
				$scope.user = {};
				$scope.showUserDetails = false;
				
				$scope.manageuser = function(){
					
					$scope.statusFinal="";
										
					if($scope.userName==null){						
						$scope.userName ="880";						
					}
					
					if($scope.mobile==null){
						$scope.mobile="a";
					}
					
					if($scope.nid==null){
						$scope.nid="a";
					}					
					
					if($scope.status==null){
						$scope.statusFinal="880";

					}else {
						$scope.statusFinal=$scope.status.text; 					
					}
					
					
					manageuserService.manageuser($scope.userName, $scope.mobile, $scope.nid, $scope.statusFinal)
					.then(
							function(d) {
								$scope.testMsg1 = "Test";
								console.log("Success.",d.message);
								var data = d.listLmsuser;
								$scope.tableParams = new NgTableParams({}, { dataset: data});
								
							},
							function(errResponse) {
								
								console
										.error("Error while fetching Currencies");
							});
				};
				
				$scope.showEmpDetails = function(user){
					
					console.log("User", user );
					$scope.showUserDetails = true;
					
					$scope.user = user;
				};
				
				
				
				
				$scope.userprofile = function(){
					
					updateuserprofileService.updateuserprofile($scope.user).then(
						function(d){
							console.log(d.message);
							console.log("Success.",d.message);
							$scope.showSuccessMessage("Update successful");
						},
						function(errResponse){
							console.log("Failed to Update User Profile.");
							$scope.showErrorMessage("Update Fail");
						}
					);
				}
				
				
				
				$scope.getDivisionData = function(){
					DivisionService.getAllDivision().then(function(d) {
						$scope.divisionNames = d;
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
				
				$scope.getDropdownData = function(){
					DropDownService.getAllDropdown().then(function(d) {
						$scope.dropdownNames = d;
					}, function(errResponse) {
						console.log("Failed to get Drop Down.");
					});
				}
				
				$scope.getRoleData = function(){
					RoleService.getAllRole().then(function(d) {
						$scope.roleNames = d;
					}, function(errResponse) {
						console.log("Failed to get Drop Down.");
					});
				}
				
				$scope.getWftroleData = function(){
					WftroleService.getAllWftrole().then(function(d) {
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
				
			} ]);
