<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑图书</title>
<%@include file="/include/base.jsp"%>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
	
	input {
		text-align: center;
	}
	
	 td {
	 	color:white;
	 	font-size:20px;
	 } 

</style>
</head>
<body style="background-image:url(static/img/6.png);background-size:100% 130%">
		<div id="header">
		<!--<img class="logo_img" alt="" src="static/img/logo.gif" >  -->	
		    <span class="wel_word"></span>
			<%@include file="/include/book-manager.jsp" %>
		</div>
		
		<div id="main">
			<form action="manager/BookManagerServlet" method="post">
				<input name="method" value="${param.m}" type="hidden"/>
				<input name="id" value="${book.id}" type="hidden"/>
				<input name="pn" value="${param.pn}" type="hidden"/>
				<table>
					<tr>
						<td>名称</td>
						<td>价格</td>
						<td>作者</td>
						<td>销量</td>
						<td>库存</td>
						<td colspan="2">操作</td>
					</tr>		
					<tr>
						<td><input name="title" type="text" value="${book.title}"/></td>
						<td><input name="price" type="text" value="${book.price}"/></td>
						<td><input name="author" type="text" value="${book.author}"/></td>
						<td><input name="sales" type="text" value="${book.sales}"/></td>
						<td><input name="stock" type="text" value="${book.stock}"/></td>
						<td><input type="submit" value="提交"/></td>
					</tr>	
				</table>
			</form>
			
	
		</div>
		
		<div id="bottom">
			<span>
				应尽书城.Copyright &copy;2020
			</span>
		</div>
</body>
</html>