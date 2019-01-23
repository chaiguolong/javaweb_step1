package com.itheima.mybatis.dao;

import com.itheima.mybatis.pojo.User;

public interface UserDao_003 {
	//根据用户ID查找用户
	public User selectUserById(Integer id);
	
}
