App
		.controller(
				'subordinatelvblnceController',
				[
						'$scope',
						'$timeout',
						'$http',						
						'manageuserService',		
						'$filter',
						'$location',
						'NgTableParams',
						'url',

						function($scope, $timeout, $http, 
								manageuserService, $filter,
								$location, NgTableParams, url) {

							$scope.testMsg = "Testing Message";
							$scope.user = {};
							$scope.userID = "";
														
							$scope.userAuthentication = function(userID) {
								$scope.userID = userID;							

								manageuserService
										.subordinate(userID)
										.then(
												function(d) {
													$scope.testMsg1 = "Test";
													console.log("Success.",
															d.message);
													var data = d.listLmsuser;
													$scope.tableParams = new NgTableParams(
															{}, {
																dataset : d
															});													

												},
												function(errResponse) {

													console
															.error("Error while fetching Currencies");
												});

							};

														
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

							$scope.clearAll = function() {

								$scope.formSignVerified = false;
								$scope.user.name = "";
								$scope.user.lmsDivision = '0';
								$scope.user.email = "";
								$scope.user.lmsDepartment = '0';
								$scope.user.lmsSection = '0';
								$scope.user.lmsDesignation = '0';
								$scope.user.lmsMinistry = '0';
								$scope.nationality = "";
								$scope.user.lmsOfficeLocation = '0';
								$scope.user.mobilePersonal = "";
								$scope.user.mobileOffice = "";
								$scope.user.fax = "";
								$scope.joiningDate = "";
								$scope.gender = '0';
								$scope.ddReliever = '0';
								$scope.user.address = "";
								$scope.user.passport = "";
								$scope.user.password = "";
								$scope.user.nid = "";
								$scope.dateofbirth = "";

							};

							$scope.gotoHomePage = function() {

								window.location = "employeehomepage";
							};

						} ]);