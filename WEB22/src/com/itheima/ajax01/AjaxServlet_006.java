package com.itheima.ajax01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AjaxServlet_006 extends HttpServlet{
	private static final long serialVersionUID = -23324535345L;

	protected void doGet(HttpServletRequest request ,HttpServletResponse response) throws ServletException ,IOException{

		try {
			Thread.sleep(5000);
		} catch(Exception e){
			e.printStackTrace();
		}

		String parameter = request.getParameter("name");
		response.getWriter().write(Math.random()+parameter);


	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException ,IOException{
		doGet(request,response);
	}
}
