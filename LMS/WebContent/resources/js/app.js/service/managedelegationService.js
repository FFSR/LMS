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
				
				getUserDelegationInfo: function(userID){
					return $http.get(url+'wftdelegationbyuser/' + userID + '/')
					
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
				
				addReliever: function(loginUserID, releiverid, fromDate,toDate,listLmsWftRoleUserMap){
					//return $http.post(url+'wftrolebydelegateuser/'+ loginUserID +'/'+ releiverid +'/', listLmsWftRoleUserMap)
					return $http.post(url+'wftrolebydelegateuser/'+ loginUserID +'/'+ releiverid +'/' + fromDate +'/' + toDate , listLmsWftRoleUserMap)
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
				
				deleteReliever: function(userid,delegatebyid){
					return $http.delete(url+'wftrolebydelegateuser/' + userid +'/'+ delegatebyid +'/')
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
				
			}
		} ]);