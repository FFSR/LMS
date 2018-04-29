/**
 * 
 */
'use strict';

App.factory('holidayService', [
		'$http',
		'$q',
		'url',
		function($http, $q, url) {
			return {
				
				holidaymanagement: function(holidayrecord){
					return $http.post(url+'holidaymanagement', holidayrecord)
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
				
			holidaygridshow: function(){
				return $http.get(url+'getHolidayList/')
				.then(function(response) {
					return response.data;
				},
				function(errResponse) {
					console
							.error('Error while fetching holiday list.');
					return $q
							.reject(errResponse);
				});
			},
			
		}
		} ]);