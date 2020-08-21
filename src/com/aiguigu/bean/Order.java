package com.aiguigu.bean;

import java.util.Date;



public class Order {
	//������
	private String orderId;
	//��������
	private Date createDate;
	//����״̬
	private int status;
	//�����ܶ�
	private double totalMoney;
	//�������û�
	private Integer userId;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public double getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Order(String orderId, Date createDate, int status,
			double totalMoney, Integer userId) {
		super();
		this.orderId = orderId;
		this.createDate = createDate;
		this.status = status;
		this.totalMoney = totalMoney;
		this.userId = userId;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", createDate=" + createDate
				+ ", status=" + status + ", totalMoney=" + totalMoney
				+ ", userId=" + userId + "]";
	}
	
}
