App
	.controller(
		'holidayController',
		[
			'$scope',
			'$http',
			'holidayService',
			'holidaygridshowService',
			'$timeout',
			'$filter',
			'NgTableParams',
			'$location',

			function($scope, $http,holidayService,holidaygridshowService,
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
				
				$scope.testMsg = "Testing Message";
				
				$scope.holidayrecord = {
						"leaveSubject" : "",
						"leaveDate" : "",
						"optional" : "",
						"subjectToMoon" : "",
						"insertDate" : "",
						"insertBy" : "",
						"updatDate" : "",						
						"updateBy" : "",
					};
	
				$scope.holidaymanagement = function(){				
					
					$scope.holidayrecord.leaveSubject = $scope.leaveSubject;
					$scope.holidayrecord.leaveDate = new Date($('#fromDate').val());
					$scope.holidayrecord.optional = $scope.optional;
					$scope.holidayrecord.subjectToMoon = $scope.subjectToMoon;
					
						
					
					holidayService.holidaymanagement($scope.holidayrecord).then(
							function(d) {
								$scope.testMsg = d.message;
								console.log("Success.",d.message);
							},
							function(e) {
								$scope.testMsg = e.data.message;								
								console.error(e.data.message);
							});
				}
				
									
			} 
			]);
				
				