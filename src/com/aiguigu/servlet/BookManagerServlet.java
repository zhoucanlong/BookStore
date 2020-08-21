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
    //ֻҪ��ʾ��ҳ���ݾ���
    protected void page(HttpServletRequest request,
    		HttpServletResponse response) throws ServletException, IOException {
    	//�û����ͼ�������ʾ��������,ҳ��Ӧ���û����ݵ�
    	String pn=request.getParameter("pn");
    	Page<Book> page=bookService.getPage(pn, "4");
    	page.setUrl("manager/BookManagerServlet?method=page");
    	//����һҳ�����ݷŵ�ҳ����ʾ
    	request.setAttribute("page", page);
    	//����ҳ��
    	request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
    }
    protected void list(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
    	System.out.println("BookManagerServlet list");
    	//�������ͼ�����ݲ���ʾ
    	//List<Book> list=bookService.getAll();
    	List<Book> list=bd.getAllBook();
    	System.out.println(list.getClass().toString());
    	//System.out.println("hahahah");
    	//ͼ�����Ժ󽻸�ҳ����ʾbook_manager.jsp
    	request.setAttribute("list", list);
    	//����ҳ��
    	request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
    }
    //ͼ�����
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//1.���ύ��ͼ����Ϣ����װΪBook����,����nameӦ�úͶ��������һһ��Ӧ
    	Book book=WebUtils.param2bean(request, new Book());
    	System.out.println(book.toString());
    	//2.��ͼ�鱣�浽���ݿ�
    	boolean b=bookService.add(book);
    	//3.����ɹ�ת�����ض���
    	request.getRequestDispatcher("/manager/BookManagerServlet?method=page").forward(request, response);
    }
    //ɾ��ͼ��
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//��װҪɾ����book
    	Book book=WebUtils.param2bean(request, new Book());
    	String parameter=request.getParameter("pn");
    	
    	System.out.println("delete");
    	System.out.println(book.toString());
    	//����ɾ������
    	bookService.delete(book);
    	request.getRequestDispatcher("/manager/BookManagerServlet?method=page&pn="+parameter).forward(request, response);
    }
    //�޸�ͼ��
    
    //���ĳ��ͼ�����ϸ��Ϣ������ʾ��ҳ��
    protected void getBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//
    	
    	Book book=WebUtils.param2bean(request, new Book());
    	//��ȡ��ϸ��Ϣ
    	Book one=bookService.getOne(book);
    	//�ص��༭ҳ�������ʾ
    	request.setAttribute("book", one);
    	//ת����ҳ�������ʾ
    	request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request, response);
    }
    

    protected void update(HttpServletRequest request,
    		HttpServletResponse response) throws ServletException, IOException {
    	//��װ�޸ĵ�ͼ����Ϣ
    	Book book=WebUtils.param2bean(request, new Book());
    	String parameter=request.getParameter("pn");
    	//�޸Ľ����ݿ�
    	if(book.getId()>0){
    		bookService.update(book);
    	}else{
    		bookService.add(book);
    	}	
    	//����ת��
    	request.getRequestDispatcher("/manager/BookManagerServlet?method=page&pn"+parameter).forward(request, response);
    }
}
