package com.hzfc.web.service;

import java.util.List;
import java.util.Map;

import com.hzfc.web.entity.Category;

public interface CategoryService {
	public List<Object> selectCategoryListByMap(Map<Object, Object> map);
	
	public Category selectCategoryByCategoryid(Long categoryid);
	
	public List<Object> selectFdcxhCategoryListByMap(Map<Object, Object> map);
	
	public List<Object> selectZjxhCategoryListByMap(Map<Object, Object> map);
}