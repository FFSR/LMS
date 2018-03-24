App
	.controller(
		'registrationController',
		[
			'$scope',
			'$http',
			'registrationService',
			'$timeout',
			'$filter',
			'$location',

			function($scope, $http, registrationService,
				$timeout, $filter,$location) {
				
				$scope.testMsg = "Testing Message";
				
				$scope.user = {
						"name" : "",
						"email" : "",
						"phone" : "",
						"passport" : "",
						"fax" : "",
						"mobilePersonal" : "",
						"mobileOffice" : "",
						"gender" : "",
						"address" : "",
						"nid" : "",
						"nationality" : "",
						"joiningDate" : "",						
						"status" : "",
						"password" : "",
						"designation_id" : "",
						"section_id" : "",
						"department_id" : "",						
						"division_id" : "",
						"ministry_id" : "",
						"office_location_id" : "",
						"supervisor_id" : "",							
						"insertDate" : "",
						"insertBy" : "",
						"updateDate" : "",
						"updateBy" : "",
					};

				
				$scope.registration = function(){
										
					$scope.user.name = $scope.username;
					$scope.user.nid = $scope.nid;
					$scope.user.office = $scope.office;
					$scope.user.division = $scope.division;
					$scope.user.designation = $scope.designation;
					$scope.user.ministry = $scope.ministry;
					$scope.user.section = $scope.section;
					$scope.user.nationality = $scope.nationality;
					$scope.user.passport = $scope.passport;
					$scope.user.mobile = $scope.mobile;
					$scope.user.telephone = $scope.telephone;
					$scope.user.email = $scope.email;
					$scope.user.fax = $scope.fax;
					$scope.user.joiningdate = $scope.joiningdate;
					$scope.user.gender = $scope.gender;
					$scope.user.supervisoremail = $scope.supervisoremail;
					$scope.user.address = $scope.address;
						
					
					
					registrationService.registration($scope.user).then(
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