package com.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
	//������
	private String oid;//�������
	private String uid;//���������߱��
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	private Date ordertime; //�µ�ʱ��
	private double total;	//�ϼ�
	//����״̬�����֣�
	private int state; //1.δ���2.����δ������3.����δ�ջ���4.���׳ɹ�
	
	private User user; //����������
    private String address;  //�ջ��ַ
    private String name;//�ջ�������
    private String telephone;//�ջ��˵绰
	private List<OrderItem> orderItems = new ArrayList<OrderItem>();  //��ǰ������������Ʒ��Ŀ
	
	
	
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	
	
	
	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public Date getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	

	




}
