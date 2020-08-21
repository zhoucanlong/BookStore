package com.aiguigu.dao;

import java.util.List;

import com.aiguigu.bean.OrderItem;

/**
 * �����������dao
 * @author �ܲ�¡
 *
 */
public interface OrderItemDao {
	/**
	 * ��ȡĳ�����������ж�����
	 * @return
	 */
	public List<OrderItem> getOrderItems(String orderId);
	/**
	 * ����ĳ��������
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

