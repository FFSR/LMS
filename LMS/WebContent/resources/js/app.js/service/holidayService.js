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
			
			getHolidayOptions: function(dropdownname){
				return $http.get(url+'getDropdownDataByName/' + dropdownname)// Fetching holiday options from lms_dropdown table.
				.then(function(response) {
					return response.data;
				},
				function(errResponse) {
					console
							.error('Error while fetching option type list.');
					return $q
							.reject(errResponse);
				});
			},
			
		}
		} ]);