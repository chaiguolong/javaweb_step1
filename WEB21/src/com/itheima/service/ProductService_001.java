package com.itheima.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.itheima.dao.ProductDao_001;
import com.itheima.domain.Product;
import com.itheima.vo.PageBean;

public class ProductService_001 {

	//分页操作
	@SuppressWarnings("rawtypes")
	public PageBean findPageBean(int currentPage,int currentCount) throws SQLException{
		ProductDao_001 dao = new ProductDao_001();

		//目的:就是想办法封装一个PageBean并返回
		PageBean<Product> pageBean = new PageBean<Product>();
		//1.当前页private int currentPage;
		pageBean.setCurrentPage(currentPage);
		//2.当前页显示的条数private int currentCount;
		pageBean.setCurrentCount(currentCount);
		//3.总条数private int totalCount;
		int totalCount = dao.getTotalCount();
		pageBean.setTotalPage(totalCount);
		//4.总页数private int totalPage;
		int totalPage = (int)Math.ceil(1.0*totalCount/currentCount);
		pageBean.setTotalPage(totalPage);
		//5.每页显示的数据private List<T> productList = new ArrayList<T>();
		//索引 index = (当前页-1)*每页显示的条数
		int index = (currentPage-1)*currentCount;

		List<Product> productList = dao.findProductListForPageBean(index,currentCount);

		pageBean.setProductList(productList);

		return pageBean;


	}

}
