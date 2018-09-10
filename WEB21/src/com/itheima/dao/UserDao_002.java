package com.itheima.dao;

import java.sql.SQLException;

import com.itheima.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

public class UserDao_002 {
	public Long checkUsername(String username) throws SQLException{
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from user where username=?";
		Long query = (Long) runner.query(sql,new ScalarHandler(),username);
		return query;
	}
}
