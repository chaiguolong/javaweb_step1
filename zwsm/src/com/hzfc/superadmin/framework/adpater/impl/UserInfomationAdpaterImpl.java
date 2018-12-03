package com.hzfc.superadmin.framework.adpater.impl;

import com.hzfc.common.adpater.impl.SuperAdpaterImpl;
import com.hzfc.superadmin.framework.adpater.UserInfomationAdpater;
import com.hzfc.superadmin.framework.entity.UserAccount;
import com.hzfc.superadmin.framework.entity.UserDepartment;
import com.hzfc.superadmin.framework.entity.UserInfo;
import com.hzfc.superadmin.framework.entity.UserPosition;
import com.hzfc.superadmin.framework.service.UserInfomationService;

public class UserInfomationAdpaterImpl extends SuperAdpaterImpl implements UserInfomationAdpater{
	private UserInfomationService _userInfomationService;
	
	public void saveUserExtInfo(UserAccount userAccount, UserInfo userInfo, UserDepartment userDepartment, UserPosition userPosition){
		_userInfomationService.saveUserExtInfo(userAccount, userInfo, userDepartment, userPosition);
	}
	
	public boolean selectisExistUsername(String tablename, String username){
		return _userInfomationService.selectisExistUsername(tablename, username);
	}
	
	public void deleteUserInfo(UserInfo userInfo){
		 _userInfomationService.deleteUserInfo(userInfo);
	}
	public UserInfomationService getUserInfomationService() {
		return _userInfomationService;
	}

	public void setUserInfomationService(UserInfomationService userInfomationService) {
		_userInfomationService = userInfomationService;
	}
	
}
