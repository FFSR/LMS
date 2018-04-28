<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" type="image/png" sizes="16x16" href="resources/images/favicon.png">
    <title>Elite Admin Template - The Ultimate Multipurpose admin template</title>
    <!-- Bootstrap Core CSS -->
    <link href="resources/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/bower_components/bootstrap-extension/css/bootstrap-extension.css" rel="stylesheet">
    <!-- Menu CSS -->
    <link href="resources/bower_components/sidebar-nav/dist/sidebar-nav.min.css" rel="stylesheet">
    <!-- toast CSS -->
    <link href="resources/bower_components/toast-master/css/jquery.toast.css" rel="stylesheet">
    <!-- morris CSS -->
    <!-- <link href="resources/bower_components/morrisjs/morris.css" rel="stylesheet"> -->
    <!-- animation CSS -->
    <link href="resources/css/animate.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="resources/css/style.css" rel="stylesheet">
    <!-- color CSS -->
    <link href="resources/css/colors/default-dark.css" id="theme" rel="stylesheet">
    <!-- <link href="resources/css/colors/blue.css" id="theme" rel="stylesheet"> -->
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
    <!-- jQuery -->
    <script src="resources/bower_components/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="resources/bootstrap/dist/js/tether.min.js"></script>
    <script src="resources/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="resources/bower_components/bootstrap-extension/js/bootstrap-extension.min.js"></script>
    <!-- Menu Plugin JavaScript -->
    <script src="resources/bower_components/sidebar-nav/dist/sidebar-nav.min.js"></script>
    <!--slimscroll JavaScript -->
    <script src="resources/js/jquery.slimscroll.js"></script>
    <!--Wave Effects -->
    <script src="resources/js/waves.js"></script>
    <!--Counter js -->
    <script src="resources/bower_components/waypoints/lib/jquery.waypoints.js"></script>
    <script src="resources/bower_components/counterup/jquery.counterup.min.js"></script>
    <!--Morris JavaScript -->
    <script src="resources/bower_components/raphael/raphael-min.js"></script>
    <!-- <script src="resources/bower_components/morrisjs/morris.js"></script> -->
    <!-- Custom Theme JavaScript -->
    <script src="resources/js/custom.min.js"></script>
    <!-- <script src="resources/js/dashboard1.js"></script> -->
    <!-- Sparkline chart JavaScript -->
    <script src="resources/bower_components/jquery-sparkline/jquery.sparkline.min.js"></script>
    <script src="resources/bower_components/jquery-sparkline/jquery.charts-sparkline.js"></script>
    <script src="resources/bower_components/toast-master/js/jquery.toast.js"></script>
    <!--Style Switcher -->
    <script src="resources/bower_components/styleswitcher/jQuery.style.switcher.js"></script>
<!-- Angular Stuff -->
<!-- <script type="text/javascript" src="resources/js/ng-table.min.js"></script>
<link href="resources/css/ng-table.min.css"> -->
<!-- <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
<script type="text/javascript" src="resources/js/app.js/app.js"></script> -->
<script type="text/javascript" src="resources/js/angular.min.js"></script>
<script type="text/javascript" src="resources/js/app.js/app.js"></script>
</head>

