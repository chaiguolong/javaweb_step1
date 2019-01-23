package com.itheima.mybatis.dao;

import com.itheima.mybatis.pojo.User;

public interface UserDao_002 {
	//根据用户ID查询用户
	public User selectUserById(Integer id);
	
}
