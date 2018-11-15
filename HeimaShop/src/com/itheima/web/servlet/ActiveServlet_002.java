package com.itheima.web.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.service.UserService_002;

public class ActiveServlet_002 extends HttpServlet{
	private static final long serialVersionUID = -23324535345L;

	protected void doGet(HttpServletRequest request ,HttpServletResponse response) throws ServletException ,IOException{
		//获得激活码
		String activeCode = request.getParameter("activeCode");

		UserService_002 service = new UserService_002();

		service.active(activeCode);

		//跳转到登录界面
		response.sendRedirect(request.getContextPath()+"/login.jsp");

	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException ,IOException{
		doGet(request,response);
	}
}
