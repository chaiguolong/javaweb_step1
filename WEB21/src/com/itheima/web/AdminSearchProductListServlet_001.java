package com.itheima.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.itheima.domain.Category;
import com.itheima.domain.Product;
import com.itheima.service.AdminProductService_001;
import com.itheima.vo.Condition;

public class AdminSearchProductListServlet_001 extends HttpServlet{
	private static final long serialVersionUID = -23324535345L;

	protected void doGet(HttpServletRequest request ,HttpServletResponse response) throws ServletException ,IOException{

		request.setCharacterEncoding("UTF-8");

		//1.收集表单数据
		Map<String,String[]> properties = request.getParameterMap();
		//2.将散装的查询数据封装到一个VO实体中
		Condition condition = new Condition();
		try {
			BeanUtils.populate(condition,properties);
		} catch(Exception e){
			e.printStackTrace();
		}

		//3.将实体传递给service层
		AdminProductService_001 service = new AdminProductService_001();
		List<Product> productList = null;
		try {
			productList= service.findProductListByCondition(condition);
		} catch(Exception e){
			e.printStackTrace();
		}

		//准备商品类别
		//获得所有商品的类别数据

		List<Category> categoryList = null;
		try {
			categoryList = service.findAllCategory();
		} catch(Exception e){
			e.printStackTrace();
		}

		request.setAttribute("condition",condition);
		request.setAttribute("categoryList",categoryList);
		request.setAttribute("productList",productList);

		request.getRequestDispatcher("/admin/product/list_001.jsp").forward(request,response);




	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException ,IOException{
		doGet(request,response);
	}
}



























