package com.service;

import com.model.Order;
import com.model.Product;

public interface ProductService {
	//����ָ����pid��ȡ��Ӧ����Ʒ
	public Product findProductByPid(String pid);
	
	

	public void submitOrder(Order order);

}
