package com.aiguigu.service;

import java.util.List;

import com.aiguigu.bean.Cart;
import com.aiguigu.bean.Order;
import com.aiguigu.bean.User;

public interface OrderService {
	/**
	 * 结账操作
	 * @param cart
	 * @return
	 */
	public String checkout(Cart cart,User user);
	/**
	 * 修改订单状态
	 * @param orderid
	 * @param status
	 */
	public void updateStatus(String orderid,String status);
	/**
	 * 获取所有订单，管理员使用
	 * @return
	 */
	public List<Order> getAllOrder();
	/**
	 * 获取某个用户的所有订单
	 * @param userId
	 * @return
	 */
	public List<Order> getMyOrders(Integer userId);
	
	
}
