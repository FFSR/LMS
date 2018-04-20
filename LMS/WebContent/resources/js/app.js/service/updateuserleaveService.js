/**
 * 
 */
'use strict';

App.factory('updateuserleaveService', [
		'$http',
		'$q',
		'url',
		function($http, $q, url) {
			return {
				
				updateuserleave: function(leaveapplication){
					console.log(leaveapplication);
					return $http.put(url+'updateuserleave',leaveapplication)
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