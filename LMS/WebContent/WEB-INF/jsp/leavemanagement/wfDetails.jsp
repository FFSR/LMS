<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript"
	src="resources/js/app.js/service/manageleaveService.js"></script>
<script type="text/javascript"
	src="resources/js/app.js/controller/leaveApplicationDetailsController.js"></script>
</head>
<body>
	<div ng-controller="leaveApplicationDetailsController">
		Test wfID= ${requestScope.wfID}
		<div ng-init="viewAttachment(${requestScope.leaveApplication})"></div>
		//Tets:{{test}}
		<div class="row">
			<div class="col-md-12 form-group">
				<label class="col-md-2 control-label">Download Files: </label>
				<div class="col-md-10" style="height: 150px; overflow: scroll;">
					<ul class="list-group" ng-repeat="file in fileNames">
						<li class="list-group-item"><a
							href="download?fileName={{file}}">{{file}}</a></li>
					</ul>
				</div>
			</div>

		</div>

	</div>
</body>
</html>