<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的订单</title>
<%@include file="/include/base.jsp"%>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
</head>
<body style="background-image:url(static/img/6.png);background-size:100% 130%">
	
	<div id="header">
			<!--<img class="logo_img" alt="" src="static/img/logo.gif" >  -->
			<span class="wel_word"><i class="fa fa-cc-mastercard" style="font-size:60px;color:white"></i></span>
			<%@include file="/include/user-success.jsp"%>
	</div>
	
	<div id="main">
		<c:if test="${empty orders}">
			没有对应订单，<a href="index.jsp">赶紧去买</a>
		</c:if>
        <c:if test="${!empty orders}">
			<table>
			<tr>
			    <td>订单号</td>
				<td>日期</td>
				<td>金额</td>
				<td>状态</td>
				<td>详情</td>
			</tr>		
			<c:forEach items="${orders}" var="order">
				<tr>
				    <td>${order.orderId}</td>
					<td>${order.createDate}</td>
					<td>${order.totalMoney}</td>
					<td>
						<c:choose>
							<c:when test="${order.status==0}">
								未发货
							</c:when>
							<c:when test="${order.status==1}">
								已发货
								<a href="client/OrderClientServlet?method=received&orderid=${order.orderId}">确认收货</a>
							</c:when>
							<c:when test="${order.status==2}">
								交易完成
							</c:when>
						</c:choose>
					</td>
					<td><a href="#">查看详情</a></td>
				</tr>
			</c:forEach>	
		</table>
	 	</c:if>		
	</div>
	
	<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2015
		</span>
	</div>
</body>
</html>