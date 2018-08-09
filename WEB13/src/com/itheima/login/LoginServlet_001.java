package com.itheima.login;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import com.itheima.domain.User;
import com.itheima.utils.DataSourceUtils;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet_001 extends HttpServlet{
	private static final long serialVersionUID = -21324535345L;

	@Override
	public void init() throws ServletException{
		//在servletContext域中存一个数据count
		int count = 0;
		this.getServletContext().setAttribute("count",count);
	}


	protected void doGet(HttpServletRequest request ,HttpServletResponse response) throws ServletException ,IOException{
		//1.获得用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//2.从数据库中验证该用户名和密码是否正确
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where username=? and password=?";
		User user = null;
		try{
			user = runner.query(sql,new BeanHandler<User>(User.class),username,password);
		}catch(SQLException e){
			e.printStackTrace();
		}



	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException ,IOException{
		doGet(request,response);
	}
}
