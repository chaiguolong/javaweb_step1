package com.hzfc.common.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.hzfc.common.dao.DaoConstants;
import com.hzfc.common.dao.SuperDao;
import com.hzfc.superadmin.assist.entity.DicItems;
import com.hzfc.utils.QueryCondition;
import com.ibatis.sqlmap.client.SqlMapClient;

public class SuperDaoImpl extends SqlMapClientDaoSupport implements SuperDao {
	
	//多个站点时需要配置多个源
	private SqlMapClient sqlMapClientOuter;
	private SqlMapClient sqlMapClientSelf;

	public SqlMapClient getSqlMapClientOuter() {
		return sqlMapClientOuter;
	}

	public void setSqlMapClientOuter(SqlMapClient sqlMapClientOuter) {
		this.sqlMapClientOuter = sqlMapClientOuter;
	}

	//设置注册的数据源
	public void setSqlMapClientForAutowire(String sqlMapClientId) {
		if(sqlMapClientId.equals("sqlMapClientOuter")){//萧山
			if(sqlMapClientOuter != null){
				sqlMapClientSelf = super.getSqlMapClient();
				super.setSqlMapClient(sqlMapClientOuter);
			}
		}
    }
	
	//设置默认为杭州数据源
	public void resetDefaultSqlMapClient() {
		if(sqlMapClientSelf != null) {
			super.setSqlMapClient(sqlMapClientSelf);
		}
	}
	
	//根据主键删除对象
	public void deleteByPrimaryKey(String tablename, Object object) {
		resetDefaultSqlMapClient();
		getSqlMapClientTemplate().delete(
				tablename + DaoConstants.DELETE_BY_PRIMARY_KEY_STATEMENT_ID,
				object);
	}
	
	//根据主键删除对象（站点）
	public void deleteByPrimaryKey(String tablename, Object object, String sqlMapClientId) {
		setSqlMapClientForAutowire(sqlMapClientId);
		getSqlMapClientTemplate().delete(
				tablename + DaoConstants.DELETE_BY_PRIMARY_KEY_STATEMENT_ID,
				object);
	}
	
	//自定义删除
	public void deleteByUserDefined(String statementid, Object object) {
		resetDefaultSqlMapClient();
		getSqlMapClientTemplate().delete(statementid, object);
	}
	
	//自定义删除（站点）
	public void deleteByUserDefined(String statementid, Object object, String sqlMapClientId) {
		setSqlMapClientForAutowire(sqlMapClientId);
		getSqlMapClientTemplate().delete(statementid, object);
	}

	//新增
	public void insert(String tablename, Object object) {
		resetDefaultSqlMapClient();
		getSqlMapClientTemplate().insert(
				tablename + DaoConstants.INSERT_STATEMENT_ID, object);

	}
	
	//新增（站点）
	public void insert(String tablename, Object object, String sqlMapClientId) {
		setSqlMapClientForAutowire(sqlMapClientId);
		getSqlMapClientTemplate().insert(
				tablename + DaoConstants.INSERT_STATEMENT_ID, object);

	}

	//选择性新增
	public void insertSelective(String tablename, Object object) {
		resetDefaultSqlMapClient();
		getSqlMapClientTemplate().insert(
				tablename + DaoConstants.INSERT_SELECTIVE_STATEMENT_ID, object);

	}
	
	//选择性新增(站点)
	public void insertSelective(String tablename, Object object, String sqlMapClientId) {
		setSqlMapClientForAutowire(sqlMapClientId);
		getSqlMapClientTemplate().insert(
				tablename + DaoConstants.INSERT_SELECTIVE_STATEMENT_ID, object);

	}

	//修改对象
	public void updateByPrimaryKey(String tablename, Object object) {
		resetDefaultSqlMapClient();
		getSqlMapClientTemplate().update(
				tablename + DaoConstants.UPDATE_BY_PRIMARY_KEY_STATEMENT_ID,
				object);

	}
	
	//修改对象（站点）
	public void updateByPrimaryKey(String tablename, Object object, String sqlMapClientId) {
		setSqlMapClientForAutowire(sqlMapClientId);
		getSqlMapClientTemplate().update(
				tablename + DaoConstants.UPDATE_BY_PRIMARY_KEY_STATEMENT_ID,
				object);

	}
	
	//自定义修改对象
	public void updateByUserDefined(String statementid, Object object) {
		resetDefaultSqlMapClient();
		getSqlMapClientTemplate().update(statementid, object);
	}
	
	//自定义修改对象（站点）
	public void updateByUserDefined(String statementid, Object object, String sqlMapClientId) {
		setSqlMapClientForAutowire(sqlMapClientId);
		getSqlMapClientTemplate().update(statementid, object);
	}

	//选择性修改
	public void updateByPrimaryKeySelective(String tablename, Object object) {
		resetDefaultSqlMapClient();
		getSqlMapClientTemplate()
				.update(
						tablename
								+ DaoConstants.UPDATE_BY_PRIMARY_KEY_SELECTIVE_STATEMENT_ID,
						object);

	}
	
	//选择性修改（站点）
	public void updateByPrimaryKeySelective(String tablename, Object object, String sqlMapClientId) {
		setSqlMapClientForAutowire(sqlMapClientId);
		getSqlMapClientTemplate()
				.update(
						tablename
								+ DaoConstants.UPDATE_BY_PRIMARY_KEY_SELECTIVE_STATEMENT_ID,
						object);

	}

