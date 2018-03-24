/**
 * 
 */
'use strict';

App.factory('forgetpasswordService', [
		'$http',
		'$q',
		'url',
		function($http, $q, url) {
			return {
				
				forgetpassword: function(emailid){
					return $http.post(url+'forgetpassword',emailid)
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