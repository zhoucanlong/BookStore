package com.aiguigu.bean;

import java.util.List;

public class Page<T>{
	//��ǰ�ǵڼ�ҳ�����ݵĲ���
	private int pageNo;
	//��ҳ��������õ�
	private int totalPage;
	//�ܼ�¼������ѯ�õ�
	private int totalCount;
	//ÿҳ��ʾ���������������ݿ�һ�β�������¼
	private int pageSize=4;
	//�������ݴ��ĸ�������ʼ�飬����õ�
	private int index;
	//�Ƿ�����һҳ���жϵõ�
	private boolean hasNext;
	//�Ƿ�����һҳ���жϵõ�
	private boolean hasPrev;
	//��װ������ķ�ҳ���ݣ���ѯ�������ý����
	private List<T> pageData;
	
	private String url; 
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		pageNo=pageNo>0?pageNo:1;
		pageNo=pageNo>getTotalCount()?getTotalPage():pageNo;
		this.pageNo = pageNo;
	}
	//��ȡ��ҳ��
	public int getTotalPage() {
		//����ʵ�ʵ�totalPage
		this.totalPage=getTotalCount()/getPageSize();//
		if(!(getTotalCount()/getPageSize()==0)){
			this.totalPage=this.totalPage+1;
		}
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	//����ó�����ֵ
	public int getIndex() {
		//ÿҳ��ʾ����
		int index=(getPageNo()-1)*getPageSize();
		return index;
	}
	//�ж��Ƿ�Ϊ��һ�������ݵ�ǰҳ���ж�
	public boolean isHasNext() {
		return getPageNo()<getTotalPage();
	}
	//�ж��Ƿ�����һ��
	public boolean isHasPrev() {
		return getPageNo()>1;
	}
	public void setHasPrev(boolean hasPrev) {
		this.hasPrev = hasPrev;
	}
	public List<T> getPageData() {
		return pageData;
	}
	public void setPageData(List<T> pageData) {
		this.pageData = pageData;
	}
	public Page(int pageNo, int totalPage, int totalCount, int pageSize,
			int index, boolean hasNext, boolean hasPrev, List<T> pageData) {
		super();
		this.pageNo = pageNo;
		this.totalPage = totalPage;
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		this.index = index;
		this.hasNext = hasNext;
		this.hasPrev = hasPrev;
		this.pageData = pageData;
	}
	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Page [pageNo=" + pageNo + ", totalPage=" + totalPage
				+ ", totalCount=" + totalCount + ", pageSize=" + pageSize
				+ ", index=" + index + ", hasNext=" + hasNext + ", hasPrev="
				+ hasPrev + ", pageData=" + pageData + "]";
	}
	
}
