App
		.factory(
				'rptleavestatusService',
				[
						'$http',
						'$q',
						'url',
						function($http, $q, url) {
							return {

								getleavestatus : function(userID) {
									return $http.get(url + 'report/'+ userID)
											.then(
													function(response) {
														return response.data;
													},
													function(errResponse) {
														console
																.log("Error while fetching user info list.");
														return $q
																.reject(errResponse);
													});
								},
								
								getdatewiseleavestatus : function(userID,startdate,enddate) {
									return $http.get(url + 'report/'+ userID + '/' + startdate + '/' + enddate +'/')
											.then(
													function(response) {
														return response.data;
													},
													function(errResponse) {
														console
																.log("Error while fetching user info list.");
														return $q
																.reject(errResponse);
													});
								},

							}
						} ]);