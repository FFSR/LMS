App
	.controller(
		'leaveapplicationController',
		[
			'$scope',
			'$http',
			'leaveapplicationservice',
			'leavetypeService',
			'userlistService',
			'wfManagementService',
			'DropDownService',
			'$timeout',
			'$filter',
			'$location',
			'url',

			function($scope, $http,leaveapplicationservice,leavetypeService,userlistService,wfManagementService,DropDownService,
				$timeout, $filter,$location,url) {
				
				$scope.testMsg = "Testing Message";
				
				$scope.uploadFile = function(){
					$scope.processDropzone();
					//$scope.restDropzone();
				}
				
				$scope.leaveapplication = {
						"year" : "",
						"lmsLeaveType" : {
							"id":0,
							"type":"",
							"status":"",
							"maximumDays":"",
							"incremental":"",
							"yearlyAllocated":"",
							"insertDate":"",
							"insertBy":"",
							"updateDate":"",
							"updateBy":""			
						},
						"leaveAvailable" : "",
						"leaveTaken" : "",
						"leaveBalance" : "",
						"lmsLeaveType" : {
							"id": 0,
							"type":"",
							"status":"",
							"maximumDays":"",
							"incremental":"",
							"yearlyAllocated":"",
							"insertDate":"",
							"insertBy":"",
							"updateDate":"",
							"updateBy":""					
						},
						
						"lmsUserByReliverEmailAddressUserId" :{
							"id": 0,
					        "lmsDepartment": {
					            "id": 0,
					            "lmsMinistry": {
					                "id": 0,
					                "name": "",
					                "insertDate": "",
					                "insertBy": "",
					                "updateDate": "",
					                "updateBy": ""
					            },
					            "name": "",
					            "insertDate": "",
					            "insertBy": "",
					            "updateDate": "",
					            "updateBy": ""
					        },
					        "lmsDesignation": {
					            "id": 0,
					            "lmsClass": {
					                "id": 0,
					                "name": ""
					            },
					            "name": "",
					            "insertDate": "",
					            "insertBy": "",
					            "updateDate": "",
					            "updateBy": ""
					        },
					        "lmsDivision": {
					            "id": 0,
					            "lmsDepartment": {
					                "id": 0,
					                "lmsMinistry": {
					                    "id": 0,
					                    "name": "",
					                    "insertDate": "",
					                    "insertBy": "",
					                    "updateDate": "",
					                    "updateBy": ""
					                },
					                "name": "",
					                "insertDate": "",
					                "insertBy": "",
					                "updateDate": "",
					                "updateBy": ""
					            },
					            "name": "",
					            "insertDate": "",
					            "insertBy": "",
					            "updateDate": "",
					            "updateBy": ""
					        },
					        "lmsMinistry": {
					            "id": 0,
					            "name": "",
					            "insertDate": "",
					            "insertBy": "",
					            "updateDate": "",
					            "updateBy": ""
					        },
					        "lmsOfficeLocation": {
					            "id": 0,
					            "name": "",
					            "address": "",
					            "insertDate": "",
					            "insertBy": "",
					            "updateDate": "",
					            "updateBy": ""
					        },
					        "lmsSection": {
					            "id": 0,
					            "lmsDepartment": {
					                "id": 1,
					                "lmsMinistry": {
					                    "id": 0,
					                    "name": "",
					                    "insertDate": "",
					                    "insertBy": "",
					                    "updateDate": "",
					                    "updateBy": ""
					                },
					                "name": "",
					                "insertDate": "",
					                "insertBy": "",
					                "updateDate": "",
					                "updateBy": ""
					            },
					            "name": "",
					            "insertDate": "",
					            "insertBy": "",
					            "updateDate": "",
					            "updateBy": ""
					        },
					        "lmsUser": "",
					        "name": "",
					        "email": "",
					        "phone": "",
					        "passport": "",
					        "fax": "",
					        "mobilePersonal": "",
					        "mobileOffice": "",
					        "gender": "",
					        "address": "",
					        "nid": "",
					        "nationality": "",
					        "joiningDate": "",
					        "status": "",
					        "password": "",
					        "insertDate": "",
					        "insertBy": "",
					        "updateDate": "",
					        "updateBy": ""
						},

						"eligibility" : "", 
						"fromDate" : "",
						"toDate" : "",
						"totalDayCount" : "",
						"totalDayText" : "",					
						"reasonForLeave" : "",
						"taskNeedToPerformed" : "",
						"lmsUserByReliverEmailAddressUserId":"",
						"insertDate" : "",
						"insertBy" : "",
						"updatDate" : "",						
						"updateBy" : "",
						"inStation" :"",
					};
	
				$scope.applicationforleave = function(){				
					
					//$scope.leaveapplication.leaveAvailable = $scope.leaveavailable;
					$scope.leaveapplication.leaveTaken = $scope.leaveTaken;
					$scope.leaveapplication.lmsLeaveType = $scope.leavetype;
					$scope.leaveapplication.userId= parseInt($scope.userid) ;
					//$scope.leaveapplication.lmsLeaveType.type = $scope.appStatus.type;
					$scope.leaveapplication.leaveBalance = $scope.leaveBalance;
					$scope.leaveapplication.lmsUser = $scope.ddReliever;
					$scope.leaveapplication.eligibility = $scope.eligibility;
					$scope.leaveapplication.fromDate = new Date($('#fromDate').val());
					$scope.leaveapplication.toDate = new Date($('#toDate').val());
					$scope.leaveapplication.totalDayCount = $scope.totalDayCount;
					$scope.leaveapplication.totalDayText = $scope.totalDayText;
					$scope.leaveapplication.reasonForLeave = $scope.reasonForLeave;
					$scope.leaveapplication.taskNeedToPerformed = $scope.taskNeedToPerformed;
					$scope.leaveapplication.inStation = $scope.inStation;
				//	$scope.leaveapplication.insertDate = 
					//$scope.leaveapplication.insertBy = 3;
					//$scope.leaveapplication.updatDate = $scope.update_date;
					//$scope.leaveapplication.updateBy = $scope.update_by;
						
					
					leaveapplicationservice.applicationforleave($scope.leaveapplication).then(
							function(d) {
								wfManagementService.generaterequest(d.userid,d.leavetypeid,d.leaveapplicationid).then(
								function(d){
									console.log(d);
								},
								function(e){
									console.log(e);
								}
								);
								
								$scope.testMsg = d.message;
								console.log("Success.",d.message);
								$scope.showSuccessMessage("Insertion successful");
								$scope.uploadFile();
								$window.location.reload();
							},
							function(e) {
								$scope.testMsg = e.data.message;								
								console.error(e.data.message);
								$scope.showErrorMessage("Insertion Fail");
							});
				}
				
			$scope.loadLeaveTypeDownDown = function(){
					$scope.dDName = "";
					leavetypeService.getLeaveType().then(function(d) {
						$scope.dropdownData = d;
					}, function(errResponse) {
						console.log("Failed to get Drop Down.");
					});
				};
				
				$scope.loadDropDownStation = function(dropdownname){
					DropDownService.getStationOptions(dropdownname).then(function(d) {
						$scope.stationData = d.listLmsDropdown;
					}, function(errResponse) {
						console.log("Failed to get Drop Down.");
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
		/* $scope.getleaveapplication = function(leaveapplicationid){
					console.log("From Get Method");
					leaveapplicationservice.getleaveapp(leaveapplicationid).then(
					function(d){
						$scope.leaveData = d;
						$scope.leavetype = $scope.leaveData.lmsLeaveType;
						$scope.reasonForLeave = $scope.leaveData.reasonForLeave;
						
					},
					function(errResponse){
						console.log(errResponse.data);
					}
					);
				};
				
				$scope.getleaveapplication(4);*/
				
				$scope.getSessionUserDetails = function(userName,userID){
					
					$scope.username = userName;
					$scope.userid = userID;
					
					console.log("User Group");
				};
				
				$scope.showLeaveBalance = function(userid,leavetypeid){
					
					//$scope.Userid = 
					//$scope.t = leavetype;
					//console.log("efghjk");
					leaveapplicationservice.getLeaveBalance($scope.userid,leavetypeid)
					.then(
							function(d) {
						
						//$scope.lmsLeaveBalance=d.lmsLeaveBalance;
						
						$scope.eligibility = d.lmsLeaveBalance.eligiblity;
						$scope.leaveBalance = d.lmsLeaveBalance.leaveBalance;
						$scope.leaveTotal = d.lmsLeaveBalance.leaveTotal;
						
						//$scope.eligibility = d.eligiblity;
						
					}, function(errResponse) {
						console.log("Failed to get Drop Down.");
					});
				}
				
                    $scope.gotoHomePage = function(){	
					window.location = url+"employeehomepage";
				}
				
			} 
			]);
				
				
