App
	.controller(
		'loginController',
		[
			'$scope',
			'$http',
			'loginService',
			'$timeout',
			'$filter',
			'$location',

			function($scope, $http, loginService,
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
							});
				}
			} ]);