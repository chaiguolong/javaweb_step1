package com.itheima.context;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TextServlet_001 extends HttpServlet{

	private static final long serialVersionUID = -23324535345L;

	protected void doGet(HttpServletRequest request ,HttpServletResponse response) throws ServletException ,IOException{
		//设置response查询的码表
		// response.getCharacterEncoding("UTF-8");
		
		//通过一个头Contenet-Type 告知客户端使用何种码表
		// response.setHeader("Content-Type","text/html;charset=UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter writer = response.getWriter();

		writer.write("hello response");

		// writer.write("你好");

		

	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException ,IOException{
		doGet(request,response);
	}
}
