'use strict';

App.factory('wfManagementService', [
		'$http',
		'$q',
		'url',
		function($http, $q, url) {
			return {
				
				generaterequest: function(userid,leavetypeid,leaveapplicationid){
					return $http.post(url+'generaterequest'+"/"+ userid+"/"+leavetypeid+"/"+leaveapplicationid)
					.then(function(response) {
						return response.data;
					},
					function(errResponse) {
						console
								.error("Error while fetching user info list.");
						return $q
								.reject(errResponse);
					});
				}
				
			}
		} ]);