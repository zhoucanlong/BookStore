package com.aiguigu.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.aiguigu.bean.Book;
import com.aiguigu.bean.Cart;
import com.aiguigu.bean.CartItem;
import com.aiguigu.bean.Order;
import com.aiguigu.bean.OrderItem;
import com.aiguigu.bean.User;
import com.aiguigu.dao.OrderDao;
import com.aiguigu.dao.impl.OrderDaoImpl;
import com.aiguigu.service.BookService;
import com.aiguigu.service.OrderItemService;
import com.aiguigu.service.OrderService;

public class OrderServiceImpl implements OrderService {
	OrderDao orderDao=new OrderDaoImpl();
	OrderItemService itemService=new OrderItemServiceImpl();
	BookService bookService=new BookServiceImpl();
	@Override
	public String checkout(Cart cart,User user) {
		//结账操作，把购物车里面的数据封装并保存
		//1.封装订单对象

		//orderId需要使用算法生成
		long millis=System.currentTimeMillis();
		//时间戳+Id
		String orderId=millis+""+user.getId();
		Order order=new Order();
		order.setCreateDate(new Date());
		order.setOrderId(orderId);
		order.setTotalMoney(cart.getTotalMoney());
		order.setStatus(0);
		order.setUserId(user.getId());
		
		//2.封装订单项对象
		List<CartItem> allItems=cart.getAllItems();
		List<OrderItem> orderItems=new ArrayList();
		for(CartItem cartItem:allItems){
			OrderItem item=new OrderItem(cartItem.getBook().getTitle(),cartItem.getCount(),cartItem.getBook().getPrice(),cartItem.getTotalPrice(),orderId);
			orderItems.add(item);
		}
		
		//3.保存订单
		orderDao.saveOrder(order);
		
		//4.保存所有订单项
		itemService.saveItem(orderItems);
		
		//5.修改相应库存,改图书的信息,改每一项
		for(CartItem cartItem:allItems){
			//获取详细信息
			//图书的信息应该从数据库得到
			Book book=cartItem.getBook();
			Book one=bookService.getOne(book);
			//修改库存和销量
			int count=cartItem.getCount();
			book.setStock(one.getStock()-count);
			book.setSales(one.getSales()+count);
			//更新图书
			bookService.update(one);
		}
		//6.清空购物车
		cart.clear();
		System.out.println("orderId:"+orderId);
		return orderId;
	}

	@Override
	public void updateStatus(String orderid, String status) {
		// TODO Auto-generated method stub
		Order order=new Order();
		order.setOrderId(orderid);
		int parseInt=0;
		parseInt=Integer.parseInt(status);
		order.setStatus(parseInt);
		orderDao.updateStatus(order);
	}

	@Override
	public List<Order> getAllOrder() {
		
		return orderDao.getOrderList();
	}

	@Override
	public List<Order> getMyOrders(Integer userId) {
		return orderDao.getOrderByUserId(userId);
	}

}
