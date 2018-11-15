package com.itheima.web.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("rawtypes")
public class BaseServlet_002 extends HttpServlet{
	private static final long serialVersionUID = -345341231532346L;

	@SuppressWarnings("unchecked")
	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException ,IOException{

		request.setCharacterEncoding("UTF-8");
		try {
			//1.获取请求的method的名字
			String methodName = request.getParameter("method");
			//2.获得当前被访问的对象的字节码对象
			Class clazz = this.getClass();
			//3.获得当前字节码对象中的指定方法
			Method method = clazz.getMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
			//4.执行相应功能方法
			method.invoke(this,request,response);
		} catch(Exception e){
			e.printStackTrace();
		}
	}

}
