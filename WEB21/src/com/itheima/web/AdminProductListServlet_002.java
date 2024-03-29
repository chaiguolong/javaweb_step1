package com.itheima.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.Product;
import com.itheima.service.AdminProductService_002;

public class AdminProductListServlet_002 extends HttpServlet{
	private static final long serialVersionUID = -23324535345L;

	protected void doGet(HttpServletRequest request ,HttpServletResponse response) throws ServletException ,IOException{
		//传递请求到service层
		AdminProductService_002 service = new AdminProductService_002();
		List<Product> productList = null;
		try {
			productList = service.findAllProduct();
		} catch(Exception e){
			e.printStackTrace();
		}

		//将productList放到request域
		request.setAttribute("productList",productList);

		request.getRequestDispatcher("/admin/product/list_002.jsp").forward(request,response);

	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException ,IOException{
		doGet(request,response);
	}
}
