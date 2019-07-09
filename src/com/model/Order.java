package com.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
	//订单类
	private String oid;//订单编号
	private String uid;//订单所有者编号
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	private Date ordertime; //下单时间
	private double total;	//合计
	//订单状态（四种）
	private int state; //1.未付款、2.付款未发货、3.发货未收货、4.交易成功
	
	private User user; //订单所有者
    private String address;  //收获地址
    private String name;//收货人姓名
    private String telephone;//收货人电话
	private List<OrderItem> orderItems = new ArrayList<OrderItem>();  //当前订单下所有商品条目
	
	
	
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
