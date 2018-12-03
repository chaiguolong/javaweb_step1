package com.hzfc.superadmin.assist.dao.impl;

import java.util.List;
import java.util.Map;

import com.hzfc.common.dao.impl.SuperDaoImpl;
import com.hzfc.superadmin.assist.dao.AssistDao;
import com.hzfc.superadmin.assist.entity.DicItems;
import com.hzfc.superadmin.assist.entity.DicType;
import com.hzfc.superadmin.assist.entity.EsfArea;
import com.hzfc.superadmin.assist.entity.EsfCommunity;
import com.hzfc.superadmin.assist.entity.RessInfo;
import com.hzfc.superadmin.assist.entity.TempCommunity;

public class AssistDaoImpl extends SuperDaoImpl implements AssistDao {

	public boolean isExistCodetype(String tablename, String codetype) {
		DicType dicType = (DicType) getSqlMapClientTemplate().queryForObject(tablename + "_selectByCodetype", codetype);
		if (dicType == null) {
			return true;
		}
		return false;
	}

	public DicItems selectExistCodeItemByItemvalue(Map map) {
		return (DicItems) getSqlMapClientTemplate().queryForObject("selectExistCodeItemByItemvalue", map);
	}

}
