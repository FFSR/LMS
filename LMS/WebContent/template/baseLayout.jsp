<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Cache-control" content="no-cache">
<meta http-equiv="Expires" content="-1">
<meta http-equiv='pragma' content='no-cache'>
<title>LMS</title>
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">

<script type="text/javascript" src="resources/js/angular.min.js"></script>
<script type="text/javascript" src="resources/js/app.js/app.js"></script>

</head>
<body class="hold-transition skin-blue sidebar-mini" style="zoom: 0.8;"
	ng-app="myApp">
	<tiles:insertAttribute name="menu" />
	<tiles:insertAttribute name="body" />
</body>
</html>

