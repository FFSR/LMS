App
	.controller(
		'leavehistoryController',
		[
			'$scope',
			'$http',
			'leavehistoryService',
			'$timeout',
			'$filter',
			'NgTableParams',
			'$location',

			function($scope, $http, leavehistoryService,
				$timeout, $filter,NgTableParams,$location) {
				
				$scope.testMsg = "Test Message New";
				/*$scope.leavehistory = function(user_id){
					$scope.user_id;
					leavehistoryService.leavehistory($scope.user_id).then(
							function(d) {
								$scope.testMsg = d.message;
								console.log("Success.",d.message);
								var data = d.listLmsLeaveBalance;
								self.tableParams = new NgTableParams({}, { dataset: data});
								
							},
							function(errResponse) {
								
								console
										.error("Error while fetching Currencies");
							});
				};*/
				
				var self = this;
				self.leavehistory = function(user_id){
					$scope.user_id;
					leavehistoryService.leavehistory($scope.user_id).then(
							function(d) {
								$scope.testMsg = d.message;
								console.log("Success.",d.message);
								var data = d.listLmsLeaveBalance;
								self.tableParams = new NgTableParams({}, { dataset: data});
								
							},
							function(errResponse) {
								
								console
										.error("Error while fetching Currencies");
							});
				};
				
				self.leavehistory(2);
				
				//$scope.leavehistory(2);
			} ]);
