package com.itheima.springmvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class Interceptor1_001 implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		System.out.println("方法前1");
		String requestURI = request.getRequestURI();
		String username = (String)request.getSession().getAttribute("USER_SESSION");
		System.out.println(username);
		if(!requestURI.contains("/login_001")){
			if(null == username){
				response.sendRedirect(request.getContextPath() + "/login_001.action");
				return false;
			}
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView modelAndView) throws Exception {
		System.out.println("方法后 1");
	}


	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception exception) throws Exception {
		System.out.println("页面渲染后 1");
	}


}



