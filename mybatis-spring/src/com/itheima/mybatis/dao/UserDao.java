package com.itheima.mybatis.dao;

import com.itheima.mybatis.pojo.User;

public interface UserDao {

	public User findUserById(Integer id);

}
