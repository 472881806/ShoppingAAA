package com.dao;

import com.model.Order;
import com.model.Product;

public interface ProductDao {
	public Product find(String pid);
	public void addOrders(Order order);
	public void addOrderItems(Order order);
	
}
