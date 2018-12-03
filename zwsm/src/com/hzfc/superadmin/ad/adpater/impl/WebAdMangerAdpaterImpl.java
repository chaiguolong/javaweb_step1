package com.hzfc.superadmin.ad.adpater.impl;

import java.util.List;


import com.hzfc.common.adpater.impl.SuperAdpaterImpl;
import com.hzfc.superadmin.ad.adpater.WebAdMangerAdpater;
import com.hzfc.superadmin.ad.entity.WebAdInfo;
import com.hzfc.superadmin.ad.service.WebAdMangerService;
import com.hzfc.utils.QueryCondition;

public class WebAdMangerAdpaterImpl extends SuperAdpaterImpl implements WebAdMangerAdpater {

	private WebAdMangerService _webAdMangerService;

	public boolean deleteType(Long typeid) {
		return _webAdMangerService.deleteType(typeid);
	}
	
	public void setWebAdMangerService(WebAdMangerService webAdMangerService) {
		_webAdMangerService = webAdMangerService;
	}
	
	public List<Object> selectMyAllByMapParam(String statementid,
			QueryCondition queryCondition) {
		return _webAdMangerService.selectMyAllByMapParam(statementid, queryCondition);
	}

	public void saveAdInfo(String tablename, WebAdInfo webAdInfo) {
		_webAdMangerService.saveAdInfo(tablename,webAdInfo);
	}

	public boolean deleteAdInfo(Long typeid) {
		return _webAdMangerService.deleteAdInfo(typeid);
	}
	
	public WebAdMangerService getWebAdMangerService() {
		return _webAdMangerService;
	}

}
