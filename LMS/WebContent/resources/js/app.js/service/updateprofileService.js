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

			updateprofile : function(user) {
				// console.log(user);
				// , lmsWftrole user, , user lmsWftrole
				return $http.post(url + 'updateprofile/', user).then(
						function(response) {
							return response.data;
						}, function(errResponse) {
							return $q.reject(errResponse);
						});
			},

		}
	} ]);