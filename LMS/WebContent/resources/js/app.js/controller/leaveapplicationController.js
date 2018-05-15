App.controller(
		'leaveapplicationController',
		[
			'$scope',
			'$http',
			'leaveapplicationservice',
			'leavetypeService',
			'userlistService',
			'manageuserService',
			'wfManagementService',
			'DropDownService',
			'$timeout',
			'$filter',
			'$location',
			'url',

			function($scope, $http,leaveapplicationservice,leavetypeService,userlistService,manageuserService,wfManagementService,DropDownService,
					$timeout, $filter,$location,url) {

				$scope.testMsg = "Testing Message";
				$scope.lmsuser="";

				// disable submit button
				$scope.validationLock = true;

				$scope.uploadFile = function(){
					$scope.processDropzone();
					// $scope.restDropzone();
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

						"lmsUserByUserId" :{
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


					// $scope.leaveapplication.leaveAvailable =
					// $scope.leaveavailable;
					$scope.leaveapplication.leaveTaken = $scope.leaveTaken;
					$scope.leaveapplication.lmsLeaveType = $scope.leavetype;
					// $scope.leaveapplication.userId= parseInt($scope.userid) ;
					// $scope.leaveapplication.lmsUserByUserId.id=
					// parseInt($scope.userid) ;
					$scope.leaveapplication.lmsUserByUserId= $scope.lmsuser;
					// $scope.leaveapplication.lmsLeaveType.type =
					// $scope.appStatus.type;
					$scope.leaveapplication.leaveBalance = $scope.leaveBalance;
					// $scope.leaveapplication.lmsUser = $scope.ddReliever;
					$scope.leaveapplication.eligibility = $scope.eligibility;
					$scope.leaveapplication.fromDate = new Date($('#fromDate').val());
					$scope.leaveapplication.toDate = new Date($('#toDate').val());
					$scope.leaveapplication.totalDayCount = $scope.totalDayCount;
					$scope.leaveapplication.totalDayText = $scope.totalDayText;
					$scope.leaveapplication.reasonForLeave = $scope.reasonForLeave;
					$scope.leaveapplication.taskNeedToPerformed = $scope.taskNeedToPerformed;

					if($scope.ddStation!=null){
						$scope.leaveapplication.inStation = $scope.ddStation.name;
					}
					$scope.leaveapplication.lmsUserByReliverEmailAddressUserId=$scope.ddReliever;
					// $scope.leaveapplication.insertDate =
					// $scope.leaveapplication.insertBy = 3;
					// $scope.leaveapplication.updatDate = $scope.update_date;
					// $scope.leaveapplication.updateBy = $scope.update_by;


					leaveapplicationservice.applicationforleave($scope.leaveapplication).then(
							function(d) {

								wfManagementService.generaterequest(d.userid,d.leavetypeid,d.leaveapplicationid).then(
										function(d){
											// console.log(d.message);
											$scope.showSuccessMessage(d.message);
										},
										function(e){
											// console.log(e.message);
											$scope.showErrorMessage(e.data.message);
										}
								);

								// $scope.testMsg = d.message;
								// console.log("Success.",d.message);
								$scope.showSuccessMessage(d.message);
								$scope.uploadFile();
								$scope.ClearAll();
								// $window.location.reload();
							},
							function(e) {
								// $scope.testMsg = e.data.message;
								// console.error(e.data.message);
								$scope.showErrorMessage(e.message);
							});
				}

				$scope.getUserInfo= function(userID){

					$scope.testMessage = "Test Message";

					manageuserService.manageuser(userID).then(
							function(d) {
								// $scope.testMsg1 = "Test";
								console.log("Success.",d.message);
								var data = d.listLmsuser;
								$scope.lmsuser=d.listLmsuser[0];
							},
							function(errResponse) {								
								console.error(errResponse.message);
							});
				};



				$scope.loadLeaveTypeDownDown = function(){
					$scope.dDName = "";
					leavetypeService.getLeaveType().then(function(d) {
						$scope.dropdownData = d;
					}, function(errResponse) {
						console.log("Failed to get Drop Down.");
					});
				};

				$scope.loadDropDownStation = function(dropdownname){
					DropDownService.getStationOptions(dropdownname)
					.then(function(d) {
						$scope.stationData = d.listLmsDropdown;
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

				$scope.loadUserListDropDown = function(){
					$scope.dDName = "";

					userlistService.getUserList()
					.then(
							function(d) {
								// $scope.usersList = d;
								$scope.q = d;
								$scope.userData=d;
								// console.log($scope.usersList);
								// $scope.userData = d.listLmsUser;
							}, function(errResponse) {
								console.log("Failed to get User Drop Down.");

							});
				};
				/*
				 * $scope.getleaveapplication = function(leaveapplicationid){
				 * console.log("From Get Method");
				 * leaveapplicationservice.getleaveapp(leaveapplicationid).then(
				 * function(d){ $scope.leaveData = d; $scope.leavetype =
				 * $scope.leaveData.lmsLeaveType; $scope.reasonForLeave =
				 * $scope.leaveData.reasonForLeave;
				 *  }, function(errResponse){ console.log(errResponse.data); } ); };
				 * 
				 * $scope.getleaveapplication(4);
				 */

				$scope.getSessionUserDetails = function(userName,userID){

					$scope.username = userName;
					$scope.userid = userID;

					console.log("User Group");
				};

				$scope.showLeaveBalance = function(userid,leavetypeid){

					// $scope.Userid =
					// $scope.t = leavetype;
					// console.log("efghjk");

					leaveapplicationservice.getLeaveBalance($scope.userid,leavetypeid)
					.then(
							function(d) {

								// $scope.lmsLeaveBalance=d.lmsLeaveBalance;

								$scope.eligibility = d.lmsLeaveBalance.eligibility;
								$scope.leaveTotal = d.lmsLeaveBalance.leaveTotal;
								$scope.leaveTaken = d.lmsLeaveBalance.leaveTaken;
								$scope.leaveBalance = d.lmsLeaveBalance.leaveBalance;
								$scope.leaveApplied = d.lmsLeaveBalance.leaveApplied;

								// $scope.eligibility = d.eligiblity;
								
								$scope.validationLock = true;

							}, function(errResponse) {
								//console.log("Failed to get Drop Down.");
								$scope.showErrorMessage(errResponse.data.message);	
								
								$scope.validationLock = true;
							});
				}

				$scope.gotoHomePage = function(){	
					window.location = url+"employeehomepage";
				}

				$scope.ClearAll = function() {

					$scope.leaveTaken='0';
					$scope.leavetype='0';
					$scope.userid =0;
					// $scope.leaveapplication.lmsLeaveType.type =
					// $scope.appStatus.type;
					$scope.leaveBalance='0';
					$scope.ddReliever='0';
					$scope.eligibility="";
					new Date($('#fromDate').val(''));
					new Date($('#toDate').val(''));
					$scope.totalDayCount='0';
					$scope.totalDayText="";
					$scope.reasonForLeave="";
					$scope.taskNeedToPerformed="";
					$scope.ddStation='0';


				};

				$scope.validate = function(){

					// validateLeaveRule: function(userid, leavetypeid,
					// startdate, enddate)

					leaveapplicationservice.validateLeaveRule($scope.userid, $scope.leavetype.id, $scope.fromDate, $scope.toDate)
					.then(
							function(d) {

								$scope.totalDayCount = "APPLIED ( "+d.numberOfDaysApplied+" ) + IF IMPACT ON HOLIDAY THAN MIN ( "+d.minimumHolidayConsider+" ) OF BEFORE ( "+d.forwardHolidayCount+" ) AND AFTER ( "+d.backwardHolidayCount+" )  = TOTAL ( "+d.numberOfDayConsider+" )";
								//$scope.totalDayCount = "APPLIED("+d.numberOfDaysApplied+") + MIN ("+d.minimumHolidayConsider+") ( BEFORE("+d.forwardHolidayCount+") | AFTER("+d.backwardHolidayCount+") ) = TOTAL("+d.numberOfDayConsider+")";
								$scope.validationLock = false;
								$scope.showSuccessMessage(d.message);						

							}, 
							function(errResponse) {		

								$scope.totalDayCount = "Error on Leave Rule."
								$scope.validationLock = true;						
								$scope.showErrorMessage(errResponse.data.message);					

							});


				};

			} 
			]);
