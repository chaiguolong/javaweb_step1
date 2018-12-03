package com.hzfc.superadmin.framework.dao.impl;

import com.hzfc.common.dao.impl.SuperDaoImpl;
import com.hzfc.superadmin.framework.dao.UserInfomationDao;
import com.hzfc.superadmin.framework.entity.UserAccount;

public class UserInfomationDaoImpl extends SuperDaoImpl implements UserInfomationDao{
	
	
	//检验用户名
	public boolean selectisExistUsername(String tablename, String username) {
		UserAccount userAccount = (UserAccount)getSqlMapClientTemplate().queryForObject(tablename + "_selectByUsername", username);
		if(userAccount == null){
			return true;
		}
		return false;
	}
	
}
