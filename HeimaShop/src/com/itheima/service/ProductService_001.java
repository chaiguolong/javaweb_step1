package com.itheima.service;

import java.util.List;

import com.itheima.dao.ProductDao_001;
import com.itheima.domain.Product;
import com.itheima.domain.Category;
import com.itheima.domain.PageBean;

public class ProductService_001 {
	//根据pid查找商品
	public Product findProductByPid(String pid){
		ProductDao_001 dao = new ProductDao_001();
		Product product = null;
		try {
			product = dao.findProductByPid(pid);
		} catch(Exception e){
			e.printStackTrace();
		}

		return product;
	}

	@SuppressWarnings("rawtypes")
	public PageBean findProductListByCid(String cid ,int currentPage,int currentCount){

		ProductDao_001 dao = new ProductDao_001();

		//封装一个pageBean 返回web层
		PageBean<Product> pageBean = new PageBean<Product>();

		//1.封装当前页
		pageBean.setCurrentPage(currentPage);
		//2.封装每页显示的条数
		pageBean.setCurrentCount(currentCount);
		//封装总条数
		int totalCount = 0;
		try {
			totalCount = dao.getCount(cid);
		} catch(Exception e){
			e.printStackTrace();
		}
		pageBean.setTotalCount(totalCount);
		//封装总页数
		int totalPage = (int)Math.ceil(1.0*totalCount/currentCount);
		pageBean.setTotalPage(totalPage);

		//5.当前页显示的数据
		int index = (currentPage-1)*currentCount;
		List<Product> list = null;
		try {
			list = dao.findProductByPage(cid,index,currentCount);
		} catch(Exception e){
			e.printStackTrace();
		}
		pageBean.setList(list);


		return pageBean;
	}

	//获得热门商品
	public List<Product> findHotProductList(){

		ProductDao_001 dao = new ProductDao_001();

		List<Product> hotProductList = null;

		try {
			hotProductList = dao.findHotProductList();
		} catch(Exception e){
			e.printStackTrace();
		}

		return hotProductList;

	}

	//获得最新商品
	public List<Product> findNewProductList(){
		ProductDao_001 dao = new ProductDao_001();
		List<Product> newProductList = null;
		try {
			newProductList = dao.findNewProductList();
		} catch(Exception e){
			e.printStackTrace();
		}

		return newProductList;
	}

	//获取分类列表
	public List<Category> findAllCategory(){
		ProductDao_001 dao = new ProductDao_001();
		List<Category> categoryList = null;
		try {
			categoryList = dao.findAllCategory();
		} catch(Exception e){
			e.printStackTrace();
		}

		return categoryList;
	}


}
