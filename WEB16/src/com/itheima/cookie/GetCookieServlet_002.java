package com.itheima.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetCookieServlet_002 extends HttpServlet{
	private static final long serialVersionUID = -23324535345L;

	protected void doGet(HttpServletRequest request ,HttpServletResponse response) throws ServletException ,IOException{

		//1.获取客户端携带的cookie的数据
		Cookie[] cookies = request.getCookies();
		// Cookie cookie = new Cookie("name","zhangsan");
		// 通过cookie名称获得想要的cookie
		if(cookies != null){
			for (Cookie cookie : cookies) {
				if("name".equals(cookie.getName())){
					String cookieValue = cookie.getValue();
					System.out.println(cookieValue);
				}
			}
		}

	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException ,IOException{
		doGet(request,response);
	}
}
