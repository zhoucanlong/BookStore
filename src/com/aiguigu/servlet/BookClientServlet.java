package com.aiguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aiguigu.bean.Book;
import com.aiguigu.bean.Page;
import com.aiguigu.service.BookService;
import com.aiguigu.service.impl.BookServiceImpl;

/**
 * Servlet implementation class BookClientServlet
 */
public class BookClientServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	BookService bookService=new BookServiceImpl();
    public BookClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    //给用户展示图书的分页数据
	protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  	//用户点击图书管理显示部分数据,页码应该用户传递的
    	String pn=request.getParameter("pn");
    	Page<Book> page=bookService.getPage(pn, "4");
    	page.setUrl("client/BookClientServlet?method=page");
    	//将第一页的数据放到页面显示
    	request.setAttribute("page", page);
    	//交给页面
    	request.getRequestDispatcher("/pages/book/booklist.jsp").forward(request, response);
	}
	
	//价格查询的分页数据
	
	protected void pageByPrice(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取价格区间
		String max=request.getParameter("max");
		String min=request.getParameter("min");
		String pn=request.getParameter("pn");
		//获取价格区间的所有图书
		Page<Book> page=bookService.getPageByPrice(pn, "4", max, min);
		page.setUrl("client/BookClientServlet?method=pageByPrice&max="+max+"&min="+min);
		//返回页面显示
		request.setAttribute("page", page);
		request.getRequestDispatcher("/pages/book/booklist.jsp").forward(request, response);
		;
	}

}
