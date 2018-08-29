package com.itheima.service;
import java.sql.SQLException;
import java.util.List;

import com.itheima.dao.AdminProductDao_001;
import com.itheima.domain.Category;
import com.itheima.domain.Product;

public class AdminProductService_001 {
	
	//查询所有的商品
	public List<Product> findAllProduct() throws SQLException{
		//因为没有复杂的业务,直接传递请求到dao
		AdminProductDao_001 dao = new AdminProductDao_001();
		return dao.findAllProduct();
	}

	//获得所有的类别
	public List<Category> findAllCategory() throws SQLException{
		AdminProductDao_001 dao = new AdminProductDao_001();
		return dao.findAllCategory();
	}

	//添加数据
	public void addProduct(Product product) throws SQLException {
		AdminProductDao_001 dao = new AdminProductDao_001();
		dao.addProduct(product);
	}

	//根据pid删除商品
	public void delProductByPid(String pid) throws SQLException{
		AdminProductDao_001 dao = new AdminProductDao_001();
		dao.delProductByPid(pid);
	}

	//根据pid查询商品对象
	public Product findProductByPid(String pid) throws SQLException{
		AdminProductDao_001 dao = new AdminProductDao_001();
		return dao.findProductByPid(pid);
	}

	//更新商品
	public void updateProduct(Product product) throws SQLException{
		AdminProductDao_001 dao = new AdminProductDao_001();
		//todo
		dao.updateProduct(product);
	}
}
