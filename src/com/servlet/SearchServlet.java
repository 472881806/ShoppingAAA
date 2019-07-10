package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Product;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String name = request.getParameter("title");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "admin");
			String sql = "select * from content_s where cname like '%"+name+"%' or content like '%"+name+"%' ";
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			List pros = new ArrayList();
			
			if(rs!=null){
				while(rs.next()){
					String pid = rs.getString(1);
					String pname = rs.getString(2);
					double price = rs.getDouble(3);
					long pnum = rs.getLong(4);
					String content = rs.getString(6);
					String kind = rs.getString(7);
					String pimage = rs.getString(8);
					
					Product pro = new Product();
					pro.setPid(pid);
					pro.setPname(pname);
					pro.setPrice(price);
					pro.setPnum(pnum);
					pro.setContent(content);
					pro.setKind(kind);
					pro.setPimage(pimage);
					pros.add(pro);

				}
				
				request.setAttribute("pros", pros);
				request.getRequestDispatcher("details.jsp").forward(request, response);
			}else{
				request.setAttribute("message", "没有该商品！");
				request.getRequestDispatcher("details.jsp").forward(request, response);
			}	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
