package com.hzfc.superadmin.ad.service;

import java.util.List;

import com.hzfc.common.service.SuperService;
import com.hzfc.superadmin.ad.entity.WebAdInfo;
import com.hzfc.superadmin.ad.entity.WebStatictask;
import com.hzfc.utils.QueryCondition;


public interface WebAdMangerService extends SuperService{

	boolean deleteType(Long typeid);
	boolean deleteAdInfo(Long typeid);
	List<Object> selectMyAllByMapParam(String statementid,
			QueryCondition queryCondition);
	void saveAdInfo(String tablename, WebAdInfo webAdInfo);
	void updateModel(WebStatictask webStatictask);
	
}
