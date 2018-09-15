package com.ithiema.service;

import java.sql.SQLException;

import com.ithiema.dao.UserDao_002;
import com.ithiema.domain.User;

public class UserService_002 {

	public User login(String username,String password) throws SQLException{
		UserDao_002 dao = new UserDao_002();
		return dao.login(username,password);
	}

}
