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

				$scope.leavehistory= function(userID){					
					leavehistoryService.leavehistory(userID)
					.then(
							function(d){
						var data = d.listLmsLeaveBalance;
						$scope.tableParams = new NgTableParams({}, { dataset: data});
					},
					function(errResponse){
						
					}
					);
				};
				

			
			} ]);
				
