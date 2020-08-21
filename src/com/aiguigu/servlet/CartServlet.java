package com.aiguigu.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aiguigu.bean.Book;
import com.aiguigu.bean.Cart;
import com.aiguigu.bean.CartItem;
import com.aiguigu.bean.Page;
import com.aiguigu.service.BookService;
import com.aiguigu.service.impl.BookServiceImpl;
import com.aiguigu.utils.WebUtils;
import com.google.gson.Gson;

/**
 * Servlet implementation class CartServlet
 */
public class CartServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    BookService bs=new BookServiceImpl();
	public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
     * 将图书添加到购物车
     */
	protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Book book=WebUtils.param2bean(request, new Book());
		String id=request.getParameter("id");
		HttpSession session=request.getSession();
		//获取购物车
		Cart cart=WebUtils.getCart(request);
		Book one=bs.getOne(book);
		cart.addBook2Cart(one);
		session.setAttribute("title", one.getTitle());
		//refer（请求地址）只是指上次的请求行
		//get请求地址包括请求数据的
		//post不包括请求数据的
		String refer=request.getHeader("referer");
		response.sendRedirect(refer);
	}
	/**
	 * 使用ajax技术将图书加入购物车
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void addAjax(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Book book=WebUtils.param2bean(request, new Book());
		String id=request.getParameter("id");
		HttpSession session=request.getSession();
		//获取购物车
		Cart cart=WebUtils.getCart(request);
		Book one=bs.getOne(book);
		cart.addBook2Cart(one);
		//session.setAttribute("title", one.getTitle());
		//将图书加入成功以后，只需要返回部分数据（当前购物车图书总量，书名）
		//不需要将书名发在session中，直接返回即可
		//将数据回送浏览器
		//当前购物车所有的书的数量
		int totalCount=cart.getTotalCount();
		//获取刚刚添加的图书的书名
		String title=one.getTitle();
		//为js解析方便些JSON格式的数据
		//将这两个数据封装进对象里，将对象转为json的字符串
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("totalCount",totalCount);
		map.put("title", title);
		
		//将map转为json字符串
		Gson gson=new Gson();
		String json=gson.toJson(map);
		System.out.println(json);
		//写给页面
		response.getWriter().write(json);
	}
	//删除某个购物项
	protected void delete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取购物车
		Cart cart=WebUtils.getCart(request);
		//删除购物项，根据用户传来的图书id
		cart.deleteItem(request.getParameter("id"));
		//返回cart.jsp
		String refer=request.getHeader("referer");
		response.sendRedirect(refer);
	}
	//修改
	protected void update(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取购物车
		Cart cart=WebUtils.getCart(request);
		//修改完成
		cart.updateCount(request.getParameter("id"),request.getParameter("count"));
		//返回cart.jsp
		String refer=request.getHeader("referer");
		response.sendRedirect(refer);
	}
	//修改Ajax
	protected void updateAjax(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取购物车
		Cart cart=WebUtils.getCart(request);
		String bookid=request.getParameter("id");
		//修改完成
		cart.updateCount(request.getParameter("id"),request.getParameter("count"));
		//返回部分内容，修改的图书的总金额，购物车的总金额，购物车的总数量
		//找到修改的购物项
		CartItem item=cart.getItem(bookid);
		//获取购物项的总金额
		double totalPrice=item.getTotalPrice();
		//获取购物车的总数量
		int totalCount=cart.getTotalCount();
		//购物车的总金额
		double totalMoney=cart.getTotalMoney();
		Map<String,Object> map=new HashMap<>();
		map.put("totalPrice", totalPrice);
		map.put("totalCount", totalCount);
		map.put("totalMoney", totalMoney);
		//将数据转为json字符串返回
		Gson gson=new Gson();
		//响应数据
		String json=gson.toJson(map);
		response.getWriter().write(json);
	}
	//清空购物车
	protected void clear(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取购物车
		Cart cart=WebUtils.getCart(request);
		cart.clear();
		//返回cart.jsp
		String refer=request.getHeader("referer");
		response.sendRedirect(refer);
	}

}
