<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>




<script type="text/javascript"
	src="resources/js/app.js/service/changepasswordService.js"></script>
<script type="text/javascript"
	src="resources/js/app.js/controller/changepasswordController.js"></script>



<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<script src="resources/js/jquery-3.2.1.slim.min.js"></script>
<script src="resources/js/popper.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>

</head>

<body>

<div ng-controller="changepasswordController">
<form class="form-horizontal" name="changepasswordForm">
<div class="container-fluid">
<br>

	<div class="row">		
  		<div class="col-sm-2" style="background-color: white;">Old Password</div> 
		<div class="col-sm-2" style="background-color: white;">		
		<input type="password" ng-model="oldpassword" ng-required="true" class="form-control" placeholder="Old Password">		
		</div> 	
	</div><br>
	
	<div class="row">
		<div class="col-sm-2" style="background-color: white;">New Password</div>
		<div class="col-sm-2" style="background-color: white;">
		<input type="password" ng-model="newpassword" ng-required="true" class="form-control" placeholder="New Password">
		</div>
	</div><br>
	
	<div class="row">
		<div class="col-sm-2" style="background-color: white;">Confirm Password</div>
		<div class="col-sm-2" style="background-color: white;">
		<input type="password" ng-model="confirmpassword" ng-required="true" class="form-control" placeholder="Confirm Password">
		</div> 
	</div>
	
	<br><br>

<script language="javascript">
function fncSubmit()
{

if(document.ChangePasswordForm.OldPassword.value == "")
{
alert('Please input old password');
document.ChangePasswordForm.OldPassword.focus();
return false;
} 

if(document.ChangePasswordForm.newpassword.value == "")
{
alert('Please input Password');
document.ChangePasswordForm.newpassword.focus(); 
return false;
} 

if(document.ChangePasswordForm.conpassword.value == "")
{
alert('Please input Confirm Password');
document.ChangePasswordForm.conpassword.focus(); 
return false;
} 

if(document.ChangePasswordForm.newpassword.value != document.ChangePasswordForm.conpassword.value)
{
alert('Confirm Password Not Match');
document.ChangePasswordForm.conpassword.focus(); 
return false;
} 

document.ChangePasswordForm.submit();
}
</script>

		 
										    
 		<button type="submit" class="btn" id="changepassword" onclick="return fncSubmit()"
										ng-click="changepassword(newpassword)" ng-disabled="changepasswordForm.$invalid">Submit</button>	
		
		<button type="button" class="btn">Cancel</button>
		<div>Response: {{testMsg}}</div>
		
</div>



</form>

<div class="row">
			<div class="col-md-12">
				<div id="successMssages" class="p-3 mb-2 bg-success text-white"
					
					data-ng-show="successMessages" data-ng-bind="successMessages"></div>
				<div id="errorMessages" class="p-3 mb-2 bg-danger text-white"
					data-ng-show="errorMessages" data-ng-bind="errorMessages"></div>
			</div>
		</div>


</div>	
</body>
</html>