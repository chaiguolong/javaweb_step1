package com.itheima.springmvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class Interceptor2_002 implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
		System.out.println("方法前 2");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object, ModelAndView modelAndView) throws Exception {
		System.out.println("方法后 2");
	}

	@Override
	public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object, Exception exception) throws Exception {
		System.out.println("渲染后 2");
	}

}


