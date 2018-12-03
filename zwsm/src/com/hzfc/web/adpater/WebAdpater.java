package com.hzfc.web.adpater;

import java.util.List;
import java.util.Map;

import com.hzfc.utils.QueryCondition;
import com.hzfc.web.entity.Category;
import com.hzfc.web.entity.Complaint;
import com.hzfc.web.entity.Content;

public interface WebAdpater {

	/**
	 * 获取菜单,只获取前台显示的
	 * 
	 * @return
	 */
	public List<Object> selectCategoryList(Map<Object, Object> argMap);

	/**
	 * 获取菜单,只获取前台显示的
	 * 
	 * @return
	 */
	public List<Object> selectFdcxhCategoryList(Map<Object, Object> argMap);

	/**
	 * 获取菜单,只获取前台显示的
	 * 
	 * @return
	 */
	public List<Object> selectZjxhCategoryList(Map<Object, Object> argMap);
	
	/**
	 * 根据搜索条件获取文章列表
	 * 
	 * @param argMap
	 * @return
	 */
	public List<Object> selectContentListByMap(Map<Object, Object> argMap);

	/**
	 * 根据搜索条件获取文章列表
	 * 
	 * @param argMap
	 * @return
	 */
	public List<Object> selectContentinfoByMap(Map<Object, Object> map);

	/**
	 * 根据主键搜索文章
	 * 
	 * @param contentid
	 * @return
	 */
	public Content selectContentByContentid(Long contentid);

	/**
	 * 根据主键搜索相应的栏目
	 * 
	 * @param categoryid
	 * @return
	 */
	public Category selectCategoryByCategoryid(Long categoryid);

	/**
	 * 机构信息
	 * 
	 * @return
	 */
	public List<Object> selectAgencyInfo();

	/**
	 * 机构信息
	 * 
	 * @param categoryid
	 * @return
	 */
	public List<Object> selectAgencyInfo(Long categoryid);

	/**
	 * 获取新房日统计信息
	 * 
	 * @return
	 */
	public List<Object> selectStatisticForDay();
	
	/**
	 * 获取二手房签约日统计信息
	 * 
	 * @return
	 */
	public List<Object> selectUsedStatisticForDay();

	/**
	 * 获取新房月统计信息
	 * 
	 * @return
	 */
	public List<Object> selectStatisticForMonth();

	/**
	 * 获取房产公司列表
	 * 
	 * @return
	 */
	public List<Object> selectDeveloperList();

	/**
	 * 获取投诉列表
	 * 
	 * @param argMap
	 * @return
	 */
	public List<Object> selectComplaintList(Map<Object, Object> argMap);

	/**
	 * 根据主键查询投诉详情
	 * 
	 * @param complaintid
	 * @return
	 */
	public Complaint selectComplaintByComplaintid(Long complaintid);

	/**
	 * 新增投诉信息
	 * 
	 * @param complaint
	 */
	public void insertComplaint(Complaint complaint);

	/**
	 * 分页查询
	 * 
	 * @param statementid
	 *            执行操作的sql_id
	 * @param map
	 *            参数
	 */
	public List<Object> selectPageByQueryCondition(String statementid,
			QueryCondition queryCondition);

	/**
	 * 领证公告
	 * 
	 * @return
	 */
	public List<String> selectNoticeList();

	/**
	 * 办事进度查询
	 * 
	 * @param name
	 *            申请人姓名
	 * @param slbh
	 *            受理编号
	 * @return json字符串
	 */
	public String planquery(String name, String slbh);

	/**
	 * 关联表
	 * 
	 * @param argMap
	 * @return
	 */
	public List<Object> selectContentCategoryList(Map<Object, Object> argMap);

	/**
	 * 连续预定列表
	 * 
	 * @param map
	 * @return
	 */
	public List<Object> selectContinuousList(Map<Object, Object> map);

	/**
	 * 取消预定列表
	 * 
	 * @param map
	 * @return
	 */
	public List<Object> selectRevokeList(Map<Object, Object> map);
	
	/**
	 * 取最新的15条预售证公示
	 * 
	 * @return
	 */
	public List<Object> selectPresellNew15();
	
	public List<Object> selectPresellAllNew();
}