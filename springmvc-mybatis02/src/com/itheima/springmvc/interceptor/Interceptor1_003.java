package com.itheima.springmvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class Interceptor1_003 implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		System.out.println("方法前	1");
		String requestURI = request.getRequestURI();
		if(!requestURI.contains("/login_003")){
			String username = (String)request.getSession().getAttribute("USER_SESSION");
			System.out.println(username);
			if(null == username){
				response.sendRedirect(request.getContextPath()+"/login_003");
			}
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object, ModelAndView modelAndView) throws Exception {
		System.out.println("方法后	1");
	}

	@Override
	public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object, Exception exception) throws Exception {
		System.out.println("渲染后	1");
	}

}
