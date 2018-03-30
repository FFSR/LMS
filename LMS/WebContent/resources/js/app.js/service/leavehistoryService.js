/**
 * 
 */
'use strict';

App.factory('leavehistoryService', [
		'$http',
		'$q',
		'url',
		function($http, $q, url) {
			return {
				
				leavehistory: function(user_id){
					return $http.get(url+'leavehistory/'+user_id)
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
				
				
			}
		} ]);