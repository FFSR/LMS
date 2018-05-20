/**
 * 
 */
'use strict';

App
.factory(
		'leavehistoryService',
		[
			'$http',
			'$q',
			'url',
			function($http, $q, url) {
				return {

					leavehistory : function(userID) {
						return $http
						.get(
								url + 'leavehistory/'
								+ userID + '/')
								.then(
										function(response) {
											return response.data;
										},
										function(errResponse) {
											console
											.error("Error while fetching user info list.");
											return $q
											.reject(errResponse);
										});
					},
					
					leavebalanceforapply : function(userid, leavetypeid, leavetaken) {
						return $http
						.put(
								url + 'leavebalanceforapply/'
								+ userid +'/'+ leavetypeid +'/'+ leavetaken +'/')
								.then(
										function(response) {
											return response.data;
										},
										function(errResponse) {
											console
											.error("Error while fetching user info list.");
											return $q
											.reject(errResponse);
										});
					},
					
					leavebalanceforapprove : function(userid, leavetypeid, leaveapprove) {
						return $http
						.put(
								url + 'leavebalanceforapprove/'
								+ userid +'/'+ leavetypeid +'/'+ leaveapprove +'/')
								.then(
										function(response) {
											return response.data;
										},
										function(errResponse) {
											console
											.error("Error while fetching user info list.");
											return $q
											.reject(errResponse);
										});
					},
					
					leavebalanceforreject : function(userid, leavetypeid, leaverejected) {
						return $http
						.put(
								url + 'leavebalanceforreject/'
								+ userid +'/'+ leavetypeid +'/'+ leaverejected +'/')
								.then(
										function(response) {
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