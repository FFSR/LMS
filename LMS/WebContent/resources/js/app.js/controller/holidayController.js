App
	.controller(
		'holidayController',
		[
			'$scope',
			'$http',
			'holidayService',
			'holidaygridshowService',
			'updateholidayrecordService',
			'DropDownService',
			'$timeout',
			'$filter',
			'NgTableParams',
			'$location',
			'url',

			function($scope, $http,holidayService,holidaygridshowService,updateholidayrecordService,DropDownService,
				$timeout, $filter,NgTableParams,$location,url) {
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
					$scope.holidayrecord.optional = $scope.ddOptional.name;
					$scope.holidayrecord.subjectToMoon = $scope.ddMoon.name;
						
					
					holidayService.holidaymanagement($scope.holidayrecord).then(
							function(d) {
								$scope.testMsg = d.message;
								console.log("Success.",d.message);
								$scope.showSuccessMessage("Insertion successful");
								$scope.ClearAll();
							},
							function(e) {
								$scope.testMsg = e.data.message;								
								console.error(e.data.message);
								$scope.showErrorMessage("Insertion Fail");
							});
				}
				
                    $scope.showHolidayRecordDetails = function(holidayrecord){	
					console.log("HolidayRecord", holidayrecord );
					$scope.showHolidayDetails = true;	
					$scope.holidayrecd = holidayrecord;
					$scope.test = "";
				};
				
				$scope.deleteHolidayRecord = function(holidayrecord){	
					//console.log("HolidayRecord", holidayrecord );
					$scope.holidayrecord_id=holidayrecord.id;
					updateholidayrecordService.deleteholidayrecord($scope.holidayrecord_id).then(
							function(d){
								console.log(d.message);
							},
							function(errResponse){
								console.log("Failed to Update User Profile.");
							}
						);
					
				};
				
				//deleteHolidayRecord(holidayrecord)
				
				
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
				
				$scope.loadDropDownHolidayOption = function(dropdownname){
					DropDownService.getHolidayOptions(dropdownname).then(function(d) {
						$scope.optionData = d.listLmsDropdown;
					}, function(errResponse) {
						console.log("Failed to get Drop Down.");
					});
				};
				
				$scope.loadDropDownMoonOption = function(dropdownname){
					DropDownService.getMoonOptions(dropdownname).then(function(d) {
						$scope.moonData = d.listLmsDropdown;
					}, function(errResponse) {
						console.log("Failed to get Drop Down.");
					});
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
				
				/* Show Error Message */
				$scope.ClearAll = function() {

					$scope.leaveSubject ="";
					//$scope.leaveDate = new Date($('#fromDate').val(''));
					new Date($('#fromDate').val(''));
					$scope.ddOptional = '0';
					$scope.subjectToMoon = '0';
				};
				
				$scope.gotoHomePage = function(){	
					window.location = url+"employeehomepage";
				}
				
			} 
			]);
				
				