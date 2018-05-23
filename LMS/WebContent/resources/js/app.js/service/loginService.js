/**
 * 
 */
'use strict';

App.factory('loginService', [
		'$http',
		'$q',
		'url',
		function($http, $q, url) {
			return {
				
				login: function(username,password){
					return $http.get(url+'login/'+username+'/'+password+'/')
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
				
				//login.java  /getauthorised/{userid}/{pageid}/
				
				getauthorised: function(userid, pageid){
					return $http.get(url+'getauthorised/'+ userid +'/'+ pageid +'/')
					.then(function(response) {
						return response.data;
					},
					function(errResponse) {
						return $q.reject(errResponse);
					});
				},				
				
			}
		} ]);