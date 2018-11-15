package com.itheima.web.servlet;


import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.Category;
import com.itheima.service.ProductService_001;
import com.itheima.utils.JedisPoolUtils;
import redis.clients.jedis.Jedis;

public class CategoryListServlet_001 extends HttpServlet{
	private static final long serialVersionUID = -23324535345L;

	protected void doGet(HttpServletRequest request ,HttpServletResponse response) throws ServletException ,IOException{

		ProductService_001 service = new ProductService_001();

		//先从缓存总查询categoryList 如果有直接使用 没有再从数据库中查询 存到缓存
		//1.获得jedis对象 连接redis数据库
		Jedis jedis = JedisPoolUtils.getJedis();

		String categoryListJson = jedis.get("categoryListJson");

		//2.判断categoryListJson是否为空
		if(categoryListJson==null){
			System.out.println("--------222222-------------");
			System.out.println("缓存没有数据 查询数据库");
			//准备分类数据
			List<Category> categoryList = service.findAllCategory();

			Gson gson = new Gson();
			categoryListJson = gson.toJson(categoryList);
			jedis.set("categoryListJson",categoryListJson);
		}

		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(categoryListJson);



	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException ,IOException{
		doGet(request,response);
	}
}
