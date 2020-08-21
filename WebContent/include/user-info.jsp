<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<%@include file="/include/base.jsp"%>
</head>
<body>
<!-- session域中user不为空 -->
<c:if test="${empty user}">
<!-- 这里是操作菜单 -->
<div>
	<a title="登录" class="user_a" href="pages/user/login.jsp"><i class="fa fa-superpowers" style="font-size:26px;color:white"></i></a> &nbsp;&nbsp;&nbsp;&nbsp;
	<a title="注册"  class="user_a" href="pages/user/regist.jsp"><i class="fa fa-address-card-o" style="font-size:26px;color:white"></i></a> &nbsp;&nbsp;&nbsp;&nbsp;
	<a title="购物车"  class="user_a" href="pages/cart/cart.jsp"><i class="fa fa-cart-arrow-down" style="font-size:30px;color:white"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a title="后台管理"  class="user_a" href="pages/manager/manager.jsp"><i class="fa fa-database" style="font-size:26px;color:white"></i></a>
</div>
</c:if>
<!-- session域中user为空 -->
<c:if test="${!empty user}">
<!-- 这里是操作菜单 -->
<div>
	<span style="color:white"><b style="color:white">欢迎</b><span class="um_span"><b style="color:white">${user.username}</b></span><b style="color:white">光临应尽书城</b></span>&nbsp;&nbsp;&nbsp;&nbsp;
	<a title="购物车"  class="user_a" href="pages/cart/cart.jsp"><i class="fa fa-cart-arrow-down" style="font-size:36px;color:white"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a title="我的订单"  class="user_a" href="client/OrderClientServlet?method=list"><i class="fa fa-list" style="font-size:30px;color:white"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a title="注销"  class="user_a" href="UserServlet?method=logout"><i class="fa fa-dot-circle-o" style="font-size:30px;color:white"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a title="返回商城"  class="user_a" href="index.jsp"><i class="fa fa-sign-out" style="font-size:30px;color:white"></i></a>
</div>
</c:if>


</body>
</html>