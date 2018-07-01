App
	.controller(
		'rptsubordinateleavestatusController',
		[
			'$scope',
			'$http',
			'rptleavestatusService',
			'wfrequesthopService',
			'manageuserService',
			'$timeout',
			'$filter',
			'NgTableParams',
			'$location',

			function($scope, $http, rptleavestatusService,wfrequesthopService,manageuserService,
				$timeout, $filter,NgTableParams,$location) {
				
				$scope.startdate="";
				$scope.enddate="";
				
				$scope.userID = "";
				
				$scope.showLeaveDetails = false;
				
				$scope.getSessionUserDetails = function(userID) {

					$scope.userID = userID;
				};
				
				$scope.loadrptleavestatus = function(userID){	
					
					$scope.userID = userID;
					
					rptleavestatusService.getleavestatus($scope.userID)
					.then(
							function(d){
						var dataReportStatus = d.listLmsWfRequest;
						var wfRequest =d.listLmsWfRequest[0];
						$scope.employeename=wfRequest.lmsUserByUserId.name;
						$scope.tableParams = new NgTableParams({}, { dataset: dataReportStatus});
					},
					function(errResponse){
						
					}
					);
				};
				
				
				$scope.SubordinateuserList = function(userID) {

					manageuserService.subordinate(userID).then(function(d) {
						$scope.testMsg1 = "Test";
						console.log("Success.", d.message);
						//	var data = d.Listlmsuser;
						$scope.tableParams1 = new NgTableParams({}, {
							dataset : d
						});

					}, function(errResponse) {

						console.error("Error while fetching Currencies");
					});

				};
				
				
                   $scope.showApprovalFlowDetails= function(wfrequestID){
                	 var dataHopsStatus={};
                	$scope.wfrequestID=wfrequestID;
					wfrequesthopService.getHopsinfo( $scope.wfrequestID)
					.then(
							function(d){
						var dataHopsStatus = d.listLmsWfRequestHops;
						$scope.tableParams3 = new NgTableParams({}, { dataset: dataHopsStatus});
					},
					function(errResponse){
						
					}
					);
				};
				
				
				
				$scope.gomyPage = function(){	
					location.reload();
					window.location = url+"rptleavestatus";
				}
				

			
			} ]);
