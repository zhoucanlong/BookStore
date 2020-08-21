package com.aiguigu.dao;

import java.util.List;

import com.aiguigu.bean.Order;

/**
 * 操作订单的dao
 * @author 周灿隆
 *
 */
public interface OrderDao {
	/**
	 * 保存订单
	 */
	public int saveOrder(Order order);
	/**
	 * 修改订单状态
	 */
	public int updateStatus(Order order);
	/**
	 * 获取所有订单
	 * @return
	 */
	public List<Order> getOrderList();
	/**
	 * 获取某个用户的所有订单
	 * @param userId
	 * @return
	 */
	public List<Order> getOrderByUserId(Integer userId);
}
