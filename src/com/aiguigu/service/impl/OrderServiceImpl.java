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
		//���˲������ѹ��ﳵ��������ݷ�װ������
		//1.��װ��������

		//orderId��Ҫʹ���㷨����
		long millis=System.currentTimeMillis();
		//ʱ���+Id
		String orderId=millis+""+user.getId();
		Order order=new Order();
		order.setCreateDate(new Date());
		order.setOrderId(orderId);
		order.setTotalMoney(cart.getTotalMoney());
		order.setStatus(0);
		order.setUserId(user.getId());
		
		//2.��װ���������
		List<CartItem> allItems=cart.getAllItems();
		List<OrderItem> orderItems=new ArrayList();
		for(CartItem cartItem:allItems){
			OrderItem item=new OrderItem(cartItem.getBook().getTitle(),cartItem.getCount(),cartItem.getBook().getPrice(),cartItem.getTotalPrice(),orderId);
			orderItems.add(item);
		}
		
		//3.���涩��
		orderDao.saveOrder(order);
		
		//4.�������ж�����
		itemService.saveItem(orderItems);
		
		//5.�޸���Ӧ���,��ͼ�����Ϣ,��ÿһ��
		for(CartItem cartItem:allItems){
			//��ȡ��ϸ��Ϣ
			//ͼ�����ϢӦ�ô����ݿ�õ�
			Book book=cartItem.getBook();
			Book one=bookService.getOne(book);
			//�޸Ŀ�������
			int count=cartItem.getCount();
			book.setStock(one.getStock()-count);
			book.setSales(one.getSales()+count);
			//����ͼ��
			bookService.update(one);
		}
		//6.��չ��ﳵ
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
