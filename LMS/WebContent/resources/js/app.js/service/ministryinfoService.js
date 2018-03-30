/**
 * 
 */
'use strict';

App.factory('ministryinfoService', [
		'$http',
		'$q',
		'url',
		function($http, $q, url) {
			return {
				
				ministryinfo: function(ministry){
					return $http.post(url+'ministryinfo', ministry)
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