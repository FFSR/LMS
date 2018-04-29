App
	.controller(
		'rptleavestatusController',
		[
			'$scope',
			'$http',
			'rptleavestatusService',
			'$timeout',
			'$filter',
			'NgTableParams',
			'$location',

			function($scope, $http, rptleavestatusService,
				$timeout, $filter,NgTableParams,$location) {
			
				
				$scope.loadrptleavestatus = function(userID){					
					rptleavestatusService.getleavestatus(userID)
					.then(
							function(d){
						var data = d.listLmsWfRequest;
						$scope.tableParams = new NgTableParams({}, { dataset: data});
					},
					function(errResponse){
						
					}
					);
				};
				

			
			} ]);
