package com.aiguigu.test;

import java.math.BigDecimal;

import com.aiguigu.bean.Book;
import com.aiguigu.bean.Cart;

public class CartTest {
	public static void main(String[] args){
		Cart cart=new Cart();
		Book book1=new Book(1,"���μ�1","",12.6,100,100,"");
		Book book2=new Book(2,"���μ�2","",13.6,100,100,"");
		Book book3=new Book(3,"���μ�3","",14.6,100,100,"");
		Book book4=new Book(4,"���μ�4","",15.6,100,100,"");
		Book book5=new Book(5,"���μ�5","",16.6,100,100,"");
		Book book6=new Book(6,"���μ�6","",17.6,100,100,"");
		cart.addBook2Cart(book1);
		cart.addBook2Cart(book1);
		cart.addBook2Cart(book3);
		System.out.println("��ǰ�ܼƣ�"+cart.getTotalCount()+"����");
		System.out.println("��ǰ�ܼۣ�"+cart.getTotalMoney()+"Ԫ");
		System.out.println("��ǰ���ﳵ�е���Ŀ"+cart.getAllItems());
		cart.deleteItem("3");
		System.out.println("��ǰ�ܼƣ�"+cart.getTotalCount()+"����");
		System.out.println("��ǰ�ܼۣ�"+cart.getTotalMoney()+"Ԫ");
		System.out.println("��ǰ���ﳵ�е���Ŀ"+cart.getAllItems());
//		BigDecimal bigDecimal=new BigDecimal(1);
//		for(int j=1;j<210;j++){
//			bigDecimal=bigDecimal.multiply(new BigDecimal(j));
//		}
//		System.out.println(bigDecimal);
	}
}
