App
	.controller(
		'TestController',
		[
			'$scope',
			'$http',
			'testService',
			'DropDownService',
			'$timeout',
			'$filter',
			'$location',

			function($scope, $http, testService,DropDownService,
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
				};
				
				$scope.loadDownDown = function(dropDownName){
					$scope.dDName = dropDownName;
					DropDownService.populateDropDown($scope.dDName).then(function(d) {
						$scope.dropdownData = d;
					}, function(errResponse) {
						console.log("Failed to get Drop Down.");
					});
				};
				
				$scope.uploadFile = function() {
					console.log("Inside the dropbox");
					$scope.processDropzone();
					$scope.resetDropzone();
				};
								
				
			} ]);