<body ng-app="myApp">
    <!-- Preloader -->
    <div class="preloader">
        <div class="cssload-speeding-wheel"></div>
    </div>
    <div id="wrapper">
        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top m-b-0">
            <div class="navbar-header"> <a class="navbar-toggle hidden-sm hidden-md hidden-lg " href="javascript:void(0)" data-toggle="collapse" data-target=".navbar-collapse"><i class="ti-menu"></i></a>
                <div class="top-left-part"><a class="logo" href="index.html"><b><!--This is dark logo icon--><img src="resources/images/eliteadmin-logo.png" alt="home" class="dark-logo" /><!--This is light logo icon--><img src="resources/images/eliteadmin-logo-dark.png" alt="home" class="light-logo" /></b><span class="hidden-xs"><!--This is dark logo text--><img src="resources/images/eliteadmin-text.png" alt="home" class="dark-logo" /><!--This is light logo text--><img src="resources/images/eliteadmin-text-dark.png" alt="home" class="light-logo" /></span></a></div>
                <ul class="nav navbar-top-links navbar-left hidden-xs">
                    <li><a href="javascript:void(0)" class="open-close hidden-xs waves-effect waves-light"><i class="icon-arrow-left-circle ti-menu"></i></a></li>
                </ul>
                <ul class="nav navbar-top-links navbar-right pull-right">
                    <!-- /.dropdown -->
                    <!-- /.dropdown -->
                    <!-- .Megamenu -->
                    <!-- /.Megamenu -->
                    <!-- /.dropdown -->
                </ul>
            </div>
            <!-- /.navbar-header -->
            <!-- /.navbar-top-links -->
            <!-- /.navbar-static-side -->
        </nav>
        <!-- Left navbar-header -->
        <div class="navbar-default sidebar" role="navigation">
            <div class="sidebar-nav navbar-collapse slimscrollsidebar">
                <div class="user-profile">
                    <div class="dropdown user-pro-body">
                        <div><img src="resources/images/users/varun.jpg" alt="user-img" class="img-circle"></div> <a href="#" class="dropdown-toggle u-dropdown" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Steave Gection <span class="caret"></span></a>
                        <ul class="dropdown-menu animated flipInY">
                            <li><a href="login.html"><i class="fa fa-power-off"></i> Logout</a></li>
                        </ul>
                    </div>
                </div>
                <ul class="nav" id="side-menu">
                    <li class="sidebar-search hidden-sm hidden-md hidden-lg">
                        <!-- input-group -->
                        <div class="input-group custom-search-form">
                            <input type="text" class="form-control" placeholder="Search..."> <span class="input-group-btn">
            <button class="btn btn-default" type="button"> <i class="fa fa-search"></i> </button>
            </span> </div>
                        <!-- /input-group -->
                    </li>
                    <li class="nav-small-cap m-t-10">--- Main Menu</li>
                    <li> <a href="employeehomepage" class="waves-effect"><i data-icon="v" class="linea-icon linea-basic fa-fw"></i><span class="hide-menu" >Home</span></a> </li>
                    <li> <a href="javascript:void(0);" class="waves-effect"><i class="linea-icon linea-basic fa-fw text-danger" data-icon="7"></i> <span class="hide-menu text-danger"> Leave Management <span class="fa arrow"></span></span></a>
                        <ul class="nav nav-second-level">
                            <li> <a href="applicationforleave">Application For Leave</a> </li>
                            <li role="separator" class="divider"></li>
                            <li> <a href="leavemanagementhead">Approve Leave</a></li>
                        </ul>
                    </li>
                    
                    <li> <a href="leavehistory" class="waves-effect"><i data-icon="v" class="linea-icon linea-basic fa-fw"></i><span class="hide-menu" >Leave History</span></a> </li>
                    
                    <li> <a href="#" class="waves-effect"><i data-icon=")" class="linea-icon linea-basic fa-fw"></i> <span class="hide-menu">Reports<span class="fa arrow"></span></span></a>
                        <ul class="nav nav-second-level">
                            <li><a href="rptleavestatus">Leave Status</a></li>
                        </ul>
                    </li>
                    
                    <li> <a href="#" class="waves-effect"><i data-icon="/" class="linea-icon linea-basic fa-fw"></i> <span class="hide-menu">Maintainance<span class="fa arrow"></span></span></a>
                        <ul class="nav nav-second-level">
                            <li><a href="manageuser">Manage User</a></li>
                            <li><a href="manageusersearch">Search User</a></li>
                            <li><a href="divisioninfo">Division</a></li>
                            <li><a href="ministryinfo">Ministry</a></li>
                            <li><a href="holidaymanagement">Holiday</a></li>
                        </ul>
                    </li>
                    <li> <a href="forms.html" class="waves-effect"><i data-icon="&#xe00b;" class="linea-icon linea-basic fa-fw"></i> <span class="hide-menu">User Management<span class="fa arrow"></span></span></a>
                        <ul class="nav nav-second-level">
                            <li><a href="changepassword">Change Password</a></li>
                            <li><a href="userprofile">Update Profile</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
        <!-- Left navbar-header end -->
        <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                	<div class="col-md-12 col-lg-12 col-sm-12">
                	<br/>
                		<div class="white-box">
                    		<tiles:insertAttribute name="body" />
                    	</div>
                    </div>
                </div>
                <!-- /.row -->
                <!--row -->
                <!-- /.row -->
                <!--row -->
                <!-- /.row -->
                <!--row -->
                <!-- row -->
                <!-- /.row -->
                <!-- .right-sidebar -->
                <!-- /.right-sidebar -->
            </div>
            <!-- /.container-fluid -->
            <footer class="footer text-center"> 2017 &copy; Elite Admin </footer>
        </div>
        <!-- /#page-wrapper -->
    </div>
    <!-- /#wrapper -->
</body>

</html>
