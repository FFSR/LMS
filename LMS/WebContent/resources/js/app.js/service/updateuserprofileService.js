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

								updateuserprofile : function(lmsWftrole,
										lmsRole, user) {
									// console.log(user);
									// , lmsWftrole user, , user lmsWftrole
									return $http
											.post(
													url + 'updateuserprofile/'
															+ lmsWftrole.id
															+ '/' + lmsRole.id
															+ '/', user)
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