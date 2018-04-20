/**
 * 
 */
'use strict';

App.factory('leaveapplicationservice', [
		'$http',
		'$q',
		'url',
		function($http, $q, url) {
			return {
				
				applicationforleave: function(leaveapplication){
					return $http.post(url+'testleave', leaveapplication)
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
				getleaveapp: function(leaveapplicationid){
					return $http.get(url+'getleaveapplication/'+ leaveapplicationid)
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
				getleaveapp: function(leaveapplicationid){
					return $http.get(url+'getleaveapplication/'+ leaveapplicationid)
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