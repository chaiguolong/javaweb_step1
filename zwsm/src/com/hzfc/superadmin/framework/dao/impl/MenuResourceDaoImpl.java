package com.hzfc.superadmin.framework.dao.impl;


import java.util.List;

import com.hzfc.common.dao.impl.SuperDaoImpl;
import com.hzfc.superadmin.framework.dao.MenuResourceDao;
import com.hzfc.utils.Ztree;

public class MenuResourceDaoImpl extends SuperDaoImpl implements MenuResourceDao{
	@SuppressWarnings("unchecked")
	public List<Ztree> getZtreeMenu() {
		return this.getSqlMapClientTemplate().queryForList("getZtree");
	}
}
