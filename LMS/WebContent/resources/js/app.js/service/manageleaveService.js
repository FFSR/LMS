/**
 * 
 */
'use strict';

App.factory('manageleaveService', [
		'$http',
		'$q',
		'url',
		function($http, $q, url) {
			return {
				
				manageleave: function(search){
					return $http.post(url+'manageleave/',search)
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
				loadCurrentLeaveApplication: function(userid){
					return $http.get(url+'loadCurrentLeaveApplication/'+userid)
					.then(function(response) {
						return response.data;
					},
					function(errResponse) {
						console
								.error("Error while fetching WF Request.");
						return $q
								.reject(errResponse);
					});
				},
				
				//Added by Feroj on 20th June,2018
				loadCancelLeaveApplication: function(userid){
					return $http.get(url+'loadCancelLeaveApplication/'+userid)
					//return $http.get(url+'loadCurrentLeaveApplication/'+userid)
					.then(function(response) {
						return response.data;
					},
					function(errResponse) {
						console
								.error("Error while fetching WF Request.");
						return $q
								.reject(errResponse);
					});
				},
				
				
				updateWFRequestHop: function(userID,wfRequestHopid,status, wfRequestHop){
					return $http.put(url+'updaterequesthope/'+userID+'/'+wfRequestHopid+'/'+status+'/',wfRequestHop)
					.then(function(response) {
						return response.data;
					},
					function(errResponse) {
						console
								.error("Error while fetching WF Request Hops.");
						return $q
								.reject(errResponse);
					});findByRoleMapAndStatusWithOutCancel
				},
				getAttachment: function(leaveapplicationid){
					return $http.get(url+'getAttachment/'+ leaveapplicationid)
					.then(function(response) {
						return response.data;
					},
					function(errResponse) {
						console
								.error("Error while fetching attachment list.");
						return $q
								.reject(errResponse);
					});
				},
			}
		} ]);