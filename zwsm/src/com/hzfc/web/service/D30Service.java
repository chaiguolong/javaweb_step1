package com.hzfc.web.service;

import java.util.List;

public interface D30Service {

	/**
	 * 获取新房日统计信息
	 * 
	 * @return
	 */
	public List<Object> selectStatisticForDay();

	/**
	 * 获取新房月统计信息
	 * 
	 * @return
	 */
	public List<Object> selectStatisticForMonth();

	/**
	 * 获取新房日统计信息
	 * 
	 * @return
	 */
	public List<Object> selectStatisticForDayAtOuter();

	/**
	 * 获取新房月统计信息
	 * 
	 * @return
	 */
	public List<Object> selectStatisticForMonthAtOuter();

	/**
	 * 获取二手房签约日统计信息
	 * 
	 * @return
	 */
	public List<Object> selectUsedStatisticForDay();

	/**
	 * 获取二手房签约日统计信息
	 * 
	 * @return
	 */
	public List<Object> selectUsedStatisticForDayAtOuter();
}
