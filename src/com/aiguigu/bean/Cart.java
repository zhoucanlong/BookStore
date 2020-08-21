package com.aiguigu.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 购物车，保存了每个购物项的信息，还封装了对购物车操作的方法
 * @author 周灿隆
 *
 */
public class Cart implements Serializable{
	//保存了所有购物项
	private Map<Integer,CartItem> items=new LinkedHashMap<>();
	//总商品数
	private int totalCount;
	//所有项总金额
	private double totalMoney;
	//返回所有的购物项
	public List<CartItem> getAllItems(){
		//返回map中的所有值
		Collection<CartItem> values= items.values();
		return new ArrayList<>(values);
	}
	
	public Map<Integer, CartItem> getItems() {
		return items;
	}
	//获取商品总数
	public int getTotalCount() {
		//获取所有购物车中所有商品
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
			//将每项总金额加起来
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
	//定义操作购物车的其他方法
	//添加图书
	public void addBook2Cart(Book book){
		//判断是否有当前图书，有则数量加一
		CartItem item=items.get(book.getId());
		if(item==null){
			//没有当前的购物项，则是第一次添加
			CartItem cartItem = new CartItem();
			cartItem.setBook(book);
			//
			items.put(book.getId(), cartItem);
		}else{
			item.setCount(item.getCount()+1);
		}
	}
	//删除图书
	public void deleteItem(String bookid){
		int id=Integer.parseInt(bookid);
		items.remove(id);
	}
	//修改数量,count为要修改的数量
	public void updateCount(String bookid,String count){
		int c=1;
		int id=0;
		try {
			c = Integer.parseInt(count);
			//禁止改为负数
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
	//清空购物车
	public void clear(){
		//清空map
		items.clear();
	}
	//获取一个购物项
	public CartItem getItem(String bookid){
		int parse=Integer.parseInt(bookid);
		return items.get(parse);
	}
}
