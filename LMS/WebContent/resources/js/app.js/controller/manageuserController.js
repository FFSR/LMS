App
	.controller(
		'manageuserController',
		[
			'$scope',
			'$http',
			'manageuserService',
			'$timeout',
			'$filter',
			'NgTableParams',
			'$location',

			function($scope, $http, manageuserService,
				$timeout, $filter,NgTableParams,$location) {
				var self = this;
				self.testMsg = "Test Message New";
				
				self.manageuser = function(user_id){
					self.testMessage = "Test Message";
					manageuserService.manageuser(user_id).then(
							function(d) {
								self.testMsg1 = "Test";
								console.log("Success.",d.message);
								var data = d.listLmsuser;
								self.tableParams = new NgTableParams({}, { dataset: data});
								
							},
							function(errResponse) {
								
								console
										.error("Error while fetching Currencies");
							});
				};
				
				
				
				//self.leavehistory(2);
			} ]);
