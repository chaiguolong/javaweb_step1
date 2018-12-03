package com.hzfc.web.service.impl;


import java.util.List;

import com.hzfc.utils.TablesNameConstants;
import com.hzfc.web.dao.DeveloperDAO;
import com.hzfc.web.service.DeveloperService;

public class DeveloperServiceImpl implements DeveloperService {

	private DeveloperDAO _developerDao;
	
	public DeveloperDAO getDeveloperDao() {
		return _developerDao;
	}

	public void setDeveloperDao(DeveloperDAO developerDao) {
		_developerDao = developerDao;
	}

	@Override
	public List<Object> selectDeveloperList() {
		return _developerDao.selectByStatementid(TablesNameConstants.WEB_COH_DEVELOPER + "_selectAll");
	}

	@Override
	public List<Object> selectDeveloperListOuter() {
		return _developerDao.selectByStatementid(TablesNameConstants.WEB_COH_DEVELOPER + "_selectAll", TablesNameConstants.SQLMAPCLIENTOUTER);
	}
	
}
