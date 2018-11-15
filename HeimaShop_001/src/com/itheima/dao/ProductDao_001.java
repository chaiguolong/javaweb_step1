package com.itheima.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;


import com.itheima.domain.Product;
import com.itheima.utils.DataSourceUtils;
import com.itheima.domain.Category;

public class ProductDao_001 {
	//获得热门商品
	public List<Product> findHotProductList() throws SQLException{
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from Product where is_hot = ? limit ?,?";
		return runner.query(sql,new BeanListHandler<Product>(Product.class),1,0,9);
	}

	public List<Product> findNewProductList() throws SQLException{
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from Product order by pdate desc limit ?,?"; 
		return runner.query(sql,new BeanListHandler<Product>(Product.class),0,9);
	}

	public int getCount(String cid) throws SQLException{
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from Product where cid=?";
		Long query = (Long)runner.query(sql,new ScalarHandler(),cid);
		return query.intValue();
	}

	public List<Product> findProductByPage(String cid,int index,int currentCount) throws SQLException{
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from Product where cid=? limit ?,?";
		return runner.query(sql,new BeanListHandler<Product>(Product.class),cid,index,currentCount);
	}

	public List<Category> findAllCategory() throws SQLException{
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from Category";
		return runner.query(sql,new BeanListHandler<Category>(Category.class));
	}

	public Product findProductByPid(String pid) throws SQLException{
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product where pid=?";
		return runner.query(sql,new BeanHandler<Product>(Product.class),pid);
	}

}
