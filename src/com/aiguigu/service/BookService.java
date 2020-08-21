package com.aiguigu.service;

import java.util.List;

import com.aiguigu.bean.Book;
import com.aiguigu.bean.Page;

/**
 * ҵ���߼���
 * @author �ܲ�¡
 *
 */
public interface BookService {
	/**
	 * ���ͼ��,true����ӳɹ�
	 */
	public boolean add(Book book);
	/**
	 * �޸�ͼ��,����Id�޸���������
	 */
	public boolean update(Book book);
	/**
	 * ɾ��ͼ�飬
	 */
	public boolean delete(Book book);
	/**
	 * ��ȡһ��ͼ��
	 */
	public Book getOne(Book book);
	/**
	 * ��ѯ������ͼ�飬���ص���һ��ͼ�鼯
	 */
	public List<Book> getAll();
	/**
	 * ���ط�ҳ����
	 */
	public Page<Book> getPage(String pageNo,String pageSize);
	/*
	 * ��ȡ��ҳ
	 */
	public Page<Book> getPageByPrice(String pageNo, String pageSize,String maxPrice,String minPrice);
}
