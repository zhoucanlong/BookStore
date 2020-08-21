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
		//获取已经登录的用户
		User loginUser=WebUtils.getLoginUser(request);
		HttpSession session=request.getSession();
		//2.登录则结算
		if(loginUser!=null){
			//代表用户已经登录
			Cart cart=WebUtils.getCart(request);
			//结算,返回一个订单号
			String orderid=orderService.checkout(cart, loginUser);
			session.setAttribute("orderId", orderid);
			response.sendRedirect(request.getContextPath()+"/pages/cart/checkout.jsp");
		}else{
			//3.否则直接返回登录页面提示用户登录
			request.setAttribute("msg", "此操作需要登录");
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
		}
	}
	
	/**
	 * 列出当前用户的所有订单
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void list(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		User user=WebUtils.getLoginUser(request);
		List<Order> list=orderService.getMyOrders(user.getId());
		//域中保存了该用户的所有订单
		request.setAttribute("orders", list);
		System.out.println("list"+list);
		request.getRequestDispatcher("/pages/order/order.jsp").forward(request, response);
	}
	/**
	 * 收货
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void received(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String orderid=request.getParameter("orderid");
		//确认收货状态
		orderService.updateStatus(orderid, "2");
		String refer=request.getHeader("referer");
		response.sendRedirect(refer);
	}

}
