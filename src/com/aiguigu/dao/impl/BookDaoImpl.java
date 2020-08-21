package com.aiguigu.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.aiguigu.bean.Book;
import com.aiguigu.dao.BaseDao;
import com.aiguigu.dao.BookDao;

public class BookDaoImpl extends BaseDao<Book> implements BookDao {
	/**
	 * 获取所有图书，返回图书的集合
	 */
	@Override
	public List<Book> getAllBook() {
		String sql="select id,title,author,price,sales,stock,img_path imgPath from bs_book";
		//返回所有图书
		try {
			return getBeanList(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 添加图书
	 */
	@Override
	public boolean addBook(Book book){
		String sql="insert into bs_book(title,author,price,sales,stock,img_path) values(?,?,?,?,?,?)";
		int update=0;
		try {
			update=update(sql,book.getTitle(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return update>0;
	}
	/**
	 * 删除图书
	 */
	@Override
	public boolean delBook(Book book) {
		String sql="delete from bs_book where id=?";
		int update=0;
		try {
			update=update(sql,book.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return update>0;
	}
	/**
	 * 修改图书
	 */
	@Override
	public boolean updateBook(Book book) {
		String sql="update bs_book set title=?,author=?,price=?,sales=?,stock=?,img_path=? where id=?";
		int update=0;
		try {
			update=update(sql,book.getTitle(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath(),book.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return update>0;
	}
	/**
	 * 获取一本图书
	 */
	@Override
	public Book getBook(Book book) {
		String sql="select id,title,author,price,sales,stock,img_path imgPath from bs_book where id=?";
		try {
			return getBean(sql,book.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Book> getPageList(int index,int size){
		String sql="select id,title,author,price,sales,stock,img_path imgPath from bs_book limit ?,?";
		try {
			return getBeanList(sql,index,size);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	///根据图书价格查询图书，minPrice最小价格，maxPrice最大价格
	public List<Book> getPageByPrice(int index,int size,double minPrice,double maxPrice){
		String sql="select id,title,author,price,sales,stock,img_path imgPath from bs_book where price between ? and ? limit ?,?";
		try {
			return getBeanList(sql,minPrice,maxPrice,index,size);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//查出数据库中的总记录数
	@Override
	public int getTotalCount() {
		String sql="select count(*) from bs_book";
		Object object=null;
		try {
			object=getSingleValue(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int parseInt=0;
		parseInt=Integer.parseInt(object.toString());		
		return parseInt;
	}
	//根据图书价格查找出相应的记录数
	@Override
	public int getTotalCountByPrice(double minPrice, double maxPrice){
		String sql="select count(*) from bs_book where price between ? and ?";
		int i=0;
		try {
			Object object=getSingleValue(sql,minPrice,maxPrice);
			i=Integer.parseInt(object.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	//修改库存
	@Override
	public void updateStockAndSales(Integer bookid, Integer stock, Integer count) {
		// TODO Auto-generated method stub
		
	}

}
