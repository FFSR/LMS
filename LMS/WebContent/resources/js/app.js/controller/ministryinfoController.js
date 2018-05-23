App
	.controller(
		'ministryinfoController',
		[
			'$scope',
			'$http',
			'loginService',
			'ministryinfoService',
			'$timeout',
			'$filter',
			'$location',
			'url',

			function($scope, $http, loginService, ministryinfoService,
				$timeout, $filter,$location, url) {
				
				$scope.testMsg = "Testing Message";
				
				$scope.ministry = {
						"name" : "",				
						"insertDate" : "",
						"insertBy" : "",
						"updateDate" : "",
						"updateBy" : "",
					};

				
				$scope.ministryinfo = function(){
										
					$scope.ministry.name = $scope.name;
					$scope.ministry.insertBy = 3;
					$scope.ministry.updateBy = 3;
					
				//	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
					//Date date1 = new Date();
					//System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
					
					//$scope.ministry.insertDate = new date();
					//$scope.ministry.updateDate = new date();
					
					
					
					ministryinfoService.ministryinfo($scope.ministry).then(
							function(d) {
								$scope.testMsg = d.message;
								console.log("Success.",d.message);
							},
							function(e) {
								$scope.testMsg = e.data.message;								
								console.error(e.data.message);
							});
				}
				
				$scope.gotoHomePage = function(){	
					window.location = url+"employeehomepage";
				}
				
				/* Show Error Message */
				$scope.showErrorMessage = function(message) {

					$scope.errorMessages = message;
					$timeout(function() {
						$scope.successMessages = null;
						$scope.errorMessages = null;
					}, 6000);
				};
				
				$scope.showConfirmationMessage = function() {
					var result = confirm("Do your want to submit?");
	                if (result) {
	                	$scope.holidaymanagement();
	                } else {
	                    return false;
	                }
				};
				
				$scope.userAuthentication = function(userid){
					
					// Validate from lms_pages table
					$scope.pageid = 24;
					
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