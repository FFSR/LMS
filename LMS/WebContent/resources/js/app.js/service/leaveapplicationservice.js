/**
 * 
 */
'use strict';

App.factory('leaveapplicationservice', [
		'$http',
		'$q',
		'url',
		function($http, $q, url) {
			return {
				
				applicationforleave: function(leaveapplication){
					return $http.post(url+'testleave', leaveapplication)
					.then(function(response) {
						return response.data;
					},
					function(errResponse) {
						console
								.error("Error while fetching user info list.");
						return $q
								.reject(errResponse);
					});
				},
				getleaveapp: function(leaveapplicationid){
					
					return $http.get(url+'getleaveapplication/'+ leaveapplicationid)
					.then(function(response) {
						return response.data;
					},
					function(errResponse) {
						console
								.error("Error while fetching user info list.");
						return $q
								.reject(errResponse);
					});
				},
				
				getLeaveBalance: function(userid,leavetypeid){
					return $http.get(url+'leaverule/'+ userid+'/'+leavetypeid+'/')
					.then(function(response) {
						return response.data;
					},
					function(errResponse) {
						console
								.error("Error while fetching user info list.");
						return $q
								.reject(errResponse);
					});
				},
				
				getLeaveBalance: function(userid,leavetypeid){
					return $http.get(url+'leaverule/'+ userid+'/'+leavetypeid+'/')
					.then(function(response) {
						return response.data;
					},
					function(errResponse) {
						console
								.error("Error while fetching user info list.");
						return $q
								.reject(errResponse);
					});
				},
				
/*				@RequestMapping(value = "/leaverule/{userid}/{leavetypeid}/{startdate}/{enddate}/", method = RequestMethod.GET)
				public ResponseEntity<ResponseWrapperLeaveRule> generateRequest(@PathVariable("userid") Integer userid,
						@PathVariable("leavetypeid") Integer leavetypeid, @PathVariable("startdate") String strstartdate,
						@PathVariable("enddate") String strenddate) {*/
				
				validateLeaveRule: function(userid, leavetypeid, startdate, enddate){
					return $http.get(url+'leaverule/'+ userid +'/'+ leavetypeid +'/'+ startdate +'/'+ enddate +'/')
					.then(function(response) {
						return response.data;
					},
					function(errResponse) {
						console.error("Error while fetching user info list.");
						return $q.reject(errResponse);
					});
				},
				
			}
		} ]);