package com.itheima.mybatis.mapper;

import com.itheima.mybatis.pojo.User;

public interface UserMapper_001 {
	//遵循四个原则
	//接口的方法名和mapper的id相同
	//返回值类型和mapper的返回值类型一致
	//方法的入参类型与Mapper.xml中的入参类型一致
	//命名空间 绑定此接口
	public User findUserById(Integer id);
}
