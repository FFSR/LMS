/**
 * 
 */
'use strict';

App.factory('wfrequesthopService', [
		'$http',
		'$q',
		'url',
		function($http, $q, url) {
			return {
				
				getHopsinfo: function(wfrequestid){
					return $http.get(url+'getHopsinfo/'+ wfrequestid)
					.then(function(response) {
						return response.data;
					},
					function(errResponse) {
						return $q
								.reject(errResponse);
					});
				},
				
				
			}
		} ]);