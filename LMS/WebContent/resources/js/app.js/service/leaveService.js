/**
 * 
 */
'use strict';

App.factory('leaveService', [
		'$http',
		'$q',
		'url',
		function($http, $q, url) {
			return {
				
				leave: function(user_id){
					return $http.get(url+'leave/'+user_id)
					.then(function(response) {
						return response.data;
					},
					function(errResponse) {
						console.error("Error while fetching user info list.");
						return $q.reject(errResponse);
					});
				},
				
				// new function
			}
		} 
		]);