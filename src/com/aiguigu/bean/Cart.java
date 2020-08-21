package com.aiguigu.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * ���ﳵ��������ÿ�����������Ϣ������װ�˶Թ��ﳵ�����ķ���
 * @author �ܲ�¡
 *
 */
public class Cart implements Serializable{
	//���������й�����
	private Map<Integer,CartItem> items=new LinkedHashMap<>();
	//����Ʒ��
	private int totalCount;
	//�������ܽ��
	private double totalMoney;
	//�������еĹ�����
	public List<CartItem> getAllItems(){
		//����map�е�����ֵ
		Collection<CartItem> values= items.values();
		return new ArrayList<>(values);
	}
	
	public Map<Integer, CartItem> getItems() {
		return items;
	}
	//��ȡ��Ʒ����
	public int getTotalCount() {
		//��ȡ���й��ﳵ��������Ʒ
		List<CartItem> list=getAllItems();
		int count=0;
		for(CartItem cartItem:list){
			count+=cartItem.getCount();
		}
		totalCount=count;
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	public double getTotalMoney() {
		List<CartItem> list=getAllItems();
		BigDecimal money=new BigDecimal(0.0+"");
		for(CartItem cartItem:list){
			//��ÿ���ܽ�������
			BigDecimal totalPrice=new BigDecimal(cartItem.getTotalPrice()+"");
			money=money.add(totalPrice);
		}
		return money.doubleValue();
	}
	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}
	public Cart(Map<Integer, CartItem> items, int totalCount, double totalMoney) {
		super();
		this.items = items;
		this.totalCount = totalCount;
		this.totalMoney = totalMoney;
	}
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Cart [items=" + items + ", totalCount=" + totalCount
				+ ", totalMoney=" + totalMoney + "]";
	}
	//����������ﳵ����������
	//���ͼ��
	public void addBook2Cart(Book book){
		//�ж��Ƿ��е�ǰͼ�飬����������һ
		CartItem item=items.get(book.getId());
		if(item==null){
			//û�е�ǰ�Ĺ�������ǵ�һ�����
			CartItem cartItem = new CartItem();
			cartItem.setBook(book);
			//
			items.put(book.getId(), cartItem);
		}else{
			item.setCount(item.getCount()+1);
		}
	}
	//ɾ��ͼ��
	public void deleteItem(String bookid){
		int id=Integer.parseInt(bookid);
		items.remove(id);
	}
	//�޸�����,countΪҪ�޸ĵ�����
	public void updateCount(String bookid,String count){
		int c=1;
		int id=0;
		try {
			c = Integer.parseInt(count);
			//��ֹ��Ϊ����
			c=c>0?c:1;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			id = Integer.parseInt(bookid);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CartItem cartItem=items.get(id);
		if(cartItem!=null){
			cartItem.setCount(c);
		}
	}
	//��չ��ﳵ
	public void clear(){
		//���map
		items.clear();
	}
	//��ȡһ��������
	public CartItem getItem(String bookid){
		int parse=Integer.parseInt(bookid);
		return items.get(parse);
	}
}
