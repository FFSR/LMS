App
		.factory(
				'eventlogService',
				[
						'$http',
						'$q',
						'url',
						function($http, $q, url) {
							return {
								
								getdatewiseeventlog : function(startdate,enddate) {
									//return $http.get(url + 'eventlog/'+ startdate + '/' + enddate +'/')
									return $http.get(url + 'eventlog/'+ startdate + '/' + enddate )
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