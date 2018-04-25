/* Service Code */
'use strict';
 
App.factory('DivisionService', ['$http', '$q', 'url',function($http, $q, url){
    return {
    	getAllDivision: function(){
    		return $http.get(url+'getAllDivisionData/')
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