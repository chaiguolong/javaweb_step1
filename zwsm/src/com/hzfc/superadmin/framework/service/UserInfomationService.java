package com.hzfc.superadmin.framework.service;

import com.hzfc.common.service.SuperService;
import com.hzfc.superadmin.framework.entity.UserAccount;
import com.hzfc.superadmin.framework.entity.UserDepartment;
import com.hzfc.superadmin.framework.entity.UserInfo;
import com.hzfc.superadmin.framework.entity.UserPosition;

public interface UserInfomationService extends SuperService{
	public void saveUserExtInfo(UserAccount userAccount, UserInfo userInfo, UserDepartment userDepartment, UserPosition userPosition);
	
	public boolean selectisExistUsername(String tablename, String username);
	
	public void deleteUserInfo(UserInfo userInfo);
	
}
