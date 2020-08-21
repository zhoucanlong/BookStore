package com.aiguigu.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class CartItem implements Serializable{
	//��ǰ������ı���
	private Book book;
	//���������
	private int count=1;
	//�ܽ��
	private double totalPrice;
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	//�����ܽ��
	public double getTotalPrice() {
		BigDecimal price=new BigDecimal(getBook().getPrice()+"");
		BigDecimal count=new BigDecimal(getCount()+"");
		BigDecimal multiply=price.multiply(count);
		//ʹ��BigDecimal.doubleValue()תΪdouble����
		return multiply.doubleValue();
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public CartItem(Book book, int count, double totalPrice) {
		super();
		this.book = book;
		this.count = count;
		this.totalPrice = totalPrice;
	}
	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CartItem [book=" + book + ", count=" + count + ", totalPrice="
				+ totalPrice + "]";
	}
	
}
