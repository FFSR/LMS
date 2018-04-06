App
	.controller(
		'updateuserprofileController',
		[
			'$scope',
			'$http',
			'updateuserprofileService',
			'$timeout',
			'$filter',
			'$location',

			function($scope, $http, updateuserprofileService,
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
				
				
				$scope.updateuserprofile = function(){					
					$scope.user.fax = $scope.fax;
					$scope.user.email = 's@sd.com';
					updateuserprofileService.updateuserprofile($scope.user).then(
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