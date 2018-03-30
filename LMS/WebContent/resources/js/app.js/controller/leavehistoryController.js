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
				var self = this;
				self.testMsg = "Test Message New";
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
				
				
				self.leavehistory = function(user_id){
					leavehistoryService.leavehistory(user_id).then(
							function(d) {
								self.testMsg1 = "Test";
								console.log("Success.",d.message);
								var data = d.listLmsLeaveBalance;
								self.tableParams = new NgTableParams({}, { dataset: data});
								
							},
							function(errResponse) {
								
								console
										.error("Error while fetching Currencies");
							});
				};
				
				
				
				//self.leavehistory(2);
			} ]);
