package com.itheima.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet_002 extends HttpServlet{
	private static final long serialVersionUID = -23324535345L;

	protected void doGet(HttpServletRequest request ,HttpServletResponse response) throws ServletException ,IOException{

		request.setCharacterEncoding("UTF-8");

		//验证码校验
		//获得页面的验证码
		String checkCode_client = request.getParameter("checkCode");
		//获得生成图片的验证码
		String checkCode_session =(String)request.getSession().getAttribute("checkCode_session");
		//比对页面的和生成的图片的文字的验证码是否一致
		if(checkCode_session.equals(checkCode_session)){
			request.setAttribute("loginInfo","您的验证码不正确");
			request.getRequestDispatcher("/login.jsp").forward(request,response);
			return;
		}

	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException ,IOException{
		doGet(request,response);
	}
}
