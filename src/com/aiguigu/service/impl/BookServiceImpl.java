package com.aiguigu.service.impl;

import java.util.List;

import com.aiguigu.bean.Book;
import com.aiguigu.bean.Page;
import com.aiguigu.dao.BookDao;
import com.aiguigu.dao.impl.BookDaoImpl;
import com.aiguigu.service.BookService;
/**
 * ҵ���߼�ʵ��
 */
public class BookServiceImpl implements BookService {
	
	private BookDao bd=new BookDaoImpl();
	//���ͼ��
	@Override
	public boolean add(Book book) {
		// TODO Auto-generated method stub
		return bd.addBook(book);
	}
	//����ͼ��
	@Override
	public boolean update(Book book) {
		// TODO Auto-generated method stub
		return bd.updateBook(book);
	}
	//ɾ��һ��ͼ��
	@Override
	public boolean delete(Book book) {
		// TODO Auto-generated method stub
		return bd.delBook(book);
	}
	//����һ��ͼ��
	@Override
	public Book getOne(Book book) {
		// TODO Auto-generated method stub
		return bd.getBook(book);
	}
	//��������ͼ��
	@Override
	public List<Book> getAll() {
		// TODO Auto-generated method stub
		return bd.getAllBook();
	}
	//���ط�ҳ����
	@Override
	public Page<Book> getPage(String pageNo, String pageSize) {
		//1.���û�����������ȷ�װ����
		Page<Book> page=new Page<Book>();
		//2.���û����������ת�Ͳ���װ
		//����Ĭ��ֵ
		int pn=1;
		int ps=page.getPageSize();
		try{
			pn=Integer.parseInt(pageNo);
			ps=Integer.parseInt(pageSize);
		}catch(NumberFormatException e){
			e.printStackTrace();
		}
		//��Ҫ����ҳ���С���������ܼ�¼��
		page.setPageSize(ps);
		//3.��ΪҪʹ��totalCountҲ���ǵ�ǰ�ܼ�¼�������Ի���Ҫ�����ݿ�
		int totalCount=bd.getTotalCount();
		//�����Ϳ��������ҳ��
		page.setTotalCount(totalCount);
		page.setPageNo(pn);
		//4.��ѯ���ݲ���װ
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
		//1.���û�����������ȷ�װ����
		Page<Book> page=new Page<Book>();
		//2.���û����������ת�Ͳ���װ
		//����Ĭ��ֵ
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
		//��ҳ���Լ�ҳ���С���ý���page����
		//���ռ۸������ȡ�ܼ�¼��
		int count=bd.getTotalCountByPrice(min, max);
		page.setTotalCount(count);
		page.setPageSize(ps);
		//�������
		page.setPageNo(pn);
		//3.��ѯ��Ӧ����
		List<Book> list=bd.getPageByPrice(page.getIndex(), page.getPageSize(), min, max);
		//4.��װ��page����
		page.setPageData(list);
		
		return page;
	}
	

}
