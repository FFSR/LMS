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
				$scope.userID = "";
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
				
				
				$scope.getSessionUserDetails = function(userID){					
					
					$scope.userID = userID;						
				};			
				
				$scope.changepassword = function(){		
					
					if ($scope.confirmpassword != $scope.newpassword){
						
						$scope.showErrorMessage("Your confirmpassword & newpassword doesn`t match.");
						$scope.clearAll();
						return;
					}
					
					
				changepasswordService.changepassword($scope.newpassword, $scope.oldpassword, $scope.userID).then(
						function(d) {
							$scope.showSuccessMessage(d.data.message);
							$scope.clearAll();
						},
						function(e) {							
							$scope.showErrorMessage(e.data.message);
							$scope.clearAll();
						});
			};
			
			
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
			
			
			
			
			
			$scope.clearAll = function(){
				// for dropdown set to zero
				//$scope.mobileNoDropDown = '0';
				// for text filed set to empty
				//$scope.mobileNoText = "";
				// for check button set false;
				//$scope.formSignVerified = false;
				$scope.oldpassword = "";
				$scope.newpassword = "";
				$scope.confirmpassword = "";
				
			};
			
					
			
			} ]);