/**
 * 
 */
'use strict';

App.factory('managedelegationService', [
		'$http',
		'$q',
		'url',
		function($http, $q, url) {
			return {
				
				getUserwiseRoleInfo: function(userID){
					return $http.get(url+'wftrolebyuser/' + userID + '/')
					.then(function(response) {
						return response.data;
					},
					function(errResponse) {
						console
								.error("Error while fetching user info list.");
						return $q
								.reject(errResponse);
					});
				},
				
				addReliever: function(loginUserID, releiverid, listLmsWftRoleUserMap){
					return $http.put(url+'wftrolebydelegateuser/'+loginUserID +'/'+releiverid+'/'+listLmsWftRoleUserMap+'/')
					.then(function(response) {
						return response.data;
					},
					function(errResponse) {
						console
								.error("Error while fetching WF Request Hops.");
						return $q
								.reject(errResponse);
					});
				},
				
			}
		} ]);