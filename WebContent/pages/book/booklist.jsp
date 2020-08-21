<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>书城首页</title>
<%@include file="/include/base.jsp"%>
<script type="text/javascript">
	$(function(){
		//加入购物车的ajax
		$(".addCartBtn").click(function(){
			//url,[data],function(data){}
			var bookid=$(this).attr("updateId");
			//getJSON将响应的字符串直接转为json对象
			$.getJSON("client/CartServlet?method=addAjax&id="+bookid,function(data){
				//将数据的内容放在响应区域
				$("#totalCountTip").text("当前购物车中有"+data.totalCount+" 件商品");
				$("#booktitleTip").text("您刚刚将【"+data.title+"】加入购物车");
			});
		});
	});
</script>
<style type="text/css">
	span {
		color:white;
		padding: 5px
	}
	
	#max {
		border-radius: 5px;
	}

	#min{
		border-radius: 5px;
	}
	
	#find{
		border-radius: 5px;
	}
</style>

</head>
<body style="background-image:url(static/img/15.png);background-size:100% 130%">
	<div id="header">
			<!--<img class="logo_img" alt="" src="static/img/logo.gif" >  -->
			<span class="wel_word" style="color:white">网上书城</span>
			<%@include file="/include/user-info.jsp" %>
	</div>
	<div id="main">
		<div id="book">
			<div class="book_cond">
				<form action="client/BookClientServlet" method="get" style="color:white">
					<input type="hidden" name="method" value="pageByPrice"/>
					价格：<input id="min" type="text" name="min" value="${param.min}"> 元 - 
						<input id="max" type="text" name="max" value="${param.max}"> 元 
						<input id="find" type="submit" value="查询" />
				</form>
			</div>
			<div style="text-align: center">
				<span id="totalCountTip">您的购物车中有${cart.totalCount}件商品</span>
				<div>
					<!-- 提示图书名 -->
					<span id="booktitleTip">&nbsp;</span>
				</div>
			</div>
			<c:forEach items="${page.pageData}" var="book">
				<div class="b_list">
					<div class="img_div">
						<img class="book_img" alt="" src="${book.imgPath}" />
					</div>
					<div class="book_info">
						<div class="book_name" style="height:30px">
							<span class="sp1">书名:</span>
							<span class="sp2">${book.title}</span>
						</div>
						<div class="book_author">
							<span class="sp1">作者:</span>
							<span class="sp2">${book.author}</span>
						</div>
						<div class="book_price">
							<span class="sp1">价格:</span>
							<span class="sp2">${book.price}</span>
						</div>
						<div class="book_sales">
							<span class="sp1">销量:</span>
							<span class="sp2">${book.sales}</span>
						</div>
						<div class="book_amount">
							<span class="sp1">库存:</span>
							<span class="sp2">${book.stock}</span>
						</div>
						<div class="book_add">
							<button updateId="${book.id}" class="addCartBtn">加入购物车</button>
							<!-- <a style="color:blue" href="client/CartServlet?method=add&id=${book.id}">加入购物车</a> -->
						</div>
					</div>
				</div>	
			</c:forEach>
			</div>
		<%@include file="/include/page.jsp" %>
		</div>
	</div>
	
	<div id="bottom">
		<span>
			应尽书城.Copyright &copy;2020
		</span>
	</div>
</body>
</html>