App
	.controller(
		'TestController',
		[
			'$scope',
			'$http',
			'testService',
			'$timeout',
			'$filter',
			'$location',

			function($scope, $http, testService,
				$timeout, $filter,$location) {
				
				$scope.testMsg = "Test Message";
				
				$scope.login = function(networkId,password){
					testService.login(networkId,password).then(
							function(d) {
								$scope.testMsg = d.message;
								console.log("Success.",d.message);
							},
							function(errResponse) {
								
								console
										.error('Error while fetching Currencies');
							});
				}
			} ]);