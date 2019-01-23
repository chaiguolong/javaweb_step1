package com.whiteDream.web;
import com.whiteDream.entity.MessageInfo;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.whiteDream.service.MessageBoardService;

public class ShowMessageServlet extends HttpServlet{
	private static final long serialVersionUID = -23324535345L;

	protected void doGet(HttpServletRequest request ,HttpServletResponse response) throws ServletException ,IOException{
		request.setCharacterEncoding("UTF-8");
		MessageBoardService ms = new MessageBoardService();
		List<MessageInfo> messageList = ms.findListNewMessage();
		System.out.println(messageList.get(0).getMtime());
		request.setAttribute("messageList",messageList);
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException ,IOException{
		doGet(request,response);
	}
}
