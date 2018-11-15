package com.itheima.service;

import com.itheima.dao.UserDao_001;
import com.itheima.domain.User;

public class UserService_001 {
	
	public boolean regist(User user){

		UserDao_001 dao = new UserDao_001();
		int row = 0;
		try {
			row = dao.regist(user);
		} catch(Exception e){
			e.printStackTrace();
		}

		return row > 0 ?true:false;
	}

	//激活
	public void active(String activeCode){
		UserDao_001 dao = new UserDao_001();
		try {
			dao.active(activeCode);
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	//校验用户名是否存在
	public boolean checkUsername(String username){
		UserDao_001 dao = new UserDao_001();
		Long isExist = 0L;
		try {
			isExist = dao.checkUsername(username);
		} catch(Exception e){
			e.printStackTrace();
		}

		return isExist>0?true:false;
	}

}
