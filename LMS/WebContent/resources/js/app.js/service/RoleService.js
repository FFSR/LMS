/* Service Code */
'use strict';
 
App.factory('RoleService', ['$http', '$q', 'url',function($http, $q, url){
    return {
    	getAllRole: function(){
    		return $http.get(url+'getAllRoleData/')
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