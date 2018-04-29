App
	.controller(
		'leaveapplicationController',
		[
			'$scope',
			'$http',
			'leaveapplicationservice',
			'leavetypeService',
			'userlistService',
			'$timeout',
			'$filter',
			'$location',

			function($scope, $http,leaveapplicationservice,leavetypeService,userlistService,
				$timeout, $filter,$location) {
				
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
					$scope.leaveapplication.lmsUserByUserId=$scope.ddReliever
					//$scope.leaveapplication.lmsLeaveType.type = $scope.appStatus.type;
					$scope.leaveapplication.leaveBalance = $scope.leaveBalance;
					$scope.leaveapplication.lmsUserByReliverEmailAddressUserId = $scope.ddReliever;
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
								$scope.testMsg = d.message;
								console.log("Success.",d.message);
								$scope.uploadFile();
							},
							function(e) {
								$scope.testMsg = e.data.message;								
								console.error(e.data.message);
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
			} 
			]);
				
				
