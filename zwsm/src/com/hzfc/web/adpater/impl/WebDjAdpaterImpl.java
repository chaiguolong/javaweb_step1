package com.hzfc.web.adpater.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hzfc.web.adpater.WebDjAdpater;
import com.hzfc.web.entity.Category;
import com.hzfc.web.entity.Content;
import com.hzfc.web.service.CategoryService;
import com.hzfc.web.service.ContentCategoryService;
import com.hzfc.web.service.ContentService;

public class WebDjAdpaterImpl implements WebDjAdpater {

	private CategoryService _categoryService;
	private ContentService _contentService;
	private ContentCategoryService _contentCategoryService;

	public CategoryService getCategoryService() {
		return _categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		_categoryService = categoryService;
	}

	public ContentService getContentService() {
		return _contentService;
	}

	public void setContentService(ContentService contentService) {
		_contentService = contentService;
	}

	public ContentCategoryService getContentCategoryService() {
		return _contentCategoryService;
	}

	public void setContentCategoryService(
			ContentCategoryService contentCategoryService) {
		_contentCategoryService = contentCategoryService;
	}

	@Override
	public Category selectCategoryByCategoryid(Long categoryid) {
		return _categoryService.selectCategoryByCategoryid(categoryid);
	}

	@Override
	public List<Object> selectCategoryListByMap(Map<Object, Object> argMap) {
		return _categoryService.selectCategoryListByMap(argMap);
	}

	@Override
	public List<Object> selectContentListByMap(Map<Object, Object> argMap) {
		return _contentService.selectContentListByMap(argMap);
	}

	@Override
	public List<Object> selectTopMenuList() {
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("djmenu", true);
		return _categoryService.selectCategoryListByMap(map);
	}

	@Override
	public Content selectContentByContentid(Long contentid) {
		return _contentService.selectContentByContentid(contentid);
	}

	@Override
	public List<Object> selectContentCategoryListForIndex() {
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("pid", 101);
		return _contentCategoryService.selectCategoryListByMap(map);
	}

	@Override
	public List<Object> selectContentCategoryListForNewslist(Long pid) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("pid", pid);
		return _contentCategoryService.selectCategoryListByMap(map);
	}

}
