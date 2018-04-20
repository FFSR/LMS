/* Service Code */
'use strict';
 
App.factory('MinistryService', ['$http', '$q', 'url',function($http, $q, url){
    return {
    	getAllMinistry: function(){
    		return $http.get(url+'getAllMinistryData/')
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