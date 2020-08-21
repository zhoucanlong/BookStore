package com.aiguigu.dao;

import java.util.List;

import com.aiguigu.bean.Order;

/**
 * ����������dao
 * @author �ܲ�¡
 *
 */
public interface OrderDao {
	/**
	 * ���涩��
	 */
	public int saveOrder(Order order);
	/**
	 * �޸Ķ���״̬
	 */
	public int updateStatus(Order order);
	/**
	 * ��ȡ���ж���
	 * @return
	 */
	public List<Order> getOrderList();
	/**
	 * ��ȡĳ���û������ж���
	 * @param userId
	 * @return
	 */
	public List<Order> getOrderByUserId(Integer userId);
}
