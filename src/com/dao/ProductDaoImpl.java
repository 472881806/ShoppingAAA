package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import com.model.Order;
import com.model.OrderItem;
import com.model.Product;

public class ProductDaoImpl implements ProductDao {
	
	public Product find(String pid){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl", "scott", "admin");
			String sql = "select * from Product2 where pid=?";//PRODUCT是商品表
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, pid);
			ResultSet rs=psmt.executeQuery();
			if(rs.next()){
				Product p=new Product();
			    p.setPid(rs.getString("pid"));//商品表第一列列名
				p.setPimage(rs.getString("pimage"));//商品表第二列列名
				p.setPname(rs.getString("pname"));
			    p.setPrice(rs.getDouble("Shop_price"));//商品表第四列列名
			    
			    return p;
			}
			
				return null;
		
			
		} catch (Exception e) {
			
			throw new RuntimeException(e);
		}
		
		
		
		
		
	}
	
	
	//向orders表插入数据
		public void addOrders(Order order) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl", "scott", "admin");
				String sql = "insert into orders(oid,userid,ordertime,total,state,address,uname,telephone) values(?,?,?,?,?,?,?,?)";
				PreparedStatement psmt = conn.prepareStatement(sql);
				//转换时间格式
				Timestamp timestamp = new Timestamp(order.getOrdertime().getTime());
				
				
				psmt.setObject(1, order.getOid());
				psmt.setObject(2, order.getUser().getUid());
				psmt.setObject(3, timestamp);
				psmt.setObject(4, order.getTotal());
				psmt.setObject(5, order.getState());
				psmt.setObject(6, order.getAddress());
				psmt.setObject(7, order.getName());
				psmt.setObject(8, order.getTelephone());
				psmt.execute();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		//向orderitems表插入数据
		public void addOrderItems(Order order){
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl", "scott", "admin");
				String sql = "insert into orderitems(iid,count,subtotal) values(?,?,?)";
				PreparedStatement psmt=conn.prepareStatement(sql);
				
				List<OrderItem> orderItems = order.getOrderItems();
				for(OrderItem item : orderItems){
					psmt.setObject(1, item.getIid());
					psmt.setObject(2, item.getCount());
					psmt.setObject(3, item.getSubtotal());
					psmt.execute();
				}
		
				
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			
			
		}
	
	
	
	
	

}
