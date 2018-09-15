package com.ithiema.web.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class EncodingFilter_002 implements Filter{

	@Override
	public void destroy() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		servletRequest.setCharacterEncoding("UTF-8");
		//在传递request之前对request的getParameter方法进行增强
		/*
		 装饰者模式(包装)

		 1.增强类与被增强的类要实现统一接口
		 2.在增强类中传入被增强的类
		 3.需要增强的方法重写 不需要增强的方法调用被增强对象的
		 */

		//被增强的对象
		HttpServletRequest req = (HttpServletRequest) servletRequest;
		//增强对象
		EnhanceRequest_002 enhanceRequest = new EnhanceRequest_002(req);

		filterChain.doFilter(enhanceRequest,servletResponse);


	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		throw new UnsupportedOperationException();
	}
}

class EnhanceRequest_002 extends HttpServletRequestWrapper{

	private HttpServletRequest servletRequest;

	public EnhanceRequest_002(HttpServletRequest servletRequest) {
		super(servletRequest);
		this.servletRequest = servletRequest;
	}

	@Override
	public String getParameter(String name){
		String parameter = servletRequest.getParameter(name);//乱码
		try {
			parameter = new String(parameter.getBytes("iso8859-1"),"UTF-8");
		} catch(Exception e){
			e.printStackTrace();
		}

		return parameter;
	}



}
