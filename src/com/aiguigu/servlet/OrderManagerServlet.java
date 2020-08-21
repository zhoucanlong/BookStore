package com.aiguigu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aiguigu.bean.Order;
import com.aiguigu.service.OrderService;
import com.aiguigu.service.impl.OrderServiceImpl;
import com.aiguigu.bean.Constant;
public class OrderManagerServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	OrderService orderService=new OrderServiceImpl();
    public OrderManagerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
     * �г����ж���
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("orderManager");
		//��ȡ���ж���
		List<Order> list=orderService.getAllOrder();
		//���浽����
		request.setAttribute("orders", list);
		//ת��ҳ��
		request.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(request, response);
	}
	/**
	 * ����
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void deliver(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//��ҳ���ȡ������
		String orderid=request.getParameter("orderid");
		//�޸Ķ���״̬
		orderService.updateStatus(orderid, "1");
		//�ص�ҳ��
		String refer=request.getHeader("referer");
		response.sendRedirect(refer);
	}

}
