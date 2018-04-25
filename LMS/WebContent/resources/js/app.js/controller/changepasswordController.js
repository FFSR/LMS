App
	.controller(
		'changepasswordController',
		[
			'$scope',
			'$http',
			'changepasswordService',
			'$timeout',
			'$filter',
			'$location',

			function($scope, $http, changepasswordService,
				$timeout, $filter,$location) {
				
				$scope.testMsg = "Testing Message";
				$scope.user = {
						"office" : "",
						"name" : "",
						//"lmsDivision" : "",
						//"lmsDesignation" : "",
						//"lmsMinistry" : "",
						//"lmsSection" : "",
						"nid" : "",
						"nationality" : "",
						"passport" : "",
						"mobilePersonal" : "",						
						"phone" : "",
						"email" : "",						
						"fax" : "",
						"joiningDate" : "",
						"gender" : "",
						"supervisor_id" : "",						
						"address" : "",
						"insertDate" : "",
						"insertBy" : "",
						"updateDate" : "",
						"updateBy" : "",
						
						
						
						"mobileOffice" : "",	
						"status" : "",
						"password" : "",
						"designation_id" : "",
						"section_id" : "",
						"department_id" : "",						
						"division_id" : "",
						"ministry_id" : "",
						"office_location_id" : "",
													
						
					};
				
				
				$scope.changepassword = function(newpassword){					
					$scope.user.password = newpassword;
					$scope.user.email = 's@sd.com';
				changepasswordService.changepassword($scope.user).then(
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