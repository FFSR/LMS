/**
 * 
 */
'use strict';

App.factory('applicationforleaveService', [
		'$http',
		'$q',
		'url',
		function($http, $q, url) {
			return {
				
				applicationforleave: function(leaveapplication){
					return $http.post(url+'applicationforleave', leaveapplication)
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