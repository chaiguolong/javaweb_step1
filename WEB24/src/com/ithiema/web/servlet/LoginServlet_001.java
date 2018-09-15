package com.ithiema.web.servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ithiema.domain.User;
import com.ithiema.service.UserService_001;
public class LoginServlet_001 extends HttpServlet{
	private static final long serialVersionUID = -23324535345L;

	protected void doGet(HttpServletRequest request ,HttpServletResponse response) throws ServletException ,IOException{
		request.setCharacterEncoding("UTD-8");

		HttpSession session = request.getSession();

		//获取数据
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		UserService_001 service = new UserService_001();
		User user = null;
		try {
			service.login(username,password);
		} catch(Exception e){
			e.printStackTrace();
		}

		if(user!=null){
			//登录成功
			//判断用户是否勾选自动登录
			String autoLogin = request.getParameter("autoLogin");
			if(autoLogin!=null){
				//对中文张三进行编码
				String username_code = URLEncoder.encode(username,"UTF-8");

				Cookie cookie_username = new Cookie("cookie_username",username_code);
				Cookie cookie_password = new Cookie("cookie_password",password);
				//设置cookie的持久化时间
				cookie_username.setMaxAge(60*60);
				cookie_password.setMaxAge(60*60);
				//设置cookie的携带路径
				cookie_username.setPath(request.getContextPath());
				cookie_password.setPath(request.getContextPath());
				//发送cookie
				response.addCookie(cookie_username);
				response.addCookie(cookie_password);

			}

			//将登录的用户的user对象存储到session中
			session.setAttribute("user",user);
			//重定向到首页
			response.sendRedirect(request.getContextPath());
		}else{
			//失败 转发到登录页面 提出提示信息
			request.setAttribute("loginInfo","用户名或密码错误");
			request.getRequestDispatcher("/login.jsp").forward(request,response);
		}
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException ,IOException{
		doGet(request,response);
	}
}
