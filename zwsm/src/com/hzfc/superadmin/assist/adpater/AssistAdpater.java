package com.hzfc.superadmin.assist.adpater;

import java.util.Map;

import com.hzfc.common.adpater.SuperAdpater;
import com.hzfc.superadmin.assist.entity.DicItems;

public interface AssistAdpater extends SuperAdpater{

	boolean isExistCodetype(String tablename, String codetype);

	DicItems selectExistCodeItemByItemvalue(Map map);
    
}
