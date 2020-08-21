package com.aiguigu.test;

import java.math.BigDecimal;

import com.aiguigu.bean.Book;
import com.aiguigu.bean.Cart;

public class CartTest {
	public static void main(String[] args){
		Cart cart=new Cart();
		Book book1=new Book(1,"西游记1","",12.6,100,100,"");
		Book book2=new Book(2,"西游记2","",13.6,100,100,"");
		Book book3=new Book(3,"西游记3","",14.6,100,100,"");
		Book book4=new Book(4,"西游记4","",15.6,100,100,"");
		Book book5=new Book(5,"西游记5","",16.6,100,100,"");
		Book book6=new Book(6,"西游记6","",17.6,100,100,"");
		cart.addBook2Cart(book1);
		cart.addBook2Cart(book1);
		cart.addBook2Cart(book3);
		System.out.println("当前总计："+cart.getTotalCount()+"本书");
		System.out.println("当前总价："+cart.getTotalMoney()+"元");
		System.out.println("当前购物车中的项目"+cart.getAllItems());
		cart.deleteItem("3");
		System.out.println("当前总计："+cart.getTotalCount()+"本书");
		System.out.println("当前总价："+cart.getTotalMoney()+"元");
		System.out.println("当前购物车中的项目"+cart.getAllItems());
//		BigDecimal bigDecimal=new BigDecimal(1);
//		for(int j=1;j<210;j++){
//			bigDecimal=bigDecimal.multiply(new BigDecimal(j));
//		}
//		System.out.println(bigDecimal);
	}
}
