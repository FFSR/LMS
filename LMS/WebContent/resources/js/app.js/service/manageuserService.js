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
				
				manageuser: function(userName, mobile, status){
					return $http.get(url+'manageuser/'+ userName +'/'+ mobile +'/'+ status +'/')
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