package com.itheima.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.itheima.dao.ProductDao_002;
import com.itheima.domain.Product;
import com.itheima.vo.PageBean;

public class ProductService_002 {
	//分页操作
	@SuppressWarnings("rawtypes")
	public PageBean findPageBean(int currentPage,int currentCount) throws SQLException{
		ProductDao_002 dao = new ProductDao_002();
		
		//目的:即使想办法封装一个PageBean 并返回
		PageBean<Product> pagebean = new PageBean<Product>();
		//1.当前页Private int currentPage;
		pagebean.setCurrentPage(currentPage);
		//2.当前页显示的条数private int currentCount
		pagebean.setCurrentCount(currentCount);
		//3.总条数private int totalCount
		int totalCount = dao.getTotalCount();
		pagebean.setTotalPage(totalCount);
		//4.总页数private int totalPage
		int totalPage = (int)Math.ceil(1.0*totalCount/currentCount);
		pagebean.setTotalPage(totalPage);
		//5.每页显示的数据private List<T> productList = new ArrayList<T>();
		int index = (currentPage-1)*currentCount;


		List<Product> productList = dao.findProductListForPageBean(index,currentCount);

		pagebean.setProductList(productList);


		return pagebean;

		
	}

	//根据关键字查询商品
	public List<Object> findProductByWord(String word) throws SQLException{
		ProductDao_002 dao = new ProductDao_002();
		return dao.findProductByWord(word);
	}



}
