package com.aiguigu.service.impl;

import java.util.List;

import com.aiguigu.bean.OrderItem;
import com.aiguigu.dao.OrderItemDao;
import com.aiguigu.dao.impl.OrderItemDaoImpl;
import com.aiguigu.service.OrderItemService;

public class OrderItemServiceImpl implements OrderItemService {
	OrderItemDao itemDao=new OrderItemDaoImpl();
	@Override
	public void saveItem(List<OrderItem> orderItem) {
	//	for(OrderItem orderItem2:orderItem){
	//		itemDao.saveOrderItem(orderItem2);
	//	}
		itemDao.savaBatch(orderItem);
	}

	@Override
	public List<OrderItem> getOrderItems(String orderId) {
		
		return itemDao.getOrderItems(orderId);
	}

}
