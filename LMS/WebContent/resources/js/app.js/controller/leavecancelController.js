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
				$scope.validationLock = true;
				
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
											    $scope.showSuccessMessage(d.message);	
												$scope.ClearAll();
												$scope.validationLock = true;
					//updateuserleaveService.updateuserleave($scope.leaveapplication).then(function(d) {
						
					                  }, function(errResponse) {
						              console.log("Failed to get Drop Down.");
					                  });
                                
							}, function(errResponse) {
								console.log("Failed to get Drop Down.");
							});          
				};
				
				/* Show Success Message */
				$scope.showSuccessMessage = function(message) {

					$scope.successMessages = message;
					$timeout(function() {
						$scope.successMessages = null;
						$scope.errorMessages = null;
					}, 6000);
				};

				/* Show Error Message */
				$scope.showErrorMessage = function(message) {

					$scope.errorMessages = message;
					$timeout(function() {
						$scope.successMessages = null;
						$scope.errorMessages = null;
					}, 6000);
				};

				$scope.ClearAll = function() {

					$scope.wfRequestHop.lmsUserByUserId.id="";
					$scope.wfRequestHop.lmsUserByUserId.name="";
					$scope.wfRequestHop.lmsLeaveApplication.lmsLeaveType.type="";
					$scope.wfRequestHop.lmsLeaveApplication.reasonForLeave="";
					$scope.wfRequestHop.lmsLeaveApplication.fromDate="";
					$scope.wfRequestHop.lmsLeaveApplication.toDate="";
					$scope.CancelReason="";
					$scope.EndDate="";
					$scope.AdjustDays="";
					$scope.leavetype='0';
					

				};   	
				
				$scope.validate = function(){
					    var d = new Date($('#EndDate').val());;
					    var e = new Date();
					    var diffDays = parseInt((d - e) / (1000 * 60 * 60 * 24)); 

	                    
	                    if (diffDays > $scope.AdjustDays){
	                    	//$scope.showSuccessMessage("Validation successful");
	                    	$scope.validationLock = false;       	
	                    }
	                    else{
	                    	$scope.showErrorMessage("Validation fail, Such amount of days can't be adjsuted" );
	                    	$scope.validationLock = true;  
	                    }
	                    
	                    if ($scope.leavetype.id!=27){
	                    	$scope.showErrorMessage("Validation fail, Please select Leave Cancel as leave type" );
	                    	$scope.validationLock = true;       	
	                    }
	                    
	                    if ($scope.validationLock == false){
	                    	$scope.showSuccessMessage("Validation successful");
	                    	;       	
	                    }
	                  

				};
				$scope.gomyPage = function(){	
					location.reload();
					window.location = url+"rptleavestatus";
				}
				

			
			} ]);
