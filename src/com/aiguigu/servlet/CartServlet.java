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
     * ��ͼ����ӵ����ﳵ
     */
	protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Book book=WebUtils.param2bean(request, new Book());
		String id=request.getParameter("id");
		HttpSession session=request.getSession();
		//��ȡ���ﳵ
		Cart cart=WebUtils.getCart(request);
		Book one=bs.getOne(book);
		cart.addBook2Cart(one);
		session.setAttribute("title", one.getTitle());
		//refer�������ַ��ֻ��ָ�ϴε�������
		//get�����ַ�����������ݵ�
		//post�������������ݵ�
		String refer=request.getHeader("referer");
		response.sendRedirect(refer);
	}
	/**
	 * ʹ��ajax������ͼ����빺�ﳵ
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void addAjax(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Book book=WebUtils.param2bean(request, new Book());
		String id=request.getParameter("id");
		HttpSession session=request.getSession();
		//��ȡ���ﳵ
		Cart cart=WebUtils.getCart(request);
		Book one=bs.getOne(book);
		cart.addBook2Cart(one);
		//session.setAttribute("title", one.getTitle());
		//��ͼ�����ɹ��Ժ�ֻ��Ҫ���ز������ݣ���ǰ���ﳵͼ��������������
		//����Ҫ����������session�У�ֱ�ӷ��ؼ���
		//�����ݻ��������
		//��ǰ���ﳵ���е��������
		int totalCount=cart.getTotalCount();
		//��ȡ�ո���ӵ�ͼ�������
		String title=one.getTitle();
		//Ϊjs��������ЩJSON��ʽ������
		//�����������ݷ�װ�������������תΪjson���ַ���
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("totalCount",totalCount);
		map.put("title", title);
		
		//��mapתΪjson�ַ���
		Gson gson=new Gson();
		String json=gson.toJson(map);
		System.out.println(json);
		//д��ҳ��
		response.getWriter().write(json);
	}
	//ɾ��ĳ��������
	protected void delete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//��ȡ���ﳵ
		Cart cart=WebUtils.getCart(request);
		//ɾ������������û�������ͼ��id
		cart.deleteItem(request.getParameter("id"));
		//����cart.jsp
		String refer=request.getHeader("referer");
		response.sendRedirect(refer);
	}
	//�޸�
	protected void update(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//��ȡ���ﳵ
		Cart cart=WebUtils.getCart(request);
		//�޸����
		cart.updateCount(request.getParameter("id"),request.getParameter("count"));
		//����cart.jsp
		String refer=request.getHeader("referer");
		response.sendRedirect(refer);
	}
	//�޸�Ajax
	protected void updateAjax(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//��ȡ���ﳵ
		Cart cart=WebUtils.getCart(request);
		String bookid=request.getParameter("id");
		//�޸����
		cart.updateCount(request.getParameter("id"),request.getParameter("count"));
		//���ز������ݣ��޸ĵ�ͼ����ܽ����ﳵ���ܽ����ﳵ��������
		//�ҵ��޸ĵĹ�����
		CartItem item=cart.getItem(bookid);
		//��ȡ��������ܽ��
		double totalPrice=item.getTotalPrice();
		//��ȡ���ﳵ��������
		int totalCount=cart.getTotalCount();
		//���ﳵ���ܽ��
		double totalMoney=cart.getTotalMoney();
		Map<String,Object> map=new HashMap<>();
		map.put("totalPrice", totalPrice);
		map.put("totalCount", totalCount);
		map.put("totalMoney", totalMoney);
		//������תΪjson�ַ�������
		Gson gson=new Gson();
		//��Ӧ����
		String json=gson.toJson(map);
		response.getWriter().write(json);
	}
	//��չ��ﳵ
	protected void clear(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//��ȡ���ﳵ
		Cart cart=WebUtils.getCart(request);
		cart.clear();
		//����cart.jsp
		String refer=request.getHeader("referer");
		response.sendRedirect(refer);
	}

}
