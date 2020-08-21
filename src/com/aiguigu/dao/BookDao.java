package com.aiguigu.dao;

import java.util.List;

import com.aiguigu.bean.Book;

public interface BookDao {
	//获取所有图书
	public List<Book> getAllBook();
	//添加一本图书,book为要添加的图书，返回true代表添加成功
	public boolean addBook(Book book);
	//删除一本图书，用id 删除就好
	public boolean delBook(Book book);
	//修改一本图书，book是修改后的样子
	public boolean updateBook(Book book);
	//查询单个图书,根据图书的id查找图书
	public Book getBook(Book book);
	//分页查找图书的方法
	public List<Book> getPageList(int index,int size);
	//获取所有图书的记录数
	public int getTotalCount();
	//按照价格区间获取的记录数
	public int getTotalCountByPrice(double minPrice,double maxPrice);
	//按照价格查找图书
	public List<Book> getPageByPrice(int index,int size,double minPrice,double maxPrice);
	//
	public void updateStockAndSales(Integer bookid,Integer stock,Integer count);
}
