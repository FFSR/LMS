App
	.controller(
		'homepagegridshowController',
		[
			'$scope',
			'$http',
			'homepagegridshowService',
			'$timeout',
			'$filter',
			'NgTableParams',
			'$location',

			function($scope, $http, homepagegridshowService,
				$timeout, $filter,NgTableParams,$location) {
				$scope.testMsg = "Test Message New";
				$scope.leaveapplication = {};
				
				$scope.homepagegridshow = function(){
					$scope.testMessage = "Test Message";
					homepagegridshowService.homepagegridshow().then(
							function(d) {
								$scope.testMsg1 = "Test";
								console.log("Success.",d.message);
								var data = d.listLmsLeaveApplication;
								$scope.tableParams = new NgTableParams({}, { dataset: data});
								
							},
							function(errResponse) {
								
								console
										.error("Error while fetching Currencies");
							});
				};	
				
				$scope.showUsername = function(userID){
					$scope.dDName = "";
					homepagegridshowService.getUserName(userID).then(function(d) {
						$scope.dropdownData = d;
					}, function(errResponse) {
						console.log("Failed to get Drop Down.");
					});
				};
				
				
			} ]);
