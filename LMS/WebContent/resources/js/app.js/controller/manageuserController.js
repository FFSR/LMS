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
			'$timeout',
			'$filter',
			'NgTableParams',
			'$location',

			function($scope, $http, updateuserprofileService, manageuserService, OfficeService, DivisionService, DesignationService, MinistryService,
					SectionService,DropDownService,$timeout, $filter,NgTableParams,$location) {
				$scope.testMsg = "Test Message New";
				$scope.user = {};
				$scope.showUserDetails = false;
				
				$scope.manageuser = function(user_id){
					$scope.testMessage = "Test Message";
					manageuserService.manageuser(user_id).then(
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
						},
						function(errResponse){
							console.log("Failed to Update User Profile.");
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
				
			} ]);
