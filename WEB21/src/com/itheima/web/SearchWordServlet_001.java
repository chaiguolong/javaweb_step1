
package com.itheima.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.itheima.domain.Product;
import com.itheima.service.ProductService_001;

import net.sf.json.JSONArray;
// import sun.org.mozilla.javascript.internal.json.JsonParser;
public class SearchWordServlet_001 extends HttpServlet{
	private static final long serialVersionUID = -23324535345L;

	protected void doGet(HttpServletRequest request ,HttpServletResponse response) throws ServletException ,IOException{

		//获得关键字
		String word = request.getParameter("word");

		//查询该关键字的所有商品
		ProductService_001 service = new ProductService_001();
		List<Object> productList = null;
		try {
			productList = service.findProductByWord(word);
		} catch(Exception e){
			e.printStackTrace();
		}

		JSONArray fromObject = JSONArray.fromObject(productList);
		String json = 	fromObject.toString();
		System.out.println(json);

		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(json);




	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException ,IOException{
		doGet(request,response);
	}
}
