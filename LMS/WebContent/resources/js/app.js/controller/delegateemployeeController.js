
App
	.controller(
		'delegateemployeeController',
		[
			'$scope',
			'$http',
			'userlistService',
			'managedelegationService',
			'NgTableParams',
			'$timeout',
			'$filter',
			'$location',
			function($scope, $http,userlistService,managedelegationService,NgTableParams,
				$timeout, $filter,$location) {
				
				$scope.testMsg = "Testing Message";
                $scope.loginUserID=0;
                $scope.releiverid=0;
                $scope.userlist="";
               
               // scope.listLmsWftRoleUserMap= null;
               // List<LmsWftRoleUserMap> listLmsWftRoleUserMap;
                
				$scope.getUserInfo= function(userID){
					$scope.loginUserID=userID;
					$scope.testMessage = "Test Message";
				manageuserService.manageuser(userID).then(
							function(d) {
								$scope.testMsg1 = "Test";
								//console.log("Success.",d.message);
								var data = d.listLmsuser;
								$scope.userlist=d.listLmsuser;
								$scope.name=d.listLmsuser[0].name;								
								
								if(d.listLmsuser[0].mobilePersonal !=null){
									$scope.mobilePersonal=d.listLmsuser[0].mobilePersonal;
								}
								if(d.listLmsuser[0].lmsDepartment !=null){
									$scope.departmentname=d.listLmsuser[0].lmsDepartment.name;
								}
								if(d.listLmsuser[0].lmsSection !=null){
									$scope.sectionname=d.listLmsuser[0].lmsSection.name;
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
			
					
				$scope.loadUserListDropDown = function(){
					$scope.dDName = "";
					
					userlistService.getUserList()
					.then(
						function(d) {
						$scope.usersList = d;
						$scope.q = d;
						$scope.userData;
						console.log($scope.usersList);
						//$scope.userData = d.listLmsUser;
					}, function(errResponse) {
						console.log("Failed to get User Drop Down.");
	
					});
				};
				
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
					
					console.log($scope.ddReliever_n);
					
					$scope.ddReliever_n;
							
					managedelegationService.addReliever($scope.loginUserID, $scope.releiverid,$scope.userlist).then(
							function(d){
								
								console.log(d);
								$scope.showSuccessMessage("Reliever Added");
							},
							function(errResponse){
								$scope.showErrorMessage("Reliever not Added");
								
							}
							);
							
						} 
				
				$scope.gotoHomePage = function(){	
					window.location = url+"employeehomepage";
				};
				
				$scope.e = "Test";
			} 
			]);
				
				
