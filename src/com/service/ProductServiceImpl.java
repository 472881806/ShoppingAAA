package com.service;

import com.dao.ProductDao;
import com.dao.ProductDaoImpl;
import com.model.Order;
import com.model.Product;

public class ProductServiceImpl implements ProductService{
	ProductDao dao=new ProductDaoImpl();
	
	@Override
	//��ѯ��Ʒ�ķ���
	public Product findProductByPid(String pid){

			return dao.find(pid);	
	}
	
	//�ύ�����ķ���
	public void submitOrder(Order order){
		ProductDao dao=new ProductDaoImpl();
		//1���ô�orders��ķ���
		  dao.addOrders(order);
	   //2���ô洢orderitems��ķ���
		  dao.addOrderItems(order);
	   
	}
}
