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
											.get(url + 'leavehistory/' + userID +'/')
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