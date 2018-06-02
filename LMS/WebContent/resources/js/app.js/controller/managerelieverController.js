App
	.controller(
		'managerelieverController',
		[
			'$scope',
			'$http',
			'loginService',
			'userlistService',
			'manageuserService',
			'managedelegationService',
			'NgTableParams',
			'$timeout',
			'$filter',
			'$location',
			'url',

			function($scope, $http, loginService, userlistService,manageuserService,managedelegationService,NgTableParams,
				$timeout, $filter,$location, url) {
				$scope.testMsg = "Test Message New";
				 $scope.loginUserID=0;
	             $scope.releiverid=0;
	             $scope.userlist="";
	             
				$scope.loadUserListDropDown = function(){
					$scope.dDName = "";
					userlistService.getUserList()
					.then(
						function(d) {
						$scope.userlistInfo = d;
					}, function(errResponse) {
						console.log("Failed to get User Drop Down.");
					});
				};
				
				$scope.getUserInfo= function(userID){
					
					$scope.loginUserID=userID;
					$scope.testMessage = "Test Message";
				  
					manageuserService.manageuser(userID).then(
							function(d) {
								$scope.testMsg1 = "Test";
								//console.log("Success.",d.message);
								var data = d.lmsuser;
								$scope.userlist=d.lmsuser;
								$scope.name=d.lmsuser.name;								
								
								if(d.lmsuser.mobilePersonal !=null){
									$scope.mobilePersonal=d.lmsuser.mobilePersonal;
								}
								if(d.lmsuser.lmsDepartment !=null){
									$scope.departmentname=d.lmsuser.lmsDepartment.name;
								}
								if(d.lmsuser.lmsSection !=null){
									$scope.sectionname=d.lmsuser.lmsSection.name;
								}
								
							$scope.getUserwiseRoleInfo();
								
						    $scope.getUserDelegationInfo();
								
								//$scope.loadUserListDropDown();
								
							},
							function(errResponse) {
								
								console
										.error("Error while fetching Currencies");
							});
				};
				
				$scope.getUserwiseRoleInfo= function(){	
					
					var dataUserwiseRoleInfo = {};
					$scope.testMessage = "Test Message";
					managedelegationService.getUserwiseRoleInfo($scope.loginUserID)
					.then(
							function(d) {
								console.log("Success.",d.message);
								dataUserwiseRoleInfo = d.listLmsWftRoleUserMap;
								 $scope.userlist=d.listLmsWftRoleUserMap;
								$scope.tableParams = new NgTableParams({}, { dataset: dataUserwiseRoleInfo});
																
							},
							function(errResponse) {
								
								console
										.error("Error while fetching Currencies");
							});
				};	
				
				$scope.getUserDelegationInfo= function(){
					var dataUserDelegationInfo={};
					$scope.testMessage = "Test Message";
						managedelegationService.getUserDelegationInfo($scope.loginUserID)
						.then(
								function(d) {
									console.log("Success.",d.message);
									dataUserDelegationInfo = d.listLmsWftRoleUserMap;
									$scope.tableParams2 = new NgTableParams({}, { dataset: dataUserDelegationInfo});
																	
								},
								function(errResponse) {
									
									console
											.error("Error while fetching Currencies");
									$scope.tableParams = new NgTableParams({}, { dataset: dataUserDelegationInfo});
								});
					};
					
					$scope.showUserInfo = function(uid,uname,dname,sname){	
						//$scope.Userid = 
						
							$scope.name_n = uname;
							$scope.dep_name=dname;
							$scope.sec_name=sname;
							$scope.releiverid=uid;
							//$scope.leaveBalance = d.lmsLeaveBalance.leaveBalance;
							//$scope.leaveTotal = d.lmsLeaveBalance.leaveTotal;
					       };
					       
					$scope.addReliever = function(){
						
						      $scope.delegationFrom=new Date($('#fromDate').val());
						      $scope.delegationTo=new Date($('#toDate').val());
										
								managedelegationService.addReliever($scope.loginUserID, $scope.releiverid,$scope.delegationFrom,$scope.delegationTo,$scope.userlist).then(
										function(d){
											
											console.log(d);
											//$scope.showSuccessMessage("Reliever Added");
											$scope.getUserDelegationInfo();
										},
										function(errResponse){
											//$scope.showErrorMessage("Reliever not Added");
											
										}
										);
										
									} 
					$scope.deleteReliever = function(userid,delegatebyid){	
						//console.log("HolidayRecord", holidayrecord );
						//$scope.lmsWftRoleUserMap_id=lmsWftRoleUserMap.id;
						managedelegationService.deleteReliever(userid,delegatebyid)
						.then( 
								function(d){
									console.log(d.message);
									$scope.getUserDelegationInfo();
								},
								function(errResponse){
									console.log("Failed to Update User Profile.");
									$scope.getUserDelegationInfo();
								}
							);
						
					};
					
					$scope.gotoHomePage = function(){	
						window.location = url+"employeehomepage";
					}
					
					/* Show Error Message */
					$scope.showErrorMessage = function(message) {

						$scope.errorMessages = message;
						$timeout(function() {
							$scope.successMessages = null;
							$scope.errorMessages = null;
						}, 6000);
					};
					
					$scope.showConfirmationMessage = function() {
						var result = confirm("Do your want to submit?");
		                if (result) {
		                	$scope.holidaymanagement();
		                } else {
		                    return false;
		                }
					};
					
					$scope.userAuthentication = function(userid){
						
						// Validate from lms_pages table
						$scope.pageid = 20;
						
						loginService.getauthorised(userid, $scope.pageid)
						.then(function(d) {						
							$scope.showSuccessMessage(d.message);
							
						}, 
						function(e) {
							$scope.showErrorMessage(e.data.message);
							window.location = url + "unauthorised";
						});					
					};
				
			} ]);
