package com.itheima.web.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.service.UserService_001;

public class ActiveServlet_001 extends HttpServlet{
	private static final long serialVersionUID = -23324535345L;

	protected void doGet(HttpServletRequest request ,HttpServletResponse response) throws ServletException ,IOException{
		//获得激活码
		String activeCode = request.getParameter("activeCode");

		UserService_001 service = new UserService_001();
		service.active(activeCode);

		//跳转到登录界面
		response.sendRedirect(request.getContextPath()+"/login_001.jsp");


	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException ,IOException{
		doGet(request,response);
	}
}
