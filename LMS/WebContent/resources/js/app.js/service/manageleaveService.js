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
				
				manageleave: function(user_id){
					return $http.get(url+'manageleave/'+user_id)
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