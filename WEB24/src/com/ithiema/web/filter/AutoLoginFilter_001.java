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
import com.ithiema.service.UserService_001;

public class AutoLoginFilter_001 implements Filter{

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)servletRequest;
		HttpServletResponse res = (HttpServletResponse)servletResponse;
		HttpSession session = req.getSession();

		//获得cookie中用户名和密码 进行登录的操作
		//定义cookie_username
		String cookie_username = null;
		//定义cookie_password
		String cookie_password = null;
		//获得cookie
		Cookie[] cookies = req.getCookies();
		if(cookies != null){
			for (Cookie cookie : cookies) {
				//获得名字是cookie_username和cookie_password
				if("cookie_username".equals(cookie.getName())){
					cookie_username = cookie.getValue();
					//恢复中文用户名
				}

				if("cookie_password".equals(cookie.getName())){
					cookie_password = cookie.getValue();
				}
			}
		}

		//判断username和password是否是null
		if(cookie_username!=null && cookie_password!=null){
			//登录的代码
			UserService_001 service = new UserService_001();
			User user = null;
			try {
				user = service.login(cookie_username,cookie_password);
			} catch(Exception e){
				e.printStackTrace();
			}
			//将登录用户的user对象存到session中
			session.setAttribute("user",user);
		}
		//放行
		filterChain.doFilter(req,res);

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}
}
