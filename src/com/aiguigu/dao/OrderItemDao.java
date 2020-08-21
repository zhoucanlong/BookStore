package com.aiguigu.dao;

import java.util.List;

import com.aiguigu.bean.OrderItem;

/**
 * 操作订单项的dao
 * @author 周灿隆
 *
 */
public interface OrderItemDao {
	/**
	 * 获取某个订单的所有订单项
	 * @return
	 */
	public List<OrderItem> getOrderItems(String orderId);
	/**
	 * 保存某个订单项
	 * @param item
	 * @return
	 */
	public int saveOrderItem(OrderItem item);
	/**
	 * 
	 * @param item
	 * @return
	 */
	public int savaBatch(List<OrderItem> item);
}

