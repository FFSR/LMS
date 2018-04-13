/**
 * 
 */
'use strict';

App.factory('homepagegridshowService', [
		'$http',
		'$q',
		'url',
		function($http, $q, url) {
			return {
				
				homepagegridshow: function(){
					return $http.get(url+'homepagegridshow/')
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