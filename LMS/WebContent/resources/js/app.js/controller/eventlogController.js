App
	.controller(
		'eventlogController',
		[
			'$scope',
			'$http',
			'eventlogService',
			'$timeout',
			'$filter',
			'NgTableParams',
			'$location',

			function($scope, $http, eventlogService,
				$timeout, $filter,NgTableParams,$location) {
				
				$scope.startdate="";
				$scope.enddate="";
				
				$scope.userID = "";
				
				$scope.showLeaveDetails = false;
				
				$scope.getSessionUserDetails = function(userID) {

					$scope.userID = userID;
				};
				
                  $scope.loadDatewiseeventlog = function(){	
                  var dataReportStatus ={};
                	$scope.tableParams="";
					
					eventlogService.getdatewiseeventlog(new Date($('#fromDate').val()),new Date($('#toDate').val()))
					.then(
							function(d){
						var dataReportStatus = d.listLmsEventLog;
						$scope.tableParams = new NgTableParams({}, { dataset: dataReportStatus});
					},
					function(errResponse){
						
					}
					);
				};
				
				
				$scope.CallPrint= function(strid) {
				   
					var restorepage= document.body.innerHTML;
					var printcontent=document.getElementById(strid).innerHTML;
					document.body.innerHTML=printcontent;
					window.print();
					//document.body.innerHTML=printcontent=restorepage;
				};
				
				$scope.showLeaveInfo= function(wfRequestHop){
					
					$scope.showLeaveDetails= true;
					$scope.wfRequestHop = wfRequestHop;
					
				};
				
				$scope.gomyPage = function(){	
					location.reload();
					window.location = url+"rptleavestatus";
				}
				

			
			} ]);
