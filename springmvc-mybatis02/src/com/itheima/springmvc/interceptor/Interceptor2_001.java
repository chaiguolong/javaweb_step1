package com.itheima.springmvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class Interceptor2_001 implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response ,Object object) throws Exception {
		System.out.println("方法前 2");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView modelAndView) throws Exception {
		System.out.println("方法后 2");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception exception) throws Exception {
		System.out.println("页面渲染后2");
	}
}




