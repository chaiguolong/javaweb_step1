package com.ithiema.web.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

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
		final HttpServletRequest req = (HttpServletRequest) servletRequest;

		//使用动态代理完成全局编码
		HttpServletRequest enhanceRequset = (HttpServletRequest)Proxy.newProxyInstance(
				req.getClass().getClassLoader(),
				req.getClass().getInterfaces(),
				new InvocationHandler(){
					@Override
					public Object invoke(Object proxy,Method method,Object[] args) throws Throwable{
						//对getParameter方法进行增强
						String name = method.getName();//获得目标对象的方法名称
						if("getParameter".equals(name)){
							String invoke = (String)method.invoke(req,args);

							//转码
							invoke = new String(invoke.getBytes("iso8859-1"),"UTF-8");
							return invoke;
						}
						return method.invoke(req,args);
					}
				}
			);

	filterChain.doFilter(enhanceRequset,servletResponse);







		// servletRequest.setCharacterEncoding("UTF-8");
		//在传递request之前对request的getParameter方法进行增强
		/*
		 装饰者模式(包装)

		 1.增强类与被增强的类要实现统一接口
		 2.在增强类中传入被增强的类
		 3.需要增强的方法重写 不需要增强的方法调用被增强对象的
		 */

		//被增强的对象
		// HttpServletRequest req = (HttpServletRequest) servletRequest;
		// //增强对象
		// EnhanceRequest_002 enhanceRequest = new EnhanceRequest_002(req);
        //
		// filterChain.doFilter(enhanceRequest,servletResponse);


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
