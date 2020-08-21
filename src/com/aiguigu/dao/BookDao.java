package com.aiguigu.dao;

import java.util.List;

import com.aiguigu.bean.Book;

public interface BookDao {
	//��ȡ����ͼ��
	public List<Book> getAllBook();
	//���һ��ͼ��,bookΪҪ��ӵ�ͼ�飬����true������ӳɹ�
	public boolean addBook(Book book);
	//ɾ��һ��ͼ�飬��id ɾ���ͺ�
	public boolean delBook(Book book);
	//�޸�һ��ͼ�飬book���޸ĺ������
	public boolean updateBook(Book book);
	//��ѯ����ͼ��,����ͼ���id����ͼ��
	public Book getBook(Book book);
	//��ҳ����ͼ��ķ���
	public List<Book> getPageList(int index,int size);
	//��ȡ����ͼ��ļ�¼��
	public int getTotalCount();
	//���ռ۸������ȡ�ļ�¼��
	public int getTotalCountByPrice(double minPrice,double maxPrice);
	//���ռ۸����ͼ��
	public List<Book> getPageByPrice(int index,int size,double minPrice,double maxPrice);
	//
	public void updateStockAndSales(Integer bookid,Integer stock,Integer count);
}
