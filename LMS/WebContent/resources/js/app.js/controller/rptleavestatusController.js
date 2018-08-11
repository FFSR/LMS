App
	.controller(
		'rptleavestatusController',
		[
			'$scope',
			'$http',
			'rptleavestatusService',
			'wfrequesthopService',
			'$timeout',
			'$filter',
			'NgTableParams',
			'$location',

			function($scope, $http, rptleavestatusService,wfrequesthopService,
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
						$scope.tableParams = new NgTableParams({}, { dataset: dataReportStatus});
					},
					function(errResponse){
						
					}
					);
				};
				
                   $scope.loadDatewiserptleavestatus = function(userID){	
                  var dataReportStatus ={};
                	$scope.tableParams="";
					$scope.userID = userID;
					//$scope.startdate=new Date($('#fromDate').val());
					//$scope.enddate=new Date($('#toDate').val());
					rptleavestatusService.getdatewiseleavestatus($scope.userID,new Date($('#fromDate').val()),new Date($('#toDate').val()))
					.then(
							function(d){
						var dataReportStatus_new = d.listLmsWfRequest;
						$scope.tableParams = new NgTableParams({}, { dataset: dataReportStatus_new});
					},
					function(errResponse){
						
					}
					);
				};
				
				
                   $scope.showApprovalFlowDetails= function(wfrequestID){
                	   
                	 $scope.showLeaveDetails= false;  
                	 var dataHopsStatus={};
                	$scope.wfrequestID=wfrequestID;
					wfrequesthopService.getHopsinfo( $scope.wfrequestID)
					.then(
							function(d){
						var dataHopsStatus = d.listLmsWfRequestHops;
						$scope.tableParams2 = new NgTableParams({}, { dataset: dataHopsStatus});
					},
					function(errResponse){
						
					}
					);
				};
				
				$scope.CallPrint= function(strid) {
				   
				   /* var WinPrint = window.open('', '', 'letf=0,top=0,width=1,height=1,toolbar=0,scrollbars=0,status=0');
				  //  var openWindow = window.open("", "title", "attributes");
				   var prtContent = document.getElementById(strid.previousSibling.innerHTML);
				  //  WinPrint.document.write(strid.previousSibling.innerHTML);
				          WinPrint.document.write(prtContent.innerHTML);
				   // WinPrint.document.write(prtContent.innerJSP);
				    WinPrint.document.close();
				    WinPrint.focus();
				    WinPrint.print();
				    WinPrint.close();
				  //  prtContent.innerHTML = strOldOne;*/
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
