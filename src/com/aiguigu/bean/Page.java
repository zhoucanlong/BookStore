package com.aiguigu.bean;

import java.util.List;

public class Page<T>{
	//当前是第几页，传递的参数
	private int pageNo;
	//总页数，计算得到
	private int totalPage;
	//总记录数，查询得到
	private int totalCount;
	//每页显示的条数，告诉数据库一次查四条记录
	private int pageSize=4;
	//告诉数据从哪个索引开始查，计算得到
	private int index;
	//是否有下一页，判断得到
	private boolean hasNext;
	//是否有上一页，判断得到
	private boolean hasPrev;
	//封装查出来的分页数据，查询出来设置进入的
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
	//获取总页数
	public int getTotalPage() {
		//计算实际的totalPage
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
	//计算得出索引值
	public int getIndex() {
		//每页显示四条
		int index=(getPageNo()-1)*getPageSize();
		return index;
	}
	//判断是否为下一个，根据当前页码判断
	public boolean isHasNext() {
		return getPageNo()<getTotalPage();
	}
	//判断是否有上一个
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
