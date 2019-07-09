package com.service;

import com.model.Order;
import com.model.Product;

public interface ProductService {
	//根据指定的pid获取对应的商品
	public Product findProductByPid(String pid);
	
	

	public void submitOrder(Order order);

}
