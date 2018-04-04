App
	.controller(
		'divisioninfoController',
		[
			'$scope',
			'$http',
			'divisoninfoService',
			'$timeout',
			'$filter',
			'$location',

			function($scope, $http, divisioninfoService,
				$timeout, $filter,$location) {
				
				$scope.testMsg = "Testing Message";
				
				$scope.division = {
						"name" : "",				
						"insertDate" : "",
						"insertBy" : "",
						"updateDate" : "",
						"updateBy" : "",
					};

				
				$scope.divisioninfo = function(){
										
					$scope.division.name = $scope.name;
					$scope.division.insertBy = 3;
					$scope.division.updateBy = 3;
					
				//	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
					//Date date1 = new Date();
					//System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
					
					//$scope.ministry.insertDate = new date();
					//$scope.ministry.updateDate = new date();
					
					
					
					divisioninfoService.divisioninfo($scope.division).then(
							function(d) {
								$scope.testMsg = d.message;
								console.log("Success.",d.message);
							},
							function(e) {
								$scope.testMsg = e.data.message;								
								console.error(e.data.message);
							});
				}
			} ]);