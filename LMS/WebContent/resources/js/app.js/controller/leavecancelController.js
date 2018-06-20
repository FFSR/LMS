App
	.controller(
		'leavecancelController',
		[
			'$scope',
			'$http',
			'rptleavestatusService',
			'wfrequesthopService',
			'leaveapplicationservice',
			'wfManagementService',
			'leavetypeService',
			'$timeout',
			'$filter',
			'NgTableParams',
			'$location',

			function($scope, $http, rptleavestatusService,wfrequesthopService,leaveapplicationservice,wfManagementService,leavetypeService,
				$timeout, $filter,NgTableParams,$location) {
				
				$scope.startdate="";
				$scope.enddate="";
				$scope.userID = "";
				$scope.leaveapplication = {};
				$scope.leaveapplication_new={};
				$scope.showLeaveDetails = false;
				$scope.showAttachment = false;
				$scope.wfRequestHopid = 0;
				$scope.status = "";
				
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
						var dataReportStatus = d.listLmsWfRequest;
						$scope.tableParams = new NgTableParams({}, { dataset: dataReportStatus});
					},
					function(errResponse){
						
					}
					);
				};
				
				
                   $scope.showLeaveApplicationDetails = function(wfRequestHop){
                	                                  
					
					console.log("wfRequestHop", wfRequestHop );
					$scope.showLeaveDetails = true;
					
					$scope.wfRequestHop = wfRequestHop;
					$scope.leaveapplication=wfRequestHop.lmsLeaveApplication;
					//$scope.userID = $scope.wfRequestHop.lmsUserByUserId.id;
				   //$scope.wfRequestHopid = $scope.wfRequestHop.id;
					//console.log("wfRequestHop", wfRequestHop );
					
				};
				
				
				$scope.loadLeaveTypeDownDown = function(){
					$scope.dDName = "";
					leavetypeService.getLeaveType().then(function(d) {
						$scope.dropdownData = d;
					}, function(errResponse) {
						console.log("Failed to get Drop Down.");
					});
				};
				
				$scope.cancelLeave = function(){
					
					//$scope.leaveapplication.
					//updateuserleaveService.updateuserleave().then((function(d) {
					//leavetypeService.getLeaveType().then(function(d) {
					$scope.leaveapplication_new.leaveAvailable=	$scope.leaveapplication.leaveAvailable ;
					$scope.leaveapplication_new.leaveTaken=$scope.leaveapplication.leaveTaken ;
					$scope.leaveapplication_new.lmsLeaveType=$scope.leavetype;
					$scope.leaveapplication_new.lmsUserByUserId=$scope.leaveapplication.lmsUserByUserId;
					$scope.leaveapplication_new.leaveBalance=$scope.leaveapplication.id;
					$scope.leaveapplication_new.eligibility=$scope.leaveapplication.eligibility ;
					$scope.leaveapplication_new.fromDate=$scope.leaveapplication.fromDate;
					$scope.leaveapplication_new.toDate=new Date($('#EndDate').val());
					$scope.leaveapplication_new.totalDayCount=$scope.AdjustDays;
					$scope.leaveapplication_new.totalDayText=$scope.leaveapplication.totalDayText ;
					$scope.leaveapplication_new.reasonForLeave=$scope.CancelReason;
					$scope.leaveapplication_new.taskNeedToPerformed=$scope.leaveapplication.taskNeedToPerformed;

				
					$scope.leaveapplication_new.inStation=$scope.leaveapplication.inStation
				
					$scope.leaveapplication_new.lmsUserByReliverEmailAddressUserId=$scope.leaveapplication.lmsUserByReliverEmailAddressUserId;
					
					
					leaveapplicationservice.applicationforleave($scope.leaveapplication_new).then(
							function(d) {
                                wfManagementService.generaterequest(d.userid,d.leavetypeid,d.leaveapplicationid).then(
										 function(d){
					//updateuserleaveService.updateuserleave($scope.leaveapplication).then(function(d) {
						
					                  }, function(errResponse) {
						              console.log("Failed to get Drop Down.");
					                  });
                                
							}, function(errResponse) {
								console.log("Failed to get Drop Down.");
							});          
				};
                   				
				$scope.gomyPage = function(){	
					location.reload();
					window.location = url+"rptleavestatus";
				}
				

			
			} ]);
