/**
 * 
 */
'use strict';

App.factory('userlistService', [
		'$http',
		'$q',
		'url',
		function($http, $q, url) {
			return {
				
				getUserList: function(){
					return $http.get(url+'getUserlist/')
					.then(function(response) {
						return response.data;
					},
					function(errResponse) {
						console
								.error('Error while fetching leave type list.');
						return $q
								.reject(errResponse);
					});
				},
				
				
			}
		} ]);