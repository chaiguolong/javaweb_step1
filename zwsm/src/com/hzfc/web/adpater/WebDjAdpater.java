package com.hzfc.web.adpater;

import java.util.List;
import java.util.Map;

import com.hzfc.web.entity.Category;
import com.hzfc.web.entity.Content;

public interface WebDjAdpater {

	/**
	 * 获取单个菜单信息
	 * 
	 * @param categoryid
	 *            主键
	 * @return
	 */
	public Category selectCategoryByCategoryid(Long categoryid);

	/**
	 * 获取单个文章信息
	 * 
	 * @param contentid
	 *            主键
	 * @return
	 */
	public Content selectContentByContentid(Long contentid);

	/**
	 * 获取菜单列表
	 * 
	 * @param argMap
	 * @return
	 */
	public List<Object> selectCategoryListByMap(Map<Object, Object> argMap);

	/**
	 * 获取文章列表
	 * 
	 * @param argMap
	 * @return
	 */
	public List<Object> selectContentListByMap(Map<Object, Object> argMap);

	/**
	 * 获取顶部菜单列表
	 * 
	 * @return
	 */
	public List<Object> selectTopMenuList();

	/**
	 * 首页获取栏目和新闻的关联
	 * 
	 * @return
	 */
	public List<Object> selectContentCategoryListForIndex();

	/**
	 * 列表页获取栏目和新闻的关联
	 * 
	 * @param pid
	 *            该栏目的id
	 * @return
	 */
	public List<Object> selectContentCategoryListForNewslist(Long pid);
}