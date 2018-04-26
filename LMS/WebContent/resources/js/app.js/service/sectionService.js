/* Service Code */
'use strict';
 
App.factory('SectionService', ['$http', '$q', 'url',function($http, $q, url){
    return {
    	getAllSection: function(){
    		return $http.get(url+'getAllSectionData/')
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