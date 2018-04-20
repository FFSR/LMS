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
			'url',
			'$window',
			'$location',

			function($scope, $http, testService,DropDownService,
				$timeout, $filter, url, $window, $location) {
				
				$scope.testMsg = "Test Message";
				$scope.successMessages = false;
				$scope.errorMessages = false;
				$scope.login = function(networkId,password){
					
					var regex = /^(?=.*[A-Z].*[A-Z])(?=.*[!@#$&*])(?=.*[0-9].*[0-9])(?=.*[a-z].*[a-z].*[a-z]).{8,}$/
				    var res = regex.test(password);
				    	
				    	if(!res){
				    		$scope.policyMissmatch = true;
				    		return;
				    	}
					
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
				
				$scope.getDate = function(){
					
					var a = $('#eventDate').val();//angular.element('#eventDate').val();
					console.log("Test Message");
					//var a = angular.element("#eventDate").val();
					console.log(angular.element("#eventDate").val());
					console.log("Test Message");
				};
				
				$scope.gotoRegistrationPage = function(){
					$window.location.href = url + 'registration';
				};
				
				/* Show Success Message */
				$scope.showSuccessMessage = function(message) {
					$scope.successMessages = message;
					$timeout(function() {
						$scope.successMessages = null;
						$scope.errorMessages = null;
					}, 360000);
				};

				/* Show Error Message */
				$scope.showErrorMessage = function(message) {
					$scope.errorMessages = message;
					$timeout(function() {
						$scope.successMessages = null;
						$scope.errorMessages = null;
					}, 360000);
				};
				
				$scope.getSuccessMessage = function(){
					$scope.showSuccessMessage("Hello, This is Success Message.");
				};
				
				$scope.getErrorMessage = function(){
					$scope.showErrorMessage("Hello, This is Error Message.");
				}
				
			} ]);