/**
 * 
 */
'use strict';

App.factory('manageuserService', [
		'$http',
		'$q',
		'url',
		function($http, $q, url) {
			return {
				
				manageuser: function(user_id){
					return $http.get(url+'manageuser/'+user_id)
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