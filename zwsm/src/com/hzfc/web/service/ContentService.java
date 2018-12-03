package com.hzfc.web.service;

import java.util.List;
import java.util.Map;


import com.hzfc.utils.QueryCondition;
import com.hzfc.web.entity.Content;

public interface ContentService {
	
	public List<Object> selectContentListByMap(Map<Object, Object> map);
	
	public Content selectContentByContentid(Long contentid);
	
	public List<Object> selectContentinfoByMap(Map<Object, Object> map);
	
	public List<Object> selectPageByQueryCondition(String statementid,QueryCondition queryCondition);
}