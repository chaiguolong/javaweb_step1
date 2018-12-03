package com.hzfc.superadmin.assist.service.impl;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.hzfc.common.service.impl.SuperServiceImpl;
import com.hzfc.superadmin.assist.dao.AssistDao;
import com.hzfc.superadmin.assist.entity.ActiveProperty;
import com.hzfc.superadmin.assist.entity.DicItems;
import com.hzfc.superadmin.assist.entity.EsfCommunity;
import com.hzfc.superadmin.assist.entity.EsfSchools;
import com.hzfc.superadmin.assist.entity.GisNewPrj;
import com.hzfc.superadmin.assist.entity.GisStockPrj;
import com.hzfc.superadmin.assist.entity.RessInfo;
import com.hzfc.superadmin.assist.entity.Rtxqzh;
import com.hzfc.superadmin.assist.entity.TempCommunity;
import com.hzfc.superadmin.assist.service.AssistService;
import com.hzfc.utils.FileOperUtils;
import com.hzfc.utils.TablesNameConstants;

public class AssistServiceImpl extends SuperServiceImpl implements AssistService{

	private AssistDao _assistDao;
	
	public boolean selectIsExistCodetype(String tablename, String codetype) {
		return _assistDao.isExistCodetype(tablename, codetype);
	}
	
	public DicItems selectExistCodeItemByItemvalue(Map map){
		return _assistDao.selectExistCodeItemByItemvalue(map);
	}
	
	public AssistDao getAssistDao() {
		return _assistDao;
	}

	public void setAssistDao(AssistDao assistDao) {
		_assistDao = assistDao;
	}

}
