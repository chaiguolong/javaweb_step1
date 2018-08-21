package com.itheima.dao;

import java.sql.SQLException;
import java.util.List;

import com.itheima.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.itheima.domain.Product;

public class ProductDao_001{

	public List<Product> findAllProduct() throws SQLException{
		//操作数据库
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

		String sql = "select * from product";

		List<Product> productList = runner.query(sql,new BeanListHandler<Product>(Product.class));

		return productList;
	}

}
