<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>




<script type="text/javascript"
	src="resources/js/app.js/service/homepagegridshowService.js"></script>
<script type="text/javascript"
	src="resources/js/app.js/controller/homepagegridshowController.js"></script>
<script type="text/javascript"
	src="resources/js/app.js/service/manageleaveService.js"></script>
<script src="angular.min.js"></script>
<script src="app.js"></script>

<style type="text/css">
.custom {
	font-family: Courier;
	color: red;
	font-size: 25px;
}


body {
	font-family:  Arial /*Poppins, sans-serif*/;
	color: #000;
}


body label {
	font-family:  Arial /*Poppins, sans-serif*/;
	color: #000;
	font-weight: bold;
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



</style>

</head>

<body ng-controller="homepagegridshowController as hp">
	<div ng-init="userAuthentication('${sessionScope.user.id}')"></div>

	<div
		ng-init="homepagegridshow();getSessionUserDetails('${sessionScope.user.name}','${sessionScope.user.lmsSection.name}','${sessionScope.user.fax}')"></div>
		<div ng-init="loadLeaveApplications('${sessionScope.userID}');"></div>
		<div ng-init="getMyPicture('${sessionScope.userID}');"></div>

	<div class="container-fluid">

		<div>
			<div class="row">
				<div class="col-md-4">
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<label class="control-label col-md-6">User Name</label>
								<div class="col-md-9">
									<input type="text" ng-model="name_n" class="form-control">
								</div>
							</div>
						</div>
						<div class="col-md-12">
							<div class="form-group">
								<label class="control-label col-md-6">Section Name</label>
								<div class="col-md-9">
									<input type="text" ng-model="sec_n" class="form-control">
								</div>
							</div>
						</div>
						<div class="col-md-12">
							<div class="form-group">
								<label class="control-label col-md-6">Approval Pending Count</label>
								<div class="col-md-9">
									<input type="text" ng-model="Aproval_Pending" class="form-control">
								</div>
							</div>
						</div>
					</div>
					
				</div>			    
					<div class="col-md-4">	
							<div class="row">
							
							<div class="col-md-6">
                                <img src="http://localhost:8080/LMS/displayImageServelet?filename={{picname}}" width="200" height="200">      
							</div>
							
							<div class="col-md-6">
                              <a href="resources/manuals/Manual_LMS.docm"><img src="resources/images/manual_icon_001.png" width="150" height="150"></a>      
							</div>	
							
						</div>	
					</div>
					
					<div class="col-md-4">	
							<div class="row">
									
							<div class="col-md-9">
                              <a href="resources/manuals/LeaveApprovalFlow.docx"><img src="resources/images/workflow.png" width="200" height="200"></a>	       
							</div>
						</div>	
					</div>
			</div>

			<br>
			<table class="table table-sm">
				<div>

					<!-- <label class="control-label col-md-3">Leave Notice Board</label> -->
					<h2 style="font-family: Arial; color: #000; font-size: 20px; font-wight: bold; ">Leave
						Notice Board</h2>

					<table ng-table="tableParams" class="table" show-filter="true">
						<tr ng-repeat="leaveapplication in $data">
							<td title="'Employee name'"
								filter="{'lmsUserByUserId.name': 'text'}" sortable="'name'">{{leaveapplication.lmsUserByUserId.name}}</td>

							<td title="'From Date'" filter="{ type: 'text'}"
								sortable="'lmsLeaveType.fromDate'">{{leaveapplication.fromDate
								| date: YYYY-MM-dd}}</td>

							<td title="'To Date'" filter="{ leaveTotal: 'text'}"
								sortable="'lmsLeaveType.toDate'">{{leaveapplication.toDate
								|date: YYYY-MM-dd}}</td>

							<td title="'Leave Type'" filter="{ 'lmsLeaveType.type': 'text'}"
								sortable="'leaveapplication.lmsLeaveType.type'">{{leaveapplication.lmsLeaveType.type}}</td>

							<td title="'Section'"
								filter="{ 'lmsUserByUserId.lmsSection.name': 'text'}"
								sortable="'name'">{{leaveapplication.lmsUserByUserId.lmsSection.name}}</td>
							<td title="'Department'"
								filter="{ 'lmsUserByUserId.lmsDepartment.name': 'text'}"
								sortable="'name'">{{leaveapplication.lmsUserByUserId.lmsDepartment.name}}</td>
							<td title="'Division'"
								filter="{ 'lmsUserByUserId.lmsDivision.name': 'text'}"
								sortable="'name'">{{leaveapplication.lmsUserByUserId.lmsDivision.name}}</td>
							<td title="'Reliever'"
								filter="{ 'leaveapplication.lmsUserByReliverEmailAddressUserId.name': 'text'}"
								sortable="'name'">{{leaveapplication.lmsUserByReliverEmailAddressUserId.name}}</td>
					</table>
				</div>
			</table>
		</div>

	</div>


</body>
</html>