App
	.controller(
		'divisioninfoController',
		[
			'$scope',
			'$http',
			'loginService',
			'divisioninfoService',
			'NgTableParams',
			'$timeout',
			'$filter',
			'$location',
			'url',

			function($scope, $http, loginService, divisioninfoService,NgTableParams,
				$timeout, $filter,$location, url) {
				
				$scope.testMsg = "Testing Message";
				
				$scope.division = {
						"name" : "",				
						"insertDate" : "",
						"insertBy" : "",
						"updateDate" : "",
						"updateBy" : "",
					};

				
				$scope.divisioninfo = function(){
										
					$scope.division.name = $scope.name;
					$scope.division.insertBy = 3;
					$scope.division.updateBy = 3;
					
				//	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
					//Date date1 = new Date();
					//System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
					
					//$scope.ministry.insertDate = new date();
					//$scope.ministry.updateDate = new date();
					
					
					
					divisioninfoService.divisioninfo($scope.division)
					.then(
							function(d) {
								$scope.testMsg = d.message;
								console.log("Success.",d.message);
								$scope.showSuccessMessage("Division is created");
							},
							function(e) {
								$scope.testMsg = e.data.message;								
								console.error(e.data.message);
								$scope.showErrorMessage(e.data.message);
							});
				};
				
				$scope.divisionlistshow = function(){
					$scope.testMessage = "Test Message";
					divisioninfoService.divisionlistshow().then(
							function(d) {
								$scope.testMsg1 = "Test";
								console.log("Success.",d.message);
								var data = d;
								$scope.tableParams = new NgTableParams({}, { dataset: data});
								
							},
							function(errResponse) {
								
								console
										.error("Error while fetching Currencies");
							});
				};
				
				$scope.deleteDivision = function(division){	
					//console.log("HolidayRecord", holidayrecord );
					$scope.division_id=division.id;
					divisioninfoService.deleteDivision($scope.division_id).then(
							function(d){
								console.log(d.message);
								$scope.showSuccessMessage("Deletion successful");
							},
							function(errResponse){
								console.log("Failed to Update User Profile.");
								$scope.showErrorMessage("Deletion Failed");
							}
						);
					
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
				
				$scope.userAuthentication = function(userid){
					
					// Validate from lms_pages table
					$scope.pageid = 10;
					
					loginService.getauthorised(userid, $scope.pageid)
					.then(function(d) {						
						$scope.showSuccessMessage(d.message);
						
					}, 
					function(e) {
						$scope.showErrorMessage(e.data.message);
						window.location = url + "unauthorised";
					});					
				};
			} ]);