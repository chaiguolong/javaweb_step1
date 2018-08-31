package com.itheima.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.Category;
import com.itheima.domain.Product;
import com.itheima.service.AdminProductService_001;

public class AdminUpdateProductUIServlet_001 extends HttpServlet{
	private static final long serialVersionUID = -23324535345L;

	protected void doGet(HttpServletRequest request ,HttpServletResponse response) throws ServletException ,IOException{
		
		//获得要查询Product的pid
		String pid = request.getParameter("pid");
		//传递pid查询商品信息
		AdminProductService_001 service = new AdminProductService_001();
		Product product = null;
		try {
			product = service.findProductByPid(pid);
		} catch(Exception e){
			e.printStackTrace();
		}

		//获得所有的商品的类别数据
		List<Category> categoryList = null;
		try {
			categoryList = service.findAllCategory();
		} catch(Exception e){
			e.printStackTrace();
		}

		request.setAttribute("categoryList",categoryList);
		request.setAttribute("product",product);

		request.getRequestDispatcher("/admin/product/edit_001.jsp").forward(request,response);
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException ,IOException{
		doGet(request,response);
	}
}
