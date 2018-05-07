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
					//if($scope.search.name != "" && $scope.search.user_id != 0){
					if($scope.search.user_id != 0){
						console.log("Test message");
					}
					
					manageleaveService.manageleave($scope.search).then(
							function(d) {
								$scope.testMsg1 = "Test";
								console.log("Success.", d.message);
								var data = d.listLmsLeaveApplication;
								$scope.tableParams = new NgTableParams({}, { dataset: data});
								
							},
							function(errResponse) {
								
								console.error(errResponse.message);
							});
				};
				$scope.userID = 0;
				$scope.wfRequestHopid = 0;
				$scope.status = "";
				$scope.showLeaveApplicationDetails = function(wfRequestHop){
					
					console.log("wfRequestHop", wfRequestHop );
					$scope.showLeaveDetails = true;
					
					$scope.wfRequestHop = wfRequestHop;
					
					$scope.userID = $scope.wfRequestHop.lmsWfRequest.lmsUser.id;
					$scope.wfRequestHopid = $scope.wfRequestHop.id;
					console.log("wfRequestHop", wfRequestHop );
				};
				
				
				/* Show Success Message */
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
				};
				
				
				$scope.loadLeaveApplications = function(userID){
					
					manageleaveService.loadCurrentLeaveApplication(userID).then(
					function(d){
						var data = d.listLmsWfRequestHops;
						$scope.tableParams = new NgTableParams({}, { dataset: data});
					},
					function(errResponse){
						
					}
					);
				};
				
				$scope.submitHops = function(status){
					$scope.status = status;
					console.log("Status:", $scope.status);
					manageleaveService.updateWFRequestHop($scope.userID, $scope.wfRequestHopid, $scope.status).then(
					function(d){
						console.log(d);
						$scope.showSuccessMessage("Status Updated");
					},
					function(errResponse){
						$scope.showErrorMessage("Status Not Updated");
						
					}
					);
					
				}
				
			} ]);
