<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>结算页面</title>
<%@include file="/include/base.jsp"%>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
</head>
<body style="background-image:url(static/img/8.png);background-size:100% 130%">
	<div id="header">
			<!-- <img class="logo_img" alt="" src="static/img/logo.gif" > -->
			<span class="wel_word" style="color:white"></span>
			<div>
				<span style="color:white">欢迎<span class="um_span"style="color:white">韩总</span>光临尚硅谷书城</span>
				<a title="我的订单" href="client/OrderClientServlet?method=list"><i class="fa fa-list" style="font-size:30px;color:white"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;
				<a title="注销" href="index.jsp"><i class="fa fa-dot-circle-o" style="font-size:30px;color:white"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;
				<a title="返回商城" href="index.jsp"><i class="fa fa-sign-out" style="font-size:30px;color:white"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;
			</div>
	</div>
	
	<div id="main">
		
		<h1 style="color:white">你的订单已结算，订单号为${orderId}</h1>
		
	
	</div>
	
	<div id="bottom">
		<span style="color:white">
			应尽书城.Copyright &copy;2020
		</span>
	</div>
</body>
</html>