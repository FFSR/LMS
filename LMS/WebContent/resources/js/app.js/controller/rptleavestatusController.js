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
				
				$scope.startdate="";
				$scope.enddate="";
				
				$scope.userID = "";
				
				$scope.getSessionUserDetails = function(userID) {

					$scope.userID = userID;
				};
				
				$scope.loadrptleavestatus = function(userID){	
					
					$scope.userID = userID;
					
					rptleavestatusService.getleavestatus($scope.userID)
					.then(
							function(d){
						var dataReportStatus = d.listLmsWfRequest;
						$scope.tableParams = new NgTableParams({}, { dataset: dataReportStatus});
					},
					function(errResponse){
						
					}
					);
				};
				
                   $scope.loadDatewiserptleavestatus = function(userID){	
                
                	$scope.tableParams="";
					$scope.userID = userID;
					//$scope.startdate=new Date($('#fromDate').val());
					//$scope.enddate=new Date($('#toDate').val());
					rptleavestatusService.getdatewiseleavestatus($scope.userID,new Date($('#fromDate').val()),new Date($('#toDate').val()))
					.then(
							function(d){
						var dataReportStatus = d.listLmsWfRequest;
						$scope.tableParams = new NgTableParams({}, { dataset: dataReportStatus});
					},
					function(errResponse){
						
					}
					);
				};
				
				$scope.gotoHomePage = function(){	
					window.location = url+"employeehomepage";
				}
				

			
			} ]);
