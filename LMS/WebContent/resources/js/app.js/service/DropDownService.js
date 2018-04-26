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
    						}
    						);
    	}
    };
}]);