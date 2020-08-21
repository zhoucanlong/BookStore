package com.aiguigu.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.aiguigu.bean.Order;
import com.aiguigu.dao.BaseDao;
import com.aiguigu.dao.OrderDao;

public class OrderDaoImpl extends BaseDao<Order> implements OrderDao {

	@Override
	public int saveOrder(Order order) {
		String sql="insert into bs_order(order_id,create_date,total_money,status,user_id)"
				+" values(?,?,?,?,?)";
		int update=0;
		try {
			update=update(sql,order.getOrderId(),order.getCreateDate(),order.getTotalMoney(),order.getStatus(),order.getUserId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return update;
	}
	/**
	 * 修改订单状态
	 */
	@Override
	public int updateStatus(Order order) {
		String sql="update bs_order set status=? where order_id=?";
		int update=0;
		try {
			update=update(sql,order.getStatus(),order.getOrderId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return update;
	}
	/**
	 * 返回所有订单
	 */
	@Override
	public List<Order> getOrderList() {
		String sql="select order_id orderId,create_date createDate,total_money totalMoney,status,user_id userId from bs_order";
		List<Order> order=null;
		try {
			order=getBeanList(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return order;
	}
	
	@Override
	public List<Order> getOrderByUserId(Integer userId) {
		String sql="select order_id orderId,create_date createDate,total_money totalMoney,status,user_id userId from bs_order where user_id=?";
		List<Order> order=null;
		try {
			order=getBeanList(sql,userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return order;
	}

}
