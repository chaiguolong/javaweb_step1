package com.itheima.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.service.AdminProductService_002;

public class AdminDelProductServlet_002 extends HttpServlet{
	private static final long serialVersionUID = -23324535345L;

	protected void doGet(HttpServletRequest request ,HttpServletResponse response) throws ServletException ,IOException{

		//获取要删除的pid
		String pid = request.getParameter("pid");

		//传递pid到service层
		AdminProductService_002 service = new AdminProductService_002();
		try {
			service.delProductByPid(pid);
		} catch(SQLException e){
			e.printStackTrace();
		}

		response.sendRedirect(request.getContextPath()+"/adminProductList_002");
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException ,IOException{
		doGet(request,response);
	}
}
