package com.hzfc.common.service.impl;

import java.util.List;
import java.util.Map;

import com.hzfc.common.dao.SuperDao;
import com.hzfc.common.service.SuperService;
import com.hzfc.superadmin.assist.entity.DicItems;
import com.hzfc.utils.QueryCondition;

public class SuperServiceImpl implements SuperService {

	private SuperDao superDao;

	public SuperDao getSuperDao() {
		return superDao;
	}

	public void setSuperDao(SuperDao superDao) {
		this.superDao = superDao;
	}

	public void deleteByPrimaryKey(String tablename, Object object) {
		superDao.deleteByPrimaryKey(tablename, object);
	}
	
	public void deleteByPrimaryKey(String tablename, Object object, String sqlMapClientId) {
		superDao.deleteByPrimaryKey(tablename, object, sqlMapClientId);
	}

	public void insert(String tablename, Object object) {
		superDao.insert(tablename, object);
	}
	
	public void insert(String tablename, Object object, String sqlMapClientId) {
		superDao.insert(tablename, object, sqlMapClientId);
	}

	public void insertSelective(String tablename, Object object) {
		superDao.insertSelective(tablename, object);
	}
	
	public void insertSelective(String tablename, Object object, String sqlMapClientId) {
		superDao.insertSelective(tablename, object, sqlMapClientId);
	}

	public void updateByPrimaryKey(String tablename, Object object) {
		superDao.updateByPrimaryKey(tablename, object);
	}
	
	public void updateByPrimaryKey(String tablename, Object object, String sqlMapClientId) {
		superDao.updateByPrimaryKey(tablename, object, sqlMapClientId);
	}

	public void updateByPrimaryKeySelective(String tablename, Object object) {
		superDao.updateByPrimaryKeySelective(tablename, object);
	}
	
	public void updateByPrimaryKeySelective(String tablename, Object object, String sqlMapClientId) {
		superDao.updateByPrimaryKeySelective(tablename, object, sqlMapClientId);
	}

	public Object selectByPrimaryKey(String tablename, Object object) {
		return superDao.selectByPrimaryKey(tablename, object);
	}
	
	public Object selectByPrimaryKey(String tablename, Object object, String sqlMapClientId) {
		return superDao.selectByPrimaryKey(tablename, object, sqlMapClientId);
	}

	public List<Object> selectAllByMapParam(String statementid, Map map) {
		return superDao.selectAllByMapParam(statementid, map);
	}
	
	public List<Object> selectAllByMapParam(String statementid, Map map, String sqlMapClientId) {
		return superDao.selectAllByMapParam(statementid, map, sqlMapClientId);
	}

	public List<Object> selectPageByQueryCondition(String statementid,
			QueryCondition queryCondition) {
		return superDao.selectPageByQueryCondition(statementid, queryCondition);
	}
	
	public List<Object> selectPageByQueryCondition(String statementid,
			QueryCondition queryCondition, String sqlMapClientId) {
		return superDao.selectPageByQueryCondition(statementid, queryCondition, sqlMapClientId);
	}

	public List<DicItems> selectKeyListByKeycode(String keycode) {
		return superDao.selectKeyListByKeycode(keycode);
	}
	
	public List<DicItems> selectKeyListByKeycode(String keycode, String sqlMapClientId) {
		return superDao.selectKeyListByKeycode(keycode, sqlMapClientId);
	}
	
	public List<Object> selectByStatementid(String statementid) {
		return superDao.selectByStatementid(statementid);
	}
	
	public List<Object> selectByStatementid(String statementid, String sqlMapClientId) {
		return superDao.selectByStatementid(statementid, sqlMapClientId);
	}

	public Object selectObjectByMapParam(String statementid, Map map) {
		return superDao.selectObjectByMapParam(statementid, map);
	}
	
	public Object selectObjectByMapParam(String statementid, Map map, String sqlMapClientId) {
		return superDao.selectObjectByMapParam(statementid, map, sqlMapClientId);
	}
	
	public void deleteByUserDefined(String statementid, Object object){
		superDao.deleteByUserDefined(statementid, object);
	}
	
	public void deleteByUserDefined(String statementid, Object object, String sqlMapClientId){
		superDao.deleteByUserDefined(statementid, object, sqlMapClientId);
	}
	
	public void updateByUserDefined(String statementid, Object object){
		superDao.updateByUserDefined(statementid, object);
	}

	public void updateByUserDefined(String statementid, Object object, String sqlMapClientId){
		superDao.updateByUserDefined(statementid, object, sqlMapClientId);
	}
	
	public Long getOracleSequencesBySeqName(String seqname){
		return superDao.getOracleSequencesBySeqName(seqname);
	}
}
