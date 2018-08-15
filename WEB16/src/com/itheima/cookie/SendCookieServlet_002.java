package com.itheima.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendCookieServlet_002 extends HttpServlet{
	private static final long serialVersionUID = -23324535345L;

	protected void doGet(HttpServletRequest request ,HttpServletResponse response) throws ServletException ,IOException{
		
		//1.创建cookie对象
		Cookie cookie = new Cookie("name","zhangsan");

		//1.1为cookie设置持久化时间---cookie信息子啊硬盘上保存的时间
		cookie.setMaxAge(60*10);//10分钟----时间设置为0代表删除该cookie
		//1.2为cookie设置携带路径
		// cookie.setPath("/Web/sendCookie");//访问sendCookie资源时才携带这个cookie
		cookie.setPath("/WEB16");//访问WEB16下任何资源时都携带这个cookie
		cookie.setPath("/");//访问服务器下所有的资源都携带这个cookie

		//2.将cookie中存储的信息发送到客户端---头
		response.addCookie(cookie);

	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException ,IOException{
		doGet(request,response);
	}
}
