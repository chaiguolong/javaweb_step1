package com.hzfc.superadmin.assist.service;


import java.util.Map;

import com.hzfc.common.service.SuperService;
import com.hzfc.superadmin.assist.entity.DicItems;

public interface AssistService extends SuperService{

	boolean selectIsExistCodetype(String tablename, String codetype);
	
	DicItems selectExistCodeItemByItemvalue(Map map);

}
