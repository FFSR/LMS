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
				
				changepassword: function(newpassword, oldpassword, userID){
					
					return $http.put(url+'changepassword/'+ newpassword +'/'+ oldpassword +'/'+ userID +'/')
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