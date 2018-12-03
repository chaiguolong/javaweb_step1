package com.itheima.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.itheima.domain.User;
import com.itheima.utils.DataSourceUtils;
public class UserDao_001 {

	public User login(String username,String password) throws SQLException{
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where username=? and password=?";
		return runner.query(sql,new BeanHandler<User>(User.class),username,password);
	}






}
