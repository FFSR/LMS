App
	.controller(
		'testController',
		[
			'$scope',
			'$http',
			'holidaygridshowService',
			'$timeout',
			'$filter',
			'NgTableParams',
			'$location',

			function($scope, $http,holidaygridshowService,
				$timeout, $filter,NgTableParams,$location) {
				$scope.testMsg = "Test Message New";
				$scope.holidaygridcontrol = {};
				$scope.showLeaveDetails = false;
				
				$scope.holidaygridshow = function(){
					$scope.testMessage = "Test Message";
					holidaygridshowService.holidaygridshow().then(
							function(d) {
								$scope.testMsg1 = "Test";
								console.log("Success.",d.message);
								var data = d.listLmsHolidayRecord;
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
