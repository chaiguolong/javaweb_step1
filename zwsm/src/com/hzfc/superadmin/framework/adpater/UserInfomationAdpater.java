package com.hzfc.superadmin.framework.adpater;

import com.hzfc.common.adpater.SuperAdpater;
import com.hzfc.superadmin.framework.entity.UserAccount;
import com.hzfc.superadmin.framework.entity.UserDepartment;
import com.hzfc.superadmin.framework.entity.UserInfo;
import com.hzfc.superadmin.framework.entity.UserPosition;

public interface UserInfomationAdpater extends SuperAdpater {
	public void saveUserExtInfo(UserAccount userAccount, UserInfo userInfo, UserDepartment userDepartment, UserPosition userPosition);
	
	public boolean selectisExistUsername(String tablename, String username);
	
	public void deleteUserInfo(UserInfo userInfo);
	
}
