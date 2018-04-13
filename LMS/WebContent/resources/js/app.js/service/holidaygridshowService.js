/**
 * 
 */
'use strict';

App.factory('holidaygridshowService', [
		'$http',
		'$q',
		'url',
		function($http, $q, url) {
			return {
				
				holidaygridshow: function(){
					return $http.get(url+'holidaygridshow/')
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