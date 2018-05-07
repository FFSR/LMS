App
	.controller(
		'delegateemployeeController',
		[
			'$scope',
			'$http',
			'userlistService',
			'manageuserService',
			'wfManagementService',
			'$timeout',
			'$filter',
			'$location',
			function($scope, $http,userlistService,manageuserService,wfManagementService,
				$timeout, $filter,$location) {
				
				$scope.testMsg = "Testing Message";
                $scope.loginUserID=0;
				
				$scope.getUserInfo= function(userID){
					$scope.loginUserID=userID;
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
								
								//$scope.getUserwiseRoleInfo();
								
								//$scope.loadUserListDropDown();
								
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
				
								
				
			} 
			]);
				
				
