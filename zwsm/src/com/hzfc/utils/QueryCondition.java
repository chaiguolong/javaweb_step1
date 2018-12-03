package com.hzfc.utils;

import java.util.HashMap;
import java.util.Map;

public class QueryCondition {

	private Map conditionMap;
	private Page page;

	public Map getConditionMap() {
		checkConditionInstance();
		return conditionMap;
	}

	public void setConditionMap(Map conditionMap) {
		this.conditionMap = conditionMap;
	}

	public Page getPage() {
		if (page == null) {
			page = new Page();
		}
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	/**
	 * 设置单条条件
	 * 
	 * @param key
	 * @param value
	 */
	public void setCondition(String key, Object value) {
		checkConditionInstance();
		conditionMap.put(key, value);

	}

	/**
	 * 设置查询条件集合
	 * 
	 * @param conditionMap
	 */
	public void setCondition(Map conditionMap) {

		this.conditionMap = conditionMap;

	}

	/**
	 * 设置当前页
	 * 
	 * @param pageNo
	 */
	public void setCurrentPageNo(int pageNo) {
		checkPageInstance();

		page.setPageno(pageNo);
	}

	/**
	 * 初始化分页信息
	 */
	public void initPageInfo() {
		checkPageInstance();

		page.init();
	}

	/**
	 * 获取查询记录集的起始位置
	 * 
	 * @return
	 */
	public int getStart() {
		checkPageInstance();

		return page.getStart();
	}

	/**
	 * 获取查询记录集的结束位置
	 * 
	 * @return
	 */
	public int getEnd() {
		checkPageInstance();

		return page.getEnd();
	}

	/**
	 * 获取查询记录集的记录个数
	 * 
	 * @return
	 */
	public int getRusultCount() {
		checkPageInstance();

		return page.getPagesize();
	}

	/**
	 * 获取分页属性的HTML表现用于页面展示
	 * 
	 * @return
	 */
	public String getPageInfoForHtml() {
		checkPageInstance();

		return page.toHtmlText();
	}

	private void checkPageInstance() {
		if (page == null) {
			page = new Page();
		}
	}

	private void checkConditionInstance() {
		if (conditionMap == null) {
			conditionMap = new HashMap();
		}
	}

	public static QueryCondition getInstance() {
		return new QueryCondition();
	}

}
