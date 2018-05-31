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
				
				getmanageuser: function(userName, mobile, status){
					return $http.get(url+'manageuser/'+ userName +'/'+ mobile +'/'+ status +'/')
					.then(function(response) {
						return response.data;
					},
					function(errResponse) {
						return $q
								.reject(errResponse);
					});
				},
				
				manageuser: function(userid){
					return $http.get(url+'manageuserid/'+ userid)
					.then(function(response) {
						return response.data;
					},
					function(errResponse) {
						return $q
								.reject(errResponse);
					});
				},
				
				
			}
		} ]);