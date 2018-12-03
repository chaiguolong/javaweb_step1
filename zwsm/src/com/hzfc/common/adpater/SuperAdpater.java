package com.hzfc.common.adpater;

import java.util.List;
import java.util.Map;

import com.hzfc.superadmin.assist.entity.DicItems;
import com.hzfc.utils.QueryCondition;

public interface SuperAdpater {
	
	/**
	 * 
	 * @param tablename
	 *            执行操作的表名
	 * @param object
	 *            删除的主键值
	 */
	public void deleteByPrimaryKey(String tablename, Object object);
	
	public void deleteByPrimaryKey(String tablename, Object object, String sqlMapClientId);

	/**
	 * 
	 * @param tablename
	 *            执行操作的表名
	 * @param object
	 *            对象
	 */
	public void insert(String tablename, Object object);
	
	public void insert(String tablename, Object object, String sqlMapClientId);

	/**
	 * 
	 * @param tablename
	 *            执行操作的表名
	 * @param object
	 *            对象
	 */
	public void insertSelective(String tablename, Object object);
	
	public void insertSelective(String tablename, Object object, String sqlMapClientId);

	/**
	 * 
	 * @param tablename
	 *            执行操作的表名
	 * @param object
	 *            整个更新
	 */
	public void updateByPrimaryKey(String tablename, Object object);
	
	public void updateByPrimaryKey(String tablename, Object object, String sqlMapClientId);

	/**
	 * 
	 * @param tablename
	 *            执行操作的表名
	 * @param object
	 *            选择性更新
	 */
	public void updateByPrimaryKeySelective(String tablename, Object object);
	
	public void updateByPrimaryKeySelective(String tablename, Object object, String sqlMapClientId);

	/**
	 * 
	 * @param tablename
	 *            执行操作的表名
	 * @param object
	 *            主键
	 * @return
	 */
	public Object selectByPrimaryKey(String tablename, Object object);
	
	public Object selectByPrimaryKey(String tablename, Object object, String sqlMapClientId);
	
	/**
	 * SQL需要自己扩展
	 * @param statementid
	 * @return
	 */
	
	public List<Object> selectByStatementid(String statementid);
	
	public List<Object> selectByStatementid(String statementid, String sqlMapClientId);
	
	/**
	 * SQL需要自己扩展
	 */
	public Object selectObjectByMapParam(String statementid, Map map);
	
	public Object selectObjectByMapParam(String statementid, Map map, String sqlMapClientId);

	/**
	 * SQL需要自己扩展
	 * 
	 * @param statementid
	 *            执行操作的sql_id
	 * @param map
	 *            参数
	 * @return
	 */
	public List<Object> selectAllByMapParam(String statementid, Map map);
	
	public List<Object> selectAllByMapParam(String statementid, Map map, String sqlMapClientId);

	/**
	 * SQL需要自己扩展
	 * 
	 * @param statementid
	 *            执行操作的sql_id
	 * @param map
	 *            参数
	 * @return
	 */
	public List<Object> selectPageByQueryCondition(String statementid,
			QueryCondition queryCondition);
	
	public List<Object> selectPageByQueryCondition(String statementid,
			QueryCondition queryCondition, String sqlMapClientId);
	
	/**
	 * 通过字典类型获取字典列表
	 * @param keycode
	 * @return
	 */
	public List<DicItems> selectKeyListByKeycode(String keycode);
	
	public List<DicItems> selectKeyListByKeycode(String keycode, String sqlMapClientId);
	/**
	 * 自定义删除
	 */
	public void deleteByUserDefined(String statementid, Object object);
	
	public void deleteByUserDefined(String statementid, Object object, String sqlMapClientId);
	
	/**
	 * 自定义更新
	 */
	public void updateByUserDefined(String statementid, Object object);

	public void updateByUserDefined(String statementid, Object object, String sqlMapClientId);

	
	public Long getOracleSequencesBySeqName(String seqname);
}
