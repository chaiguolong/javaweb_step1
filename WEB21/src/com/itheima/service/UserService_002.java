package com.itheima.service;

import java.sql.SQLException;

import com.itheima.dao.UserDao_002;

public class UserService_002 {
	public boolean checkUsername(String username) throws SQLException{
		UserDao_002 dao = new UserDao_002();
		Long isExist = dao.checkUsername(username);

		return isExist > 0 ? true :false;
	}
}
