package com.aiguigu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aiguigu.bean.Book;
import com.aiguigu.bean.Page;
import com.aiguigu.dao.BookDao;
import com.aiguigu.dao.impl.BookDaoImpl;
import com.aiguigu.service.BookService;
import com.aiguigu.service.impl.BookServiceImpl;
import com.aiguigu.utils.WebUtils;


public class BookManagerServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    private BookService bookService=new BookServiceImpl();
    BookDao bd=new BookDaoImpl();
    public BookManagerServlet() {
        super();        
    }
    //只要显示分页数据就行
    protected void page(HttpServletRequest request,
    		HttpServletResponse response) throws ServletException, IOException {
    	//用户点击图书管理显示部分数据,页码应该用户传递的
    	String pn=request.getParameter("pn");
    	Page<Book> page=bookService.getPage(pn, "4");
    	page.setUrl("manager/BookManagerServlet?method=page");
    	//将第一页的数据放到页面显示
    	request.setAttribute("page", page);
    	//交给页面
    	request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
    }
    protected void list(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
    	System.out.println("BookManagerServlet list");
    	//查出所有图书数据并显示
    	//List<Book> list=bookService.getAll();
    	List<Book> list=bd.getAllBook();
    	System.out.println(list.getClass().toString());
    	//System.out.println("hahahah");
    	//图书查出以后交给页面显示book_manager.jsp
    	request.setAttribute("list", list);
    	//交给页面
    	request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
    }
    //图书添加
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//1.将提交的图书信息，封装为Book对象,表单的name应该和对象的属性一一对应
    	Book book=WebUtils.param2bean(request, new Book());
    	System.out.println(book.toString());
    	//2.将图书保存到数据库
    	boolean b=bookService.add(book);
    	//3.保存成功转发或重定向
    	request.getRequestDispatcher("/manager/BookManagerServlet?method=page").forward(request, response);
    }
    //删除图书
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//封装要删除的book
    	Book book=WebUtils.param2bean(request, new Book());
    	String parameter=request.getParameter("pn");
    	
    	System.out.println("delete");
    	System.out.println(book.toString());
    	//调用删除方法
    	bookService.delete(book);
    	request.getRequestDispatcher("/manager/BookManagerServlet?method=page&pn="+parameter).forward(request, response);
    }
    //修改图书
    
    //查出某本图书的详细信息，并显示到页面
    protected void getBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//
    	
    	Book book=WebUtils.param2bean(request, new Book());
    	//获取详细信息
    	Book one=bookService.getOne(book);
    	//回到编辑页面进行显示
    	request.setAttribute("book", one);
    	//转发到页面进行显示
    	request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request, response);
    }
    

    protected void update(HttpServletRequest request,
    		HttpServletResponse response) throws ServletException, IOException {
    	//封装修改的图书信息
    	Book book=WebUtils.param2bean(request, new Book());
    	String parameter=request.getParameter("pn");
    	//修改进数据库
    	if(book.getId()>0){
    		bookService.update(book);
    	}else{
    		bookService.add(book);
    	}	
    	//请求转发
    	request.getRequestDispatcher("/manager/BookManagerServlet?method=page&pn"+parameter).forward(request, response);
    }
}