	//根据主键查询单个对象
	public Object selectByPrimaryKey(String tablename, Object object) {
		resetDefaultSqlMapClient();
		return (Object) getSqlMapClientTemplate().queryForObject(
				tablename + DaoConstants.SELECT_BY_PRIMARY_KEY_STATEMENT_ID,
				object);
	}
	
	//根据主键查询单个对象（站点）
	public Object selectByPrimaryKey(String tablename, Object object, String sqlMapClientId) {
		setSqlMapClientForAutowire(sqlMapClientId);
		return (Object) getSqlMapClientTemplate().queryForObject(
				tablename + DaoConstants.SELECT_BY_PRIMARY_KEY_STATEMENT_ID,
				object);
	}

	//自定义按条件查询记录
	@SuppressWarnings("unchecked")
	public List<Object> selectAllByMapParam(String statementid, Map map) {
		resetDefaultSqlMapClient();
		List<Object> list = getSqlMapClientTemplate().queryForList(statementid,
				map);
		return list;
	}
	
	//自定义按条件查询记录（站点）
	@SuppressWarnings("unchecked")
	public List<Object> selectAllByMapParam(String statementid, Map map, String sqlMapClientId) {
		setSqlMapClientForAutowire(sqlMapClientId);
		List<Object> list = getSqlMapClientTemplate().queryForList(statementid,
				map);
		return list;
	}

	//分页查询
	@SuppressWarnings("unchecked")
	public List<Object> selectPageByQueryCondition(String statementid,
			QueryCondition queryCondition) {
		resetDefaultSqlMapClient();
		getSqlMapClientTemplate().queryForObject(
				statementid + DaoConstants.SELECT_ADD_COUNT_ID,
				queryCondition.getConditionMap(), queryCondition.getPage());
		queryCondition.initPageInfo();
		return getSqlMapClientTemplate().queryForList(statementid,
				queryCondition.getConditionMap(), queryCondition.getStart(),
				queryCondition.getRusultCount());
	}
	
	//分页查询（站点）
	@SuppressWarnings("unchecked")
	public List<Object> selectPageByQueryCondition(String statementid,
			QueryCondition queryCondition, String sqlMapClientId) {
		setSqlMapClientForAutowire(sqlMapClientId);
		getSqlMapClientTemplate().queryForObject(
				statementid + DaoConstants.SELECT_ADD_COUNT_ID,
				queryCondition.getConditionMap(), queryCondition.getPage());
		queryCondition.initPageInfo();
		return getSqlMapClientTemplate().queryForList(statementid,
				queryCondition.getConditionMap(), queryCondition.getStart(),
				queryCondition.getRusultCount());
	}

	//取Sequences
	public Long getOracleSequencesBySeqName(String seqname) {
		resetDefaultSqlMapClient();
		seqname += DaoConstants.SEQUENCES_NEXTVAL;
		return (Long) getSqlMapClientTemplate().queryForObject(
				DaoConstants.GET_ORACLE_SEQUENCES_VALUE, seqname);
	}
	
	//取Sequences（站点）
	public Long getOracleSequencesBySeqName(String seqname, String sqlMapClientId) {
		setSqlMapClientForAutowire(sqlMapClientId);
		seqname += DaoConstants.SEQUENCES_NEXTVAL;
		return (Long) getSqlMapClientTemplate().queryForObject(
				DaoConstants.GET_ORACLE_SEQUENCES_VALUE, seqname);
	}

	//取字典
	@SuppressWarnings("unchecked")
	public List<DicItems> selectKeyListByKeycode(String keycode) {
		resetDefaultSqlMapClient();
		List<DicItems> list = getSqlMapClientTemplate().queryForList(DaoConstants.SELECT_KEYLIST_BY_KEYCODE,
				keycode);
		return list;
	}
	
	//取字典（站点）
	@SuppressWarnings("unchecked")
	public List<DicItems> selectKeyListByKeycode(String keycode, String sqlMapClientId) {
		setSqlMapClientForAutowire(sqlMapClientId);
		List<DicItems> list = getSqlMapClientTemplate().queryForList(DaoConstants.SELECT_KEYLIST_BY_KEYCODE,
				keycode);
		return list;
	}

	//无条件查询记录
	@SuppressWarnings("unchecked")
	public List<Object> selectByStatementid(String statementid) {
		resetDefaultSqlMapClient();
		List<Object> list = getSqlMapClientTemplate().queryForList(statementid);
		return list;
	}
	
	//无条件查询记录(站点)
	@SuppressWarnings("unchecked")
	public List<Object> selectByStatementid(String statementid, String sqlMapClientId) {
		setSqlMapClientForAutowire(sqlMapClientId);
		List<Object> list = getSqlMapClientTemplate().queryForList(statementid);
		return list;
	}

	//按条件查询单个对象
	@SuppressWarnings("unchecked")
	public Object selectObjectByMapParam(String statementid, Map map) {
		resetDefaultSqlMapClient();
		return (Object) getSqlMapClientTemplate().queryForObject(statementid, map);
	}
	
	//按条件查询单个对象(站点)
	@SuppressWarnings("unchecked")
	public Object selectObjectByMapParam(String statementid, Map map, String sqlMapClientId) {
		setSqlMapClientForAutowire(sqlMapClientId);
		return (Object) getSqlMapClientTemplate().queryForObject(statementid, map);
	}

}
