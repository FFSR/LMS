<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


<script type="text/javascript"
	src="resources/js/app.js/service/manageuserService.js"></script>	
<script type="text/javascript"
	src="resources/js/app.js/controller/managedelegationController.js"></script>
</head>
<body>
	<div ng-controller="managedelegationController">
		<div ng-init="getUserInfo('${sessionScope.user.id}');getRoleInfo('${sessionScope.user.id}');loadUserListDropDown()"></div>
		<form class="form-horizontal">
			<div class="form-body">
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label class="control-label col-md-3">User Name</label>
							<div class="col-md-9">
								<input type="text" ng-model="name"
									class="form-control" placeholder="User ID">
							</div>
						</div>
					</div>

					<div class="col-md-6">
						<div class="form-group">
							<label class="control-label col-md-3">Department</label>
							<div class="col-md-9">
								<input type="text" ng-model="departmentname" class="form-control"
									placeholder="User Name">
							</div>
						</div>
					</div>
				</div>
				<div class="row">
				    <div class="col-md-6">
						<div class="form-group">
							<label class="control-label col-md-3">Section Name</label>
							<div class="col-md-9">
								<input type="text" ng-model="sectionname"
									class="form-control" placeholder="User ID">
							</div>
						</div>
					</div>

					<div class="col-md-6">
						<div class="form-group">
							<label class="control-label col-md-3">Mobile</label>
							<div class="col-md-9">
								<input type="text" ng-model="mobilePersonal" class="form-control"
									placeholder="User Name">
							</div>
						</div>
					</div>
				</div>
				<div class="row">
				    <div class="col-md-6">
						<div class="form-group">
							<label class="control-label col-md-3">Roles</label>
							<div class="col-md-9">
								<input type="text" ng-model="userid"
									class="form-control" placeholder="User ID">
							</div>
						</div>
					</div>
			   </div>
				
			</div>
		</form>
		
		<form class="form-horizontal">
			<div class="form-body">
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label class="control-label col-md-3">User Name</label>
							<div class="col-md-9">
								<input type="text" ng-model="name"
									class="form-control" placeholder="User ID">
							</div>
						</div>
					</div>

					<div class="col-md-6">
						<div class="form-group">
							<label class="control-label col-md-3">Department</label>
							<div class="col-md-9">
								<input type="text" ng-model="departmentname" class="form-control"
									placeholder="User Name">
							</div>
						</div>
					</div>
				</div>
				<div class="row">
				    <div class="col-md-6">
						<div class="form-group">
							<label class="control-label col-md-3">Section Name</label>
							<div class="col-md-9">
								<input type="text" ng-model="sectionname"
									class="form-control" placeholder="User ID">
							</div>
						</div>
					</div>

					<div class="col-md-6">
						<div class="form-group">
							<label class="control-label col-md-3">Mobile</label>
							<div class="col-md-9">
								<input type="text" ng-model="mobilePersonal" class="form-control"
									placeholder="User Name">
							</div>
						</div>
					</div>
				</div>
				<div class="row">
				    <div class="col-md-6">
						<div class="form-group">
							<label class="control-label col-md-3">Roles</label>
							<div class="col-md-9">
								<input type="text" ng-model="userid"
									class="form-control" placeholder="User ID">
							</div>
						</div>
					</div>
			   </div>
				
			</div>
		</form>
		
		
	</div>




	</div>
</body>
</html>