/**
 * 
 */
'use strict';

App.factory('testService', [
		'$http',
		'$q',
		'url',
		function($http, $q, url) {
			return {
				
				login: function(networkId,password){
					return $http.get(url+'login/'+networkId+'/'+password+'/')
					.then(function(response) {
						return response.data;
					},
					function(errResponse) {
						console
								.error('Error while fetching user info list.');
						return $q
								.reject(errResponse);
					});
				},
				
				
			}
		} ]);