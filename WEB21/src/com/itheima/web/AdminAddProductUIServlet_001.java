package com.itheima.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.Category;
import com.itheima.service.AdminProductService_001;

public class AdminAddProductUIServlet_001 extends HttpServlet{
	private static final long serialVersionUID = -23324535345L;

	protected void doGet(HttpServletRequest request ,HttpServletResponse response) throws ServletException ,IOException{

		//获得所有的商品的类别数据
		AdminProductService_001 service = new AdminProductService_001();
		List<Category> categoryList = null;
		try {
			categoryList = service.findAllCategory();
		} catch(Exception e){
			e.printStackTrace();
		}

		request.setAttribute("categoryList",categoryList);

		request.getRequestDispatcher("/admin/product/add_001.jsp").forward(request,response);
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException ,IOException{
		doGet(request,response);
	}
}
