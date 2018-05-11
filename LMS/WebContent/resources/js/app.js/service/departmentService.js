/* Service Code */
'use strict';
 
App.factory('DepartmentService', ['$http', '$q', 'url',function($http, $q, url){
    return {
    	getAllDepartment: function(){
    		return $http.get(url+'getAllDepartmentData/')
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