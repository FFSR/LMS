App
	.controller(
		'leaveController',
		[
			'$scope',
			'$http',
			'leaveService',
			'$timeout',
			'$filter',
			'NgTableParams',
			'$location',

			function($scope, $http, leaveService,
				$timeout, $filter,NgTableParams,$location) {
				var self = this;
				self.testMsg = "Test Message New";
				
				self.leave = function(user_id){
					leaveService.leave(user_id).then(
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
