<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<!--Start bootstrap stuff -->

<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<script src="resources/js/jquery-3.2.1.slim.min.js"></script>
<script src="resources/js/popper.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>

<!-- End bootstrap stuff -->

<script type="text/javascript"
	src="resources/js/app.js/service/forgetpasswordService.js"></script>
<script type="text/javascript"
	src="resources/js/app.js/controller/forgetpasswordController.js"></script>

</head>
<body>
	<div class="container-fluid" ng-controller="ForgetPasswordController">
		<div id="forgotModal">
			<div class="dialog">

				<!-- Modal content-->
				<div class="content">
					<div class="header">
						<h4 class="modal-title">Forgot Password...</h4>
					</div>
					<div class="modal-body">
						<form role="form" name="myform">
							<div class="form-group">
								<label for="email">Email ID:</label> <input type="email"
									ng-model="emailid" class="form-control" id="email" required />
								<span class="error" ng-show="myForm.input.$error.email">
									Not valid email!</span>
							</div>
							<button type="submit" class="btn btn-default"
								ng-click="forgetpassword(emailid)">Submit</button>
						</form>
						<div>Response: {{testMsg}}</div>
					</div>
				</div>

			</div>
		</div>



	</div>
</body>
</html>