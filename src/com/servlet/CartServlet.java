package com.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.print.attribute.standard.RequestingUserName;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Cart;
import com.model.CartItem;
import com.model.CommonUtils;
import com.model.Order;
import com.model.OrderItem;
import com.model.Product;
import com.model.User;
import com.service.ProductService;
import com.service.ProductServiceImpl;


/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/product")
public class CartServlet extends BaseServlet{
	//添加商品到购物车
	public void addProductToCart(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		HttpSession session=request.getSession();
		ProductService service=new ProductServiceImpl();
		//获取要放入购物车的商品的pid
		String pid=request.getParameter("pid");
		//获取该商品的购买数量
		int buyNum=Integer.parseInt(request.getParameter("buyNum"));
		//获取product 对象
		Product product=service.findProductByPid(pid);
		
		//计算小计
		double subtotal=product.getPrice()*buyNum;
		
		//封装CartItem
		CartItem item=new CartItem();
		item.setProduct(product);
		item.setBuyNum(buyNum);
		item.setSubtotal(subtotal);
		
		//获得购物车
		Cart cart=(Cart)session.getAttribute("cart");
		if(cart==null){
			cart=new Cart();//判断Session中是否已经存在购物车，若不存在则创建一个
		}
		//将购物项放到购物车里面
		//先判断购物车中是否已经存在该购物项，即判断key是否已经存在
		//如果购物车里面已经存在该购物项--将现在买的数量与原来的数量相加
		
		Map<String, CartItem> cartItems=cart.getCartItems();
		//新买的商品小计
		double newsubtotal=0.0;
		
		if(cartItems.containsKey(pid)){
			CartItem cartItem=cartItems.get(pid);
			
			//获取原有商品的数量
			int oldBuyNum=cartItem.getBuyNum();
			oldBuyNum=oldBuyNum+buyNum;
		    //将总的商品购买数量放到购物项里面
			 cartItem.setBuyNum(oldBuyNum);
			//将购物项放到购物车里面
			 cart.setCartItems(cartItems);
			 
		   //修改小计
			 
			 //原来商品小计
			 double oldsubtotal = cartItem.getSubtotal();
			 //新买的商品小计
			 newsubtotal=buyNum*product.getPrice();
			//新的商品小计
			 cartItem.setSubtotal(newsubtotal+oldsubtotal);
			
		}else{
			cartItems.put(product.getPid(), item);
			newsubtotal=buyNum*product.getPrice();
			
		}
		
		
		//计算所有商品的总价格
		double total=cart.getTotal()+newsubtotal;
		cart.setTotal(total);
		
		//将车再次访问session
		session.setAttribute("cart", cart);
		
		
		//遍历出购物车中的所有商品
		Map<String, CartItem> items=cart.getCartItems();
		
		
		//直接跳转到购物车页面
		response.sendRedirect("shopcart.jsp");
		//request.getRequestDispatcher("shopcart.jsp").forward(request, response);
	
	}
	
