/**
 * 
 */
'use strict';

App.factory('updateprofileService', [
	'$http',
	'$q',
	'url',
	function($http, $q, url) {
		return {

			updateprofile : function(userID,user) {
				
				return $http.post(url+'updateprofile/'+userID+'/',user).then(
						function(response) {
							return response.data;
						}, function(errResponse) {
							return $q.reject(errResponse);
						});
			},

		}
	} ]);