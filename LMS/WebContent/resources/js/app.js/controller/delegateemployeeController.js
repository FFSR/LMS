
App
	.controller(
		'delegateemployeeController',
		[
			'$scope',
			'$http',
			'userlistService',
			'manageuserService',
			'managedelegationService',
			'NgTableParams',
			'$timeout',
			'$filter',
			'$location',
			function($scope, $http,userlistService,manageuserService,managedelegationService,NgTableParams,
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
								console.log("Success.",d.message);
								var data = d.listLmsuser;
								$scope.userlist=d.listLmsuser;
								$scope.name=d.listLmsuser[0].name;								
								$scope.mobilePersonal=d.listLmsuser[0].mobilePersonal;
								$scope.departmentname=d.listLmsuser[0].lmsDepartment.name;
								if(d.listLmsuser[0].lmsSection !=null){
									$scope.sectionname=d.listLmsuser[0].lmsSection.name;
								}
								
								$scope.getUserwiseRoleInfo();
								
								//$scope.loadUserListDropDown();
								
							},
							function(errResponse) {
								
								console
										.error("Error while fetching Currencies");
							});
				};
				
				$scope.getUserwiseRoleInfo= function(){
				$scope.testMessage = "Test Message";
					managedelegationService.getUserwiseRoleInfo($scope.loginUserID)
					.then(
							function(d) {
								console.log("Success.",d.message);
								//$scope.userRole = d.listLmsWftRoleUserMap;
								var data = d.listLmsWftRoleUserMap;	
								 $scope.userlist=d.listLmsWftRoleUserMap;
								/*----------------
								$scope.length =d.listLmsWftRoleUserMap.length ;
								while ($scope.length!=0) {
							        var oListItem = d.listLmsWftRoleUserMap[$scope.length-1];
							        $scope.length=$scope.length-1;
							       // listItemInfo += '\nID: ' + oListItem.get_id() + 
							         //   '\nDisplay name: ' + oListItem.get_displayName() + 
							           // '\nUnique role assignments: ' + oListItem.get_hasUniqueRoleAssignments();
							    }
								//*----------------*/
								//listLmsWftRoleUserMap=d.listLmsWftRoleUserMap;
								$scope.tableParams = new NgTableParams({}, { dataset: data});
																
							},
							function(errResponse) {
								
								console
										.error("Error while fetching Currencies");
							});
				};
			
				$scope.loadUserListDropDown = function(){
					$scope.dDName = "";
					userlistService.getUserList()
					.then(
						function(d) {
						$scope.userData = d;
					}, function(errResponse) {
						console.log("Failed to get User Drop Down.");
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
				
			} 
			]);
				
				
