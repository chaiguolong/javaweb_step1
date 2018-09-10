package com.itheima.service;

import java.sql.SQLException;

import com.itheima.dao.UserDao_001;

public class UserService_001 {

	public boolean checkUsername(String username) throws SQLException{

		UserDao_001 dao = new UserDao_001();
		
		Long isExist = dao.checkUsername(username);

		return isExist>0?true:false;
	}

}
