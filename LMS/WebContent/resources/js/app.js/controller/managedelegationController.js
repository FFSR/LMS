App
	.controller(
		'managedelegationController',
		[
			'$scope',
			'$http',
			'managedelegationService',
			'manageuserService',
			'userlistService',
			'$timeout',
			'$filter',
			'$location',

			function($scope, $http, manageuserService,
				$timeout, $filter,$location) {
				
				$scope.getUserInfo= function(userID){					
					$scope.testMessage = "Test Message";
					manageuserService.manageuser(userID).then(
							function(d) {
								$scope.testMsg1 = "Test";
								console.log("Success.",d.message);
								var data = d.listLmsuser;
								
								$scope.name=d.listLmsuser[0].name;								
								$scope.mobilePersonal=d.listLmsuser[0].mobilePersonal;
								$scope.departmentname=d.listLmsuser[0].lmsDepartment.name;
								if(d.listLmsuser[0].lmsSection !=null){
									$scope.sectionname=d.listLmsuser[0].lmsSection.name;
								}
							},
							function(errResponse) {
								
								console
										.error("Error while fetching Currencies");
							});
				};
				
				$scope.getRoleInfo = function(userID){
					$scope.testMessage = "Test Message";
					managedelegationService.getRoleInfo(userID).then(
							function(d) {
								$scope.testMsg1 = "Test";
								console.log("Success.",d.message);
								var data = d.listLmsLeaveApplication;
								$scope.tableParams = new NgTableParams({}, { dataset: data});
								
							},
							function(errResponse) {
								
								console
										.error("Error while fetching Currencies");
							});
				};
				
				$scope.loadUserListDropDown = function(){
					$scope.dDName = "";
					userlistService.getUserList()
					.then(
						function(d) {
						$scope.userData = d;
					}, function(errResponse) {
						console.log("Failed to get User Drop Down.");
					});
				};
				
			
			} ]);