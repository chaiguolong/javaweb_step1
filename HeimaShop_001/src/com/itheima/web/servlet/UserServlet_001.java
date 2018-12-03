package com.itheima.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itheima.domain.User;
import com.itheima.service.UserService_001;
import com.itheima.utils.MD5Utils;

public class UserServlet_001 extends BaseServlet{
	private static final long serialVersionUID = -345341231532346L;

	//用户登录
	public void login(HttpServletRequest request ,HttpServletResponse response) throws ServletException,IOException{
		HttpSession session = request.getSession();

		//获得输入的用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		//对密码进行加密
		// password = MD5Utils.md5(password);

		//将用户名和密码传递给service层
		UserService_001 service = new UserService_001();
		User user = null;
		try {
			user = service.login(username,password);
		} catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(user.getName());
		System.out.println(user.getUid());

		//判断用户是否登录成功 user是否是null
		if(user != null){
			//登录成功
			//***************判断用户是否勾选了自动登录*****************
			String autoLogin = request.getParameter("autoLogin");
			System.out.println(autoLogin);
			if("true".equals(autoLogin)){
				//要自动登录
				//创建存储用户名的cookie
				Cookie cookie_username = new Cookie("cookie_username",user.getUsername());
				cookie_username.setMaxAge(10*60);
				//创建存储密码的cookie
				Cookie cookie_password = new Cookie("cookie_password",user.getPassword());
				cookie_password.setMaxAge(10*60);

				response.addCookie(cookie_username);
				response.addCookie(cookie_password);
			}

			//***************************************************
			//将user对象存到session中
			session.setAttribute("user",user);

			//将user对象存到session中
			response.sendRedirect(request.getContextPath()+"/index_001.jsp");
		}else{
			request.setAttribute("loginError","用户名或密码错误");
			request.getRequestDispatcher("/login_001.jsp").forward(request,response);
		}

	}

}
