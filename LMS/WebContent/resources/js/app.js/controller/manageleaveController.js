App
	.controller(
		'manageleaveController',
		[
			'$scope',
			'$http',
			'updateuserleaveService',
			'manageleaveService',
			'$timeout',
			'$filter',
			'NgTableParams',
			'$location',

			function($scope, $http, updateuserleaveService, manageleaveService,
				$timeout, $filter,NgTableParams,$location) {
				$scope.testMsg = "Test Message New";
				$scope.leaveapplication = {};
				$scope.showLeaveDetails = false;
				$scope.search = {
						'user_name' : '',
						'user_id' : 0
				}
				
				$scope.manageleave = function(user_id){
					$scope.testMessage = "Test Message";
					if($scope.search.name != "" && $scope.search.user_id != 0){
						console.log("Test message");
					}
					
					manageleaveService.manageleave($scope.search).then(
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
				
				$scope.showLeaveApplicationDetails = function(leaveapplication){
					
					console.log("LeaveApplication", leaveapplication );
					$scope.showLeaveDetails = true;
					
					$scope.leaveapplication = leaveapplication;
				};
				
				
				
				// Used for updating specific leave application
				$scope.userleave = function(){ 
					
					updateuserleaveService.updateuserleave($scope.leaveapplication).then(
						function(d){
							console.log(d.message);
						},
						function(errResponse){
							console.log("Failed to Update User Profile.");
						}
					);
				}
				
			} ]);
