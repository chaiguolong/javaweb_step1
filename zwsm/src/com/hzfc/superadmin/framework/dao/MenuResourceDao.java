package com.hzfc.superadmin.framework.dao;

import java.util.List;

import com.hzfc.common.dao.SuperDao;
import com.hzfc.utils.Ztree;

public interface MenuResourceDao extends SuperDao{
	List<Ztree> getZtreeMenu();
	
}