package com.ithiema.web.filter;

import java.io.IOException;
import java.net.URLDecoder;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ithiema.domain.User;
import com.ithiema.service.UserService_002;

public class AutoLoginFilter_002 implements Filter{

	@Override
	public void destroy() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) servletRequest;
		HttpServletResponse resp = (HttpServletResponse) servletResponse;
		HttpSession session = req.getSession();

		//定义cookie中的用户名和密码 进行登录的操作
		//定义cookie_username
		String cookie_username = null;
		//定义cookie_password
		String cookie_password = null;
		//获得cookie
		Cookie[] cookies = req.getCookies();
		if(cookies != null){
			for(Cookie cookie : cookies){
				//获得名字是cookie_name和cookie_password
				if("cookie_username".equals(cookie.getName())){
					cookie_username = cookie.getValue();
					//恢复中文用户名
					cookie_username = URLDecoder.decode(cookie_username,"UTF-8");
				}
				if("cookie_password".equals(cookie.getName())){
					cookie_password = cookie.getValue();
				}
			}
		}

		//判断username和password是否是null
		if(cookie_username != null && cookie_password != null){
			//登录的代码
			UserService_002 service = new UserService_002();
			User user = null;
			try {
				user = service.login(cookie_username,cookie_password);
			} catch(Exception e){
				e.printStackTrace();
			}
			//将登录的用户的user对象存到session中
			session.setAttribute("user",user);
		}

		//放行
		filterChain.doFilter(req,resp);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		throw new UnsupportedOperationException();
	}
}
