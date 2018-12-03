package com.hzfc.superadmin.framework.dao;

import com.hzfc.common.dao.SuperDao;

public interface UserInfomationDao extends SuperDao{
	public boolean selectisExistUsername(String tablename, String username);
}
