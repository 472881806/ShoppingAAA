package com.service;

import com.dao.ProductDao;
import com.dao.ProductDaoImpl;
import com.model.Order;
import com.model.Product;

public class ProductServiceImpl implements ProductService{
	ProductDao dao=new ProductDaoImpl();
	
	@Override
	//查询商品的方法
	public Product findProductByPid(String pid){

			return dao.find(pid);	
	}
	
	//提交订单的方法
	public void submitOrder(Order order){
		ProductDao dao=new ProductDaoImpl();
		//1调用存orders表的方法
		  dao.addOrders(order);
	   //2调用存储orderitems表的方法
		  dao.addOrderItems(order);
	   
	}
}
