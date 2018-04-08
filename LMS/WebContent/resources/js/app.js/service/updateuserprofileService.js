/**
 * 
 */
'use strict';

App.factory('updateuserprofileService', [
		'$http',
		'$q',
		'url',
		function($http, $q, url) {
			return {
				
				updateuserprofile: function(user){
					console.log(user);
					return $http.put(url+'updateuserprofile',user)
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