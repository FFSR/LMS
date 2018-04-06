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
<<<<<<< HEAD
				
				$scope.testMsg = "Test Message New";
=======
				var self = this;
				self.testMsg = "Test Message New";
>>>>>>> e3eae446a69a66540732f6ec34029e0cf68f87af
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
				
<<<<<<< HEAD
				var self = this;
				self.leavehistory = function(user_id){
					$scope.user_id;
					leavehistoryService.leavehistory($scope.user_id).then(
							function(d) {
								$scope.testMsg = d.message;
=======
				
				self.leavehistory = function(user_id){
					leavehistoryService.leavehistory(user_id).then(
							function(d) {
								self.testMsg1 = "Test";
>>>>>>> e3eae446a69a66540732f6ec34029e0cf68f87af
								console.log("Success.",d.message);
								var data = d.listLmsLeaveBalance;
								self.tableParams = new NgTableParams({}, { dataset: data});
								
							},
							function(errResponse) {
								
								console
										.error("Error while fetching Currencies");
							});
				};
				
<<<<<<< HEAD
				self.leavehistory(2);
				
				//$scope.leavehistory(2);
=======
				
				
				//self.leavehistory(2);
>>>>>>> e3eae446a69a66540732f6ec34029e0cf68f87af
			} ]);
