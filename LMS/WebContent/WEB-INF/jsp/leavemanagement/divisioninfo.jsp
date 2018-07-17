<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Division Information</title>

<script type="text/javascript"
	src="resources/js/app.js/service/loginService.js"> </script>
<script type="text/javascript"
	src="resources/js/app.js/controller/divisioninfoController.js"></script>
<script type="text/javascript"
	src="resources/js/app.js/service/divisioninfoService.js"></script>
	
	<style type="text/css">
.custom {
	font-family: Courier;
	color: red;
	font-size: 20px;
}


body {
	font-family:  Arial /*Poppins, sans-serif*/;
	color: #000;
}


body label {
	font-family:  Arial /*Poppins, sans-serif*/;
	color: #000;
	font-weight: bold;
	margin-left: .5em;
}

.ng-table-header {
	font-family:  Arial /*Poppins, sans-serif*/;
	color: #000;
	font-weight: bold;
}

.line_hight h4 {
	font-family:  Arial;
	color: #000;
	line-height: 35px;
	padding-top: 25px;
}

.btn_tf {
	border-radius: 0px;
	border: thin solid #027C05;
	color: #027C05;
	padding: 0 30px;
    transition: all 0.3s ease 0s;
	-o-transition: all 0.3s ease 0s;
	-ms-transition: all 0.3s ease 0s;
	-moz-transition: all 0.3s ease 0s;
	-webkit-transition: all 0.3s ease 0s;
	padding: 5px 20px;
}

.btn_tf:focus {
	border-radius: 30px;
	background: #02C800;
	color: #fff;
    transition: all 0.6s ease 0s;
	-o-transition: all 0.6s ease 0s;
	-ms-transition: all 0.6s ease 0s;
	-moz-transition: all 0.6s ease 0s;
	-webkit-transition: all 0.6s ease 0s;
}

.btn_tf:hover {
	border-radius: 30px;
	background: #084301;
	color: #fff;
    transition: all 0.6s ease 0s;
	-o-transition: all 0.6s ease 0s;
	-ms-transition: all 0.6s ease 0s;
	-moz-transition: all 0.6s ease 0s;
	-webkit-transition: all 0.6s ease 0s;
}

.btn_tf_red {
	background: #ffo;
}

.link_black a {
	color: #000;
}


</style>
	


</head>
<body>
	<div ng-controller="divisioninfoController">
		<div ng-init="userAuthentication('${sessionScope.user.id}')"></div>
			<div ng-init="divisionlistshow()"></div>
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-3" style="background-color: white;">Division
					Name</div>
				<div class="col-sm-3" style="background-color: white;">
					<input type="text" ng-model="name" class="form-control"
						placeholder="Division Name">
				</div>

			</div>
			<br>
			<div class="row">
				<button type="submit" class="btn btn_tf btn-success waves-effect waves-light m-r-10" id="submit" 
					ng-click="divisioninfo()">Submit</button>
				<div class="col-sm-3" style="background-color: white;">
					<input type="button" class="btn btn_tf btn-info" value="Cancel">
				</div>
				<div class="col-sm-3" style="background-color: white;"></div>
			</div>

			<div class="row">
				<div class="col-md-12">
					<div id="successMssages" class="p-3 mb-2 bg-success text-white"
						data-ng-show="successMessages" data-ng-bind="successMessages"></div>
					<div id="errorMessages" class="p-3 mb-2 bg-danger text-white"
						data-ng-show="errorMessages" data-ng-bind="errorMessages"></div>
				</div>
			</div>
			
			<div>
			<br>
			<table class="table table-sm">
				<div>
					Division Names
					<table ng-table="tableParams" class="table" show-filter="true">
						<tr ng-repeat="division in $data">
							<td title="'Division Name'" filter="{name: 'text'}" sortable="'name'">{{division.name}}</td>
							
							<td title="'Action'"><button class="btn-primary"
									ng-click="deleteDivision(division)">Delete</button></td>
					</table>
				</div>
			</table>
		</div>
		</div>
	</div>
</body>
</html>