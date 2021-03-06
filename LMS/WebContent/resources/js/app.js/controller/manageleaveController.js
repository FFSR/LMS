App
	.controller(
		'manageleaveController',
		[
			'$scope',
			'$http',
			'updateuserleaveService',
			'manageleaveService',
			'leavehistoryService',
			'$timeout',
			'$filter',
			'NgTableParams',
			'$window',
			'$location','url',

			function($scope, $http, updateuserleaveService, manageleaveService,leavehistoryService,
				$timeout, $filter,NgTableParams,$window,$location,url) {
				$scope.testMsg = "Test Message New";
				$scope.leaveapplication = {};
				$scope.showLeaveDetails = false;
				$scope.showAttachment = false;
				$scope.search = {
						'user_name' : '',
						'user_id' : 0
				}
				
				$scope.manageleave = function(user_id){
					$scope.testMessage = "Test Message";
					//if($scope.search.name != "" && $scope.search.user_id != 0){
					if($scope.search.user_id != 0){
						console.log("Test message");
					}
					
					manageleaveService.manageleave($scope.search).then(
							function(d) {
								$scope.testMsg1 = "Test";
								console.log("Success.", d.message);
								var data = d.listLmsLeaveApplication;
								$scope.tableParams = new NgTableParams({}, { dataset: data});
								
							},
							function(errResponse) {
								
								console.error(errResponse.message);
							});
				};
				$scope.userID = 0;
				$scope.wfRequestHopid = 0;
				$scope.status = "";
				$scope.showLeaveApplicationDetails = function(wfRequestHop){
					
					console.log("wfRequestHop", wfRequestHop );
					$scope.showLeaveDetails = true;
					
					$scope.wfRequestHop = wfRequestHop;
					
					$scope.userID = $scope.wfRequestHop.lmsWfRequest.lmsUserByUserId.id;
					$scope.wfRequestHopid = $scope.wfRequestHop.id;
					console.log("wfRequestHop", wfRequestHop );
					manageleaveService.getAttachment($scope.wfRequestHop.lmsWfRequest.lmsLeaveApplication.id).then(
							function(d){
								$scope.fileNames = d;
								console.log("Attachment Data",d.filename);
								$scope.showAttachment = true;
							},
							function(errResponse){
								
							}
							);
				};
				
				$scope.gotoDetailsPage = function(wfRequestHop){
					window.location = "requestDetails?wfID=" + wfRequestHop.lmsWfRequest.id + "&leaveApplication=" + wfRequestHop.lmsWfRequest.lmsLeaveApplication.id;
				}
				
				$scope.viewAttachment = function(leaveApplicationID){
					
					manageleaveService.getAttachment(leaveApplicationID).then(
							function(d){
								$scope.fileNames = d;
								console.log("Attachment Data",d.filename);
								$scope.showAttachment = true;
							},
							function(errResponse){
								
							}
							);
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
				
				$scope.showConfirmationMessage = function(status,approverid) {
					var result = confirm("Do your want to submit?");
	                if (result) {
	                	$scope.submitHops(status,approverid);
	                } else {
	                    return false;
	                }
				};
				
				// Used for updating specific leave application
				$scope.userleave = function(){
					
					updateuserleaveService.updateuserleave($scope.leaveapplication).then(
						function(d){
							console.log(d.message);
						},
						function(errResponse){
							console.log("Failed to Update User Profile.");
						}
					);
				};
				
				
				$scope.loadLeaveApplications = function(userID){
					
					manageleaveService.loadCurrentLeaveApplication(userID).then(
					function(d){
						var data = d.listLmsWfRequestHops;
						$scope.tableParams = new NgTableParams({}, { dataset: data});
					},
					function(errResponse){
						
					}
					);
				};
				
				$scope.submitHops = function(status,approverid){
					$scope.status = status;
					console.log("Status:", $scope.status);
					manageleaveService.updateWFRequestHop(approverid, $scope.wfRequestHopid, $scope.status, $scope.wfRequestHop).then(
					function(d){
						console.log(d);
						
						$scope.lmsLeaveApplicationReturn = d.lmsLeaveApplication;
						
						$scope.lmsLeaveApplicationReturn.remarks= $scope.remarks;
						
						if(d.lmsWfRequest.status == 'APPROVED'){
						
						leavehistoryService.leavebalanceforapprove($scope.lmsLeaveApplicationReturn.lmsUserByUserId.id, $scope.lmsLeaveApplicationReturn.lmsLeaveType.id, $scope.lmsLeaveApplicationReturn.totalDayCount)
						.then(
								function(d){	
									 $scope.stayMyPage();
									 $scope.showSuccessMessage(d.message);
								},
								function(e){
									$scope.showErrorMessage(e.data.message);
								}
						);
						}else if(d.lmsWfRequest.status == 'REJECTED'){
							
							leavehistoryService.leavebalanceforreject($scope.lmsLeaveApplicationReturn.lmsUserByUserId.id, $scope.lmsLeaveApplicationReturn.lmsLeaveType.id, $scope.lmsLeaveApplicationReturn.totalDayCount)
							.then(
									function(d){
										$scope.showSuccessMessage(d.message);
										$scope.stayMyPage();
									},
									function(e){
										$scope.showErrorMessage(e.data.message);
									}
							);
							// added to update remarks while rejection. By Feroj: 26th May,18
							updateuserleaveService.updateuserleave($scope.lmsLeaveApplicationReturn).then(
									function(d){
										console.log(d.message);
									},
									function(errResponse){
										console.log("Failed to Update User Profile.");
									}
								);
							
						}
					
						
						
						$scope.showSuccessMessage("Status Updated");
					},
					function(errResponse){
						$scope.showErrorMessage("Status Not Updated");
						
					}
					);
					
				}
				
				 $scope.gotoHomePage = function(){	
						window.location = url+"employeehomepage";
					}
				 
				 $scope.stayMyPage = function(){	
					    location.reload();
						window.location = url+"leavemanagementhead";
					}
				
			} ]);
