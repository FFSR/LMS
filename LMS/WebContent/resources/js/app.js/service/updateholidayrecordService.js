/**
 * 
 */
'use strict';

App.factory('updateholidayrecordService', [
		'$http',
		'$q',
		'url',
		function($http, $q, url) {
			return {
				
				updateholidayrecord: function(holidayrecord){
					console.log(holidayrecord);
					return $http.put(url+'updateholidayrecord',holidayrecord)
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