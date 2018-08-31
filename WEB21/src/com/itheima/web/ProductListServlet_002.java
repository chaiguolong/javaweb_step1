package com.itheima.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.Product;
import com.itheima.service.ProductService_002;
import com.itheima.vo.PageBean;

public class ProductListServlet_002 extends HttpServlet{
	private static final long serialVersionUID = -23324535345L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request ,HttpServletResponse response) throws ServletException ,IOException{
		ProductService_002 service = new ProductService_002();

		//模拟当前是第一页
		String currentPageStr = request.getParameter("currentPage");
		if(currentPageStr==null){
			currentPageStr = "1";
		}
		int currentPage = Integer.parseInt(currentPageStr);
		//认为每页显示12条
		int currentCount = 12;

		PageBean<Product> pageBean = null;

		try {
			pageBean = service.findPageBean(currentPage,currentCount);
		} catch(Exception e){
			e.printStackTrace();
		}

		for (Product pro : pageBean.getProductList()) {
			System.out.println(pro.getPname());
		}
		request.setAttribute("pageBean",pageBean);

		request.getRequestDispatcher("/product_list_002.jsp").forward(request,response);


	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException ,IOException{
		doGet(request,response);
	}
}
