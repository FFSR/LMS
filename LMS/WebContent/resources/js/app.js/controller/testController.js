App
	.controller(
		'TestController',
		[
			'$scope',
			'$http',
			'$timeout',
			'$filter',
			'$location',

			function($scope, $http,
				$timeout, $filter,$location) {
				
				$scope.testMsg = "Test Message";
				
				
			} ]);