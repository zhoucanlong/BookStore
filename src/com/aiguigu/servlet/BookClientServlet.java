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
    //���û�չʾͼ��ķ�ҳ����
	protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  	//�û����ͼ�������ʾ��������,ҳ��Ӧ���û����ݵ�
    	String pn=request.getParameter("pn");
    	Page<Book> page=bookService.getPage(pn, "4");
    	page.setUrl("client/BookClientServlet?method=page");
    	//����һҳ�����ݷŵ�ҳ����ʾ
    	request.setAttribute("page", page);
    	//����ҳ��
    	request.getRequestDispatcher("/pages/book/booklist.jsp").forward(request, response);
	}
	
	//�۸��ѯ�ķ�ҳ����
	
	protected void pageByPrice(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//��ȡ�۸�����
		String max=request.getParameter("max");
		String min=request.getParameter("min");
		String pn=request.getParameter("pn");
		//��ȡ�۸����������ͼ��
		Page<Book> page=bookService.getPageByPrice(pn, "4", max, min);
		page.setUrl("client/BookClientServlet?method=pageByPrice&max="+max+"&min="+min);
		//����ҳ����ʾ
		request.setAttribute("page", page);
		request.getRequestDispatcher("/pages/book/booklist.jsp").forward(request, response);
		;
	}

}
