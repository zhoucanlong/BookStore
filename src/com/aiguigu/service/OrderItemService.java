package com.aiguigu.service;

import java.util.List;

import com.aiguigu.bean.OrderItem;

public interface OrderItemService {
	/**
	 * ���涩����
	 * @param orderItem
	 */
	public void saveItem(List<OrderItem> orderItem);
	/**
	 * ��ȡ���������ж�����
	 * @param orderId
	 * @return
	 */
	public List<OrderItem> getOrderItems(String orderId);
	
}
