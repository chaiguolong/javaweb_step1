package com.itheima.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SendCookieServlet_001 extends HttpServlet{
	private static final long serialVersionUID = -23324535345L;

	protected void doGet(HttpServletRequest request ,HttpServletResponse response) throws ServletException ,IOException{

		//1.创建cookie对象
		Cookie cookie = new Cookie("name","zhangsan");

		//1.1为cookie设置持久化时间---cookie信息在硬盘上保存的时间
		cookie.setMaxAge(10*60);//10分钟---时间设置为0代表删除该cookie
		//1.2为cookie设置携带路劲
		cookie.setPath("/WEB16/sendCookie");//访问sendCookie资源时才携带这个cookie



	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException ,IOException{
		doGet(request,response);
	}
}
