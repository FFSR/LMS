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
			'NgTableParams',
			'$filter',
			'$location',

			function($scope, $http, managedelegationService,manageuserService,userlistService,
				$timeout,NgTableParams,$filter,$location) {
				
				//$scope.lmsWftRoleUserMap = {};
				
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
								
								$scope.getUserwiseRoleInfo();
								
								//$scope.loadUserListDropDown();
								
							},
							function(errResponse) {
								
								console
										.error("Error while fetching Currencies");
							});
				};
				
			$scope.getUserwiseRoleInfo= function(){
					$scope.testMessage = "Test Message";
					managedelegationService.getUserwiseRoleInfo($scope.loginUserID)
					.then(
							function(d) {
								console.log("Success.",d.message);
								//$scope.userRole = d.listLmsWftRoleUserMap;
								var data = d.listLmsWftRoleUserMap;							
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
					//managedelegationService.getUserList()
					.then(
						function(d) {
						$scope.userInfo = d;
					}, function(errResponse) {
						console.log("Failed to get User Drop Down.");
					});
				}
				
			
			} ]);