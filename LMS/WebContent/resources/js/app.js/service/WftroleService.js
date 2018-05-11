/* Service Code */
'use strict';
 
App.factory('WftroleService', ['$http', '$q', 'url',function($http, $q, url){
    return {
    	getAllWftrole: function(){
    		return $http.get(url+'getAllWftroleData/')
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