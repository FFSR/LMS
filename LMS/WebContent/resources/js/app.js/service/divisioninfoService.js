/**
 * 
 */
'use strict';

App.factory('divisioninfoService', [
		'$http',
		'$q',
		'url',
		function($http, $q, url) {
			return {
				
				divisioninfo: function(division){
					return $http.post(url+'divisioninfo', division)
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