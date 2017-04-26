<!DOCTYPE HTML>
<html ng-app="taskApp">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>任务管理系统|</title>
		<link ng-if="isLogined" rel="stylesheet" type="text/css" href="css/core.css" />
		<link rel="stylesheet" type="text/css" href="css/main.css">
	</head>

<body>
<div ng-show="isLogined" ng-controller="AppController" class="top">
	<div class="topIn">任务管理系统<span><a ui-sref="boards" style="text-decoration: none;">任务看板</a></span> <span style="margin-left: 300px;" >欢迎 <strong ng-bind="user.userName" ></strong> 登录</span>
	<a class="loginBtn" style="float: right; " href="javascript:;" ng-click="logout()" >退出</a></div>
</div>
	
	<!-- 变更主体 -->
	<div ui-view="left" ></div>
	<div ui-view="main" ></div>

<div class="footer">版权所有 &copy; 2017 </div>

		<script type="text/javascript" src="js/lib/angular.js" ></script>
		<script type="text/javascript" src="js/lib/angular-ui-router.js" ></script>
		<script type="text/javascript" src="js/config.js" ></script>
		<script type="text/javascript" src="js/app.js" ></script>
		<script type="text/javascript" src="js/ctrls/appController.js" ></script>
		<script type="text/javascript" src="js/ctrls/loginController.js" ></script>
		<script type="text/javascript" src="js/ctrls/leftController.js" ></script>
		<script type="text/javascript" src="js/ctrls/boardController.js" ></script>
		<script type="text/javascript" src="js/lib/angular-sortable-view.min.js" ></script>
		<script type="text/javascript" src="js/ctrls/jobBoxController.js" ></script>
		
</body>
</html>
