package com.itheima.service;

import java.sql.SQLException;

import com.itheima.dao.UserDao_001;
import com.itheima.domain.User;

public class UserService_001 {

	public User login(String username,String password) throws SQLException{
		UserDao_001 dao = new UserDao_001();
		return dao.login(username,password);
	}

}
