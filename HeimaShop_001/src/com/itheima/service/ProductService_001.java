package com.itheima.service;

import java.sql.SQLException;
import java.util.List;

import com.itheima.dao.ProductDao_001;
import com.itheima.domain.Category;
import com.itheima.domain.Order;
import com.itheima.domain.PageBean;
import com.itheima.domain.Product;
import com.itheima.utils.DataSourceUtils;

@SuppressWarnings("rawtypes")
public class ProductService_001 {
	public void updateOrderState(String r6_Order){
		ProductDao_001 dao = new ProductDao_001();
		try {
			dao.updateOrderState(r6_Order);
		} catch(Exception e){
			e.printStackTrace();
		}
	}




	public void updateOrderAdrr(Order order){
		ProductDao_001 dao = new ProductDao_001();
		try {
			dao.updateOrderAdrr(order);
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	//提交订单 将订单的数据和订单项的数据存储到数据库
	public void submitOrder(Order order){
		ProductDao_001 dao = new ProductDao_001();
		try {
			//1.开启事务
			DataSourceUtils.startTransaction();
			//2.调用dao存储order表数据的方法
			dao.addOrders(order);
			//3.调用dao存储orderitem表数据的方法
			dao.addOrderItem(order);
		} catch(Exception e) {
			try {
				DataSourceUtils.rollback();
			} catch(SQLException e1){
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				DataSourceUtils.commitAndRelease();
			} catch(SQLException e2){
				e2.printStackTrace();
			}
		}

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
		List<Product> newProductList= null;
		try {
			newProductList= dao.findNewProductList();
		} catch(Exception e){
			e.printStackTrace();
		}

		return newProductList;
	}

	public PageBean findProductListByCid(String cid,int currentPage,int currentCount){
		ProductDao_001 dao = new ProductDao_001();
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
		int totalPage = (int)Math.ceil(1.0*totalCount/currentCount);
		pageBean.setTotalPage(totalPage);

		//5.当前页显示的数据
		//当前页与起始索引index的关系
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

	public List<Category> findAllCategory(){
		ProductDao_001 dao = new ProductDao_001();
		List<Category> list = null;
		try {
			list = dao.findAllCategory();
		} catch(Exception e){
			e.printStackTrace();
		}

		return list;
	}

}
