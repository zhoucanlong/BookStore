package com.aiguigu.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.aiguigu.bean.OrderItem;
import com.aiguigu.dao.BaseDao;
import com.aiguigu.dao.OrderItemDao;

public class OrderItemDaoImpl extends BaseDao<OrderItem> implements OrderItemDao {

	@Override
	public List<OrderItem> getOrderItems(String orderId) {
		//数据订单号，获取所有的订单项
		String sql="select id,title,count,price,total_price totalPrice,order_id orderId from bs_order_item where order_id=?";
		List<OrderItem> orderItem=null;
		try {
			orderItem=getBeanList(sql,orderId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderItem;
	}

	@Override
	public int saveOrderItem(OrderItem item) {
		String sql="insert into bs_order_item(title,count,price,total_price,order_id) values(?,?,?,?,?)";
		int update=0;
		try {
			update=update(sql,item.getTitle(),item.getCount(),item.getPrice(),item.getTotalPrice(),item.getOrderId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return update;
	}
	/**
	 * 执行批量保存
	 */
	@Override
	public int savaBatch(List<OrderItem> params) {
		String sql="insert into bs_order_item(title,count,price,total_price,order_id) values(?,?,?,?,?)";
		Object[][] objs=new Object[params.size()][5];
		int count=0;
		for(OrderItem item:params){
			objs[count++]=new Object[]{item.getTitle(),item.getCount(),item.getPrice(),item.getTotalPrice(),item.getOrderId()};
		}
		batch(sql,objs);
		return 0;
	}
	
	
	

}