	//删除某个单一商品
	//删除单一商品
		public void delProFromCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//1.获得要删除的item的pid
			String pid = request.getParameter("pid");
			//2.删除session中的购物车中的购物项集合中的item
			HttpSession session = request.getSession();
			Cart cart = (Cart) session.getAttribute("cart");
			if(cart!=null){
				Map<String, CartItem> cartItems = cart.getCartItems();
				//需要修改总价
				cart.setTotal(cart.getTotal()-cartItems.get(pid).getSubtotal());
				//删除
				cartItems.remove(pid);
				cart.setCartItems(cartItems);
			}
			session.setAttribute("cart", cart);
			//跳转回cart.jsp
			response.sendRedirect("shopcart.jsp");
		}
      //减少商品数量
		public void lessNum(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//1.获得要修改的item的pid
			String pid = request.getParameter("pid");
			//要减去的商品小计
			double newsubtotal=0.0;
			//2.session中的购物车中的购物项集合中的item
			HttpSession session = request.getSession();
			Cart cart = (Cart) session.getAttribute("cart");
			if(cart!=null){
				Map<String, CartItem> cartItems = cart.getCartItems();
				//获去要修改的购物项
				CartItem cartItem=cartItems.get(pid);
				//需要修改数量
				//获取原有的商品数量
				int oldNum=cartItem.getBuyNum();
				oldNum=oldNum-1;
				//将总的商品购买数量放到购物项里面
				cartItem.setBuyNum(oldNum);
				//将购物项放到购物车里面
				cart.setCartItems(cartItems);
				
				
				 //修改小计
				 
				 //原来商品小计
				 double oldsubtotal = cartItem.getSubtotal();
				 //要减去的商品小计
				 newsubtotal=1*cartItem.getProduct().getPrice();
				//新的商品小计
				 cartItem.setSubtotal(oldsubtotal-newsubtotal);
				//计算所有商品的总价格
					double total=cart.getTotal()-newsubtotal;
					cart.setTotal(total);
			}
			session.setAttribute("cart", cart);
			//跳转回cart.jsp
			response.sendRedirect("shopcart.jsp");
		}
		
		
		//增加商品数量
				public void addNum(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
					//1.获得要修改的item的pid
					String pid = request.getParameter("pid");
					//要加上的商品小计
					double newsubtotal=0.0;
					//2.session中的购物车中的购物项集合中的item
					HttpSession session = request.getSession();
					Cart cart = (Cart) session.getAttribute("cart");
					if(cart!=null){
						Map<String, CartItem> cartItems = cart.getCartItems();
						//获去要修改的购物项
						CartItem cartItem=cartItems.get(pid);
						//需要修改数量
						//获取原有的商品数量
						int oldNum=cartItem.getBuyNum();
						oldNum=oldNum+1;
						//将总的商品购买数量放到购物项里面
						cartItem.setBuyNum(oldNum);
						//将购物项放到购物车里面
						cart.setCartItems(cartItems);
						
						
						 //修改小计
						 
						 //原来商品小计
						 double oldsubtotal = cartItem.getSubtotal();
						 //要加上的商品小计
						 newsubtotal=1*cartItem.getProduct().getPrice();
						//新的商品小计
						 cartItem.setSubtotal(oldsubtotal+newsubtotal);
						//计算所有商品的总价格
							double total=cart.getTotal()+newsubtotal;
							cart.setTotal(total);
					}
					session.setAttribute("cart", cart);
					//跳转回cart.jsp
					response.sendRedirect("shopcart.jsp");
				}
				
		
		
		
		//提交订单
		public void submitOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           //获取购物车
			HttpSession session = request.getSession();
			
			//获取收货人姓名
		      String buyname=request.getParameter("buyname");
		    //获取收货人电话
		      String telephone=request.getParameter("telephone");
		    //获取收货地址
		      String address=request.getParameter("address");
		    
		      
			//User user = (User) session.getAttribute("user");
			User user=new User();
			user.setUid("002");
			user.setUname("李三岁");
			
			
			
			
			 
			//目的：封装好一个Order对象 传递给service层
			Order order = new Order();

			//1、private String oid;//该订单的订单号
			
			String oid=CommonUtils.getOOid();
			order.setOid(oid);

			//2、private Date ordertime;//下单时间
			order.setOrdertime(new Date());

			//3、private double total;//该订单的总金额
			//获得session中的购物车
			Cart cart = (Cart) session.getAttribute("cart");
			double total = cart.getTotal();
			order.setTotal(total);

			//4、private int state;//订单支付状态 1代表已付款 0代表未付款
			order.setState(0);

			//5、private String address;//收货地址
			order.setAddress(address);

			//6、private String name;//收货人
			order.setName(buyname);

			//7、private String telephone;//收货人电话
			order.setTelephone(telephone);

			//8、private User user;//该订单属于哪个用户
			order.setUser(user);

			//9、该订单中有多少订单项List<OrderItem> orderItems = new ArrayList<OrderItem>();
			//获得购物车中的购物项的集合map
		
			Map<String, CartItem> cartItems = cart.getCartItems();
			for(Map.Entry<String, CartItem> entry : cartItems.entrySet()){
				//取出每一个购物项
				CartItem cartItem = entry.getValue();
				//创建新的订单项
				OrderItem orderItem = new OrderItem();
				//1)private String iid;//订单项的id
				orderItem.setIid(CommonUtils.getOOid());
				//2)private int count;//订单项内商品的购买数量
				orderItem.setCount(cartItem.getBuyNum());
				//3)private double subtotal;//订单项小计
				orderItem.setSubtotal(cartItem.getSubtotal());
				//4)private Product product;//订单项内部的商品
				orderItem.setProduct(cartItem.getProduct());
				//5)private Order order;//该订单项属于哪个订单
				orderItem.setOrder(order);

				//将该订单项添加到订单的订单项集合private List<OrderItem> orderItems中;
				order.getOrderItems().add(orderItem);
			}


			//order对象封装完毕
			//传递数据到service层
			ProductService service = new ProductServiceImpl();
			service.submitOrder(order);


			session.setAttribute("order", order);

			//页面跳转
			response.sendRedirect("pay_index.jsp");


		}
	
		
		
	
}
