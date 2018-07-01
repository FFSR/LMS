App.controller('subordinatelvblnceController', [
		'$scope',
		'$timeout',
		'$http',
		'manageuserService',
		'$filter',
		'$location',
		'NgTableParams',
		'leavehistoryService',
		'url',

		function($scope, $timeout, $http, manageuserService, $filter,
				$location, NgTableParams, leavehistoryService, url) {

			$scope.testMsg = "Testing Message";
			$scope.user = {};
			$scope.userID = "";

			$scope.userAuthentication = function(userID) {

				manageuserService.subordinate(userID).then(function(d) {
					$scope.testMsg1 = "Test";
					console.log("Success.", d.message);
					//	var data = d.Listlmsuser;
					$scope.tableParams1 = new NgTableParams({}, {
						dataset : d
					});

				}, function(errResponse) {

					console.error("Error while fetching Currencies");
				});

			};
			
                $scope.userAccessAuthentication = function(userid){
				
				// Validate from lms_pages table
				$scope.pageid = 30;
				
				loginService.getauthorised(userid, $scope.pageid)
				.then(function(d) {						
					$scope.showSuccessMessage(d.message);
					
				}, 
				function(e) {
					$scope.showErrorMessage(e.data.message);
					window.location = url + "unauthorised";
				});					
			};

			$scope.leavehistoryinfo = function(user) {
				$scope.userID = user.id;
				leavehistoryService.leavehistory($scope.userID).then(function(d) {
					//var data = d.listLmsLeaveBalance;

					// change korte hobe d.listlsmLeae done
					var data = d.listLmsLeaveBalance;
					$scope.lvbalance =d.listLmsLeaveBalance[0];
					$scope.employeename=$scope.lvbalance.lmsUser.name;

					$scope.tableParams2 = new NgTableParams({}, {
						dataset : data
					});
				}, function(errResponse) {

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
			
			$scope.CallPrint= function(strid) {
				   
					var restorepage= document.body.innerHTML;
					var printcontent=document.getElementById(strid).innerHTML;
					document.body.innerHTML=printcontent;
					window.print();
				    document.body.innerHTML=printcontent=restorepage;
				    location.reload();
				    
				};
				
				

			
			$scope.gotoHomePage = function() {

				window.location = "employeehomepage";
			};

		} ]);