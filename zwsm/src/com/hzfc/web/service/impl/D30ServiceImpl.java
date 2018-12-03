package com.hzfc.web.service.impl;

import java.util.List;

import com.hzfc.utils.TablesNameConstants;
import com.hzfc.web.dao.D30DAO;
import com.hzfc.web.service.D30Service;

public class D30ServiceImpl implements D30Service {

	private D30DAO _d30Dao;
	
	public D30DAO getD30Dao() {
		return _d30Dao;
	}

	public void setD30Dao(D30DAO d30Dao) {
		_d30Dao = d30Dao;
	}

	@Override
	public List<Object> selectStatisticForDay() {
		return _d30Dao.selectByStatementid(TablesNameConstants.WEB_STA_D30 + "_selectStatisticForDay");
	}

	@Override
	public List<Object> selectStatisticForMonth() {
		return _d30Dao.selectByStatementid(TablesNameConstants.WEB_STA_D30 + "_selectStatisticForMonth");
	}

	@Override
	public List<Object> selectStatisticForDayAtOuter() {
		return _d30Dao.selectByStatementid(TablesNameConstants.WEB_STA_D30 + "_selectStatisticForDay", TablesNameConstants.SQLMAPCLIENTOUTER);
	}

	@Override
	public List<Object> selectStatisticForMonthAtOuter() {
		return _d30Dao.selectByStatementid(TablesNameConstants.WEB_STA_D30 + "_selectStatisticForMonth", TablesNameConstants.SQLMAPCLIENTOUTER);
	}

	@Override
	public List<Object> selectUsedStatisticForDay() {
		return _d30Dao.selectByStatementid(TablesNameConstants.WEB_STA_D30 + "_selectUsedStatisticForDay");
	}

	@Override
	public List<Object> selectUsedStatisticForDayAtOuter() {
		return _d30Dao.selectByStatementid(TablesNameConstants.WEB_STA_D30 + "_selectUsedStatisticForDay", TablesNameConstants.SQLMAPCLIENTOUTER);
	}

}
