package com.hzfc.common.adpater.impl;

import java.util.List;
import java.util.Map;

import com.hzfc.common.adpater.SuperAdpater;
import com.hzfc.common.service.SuperService;
import com.hzfc.superadmin.assist.entity.DicItems;
import com.hzfc.utils.QueryCondition;

public class SuperAdpaterImpl implements SuperAdpater{
	
	private SuperService superService;

	public SuperService getSuperService() {
		return superService;
	}

	public void setSuperService(SuperService superService) {
		this.superService = superService;
	}

	public void deleteByPrimaryKey(String tablename, Object object) {
		superService.deleteByPrimaryKey(tablename, object);

	}
	
	public void deleteByPrimaryKey(String tablename, Object object, String sqlMapClientId) {
		superService.deleteByPrimaryKey(tablename, object, sqlMapClientId);
	}

	public void insert(String tablename, Object object) {
		superService.insert(tablename, object);

	}
	
	public void insert(String tablename, Object object, String sqlMapClientId) {
		superService.insert(tablename, object, sqlMapClientId);
	}

	public void insertSelective(String tablename, Object object) {
		superService.insertSelective(tablename, object);
	}
	
	public void insertSelective(String tablename, Object object, String sqlMapClientId) {
		superService.insertSelective(tablename, object, sqlMapClientId);
	}

	public void updateByPrimaryKey(String tablename, Object object) {
		superService.updateByPrimaryKey(tablename, object);
	}
	
	public void updateByPrimaryKey(String tablename, Object object, String sqlMapClientId) {
		superService.updateByPrimaryKey(tablename, object, sqlMapClientId);
	}

	public void updateByPrimaryKeySelective(String tablename, Object object) {
		superService.updateByPrimaryKeySelective(tablename, object);
	}
	
	public void updateByPrimaryKeySelective(String tablename, Object object, String sqlMapClientId) {
		superService.updateByPrimaryKeySelective(tablename, object, sqlMapClientId);
	}

	public Object selectByPrimaryKey(String tablename, Object object) {
		return superService.selectByPrimaryKey(tablename, object);
	}
	
	public Object selectByPrimaryKey(String tablename, Object object, String sqlMapClientId) {
		return superService.selectByPrimaryKey(tablename, object, sqlMapClientId);
	}

	public List<Object> selectAllByMapParam(String statementid, Map map) {
		return superService.selectAllByMapParam(statementid, map);
	}
	
	public List<Object> selectAllByMapParam(String statementid, Map map, String sqlMapClientId) {
		return superService.selectAllByMapParam(statementid, map, sqlMapClientId);
	}

	public List<Object> selectPageByQueryCondition(String statementid,
			QueryCondition queryCondition) {
		return superService.selectPageByQueryCondition(statementid, queryCondition);
	}
	
	public List<Object> selectPageByQueryCondition(String statementid, QueryCondition queryCondition, String sqlMapClientId) {
		return superService.selectPageByQueryCondition(statementid, queryCondition, sqlMapClientId);
	}

	public List<DicItems> selectKeyListByKeycode(String keycode) {
		return superService.selectKeyListByKeycode(keycode);
	}
	
	public List<DicItems> selectKeyListByKeycode(String keycode, String sqlMapClientId) {
		return superService.selectKeyListByKeycode(keycode, sqlMapClientId);
	}

	public List<Object> selectByStatementid(String statementid) {
		return superService.selectByStatementid(statementid);
	}
	
	public List<Object> selectByStatementid(String statementid, String sqlMapClientId) {
		return superService.selectByStatementid(statementid, sqlMapClientId);
	}

	public Object selectObjectByMapParam(String statementid, Map map) {
		return superService.selectObjectByMapParam(statementid, map);
	}
	
	public Object selectObjectByMapParam(String statementid, Map map, String sqlMapClientId) {
		return superService.selectObjectByMapParam(statementid, map, sqlMapClientId);
	}
	
	public void deleteByUserDefined(String statementid, Object object){
		superService.deleteByUserDefined(statementid, object);
	}
	
	public void deleteByUserDefined(String statementid, Object object, String sqlMapClientId){
		superService.deleteByUserDefined(statementid, object, sqlMapClientId);
	}
	
	public void updateByUserDefined(String statementid, Object object){
		superService.updateByUserDefined(statementid, object);
	}

	public void updateByUserDefined(String statementid, Object object, String sqlMapClientId){
		superService.updateByUserDefined(statementid, object, sqlMapClientId);
	}
	
	public Long getOracleSequencesBySeqName(String seqname){
		return superService.getOracleSequencesBySeqName(seqname);
	}
	
}
