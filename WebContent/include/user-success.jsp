<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<%@include file="/include/base.jsp"%>

</head>
<body>
<div>
	<span>欢迎<span class="um_span">${user.username}</span>光临尚硅谷书城</span>
	<a title="我的订单" href="pages/order/order.jsp"><i class="fa fa-list" style="font-size:30px;color:white"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a title="注销" href="UserServlet?method=logout"><i class="fa fa-dot-circle-o" style="font-size:30px;color:white"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a title="返回商城" href="index.jsp"><i class="fa fa-sign-out" style="font-size:30px;color:white"></i></a>
</div>
</body>
</html>