package com.hzfc.superadmin.assist.dao;

import java.util.Map;

import com.hzfc.common.dao.SuperDao;
import com.hzfc.superadmin.assist.entity.DicItems;
import com.hzfc.superadmin.assist.entity.EsfCommunity;
import com.hzfc.superadmin.assist.entity.RessInfo;
import com.hzfc.superadmin.assist.entity.TempCommunity;

public interface AssistDao extends SuperDao{

	boolean isExistCodetype(String tablename, String codetype);
	/**
	 * 
	 * @param tablename 执行操作的表名
	 * @param object	删除的外键值
	 */
	
	DicItems selectExistCodeItemByItemvalue(Map map);
	
}
