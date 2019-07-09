package com.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BaseServlet
 */

public class BaseServlet extends HttpServlet {
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String act = request.getParameter("method");
		
		Class cls = this.getClass();
		try {
			Method method = cls.getDeclaredMethod(act, HttpServletRequest.class,HttpServletResponse.class);
		
			method.invoke(this,request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
