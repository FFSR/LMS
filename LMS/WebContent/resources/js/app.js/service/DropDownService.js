/* Service Code */
'use strict';
 
App.factory('DropDownService', ['$http', '$q', 'url',function($http, $q, url){
    return {
    	getAllDropdown: function(){
    		return $http.get(url+'getDropdownData/')
    				.then(
    						function(response){
    							return response.data;
    						},
    						function(errResponse){
                                console.error('Error while fetching DropDown Data');
                                return $q.reject(errResponse);
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
	
	getMoonOptions: function(dropdownname){
		return $http.get(url+'getDropdownDataByName/' + dropdownname)// Fetching holiday Moon from lms_dropdown table.
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
	
	getNationalityOption: function(dropdownname){
		return $http.get(url+'getDropdownDataByName/' + dropdownname)// Fetching holiday Moon from lms_dropdown table.
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
	
	getGenderOption: function(dropdownname){
		return $http.get(url+'getDropdownDataByName/' + dropdownname)// Fetching holiday Moon from lms_dropdown table.
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
    
}]);