package com.ithiema.service;

import java.sql.SQLException;

import com.ithiema.dao.UserDao_001;
import com.ithiema.domain.User;

public class UserService_001 {
	public User login(String username,String password) throws SQLException{
		UserDao_001 dao = new UserDao_001();
		return dao.login(username,password);
	}
}

