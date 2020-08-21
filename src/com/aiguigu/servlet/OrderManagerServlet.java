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
     * 列出所有订单
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("orderManager");
		//获取所有订单
		List<Order> list=orderService.getAllOrder();
		//保存到域中
		request.setAttribute("orders", list);
		//转发页面
		request.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(request, response);
	}
	/**
	 * 发货
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void deliver(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//从页面获取订单号
		String orderid=request.getParameter("orderid");
		//修改订单状态
		orderService.updateStatus(orderid, "1");
		//回到页面
		String refer=request.getHeader("referer");
		response.sendRedirect(refer);
	}

}
