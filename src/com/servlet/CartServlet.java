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
	//�����Ʒ�����ﳵ
	public void addProductToCart(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		HttpSession session=request.getSession();
		ProductService service=new ProductServiceImpl();
		//��ȡҪ���빺�ﳵ����Ʒ��pid
		String pid=request.getParameter("pid");
		//��ȡ����Ʒ�Ĺ�������
		int buyNum=Integer.parseInt(request.getParameter("buyNum"));
		//��ȡproduct ����
		Product product=service.findProductByPid(pid);
		
		//����С��
		double subtotal=product.getPrice()*buyNum;
		
		//��װCartItem
		CartItem item=new CartItem();
		item.setProduct(product);
		item.setBuyNum(buyNum);
		item.setSubtotal(subtotal);
		
		//��ù��ﳵ
		Cart cart=(Cart)session.getAttribute("cart");
		if(cart==null){
			cart=new Cart();//�ж�Session���Ƿ��Ѿ����ڹ��ﳵ�����������򴴽�һ��
		}
		//��������ŵ����ﳵ����
		//���жϹ��ﳵ���Ƿ��Ѿ����ڸù�������ж�key�Ƿ��Ѿ�����
		//������ﳵ�����Ѿ����ڸù�����--���������������ԭ�����������
		
		Map<String, CartItem> cartItems=cart.getCartItems();
		//�������ƷС��
		double newsubtotal=0.0;
		
		if(cartItems.containsKey(pid)){
			CartItem cartItem=cartItems.get(pid);
			
			//��ȡԭ����Ʒ������
			int oldBuyNum=cartItem.getBuyNum();
			oldBuyNum=oldBuyNum+buyNum;
		    //���ܵ���Ʒ���������ŵ�����������
			 cartItem.setBuyNum(oldBuyNum);
			//��������ŵ����ﳵ����
			 cart.setCartItems(cartItems);
			 
		   //�޸�С��
			 
			 //ԭ����ƷС��
			 double oldsubtotal = cartItem.getSubtotal();
			 //�������ƷС��
			 newsubtotal=buyNum*product.getPrice();
			//�µ���ƷС��
			 cartItem.setSubtotal(newsubtotal+oldsubtotal);
			
		}else{
			cartItems.put(product.getPid(), item);
			newsubtotal=buyNum*product.getPrice();
			
		}
		
		
		//����������Ʒ���ܼ۸�
		double total=cart.getTotal()+newsubtotal;
		cart.setTotal(total);
		
		//�����ٴη���session
		session.setAttribute("cart", cart);
		
		
		//���������ﳵ�е�������Ʒ
		Map<String, CartItem> items=cart.getCartItems();
		
		
		//ֱ����ת�����ﳵҳ��
		response.sendRedirect("shopcart.jsp");
		//request.getRequestDispatcher("shopcart.jsp").forward(request, response);
	
	}
	
	//ɾ��ĳ����һ��Ʒ
	//ɾ����һ��Ʒ
		public void delProFromCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//1.���Ҫɾ����item��pid
			String pid = request.getParameter("pid");
			//2.ɾ��session�еĹ��ﳵ�еĹ�������е�item
			HttpSession session = request.getSession();
			Cart cart = (Cart) session.getAttribute("cart");
			if(cart!=null){
				Map<String, CartItem> cartItems = cart.getCartItems();
				//��Ҫ�޸��ܼ�
				cart.setTotal(cart.getTotal()-cartItems.get(pid).getSubtotal());
				//ɾ��
				cartItems.remove(pid);
				cart.setCartItems(cartItems);
			}
			session.setAttribute("cart", cart);
			//��ת��cart.jsp
			response.sendRedirect("shopcart.jsp");
		}
      //������Ʒ����
		public void lessNum(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//1.���Ҫ�޸ĵ�item��pid
			String pid = request.getParameter("pid");
			//Ҫ��ȥ����ƷС��
			double newsubtotal=0.0;
			//2.session�еĹ��ﳵ�еĹ�������е�item
			HttpSession session = request.getSession();
			Cart cart = (Cart) session.getAttribute("cart");
			if(cart!=null){
				Map<String, CartItem> cartItems = cart.getCartItems();
				//��ȥҪ�޸ĵĹ�����
				CartItem cartItem=cartItems.get(pid);
				//��Ҫ�޸�����
				//��ȡԭ�е���Ʒ����
				int oldNum=cartItem.getBuyNum();
				oldNum=oldNum-1;
				//���ܵ���Ʒ���������ŵ�����������
				cartItem.setBuyNum(oldNum);
				//��������ŵ����ﳵ����
				cart.setCartItems(cartItems);
				
				
				 //�޸�С��
				 
				 //ԭ����ƷС��
				 double oldsubtotal = cartItem.getSubtotal();
				 //Ҫ��ȥ����ƷС��
				 newsubtotal=1*cartItem.getProduct().getPrice();
				//�µ���ƷС��
				 cartItem.setSubtotal(oldsubtotal-newsubtotal);
				//����������Ʒ���ܼ۸�
					double total=cart.getTotal()-newsubtotal;
					cart.setTotal(total);
			}
			session.setAttribute("cart", cart);
			//��ת��cart.jsp
			response.sendRedirect("shopcart.jsp");
		}
		
		
		//������Ʒ����
				public void addNum(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
					//1.���Ҫ�޸ĵ�item��pid
					String pid = request.getParameter("pid");
					//Ҫ���ϵ���ƷС��
					double newsubtotal=0.0;
					//2.session�еĹ��ﳵ�еĹ�������е�item
					HttpSession session = request.getSession();
					Cart cart = (Cart) session.getAttribute("cart");
					if(cart!=null){
						Map<String, CartItem> cartItems = cart.getCartItems();
						//��ȥҪ�޸ĵĹ�����
						CartItem cartItem=cartItems.get(pid);
						//��Ҫ�޸�����
						//��ȡԭ�е���Ʒ����
						int oldNum=cartItem.getBuyNum();
						oldNum=oldNum+1;
						//���ܵ���Ʒ���������ŵ�����������
						cartItem.setBuyNum(oldNum);
						//��������ŵ����ﳵ����
						cart.setCartItems(cartItems);
						
						
						 //�޸�С��
						 
						 //ԭ����ƷС��
						 double oldsubtotal = cartItem.getSubtotal();
						 //Ҫ���ϵ���ƷС��
						 newsubtotal=1*cartItem.getProduct().getPrice();
						//�µ���ƷС��
						 cartItem.setSubtotal(oldsubtotal+newsubtotal);
						//����������Ʒ���ܼ۸�
							double total=cart.getTotal()+newsubtotal;
							cart.setTotal(total);
					}
					session.setAttribute("cart", cart);
					//��ת��cart.jsp
					response.sendRedirect("shopcart.jsp");
				}
				
		
		
		
		//�ύ����
		public void submitOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           //��ȡ���ﳵ
			HttpSession session = request.getSession();
			
			//��ȡ�ջ�������
		      String buyname=request.getParameter("buyname");
		    //��ȡ�ջ��˵绰
		      String telephone=request.getParameter("telephone");
		    //��ȡ�ջ���ַ
		      String address=request.getParameter("address");
		    
		      
			//User user = (User) session.getAttribute("user");
			User user=new User();
			user.setUid("002");
			user.setUname("������");
			
			
			
			
			 
			//Ŀ�ģ���װ��һ��Order���� ���ݸ�service��
			Order order = new Order();

			//1��private String oid;//�ö����Ķ�����
			
			String oid=CommonUtils.getOOid();
			order.setOid(oid);

			//2��private Date ordertime;//�µ�ʱ��
			order.setOrdertime(new Date());

			//3��private double total;//�ö������ܽ��
			//���session�еĹ��ﳵ
			Cart cart = (Cart) session.getAttribute("cart");
			double total = cart.getTotal();
			order.setTotal(total);

			//4��private int state;//����֧��״̬ 1�����Ѹ��� 0����δ����
			order.setState(0);

			//5��private String address;//�ջ���ַ
			order.setAddress(address);

			//6��private String name;//�ջ���
			order.setName(buyname);

			//7��private String telephone;//�ջ��˵绰
			order.setTelephone(telephone);

			//8��private User user;//�ö��������ĸ��û�
			order.setUser(user);

			//9���ö������ж��ٶ�����List<OrderItem> orderItems = new ArrayList<OrderItem>();
			//��ù��ﳵ�еĹ�����ļ���map
		
			Map<String, CartItem> cartItems = cart.getCartItems();
			for(Map.Entry<String, CartItem> entry : cartItems.entrySet()){
				//ȡ��ÿһ��������
				CartItem cartItem = entry.getValue();
				//�����µĶ�����
				OrderItem orderItem = new OrderItem();
				//1)private String iid;//�������id
				orderItem.setIid(CommonUtils.getOOid());
				//2)private int count;//����������Ʒ�Ĺ�������
				orderItem.setCount(cartItem.getBuyNum());
				//3)private double subtotal;//������С��
				orderItem.setSubtotal(cartItem.getSubtotal());
				//4)private Product product;//�������ڲ�����Ʒ
				orderItem.setProduct(cartItem.getProduct());
				//5)private Order order;//�ö����������ĸ�����
				orderItem.setOrder(order);

				//���ö�������ӵ������Ķ������private List<OrderItem> orderItems��;
				order.getOrderItems().add(orderItem);
			}


			//order�����װ���
			//�������ݵ�service��
			ProductService service = new ProductServiceImpl();
			service.submitOrder(order);


			session.setAttribute("order", order);

			//ҳ����ת
			response.sendRedirect("pay_index.jsp");


		}
	
		
		
	
}
