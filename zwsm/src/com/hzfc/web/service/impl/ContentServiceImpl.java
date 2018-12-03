package com.hzfc.web.service.impl;

import java.util.List;
import java.util.Map;


import com.hzfc.utils.QueryCondition;
import com.hzfc.utils.TablesNameConstants;
import com.hzfc.web.dao.ContentDAO;
import com.hzfc.web.entity.Content;
import com.hzfc.web.service.ContentService;

public class ContentServiceImpl implements ContentService {

    private ContentDAO _contentDao;

	public ContentDAO getContentDao() {
		return _contentDao;
	}

	public void setContentDao(ContentDAO contentDao) {
		_contentDao = contentDao;
	}

	public List<Object> selectContentListByMap(Map<Object, Object> map) {
		return _contentDao.selectAllByMapParam(TablesNameConstants.WEB_INF_CONTENT + "_selectByMap", map);
	}

	public Content selectContentByContentid(Long contentid) {
		return (Content) _contentDao.selectByPrimaryKey(TablesNameConstants.WEB_INF_CONTENT, contentid);
	}
	
	public List<Object> selectContentinfoByMap(Map<Object, Object> map) {
		return _contentDao.selectAllByMapParam("WEB_INF_CONTENT_selectContentinfoByMap", map);
	}
	
	public List<Object> selectPageByQueryCondition(String statementid, QueryCondition queryCondition) {
		return _contentDao.selectPageByQueryCondition(statementid, queryCondition);
	}
}