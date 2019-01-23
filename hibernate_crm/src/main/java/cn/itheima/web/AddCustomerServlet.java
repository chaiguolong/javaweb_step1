package cn.itheima.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.itheima.domain.Customer;
import cn.itheima.service.CustomerService;
import cn.itheima.service.impl.CustomerServiceImpl;
public class AddCustomerServlet extends HttpServlet{
	private static final long serialVersionUID = -23324535345L;

	private CustomerService customerService = new CustomerServiceImpl();

	protected void doGet(HttpServletRequest request ,HttpServletResponse response) throws ServletException ,IOException{
		//1.获取请求参数,封装到Customer
		Customer c = new Customer();
		try {
			BeanUtils.populate(c,request.getParameterMap());
		} catch(Exception e){
			e.printStackTrace();
		}
		//2.传递到CustomerService,进行保存
		customerService.save(c);

		//3.重定向到CustomerList
		response.sendRedirect(request.getContextPath()+"/ListCustomerServlet");


	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException ,IOException{
		doGet(request,response);
	}
}
