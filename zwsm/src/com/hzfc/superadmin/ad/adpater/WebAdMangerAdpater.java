package com.hzfc.superadmin.ad.adpater;

import java.util.List;

import com.hzfc.common.adpater.SuperAdpater;
import com.hzfc.superadmin.ad.entity.WebAdInfo;
import com.hzfc.utils.QueryCondition;

public interface WebAdMangerAdpater extends SuperAdpater{
	boolean deleteType(Long typeid);
	boolean deleteAdInfo(Long typeid);
	List<Object> selectMyAllByMapParam(String statementid,
			QueryCondition queryCondition);
	void saveAdInfo(String tablename, WebAdInfo webAdInfo);
}
