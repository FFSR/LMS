App
	.controller(
		'homepagegridshowController',
		[
			'$scope',
			'$http',
			'homepagegridshowService',
			'manageleaveService',
			'$timeout',
			'$filter',
			'NgTableParams',
			'$location',

			function($scope, $http, homepagegridshowService,manageleaveService,
				$timeout, $filter,NgTableParams,$location) {
				$scope.testMsg = "Test Message New";
				$scope.leaveapplication = {};
				
				$scope.homepagegridshow = function(){
					$scope.testMessage = "Test Message";
					homepagegridshowService.homepagegridshow()
					.then(
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
				
				$scope.getSessionUserDetails =function(name,section){
					$scope.name_n = name;
					$scope.sec_n=section;
					
				};
				
                   $scope.loadLeaveApplications = function(userID){	
				   manageleaveService.loadCurrentLeaveApplication(userID)
					.then(
					function(d){
						var data = d.listLmsWfRequestHops;
						//$scope.length=data.length +1
						$scope.Aproval_Pending=data.length;
						//$scope.tableParams = new NgTableParams({}, { dataset: data});
					},
					function(errResponse){
						
					}
					);
				};
				
				
			} ]);
