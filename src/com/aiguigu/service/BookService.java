package com.aiguigu.service;

import java.util.List;

import com.aiguigu.bean.Book;
import com.aiguigu.bean.Page;

/**
 * 业务逻辑层
 * @author 周灿隆
 *
 */
public interface BookService {
	/**
	 * 添加图书,true则添加成功
	 */
	public boolean add(Book book);
	/**
	 * 修改图书,按照Id修改其他属性
	 */
	public boolean update(Book book);
	/**
	 * 删除图书，
	 */
	public boolean delete(Book book);
	/**
	 * 获取一本图书
	 */
	public Book getOne(Book book);
	/**
	 * 查询出所有图书，返回的是一个图书集
	 */
	public List<Book> getAll();
	/**
	 * 返回分页数据
	 */
	public Page<Book> getPage(String pageNo,String pageSize);
	/*
	 * 获取分页
	 */
	public Page<Book> getPageByPrice(String pageNo, String pageSize,String maxPrice,String minPrice);
}
