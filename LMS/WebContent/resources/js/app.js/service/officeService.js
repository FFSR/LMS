/* Service Code */
'use strict';
 
App.factory('OfficeService', ['$http', '$q', 'url',function($http, $q, url){
    return {
    	getAllOffice: function(){
    		return $http.get(url+'getAllOfficeData/')
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