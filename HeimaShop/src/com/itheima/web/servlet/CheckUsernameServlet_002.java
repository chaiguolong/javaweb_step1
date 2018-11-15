package com.itheima.web.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.service.UserService_002;

public class CheckUsernameServlet_002 extends HttpServlet{
	private static final long serialVersionUID = -23324535345L;

	protected void doGet(HttpServletRequest request ,HttpServletResponse response) throws ServletException ,IOException{

		//获得用户名
		String username = request.getParameter("username");

		UserService_002 service = new UserService_002();

		boolean isExist = service.checkUsername(username);

		String json = "{\"isExist\":"+isExist+"}";

		System.out.println(json);

		response.getWriter().write(json);


	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException ,IOException{
		doGet(request,response);
	}
}
