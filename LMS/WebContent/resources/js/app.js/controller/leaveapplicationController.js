App
	.controller(
		'leaveapplicationController',
		[
			'$scope',
			'$http',
			'applicationforleaveService',
			'$timeout',
			'$filter',
			'$location',

			function($scope, $http, applicationforleaveService,
				$timeout, $filter,$location) {
				
				$scope.testMsg = "Testing Message";
				
				$scope.leaveapplication = {
						"year" : "",
						"leaveAvailable" : "",
						"leaveTaken" : "",
						"leaveBalance" : "",
						"eligibility" : "",
						"fromDate" : "",
						"toDate" : "",
						"totalDayCount" : "",
						"totalDayText" : "",					
						"reasonForLeave" : "",
						"taskNeedToPerformed" : "",
						"lmsUserByReliverEmailAddressUserId":"",
						"insertDate" : "",
						"insertBy" : "",
						"updatDate" : "",						
						"updateBy" : "",
					};

				
				$scope.applicationforleave = function(){
					
					$scope.leaveapplication.leaveAvailable = $scope.leaveavailable;
					$scope.leaveapplication.leaveTaken = $scope.leaveTaken;
					//$scope.leaveapplication.lmsLeaveType = $scope.lmsLeaveType;
					$scope.leaveapplication.leaveBalance = $scope.leaveBalance;
					$scope.leaveapplication.lmsUserByReliverEmailAddressUserId = $scope.lmsUserByReliverEmailAddressUserId;
					$scope.leaveapplication.eligibility = $scope.eligibility;
					$scope.leaveapplication.fromDate = $scope.fromDate;
					$scope.leaveapplication.toDate = $scope.toDate;
					$scope.leaveapplication.totalDayCount = $scope.totalDayCount;
					//$scope.leaveapplication.totalDayText = $scope.totalDayText;
					$scope.leaveapplication.reasonForLeave = $scope.reasonForLeave;
					$scope.leaveapplication.taskNeedToPerformed = $scope.taskNeedToPerformed;
					//$scope.leaveapplication.insertDate = 
					//$scope.leaveapplication.insertBy = 3;
					//$scope.leaveapplication.updatDate = $scope.update_date;
					//$scope.leaveapplication.updateBy = $scope.update_by;
						
					
					applicationforleaveService.applicationforleave($scope.leaveapplication).then(
							function(d) {
								$scope.testMsg = d.message;
								console.log("Success.",d.message);
							},
							function(e) {
								$scope.testMsg = e.data.message;								
								console.error(e.data.message);
							});
				}
			} ]);