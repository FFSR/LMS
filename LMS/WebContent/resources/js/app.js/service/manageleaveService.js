/**
 * 
 */
'use strict';

App.factory('manageleaveService', [
		'$http',
		'$q',
		'url',
		function($http, $q, url) {
			return {
				
				manageleave: function(search){
					return $http.post(url+'manageleave/',search)
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