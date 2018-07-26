App
	.controller(
		'ForgetPasswordController',
		[
			'$scope',
			'$http',
			'forgetpasswordService',
			'$timeout',
			'$filter',
			'$location',

			function($scope, $http, forgetpasswordService,
				$timeout, $filter,$location) {
				
				$scope.testMsg = "Test Message New";
				
				$scope.forgetpassword = function(emailID){
					forgetpasswordService.forgetpassword(emailID).then(
							function(d) {
								$scope.testMsg = d.message;
								console.log("Success.",d.message);
								$scope.showSuccessMessage(d.message);
							},
							function(e) {
								$scope.testMsg = e.data.message;								
								console.error(e.data.message);
								$scope.showErrorMessage(e.data.message);
							});
				}
				
                   $scope.gotoHomePage = function(){
					
					window.location = "login";
				}
                   
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
                   
				
			} ]);