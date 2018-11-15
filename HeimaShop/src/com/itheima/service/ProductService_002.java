package com.itheima.service;

import java.util.List;

import com.itheima.dao.ProductDao;
import com.itheima.dao.ProductDao_002;
import com.itheima.domain.Category;
import com.itheima.domain.PageBean;
import com.itheima.domain.Product;

public class ProductService_002 {
	//通过pid找到浏览过的产品
	public Product findProductByPid(String pid){
		ProductDao_002 dao = new ProductDao_002();
		Product product = null;
		try {
			product = dao.findProductByPid(pid);
		} catch(Exception e){
			e.printStackTrace();
		}

		return product;
	}

	@SuppressWarnings("rawtypes")
	public PageBean findProductListByCid(String cid,int currentPage,int currentCount){
		ProductDao_002 dao = new ProductDao_002();
		//封装一个PageBean 返回web层
		PageBean<Product> pageBean = new PageBean<Product>();

		//1.封装当前页
		pageBean.setCurrentPage(currentPage);
		//2.封装每页显示的条数
		pageBean.setCurrentCount(currentCount);
		//3.封装总条数
		int totalCount = 0;
		try {
			totalCount = dao.getCount(cid);
		} catch(Exception e){
			e.printStackTrace();
		}
		pageBean.setTotalCount(totalCount);
		//4.封装总页数
		int totalPage = (int) Math.ceil(1.0*totalCount/currentCount);
		pageBean.setTotalPage(totalPage);

		//5.当前页显示的数据
		//select * from product where cid=? limit ?,?
		//当前页与起始索引index的关系
		int index = (currentPage -1)*currentCount;
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

		ProductDao_002 dao = new ProductDao_002();
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
		ProductDao_002 dao = new ProductDao_002();
		List<Product> newProductList = null;
		try {
			newProductList = dao.findNewProductList();
		} catch(Exception e){
			e.printStackTrace();
		}
		return newProductList;
	}

	public List<Category> findAllCategory(){
		ProductDao_002 dao = new ProductDao_002();
		List<Category> categoryList = null;
		try {
			categoryList = dao.findAllCategory();
		} catch(Exception e){
			e.printStackTrace();
		}

		return categoryList;

	}
}
