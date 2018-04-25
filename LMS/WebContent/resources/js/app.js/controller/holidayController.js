App
	.controller(
		'holidayController',
		[
			'$scope',
			'$http',
			'holidayService',
			'holidaygridshowService',
			'updateholidayrecordService',
			'$timeout',
			'$filter',
			'NgTableParams',
			'$location',

			function($scope, $http,holidayService,holidaygridshowService,updateholidayrecordService,
				$timeout, $filter,NgTableParams,$location) {
				$scope.testMsg = "Test Message New";
				$scope.holidaygridcontrol = {};
				$scope.showHolidayDetails = false;
				
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
					//$scope.holidayrecord.optional = $scope.SelectedOption.options;
					//$scope.holidayrecord.subjectToMoon = $scope.SelectedOption.options;
					
						
					
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
				
                    $scope.showHolidayRecordDetails = function(holidayrecord){	
					console.log("HolidayRecord", holidayrecord );
					$scope.showHolidayDetails = true;	
					$scope.holidayrecord = holidayrecord;
				};
				
				
				// Used for updating specific holiday record
				$scope.holidayRecord = function(){ 
					
					updateholidayrecordService.updateholidayrecord($scope.holidayrecord).then(
						function(d){
							console.log(d.message);
						},
						function(errResponse){
							console.log("Failed to Update User Profile.");
						}
					);
				}
			} 
			]);
				
				