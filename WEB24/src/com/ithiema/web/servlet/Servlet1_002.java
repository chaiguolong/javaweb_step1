package com.ithiema.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1_002 extends HttpServlet{
	private static final long serialVersionUID = -23324535345L;

	protected void doGet(HttpServletRequest request ,HttpServletResponse response) throws ServletException ,IOException{
		System.out.println("Servlet1 running");
		response.getWriter().write("Servlet1 running...");

		request.getRequestDispatcher("servlet2").forward(request,response);
		response.sendRedirect(request.getContextPath()+"/servlet2");
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException ,IOException{
		doGet(request,response);
	}
}
