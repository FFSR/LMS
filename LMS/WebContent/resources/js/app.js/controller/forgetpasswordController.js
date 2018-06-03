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
							},
							function(e) {
								$scope.testMsg = e.data.message;								
								console.error(e.data.message);
							});
				}
				
                  
				
			} ]);