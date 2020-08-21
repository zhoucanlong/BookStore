package com.aiguigu.test;

import java.util.List;

import com.aiguigu.bean.Book;
import com.aiguigu.bean.Page;
import com.aiguigu.dao.BookDao;
import com.aiguigu.dao.impl.BookDaoImpl;
import com.aiguigu.service.BookService;
import com.aiguigu.service.impl.BookServiceImpl;

public class BookDaoTest {
	public static void main(String[] args){
		BookDao bd=new BookDaoImpl();
//		List<Book> list=(List<Book>)bd.getAllBook();
//		System.out.println("lalala"+list);
//		Book book=new Book(null,"java","zhoucanlong",100.10,0,200,null);
//		boolean b=bd.addBook(book);
//		System.out.println(b);
//		Book book2=new Book();
//		book2.setId(19);
//		boolean f=bd.delBook(book2);
//		System.out.println(f);
//		book2.setId(5);
//		Book book3=bd.getBook(book2);
//		System.out.println(book3.toString());
		
		BookService bs=new BookServiceImpl();
		Page<Book> page=bs.getPageByPrice("1", "4", "150", "0");
		System.out.println(page.toString());
	}
}
