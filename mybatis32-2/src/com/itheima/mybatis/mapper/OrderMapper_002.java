package com.itheima.mybatis.mapper;

import java.util.List;

import com.itheima.mybatis.pojo.Orders;
import com.itheima.mybatis.pojo.User;

public interface OrderMapper_002 {
	//查询所有订单
	public List<Orders> selectOrdersList();

	//一对一关联 查询 以订单为中心 关联用户
	public List<Orders> selectOrders();


	//一对多关联
	public List<User> selectUserList();
}
