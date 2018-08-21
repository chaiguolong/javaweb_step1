package com.itheima.dbutils;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.itheima.utils.DataSourceUtils;

public class DBUtilsDemo_001{
	public static void main(String[] args) {
		Connection conn = null;
		try {
			QueryRunner runner = new QueryRunner();
			//获得一个Connection
			conn = DataSourceUtils.getConnection();

			//开启事务
			conn.setAutoCommit(false);

			runner.update(conn,"update account set money=15000 where name='tomo'");

			//提交或回滚事务
			conn.commit();
		} catch(Exception e){
			try {
				conn.rollback();
			} catch(Exception e1){
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
}
