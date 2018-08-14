package com.itheima.login;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.itheima.register.User;
import com.itheima.utils.DataSourceUtils;


public class LoginServlet_002 extends HttpServlet{
	private static final long serialVersionUID = -23324535345L;

	protected void doGet(HttpServletRequest request ,HttpServletResponse response) throws ServletException ,IOException{

		request.setCharacterEncoding("UTF-8");

		//1.获得用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//2.调用一个业务方法进行该用户的查询
		User login = null;
		try{
			login = login(username,password);
		}catch(SQLException e){
			e.printStackTrace();
		}

		//3.通过user是否为null判断用户名和密码是否正确
		if(login != null){
			//用户名和密码正确
			//登录成功,跳转到网站的首页
			response.sendRedirect(request.getContextPath());
		}else{
			//用户名或密码错误
			//调回当前的login.jsp
			request.setAttribute("loginInfo","用户名或密码错误");
			request.getRequestDispatcher("/login.jsp").forward(request,response);
		}

	}

	public User login(String username,String password) throws SQLException{
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where username=? and password=?";

		User user = runner.query(sql,new BeanHandler<User>(User.class),username,password);
		return user;
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException ,IOException{
		doGet(request,response);
	}
}
