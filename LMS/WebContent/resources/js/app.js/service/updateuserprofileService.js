/**
 * 
 */
'use strict';

App.factory(
				'updateuserprofileService',
				[
						'$http',
						'$q',
						'url',
						function($http, $q, url) {
							return {

								updateuserprofile : function(user, lmsRole, lmsWftrole) {
									//console.log(user);
									// , lmsWftrole  user,  , user
									return $http.post(url + 'updateuserprofile/'+ lmsRole.id +'/'+ lmsWftrole.id,user)
											.then(
													function(response) {
														return response.data;
													},
													function(errResponse) {
														console.error("Error while fetching user info list.");
														return $q
																.reject(errResponse);
													});
								},

							}
						} ]);