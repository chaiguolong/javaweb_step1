package com.itheima.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.service.UserService_002;

public class CheckUsernameServlet_002 extends HttpServlet{
	private static final long serialVersionUID = -23324535345L;

	protected void doGet(HttpServletRequest request ,HttpServletResponse response) throws ServletException ,IOException{

		//获得要校验的用户名
		String username = request.getParameter("username");

		//传递username到service
		UserService_002 service = new UserService_002();
		boolean isExist = false;
		try {
			isExist = service.checkUsername(username);
		} catch(Exception e){
			e.printStackTrace();
		}



		response.getWriter().write("{\"isExist\":"+isExist+"}");


	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException ,IOException{
		doGet(request,response);
	}
}
