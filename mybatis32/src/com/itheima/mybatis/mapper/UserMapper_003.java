package com.itheima.mybatis.mapper;

import com.itheima.mybatis.pojo.User;

public interface UserMapper_003 {
	//遵循四个原则
	//接口的方法名和mapper.xml的id名相同
	//返回值类型和mapper.xml的返回值类型一致
	//方法的入参类型和mapper.xml的入参类型一致
	//命名空间 绑定此接口

	public User findUserById(Integer id);
}
