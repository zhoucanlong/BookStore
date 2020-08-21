package com.aiguigu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aiguigu.bean.Cart;
import com.aiguigu.bean.Order;
import com.aiguigu.bean.User;
import com.aiguigu.service.OrderService;
import com.aiguigu.service.impl.OrderServiceImpl;
import com.aiguigu.utils.WebUtils;

public class OrderClientServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	OrderService orderService=new OrderServiceImpl();
    public OrderClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void checkout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ�Ѿ���¼���û�
		User loginUser=WebUtils.getLoginUser(request);
		HttpSession session=request.getSession();
		//2.��¼�����
		if(loginUser!=null){
			//�����û��Ѿ���¼
			Cart cart=WebUtils.getCart(request);
			//����,����һ��������
			String orderid=orderService.checkout(cart, loginUser);
			session.setAttribute("orderId", orderid);
			response.sendRedirect(request.getContextPath()+"/pages/cart/checkout.jsp");
		}else{
			//3.����ֱ�ӷ��ص�¼ҳ����ʾ�û���¼
			request.setAttribute("msg", "�˲�����Ҫ��¼");
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
		}
	}
	
	/**
	 * �г���ǰ�û������ж���
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void list(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		User user=WebUtils.getLoginUser(request);
		List<Order> list=orderService.getMyOrders(user.getId());
		//���б����˸��û������ж���
		request.setAttribute("orders", list);
		System.out.println("list"+list);
		request.getRequestDispatcher("/pages/order/order.jsp").forward(request, response);
	}
	/**
	 * �ջ�
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void received(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String orderid=request.getParameter("orderid");
		//ȷ���ջ�״̬
		orderService.updateStatus(orderid, "2");
		String refer=request.getHeader("referer");
		response.sendRedirect(refer);
	}

}
