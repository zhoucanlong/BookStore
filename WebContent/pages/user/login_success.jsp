<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>
<%@include file="/include/base.jsp"%>

<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	h1 a {
		color:red;
		font-size:50px;
	}
</style>
</head>
<body style="background-image:url(static/img/4.png);background-size:100% 130%">
	<div id="header">
			<!--<img class="logo_img" alt="" src="static/img/logo.gif" > -->	
				<%@include file="/include/user-info.jsp"%>
	</div>	
	<div id="main">	
			<h1 style="color:white;">欢迎回来 <a href="index.jsp">转到主页</a></h1>
	</div>
	
	<div id="bottom">
			<span>
				应尽书城.Copyright &copy;2020
			</span>
	</div>
</body>
</html>