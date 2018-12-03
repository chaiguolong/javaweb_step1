package com.hzfc.superadmin.framework.service.impl;

import java.util.List;
import java.util.Map;

import com.hzfc.superadmin.framework.dao.SuperMenuDao;
import com.hzfc.superadmin.framework.entity.SuperMenu;
import com.hzfc.superadmin.framework.entity.SysAccount;
import com.hzfc.superadmin.framework.service.SuperMenuService;
import com.hzfc.superadmin.newscontent.entity.WebSite;

public class SuperMenuServiceImpl implements SuperMenuService{
	
	private SuperMenuDao _superMenuDao;

	public List<SuperMenu> getTopMenuByAccountid(long accountid) {
		return _superMenuDao.getTopMenuByAccountid(accountid);
	}

	public List<SuperMenu> getLeftMenuByArgMap(Map<String, Object> argMap, boolean flag) {
		List<SuperMenu> list = _superMenuDao.getLeftMenuByArgMap(argMap);
		if(flag){
			list.addAll(_superMenuDao.getLeftMenuByArgMapAndInf(argMap));
		}
		return list;
	}
	
	public SysAccount getSysAccountForLoginByLoginname(Map<String, Object> argMap) {
		return _superMenuDao.getSysAccountForLoginByLoginname(argMap);
	}
	
	public void updateSysAccountPassword(SysAccount account) {
		_superMenuDao.updateSysAccountPassword(account);
	}
	
	public SuperMenuDao getSuperMenuDao() {
		return _superMenuDao;
	}

	public void setSuperMenuDao(SuperMenuDao superMenuDao) {
		_superMenuDao = superMenuDao;
	}

	public List<WebSite> getWebSiteList() {
		return _superMenuDao.getWebSiteList();
	}


}
