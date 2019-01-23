package com.whiteDream.web;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.whiteDream.entity.MessageInfo;
import com.whiteDream.service.MessageBoardService;
import com.whiteDream.utils.MD5Utils;

public class AddMessageServlet extends HttpServlet{
	private static final long serialVersionUID = -23324535345L;

	protected void doGet(HttpServletRequest request ,HttpServletResponse response) throws ServletException ,IOException{
		//设置从request中取得的值或从数据库中取出的值为UTF-8编码
		request.setCharacterEncoding("UTF-8");
		//获取text和token值
		String text = request.getParameter("text");
		System.out.println(text);
		MessageInfo messageInfo = new MessageInfo();
		messageInfo.setMessage(text);
		MessageBoardService ms = new MessageBoardService();
		ms.addMessage(messageInfo);
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException ,IOException{
		doGet(request,response);
	}
}
