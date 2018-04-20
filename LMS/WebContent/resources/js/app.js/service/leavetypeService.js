/**
 * 
 */
'use strict';

App.factory('leavetypeService', [
		'$http',
		'$q',
		'url',
		function($http, $q, url) {
			return {
				
				getLeaveType: function(){
					return $http.get(url+'getLeavetype/')
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