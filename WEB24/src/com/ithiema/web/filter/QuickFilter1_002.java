package com.ithiema.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class QuickFilter1_002 implements Filter{

	@Override
	public void destroy() {
		System.out.println("destroy");
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		System.out.println("quick1 running......");
		//放行请求
		filterChain.doFilter(servletRequest,servletResponse);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//1.获得web.xml中filter的名称<filter-name>QuickFilter1_002</filter-name>
		System.out.println(filterConfig.getFilterName());
		//2.获得当前filter的初始化参数
		System.out.println(filterConfig.getInitParameter("aaa"));
		//3.获得servletContext
		filterConfig.getServletContext();

		System.out.println("init.......");
	}
}
