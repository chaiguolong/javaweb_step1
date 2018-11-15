package com.itheima.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.itheima.domain.Category;
import com.itheima.domain.Product;
import com.itheima.utils.DataSourceUtils;

public class ProductDao_001 {
	//根据pid获得产品
	public Product findProductByPid(String pid) throws SQLException{
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product where pid=?";
		return runner.query(sql, new BeanHandler<Product>(Product.class),pid);
	}

	//获得当前页的产品列表
	public List<Product> findProductByPage(String cid,int index,int currentCount) throws SQLException{
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product where cid=? limit ?,?";
		List<Product> list = runner.query(sql,new BeanListHandler<Product>(Product.class),cid,index,currentCount);
		return list;
	}

	//获得当前分类的总条数
	public int getCount(String cid) throws SQLException{
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from product where cid=?";
		Long query = (Long)runner.query(sql,new ScalarHandler(),cid);
		return query.intValue();
	}

	//获得热门商品
	public List<Product> findHotProductList() throws SQLException{
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product where is_hot=? limit ?,?";
		return runner.query(sql,new BeanListHandler<Product>(Product.class),1,0,9);
	}

	//获得最新商品
	public List<Product> findNewProductList() throws SQLException{
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product order by pdate desc limit ?,?";
		return runner.query(sql,new BeanListHandler<Product>(Product.class),0,9);
	}

	//获得分类列表
	public List<Category> findAllCategory() throws SQLException{
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from category";
		return runner.query(sql,new BeanListHandler<Category>(Category.class));
	}


}
