/**
 * 
 */
'use strict';

App.factory('registrationService', [
		'$http',
		'$q',
		'url',
		function($http, $q, url) {
			return {
				
				registration: function(user){
					return $http.post(url+'registration', user)
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