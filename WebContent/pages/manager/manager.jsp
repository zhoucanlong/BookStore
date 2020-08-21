<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>后台管理</title>
<%@include file="/include/base.jsp"%>

<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
</head>
<body style="background-image:url(static/img/14.png);background-size:100% 130%">
	
	<div id="header">
			<!--<img class="logo_img" alt="" src="static/img/logo.gif" >  -->
			<!--<span class="wel_word" style="color:white">后台管理系统</span>  -->
			<%@include file="/include/book-manager.jsp" %>

	</div>
	
	<div id="main">
		<h1 style="color:white">欢迎管理员进入后台管理系统</h1>
	</div>
	
	<div id="bottom">
		<span style="color:white">
			应尽书城.Copyright &copy;2020
		</span>
	</div>
</body>
</html>