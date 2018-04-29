App
	.controller(
		'loginController',
		[
			'$scope',
			'$timeout',
			'$http',
			'loginService',
			'$timeout',
			'$filter',
			'$location',

			function($scope, $timeout, $http, loginService,
				$timeout, $filter,$location) {
				
				$scope.testMsg = "Testing Message";
				
				$scope.login = function(username,password){
					loginService.login(username,password).then(
							function(d) {
								$scope.testMsg = d.message;
								console.log("Success.",d.message);
								window.location = "employeehomepage";
							},
							function(e) {
								$scope.testMsg = e.data.message;								
								console.error(e.data.message);
								$scope.showErrorMessage("Login Failed.");
							});
				}
				
				
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