package com.itheima.domian;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TestCustomerActiveServlet_002 extends HttpServlet{
	private static final long serialVersionUID = -23324535345L;

	protected void doGet(HttpServletRequest request ,HttpServletResponse response) throws ServletException ,IOException{
		HttpSession session = request.getSession();

		//将session放到session中
		Customer customer = new Customer();
		customer.setId("200");
		customer.setName("lucy");
		session.setAttribute("customer",customer);

		System.out.println("customer被放到session域中了");

	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException ,IOException{
		doGet(request,response);
	}
}
