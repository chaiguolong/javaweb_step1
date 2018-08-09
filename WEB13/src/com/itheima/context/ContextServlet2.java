package com.itheima.context;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContextServlet2 extends HttpServlet {

	private static final long serialVersionUID = -763618247875550322L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//域对象---从servletContext中取数据
		String attribute = (String) this.getServletContext().getAttribute("name");
		response.getWriter().write(attribute);
		response.getWriter().write("I have not console");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
