package com.hzfc.web.service.impl;

import java.util.List;
import java.util.Map;

import com.hzfc.utils.TablesNameConstants;
import com.hzfc.web.dao.ContentCategoryDAO;
import com.hzfc.web.service.ContentCategoryService;

public class ContentCategoryServiceImpl implements ContentCategoryService {

	private ContentCategoryDAO _contentCategoryDao;
    public ContentCategoryServiceImpl() {
        super();
    }

	public ContentCategoryDAO getContentCategoryDao() {
		return _contentCategoryDao;
	}

	public void setContentCategoryDao(ContentCategoryDAO contentCategoryDao) {
		_contentCategoryDao = contentCategoryDao;
	}

	public List<Object> selectCategoryListByMap(
			Map<Object, Object> argMap) {
		return _contentCategoryDao.selectAllByMapParam(TablesNameConstants.WEB_INF_CONTENTCATEGORY + "_selectCategoryListByMap", argMap);
	}
}