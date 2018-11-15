package com.itheima.service;

import com.itheima.domain.User;

import com.itheima.dao.UserDao_002;

public class UserService_002 {

	public boolean regist(User user){

		UserDao_002 dao = new UserDao_002();
		int row = 0;
		try {
			row = dao.regist(user);
		} catch(Exception e){
			e.printStackTrace();
		}

		return row>0?true:false;
	}

	//校验用户名是否存在
	public boolean checkUsername(String username){
		UserDao_002 dao = new UserDao_002();
		Long isExist = 0L;
		try {
			isExist = dao.checkUsername(username);
		} catch(Exception e){
			e.printStackTrace();
		}

		return isExist>0?true:false;
	}

	//激活
	public void active(String activeCode){
		UserDao_002 dao = new UserDao_002();
		try {
			dao.active(activeCode);
		} catch(Exception e){
			e.printStackTrace();
		}
	}


}
