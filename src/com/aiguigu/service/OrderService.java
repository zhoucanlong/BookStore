package com.aiguigu.service;

import java.util.List;

import com.aiguigu.bean.Cart;
import com.aiguigu.bean.Order;
import com.aiguigu.bean.User;

public interface OrderService {
	/**
	 * ���˲���
	 * @param cart
	 * @return
	 */
	public String checkout(Cart cart,User user);
	/**
	 * �޸Ķ���״̬
	 * @param orderid
	 * @param status
	 */
	public void updateStatus(String orderid,String status);
	/**
	 * ��ȡ���ж���������Աʹ��
	 * @return
	 */
	public List<Order> getAllOrder();
	/**
	 * ��ȡĳ���û������ж���
	 * @param userId
	 * @return
	 */
	public List<Order> getMyOrders(Integer userId);
	
	
}
