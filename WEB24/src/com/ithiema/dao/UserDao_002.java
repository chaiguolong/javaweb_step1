package com.ithiema.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.ithiema.domain.User;
import com.ithiema.utils.DataSourceUtils;

public class UserDao_002 {
	
	public User login(String username,String password) throws SQLException{

		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user username = ? and password = ?";
		return runner.query(sql,new BeanHandler<User>(User.class),username,password);

	}

}
