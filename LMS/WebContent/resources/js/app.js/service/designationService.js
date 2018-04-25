/* Service Code */
'use strict';
 
App.factory('DesignationService', ['$http', '$q', 'url',function($http, $q, url){
    return {
    	getAllDesignation: function(){
    		return $http.get(url+'getAllDesignationData/')
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