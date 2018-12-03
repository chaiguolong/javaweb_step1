package com.hzfc.web.service.impl;

import java.util.List;
import java.util.Map;

import com.hzfc.utils.TablesNameConstants;
import com.hzfc.web.dao.CategoryDAO;
import com.hzfc.web.entity.Category;
import com.hzfc.web.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	
	private CategoryDAO _categoryDao;

	public CategoryDAO getCategoryDao() {
		return _categoryDao;
	}

	public void setCategoryDao(CategoryDAO categoryDao) {
		_categoryDao = categoryDao;
	}

	public List<Object> selectCategoryListByMap(Map<Object, Object> map) {
		return _categoryDao.selectAllByMapParam(TablesNameConstants.WEB_INF_CATEGORY + "_selectCategoryListByMap", map);
	}

	@Override
	public Category selectCategoryByCategoryid(Long categoryid) {
		return (Category) _categoryDao.selectByPrimaryKey(TablesNameConstants.WEB_INF_CATEGORY, categoryid);
	}
	
	public List<Object> selectFdcxhCategoryListByMap(Map<Object, Object> map) {
		return _categoryDao.selectAllByMapParam(TablesNameConstants.WEB_INF_CATEGORY + "_selectFdcxhCategoryListByMap", map);
	}
	
	public List<Object> selectZjxhCategoryListByMap(Map<Object, Object> map) {
		return _categoryDao.selectAllByMapParam(TablesNameConstants.WEB_INF_CATEGORY + "_selectZjxhCategoryListByMap", map);
	}
}