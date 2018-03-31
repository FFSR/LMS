/**
 * 
 */
'use strict';

App.factory('changepasswordService', [
		'$http',
		'$q',
		'url',
		function($http, $q, url) {
			return {
				
				changepassword: function(user){
					console.log(user);
					return $http.put(url+'changepassword',user)
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