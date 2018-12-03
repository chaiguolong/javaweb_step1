package com.hzfc.superadmin.assist.adpater.impl;

import java.util.Map;

import com.hzfc.common.adpater.impl.SuperAdpaterImpl;
import com.hzfc.superadmin.assist.adpater.AssistAdpater;
import com.hzfc.superadmin.assist.entity.DicItems;
import com.hzfc.superadmin.assist.service.AssistService;

public class AssistAdpaterImpl extends SuperAdpaterImpl implements AssistAdpater{

	private AssistService _assistService;
	
	public boolean isExistCodetype(String tablename, String codetype) {
		return _assistService.selectIsExistCodetype(tablename, codetype);
	}

	public DicItems selectExistCodeItemByItemvalue(Map map){
		return _assistService.selectExistCodeItemByItemvalue(map);
	}
	
	public AssistService getAssistService() {
		return _assistService;
	}

	public void setAssistService(AssistService assistService) {
		_assistService = assistService;
	}

	
}
