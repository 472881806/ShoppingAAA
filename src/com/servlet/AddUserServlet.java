package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/adduser")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String name = request.getParameter("account_name");
			String phone = request.getParameter("account_phone");
			String password = request.getParameter("account_password");
			
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = 
	DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl","scott","admin");
			String sql = "insert into user_a (account_name,account_phone,account_password) values(?,?,?)";
			PreparedStatement psmt = conn.prepareStatement(sql);
		    psmt.setObject(1,name);
		    psmt.setObject(2,phone);
		    psmt.setObject(3,password);
		    psmt.execute();
		    
		    response.sendRedirect("user.jsp");
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
