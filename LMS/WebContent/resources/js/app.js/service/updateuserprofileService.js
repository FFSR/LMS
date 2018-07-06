/**
 * 
 */
'use strict';

App
		.factory(
				'updateuserprofileService',
				[
						'$http',
						'$q',
						'url',
						function($http, $q, url) {
							return {

								updateuserprofile : function(lmssupervisor, userWrapper ) {
									//console.log(user);
									
									// Added by Feroj on 12th June,2018. If supervisor is null, update shud be successfull
								if (lmssupervisor == null || lmssupervisor=="undefined")
									{
									lmssupervisor.id=0;
									}
									
									return $http.post(url + 'updateuserprofile/'+ lmssupervisor.id + '/', userWrapper)		
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
								
								updateuserprofile : function(lmssupervisor, userWrapper ) {
									//console.log(user);
									
									// Added by Feroj on 12th June,2018. If supervisor is null, update shud be successfull
								if (lmssupervisor.id== null || lmssupervisor.id=="undefined")
									{
									lmssupervisor.id=0;
									}
									
									return $http.post(url + 'updateuserprofile/'+ lmssupervisor.id + '/', userWrapper)		
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