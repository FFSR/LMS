
App
	.controller(
		'ministryinfoController',
		[
			'$scope',
			'$http',
			'ministryinfoService',
			'$timeout',
			'$filter',
			'$location',

			function($scope, $http, ministryinfoService,
				$timeout, $filter,$location) {
				
				$scope.testMsg = "Testing Message";
				
				$scope.ministry = {
						"name" : "",				
						"insertDate" : "",
						"insertBy" : "",
						"updateDate" : "",
						"updateBy" : "",
					};

				
				$scope.ministryinfo = function(){
										
					$scope.ministry.name = $scope.name;
					$scope.ministry.insertBy = 3;
					$scope.ministry.updateBy = 3;
					
				//	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
					//Date date1 = new Date();
					//System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
					
					//$scope.ministry.insertDate = new date();
					//$scope.ministry.updateDate = new date();
					
					
					
					ministryinfoService.ministryinfo($scope.ministry).then(
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