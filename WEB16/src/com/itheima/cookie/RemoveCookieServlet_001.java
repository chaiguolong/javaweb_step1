package com.itheima.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RemoveCookieServlet_001 extends HttpServlet{
	private static final long serialVersionUID = -23324535345L;

	protected void doGet(HttpServletRequest request ,HttpServletResponse response) throws ServletException ,IOException{

		//删除客户端保存name=zhangsan的cookie信息
		Cookie cookie = new Cookie("name","");
		//将path设置为与要删除cookie的path一致
		cookie.setPath("/WEB16");
		//设置时间为0
		cookie.setMaxAge(0);

		response.addCookie(cookie);

	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException ,IOException{
		doGet(request,response);
	}
}