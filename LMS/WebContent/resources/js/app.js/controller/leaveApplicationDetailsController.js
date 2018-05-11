App.controller('leaveApplicationDetailsController',[
	'$scope',
	'$http',
	'$timeout',
	'$filter',
	'NgTableParams',
	'$window',
	'manageleaveService',
	'$location',

	function($scope, $http,
		$timeout, $filter,NgTableParams,$window,manageleaveService,$location) {
		
		$scope.test = [
		    {
		        "id": 2,
		        "lmsLeaveApplication": {
		            "id": 8,
		            "lmsLeaveType": {
		                "id": 1,
		                "type": "EARNED LEAVE - AVERAGE SALARY - PERSONAL",
		                "status": "ACTIVE",
		                "maximumDays": 0,
		                "incremental": "YES",
		                "yearlyAllocated": null,
		                "maximumTimes": null,
		                "maximumAtATime": 120,
		                "yearInterval": null,
		                "eligibleAfter": null,
		                "eligibleBefore": null,
		                "impactOnHoliday": null,
		                "extensible": "NO",
		                "impactOnEarnedLeave": "YES",
		                "insertBy": null,
		                "insertDate": null,
		                "updateBy": null,
		                "updateDate": null,
		                "minimumAtATime": null,
		                "applyDaysEachYear": null,
		                "dependentLeaveAc": null
		            },
		            "lmsUser": null,
		            "userId": 4,
		            "year": null,
		            "leaveAvailable": null,
		            "leaveTaken": null,
		            "leaveBalance": null,
		            "eligibility": "",
		            "fromDate": 1525194600000,
		            "toDate": 1525626600000,
		            "totalDayCount": null,
		            "totalDayText": null,
		            "reasonForLeave": "",
		            "taskNeedToPerformed": null,
		            "insertDate": null,
		            "insertBy": null,
		            "updateDate": null,
		            "updateBy": null,
		            "inStation": null
		        },
		        "lmsUser": null,
		        "documentName": null,
		        "filename": "_(2018-05-04_23-11-34)_RARBG.txt",
		        "location": null,
		        "insertDate": null,
		        "insertBy": null,
		        "updateDate": null,
		        "updateBy": null
		    },
		    {
		        "id": 3,
		        "lmsLeaveApplication": {
		            "id": 8,
		            "lmsLeaveType": {
		                "id": 1,
		                "type": "EARNED LEAVE - AVERAGE SALARY - PERSONAL",
		                "status": "ACTIVE",
		                "maximumDays": 0,
		                "incremental": "YES",
		                "yearlyAllocated": null,
		                "maximumTimes": null,
		                "maximumAtATime": 120,
		                "yearInterval": null,
		                "eligibleAfter": null,
		                "eligibleBefore": null,
		                "impactOnHoliday": null,
		                "extensible": "NO",
		                "impactOnEarnedLeave": "YES",
		                "insertBy": null,
		                "insertDate": null,
		                "updateBy": null,
		                "updateDate": null,
		                "minimumAtATime": null,
		                "applyDaysEachYear": null,
		                "dependentLeaveAc": null
		            },
		            "lmsUser": null,
		            "userId": 4,
		            "year": null,
		            "leaveAvailable": null,
		            "leaveTaken": null,
		            "leaveBalance": null,
		            "eligibility": "",
		            "fromDate": 1525194600000,
		            "toDate": 1525626600000,
		            "totalDayCount": null,
		            "totalDayText": null,
		            "reasonForLeave": "",
		            "taskNeedToPerformed": null,
		            "insertDate": null,
		            "insertBy": null,
		            "updateDate": null,
		            "updateBy": null,
		            "inStation": null
		        },
		        "lmsUser": null,
		        "documentName": null,
		        "filename": "Test.txt",
		        "location": null,
		        "insertDate": null,
		        "insertBy": null,
		        "updateDate": null,
		        "updateBy": null
		    }
		];
		
		$scope.viewAttachment = function(leaveApplicationID){
			
			manageleaveService.getAttachment(leaveApplicationID).then(
					function(d){
						$scope.fileNames = d;
						console.log("Attachment Data",d);
						$scope.showAttachment = true;
					},
					function(errResponse){
						
					}
					);
		};
		
		

		
		
	} ]);