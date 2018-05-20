App.controller('leavehistoryController', [
		'$scope',
		'$http',
		'leavehistoryService',
		'$timeout',
		'$filter',
		'NgTableParams',
		'$location',

		function($scope, $http, leavehistoryService, $timeout, $filter,
				NgTableParams, $location) {
			
			
			$scope.userID = "";
			
			$scope.getSessionUserDetails = function(userID) {

				$scope.userID = userID;
			};			
			

			$scope.leavehistory = function() {
				leavehistoryService.leavehistory($scope.userID).then(function(d) {
					var data = d.listLmsLeaveBalance;
					$scope.tableParams = new NgTableParams({}, {
						dataset : data
					});
				}, function(errResponse) {

				});
			};
			
			$scope.gomyPage = function(){	
				location.reload();
				window.location = url+"leavehistory";
			}
			
		} ]);
