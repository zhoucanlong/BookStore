package com.aiguigu.service.impl;

import java.util.List;

import com.aiguigu.bean.Book;
import com.aiguigu.bean.Page;
import com.aiguigu.dao.BookDao;
import com.aiguigu.dao.impl.BookDaoImpl;
import com.aiguigu.service.BookService;
/**
 * 业务逻辑实现
 */
public class BookServiceImpl implements BookService {
	
	private BookDao bd=new BookDaoImpl();
	//添加图书
	@Override
	public boolean add(Book book) {
		// TODO Auto-generated method stub
		return bd.addBook(book);
	}
	//更新图书
	@Override
	public boolean update(Book book) {
		// TODO Auto-generated method stub
		return bd.updateBook(book);
	}
	//删除一本图书
	@Override
	public boolean delete(Book book) {
		// TODO Auto-generated method stub
		return bd.delBook(book);
	}
	//查找一本图书
	@Override
	public Book getOne(Book book) {
		// TODO Auto-generated method stub
		return bd.getBook(book);
	}
	//查找所有图书
	@Override
	public List<Book> getAll() {
		// TODO Auto-generated method stub
		return bd.getAllBook();
	}
	//返回分页数据
	@Override
	public Page<Book> getPage(String pageNo, String pageSize) {
		//1.将用户传入的数据先封装部分
		Page<Book> page=new Page<Book>();
		//2.将用户传入的数据转型并封装
		//设置默认值
		int pn=1;
		int ps=page.getPageSize();
		try{
			pn=Integer.parseInt(pageNo);
			ps=Integer.parseInt(pageSize);
		}catch(NumberFormatException e){
			e.printStackTrace();
		}
		//先要设置页面大小，再设置总记录数
		page.setPageSize(ps);
		//3.因为要使用totalCount也就是当前总记录数，所以还需要查数据库
		int totalCount=bd.getTotalCount();
		//这样就可以算出总页码
		page.setTotalCount(totalCount);
		page.setPageNo(pn);
		//4.查询数据并封装
		List<Book> list=bd.getPageList(page.getPageNo(), page.getPageSize());
		page.setPageData(list);
		return page;
	}
	//

	@Override
	public Page<Book> getPageByPrice(String pageNo, String pageSize,
			String maxPrice, String minPrice) {
		double min=0.0; 
		double max=Double.MAX_VALUE;
		//1.将用户传入的数据先封装部分
		Page<Book> page=new Page<Book>();
		//2.将用户传入的数据转型并封装
		//设置默认值
		int pn=1;
		int ps=page.getPageSize();
		try{
			pn=Integer.parseInt(pageNo);
			ps=Integer.parseInt(pageSize);
			min=Double.parseDouble(minPrice);
			max=Double.parseDouble(maxPrice);
		}catch(NumberFormatException e){
			e.printStackTrace();
		}
		//将页码以及页面大小设置进入page对象
		//按照价格区间获取总记录数
		int count=bd.getTotalCountByPrice(min, max);
		page.setTotalCount(count);
		page.setPageSize(ps);
		//最后设置
		page.setPageNo(pn);
		//3.查询相应数据
		List<Book> list=bd.getPageByPrice(page.getIndex(), page.getPageSize(), min, max);
		//4.封装进page对象
		page.setPageData(list);
		
		return page;
	}
	

}
