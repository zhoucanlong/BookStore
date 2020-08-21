package com.aiguigu.service;

import java.util.List;

import com.aiguigu.bean.OrderItem;

public interface OrderItemService {
	/**
	 * 保存订单项
	 * @param orderItem
	 */
	public void saveItem(List<OrderItem> orderItem);
	/**
	 * 获取订单的所有订单项
	 * @param orderId
	 * @return
	 */
	public List<OrderItem> getOrderItems(String orderId);
	
}
