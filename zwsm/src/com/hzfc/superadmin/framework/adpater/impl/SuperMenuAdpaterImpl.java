package com.hzfc.superadmin.framework.adpater.impl;

import java.util.List;
import java.util.Map;

import com.hzfc.superadmin.framework.adpater.SuperMenuAdpater;
import com.hzfc.superadmin.framework.entity.SuperMenu;
import com.hzfc.superadmin.framework.entity.SysAccount;
import com.hzfc.superadmin.framework.service.SuperMenuService;
import com.hzfc.superadmin.newscontent.entity.WebSite;


public class SuperMenuAdpaterImpl implements SuperMenuAdpater{
	
	private SuperMenuService _superMenuService;

	
	public List<SuperMenu> getLeftMenuByArgMap(Map<String, Object> argMap, boolean flag) {
		return _superMenuService.getLeftMenuByArgMap(argMap, flag);
	}

	public List<SuperMenu> getTopMenuByAccountid(long accountid) {
		return _superMenuService.getTopMenuByAccountid(accountid);
	}
	
	public SysAccount getSysAccountForLoginByLoginname(Map<String, Object> argMap) {
		return _superMenuService.getSysAccountForLoginByLoginname(argMap);
	}
	
	public void updateSysAccountPassword(SysAccount account) {
		_superMenuService.updateSysAccountPassword(account);
	}

	public void setSuperMenuService(SuperMenuService superMenuService) {
		_superMenuService = superMenuService;
	}

	public SuperMenuService getSuperMenuService() {
		return _superMenuService;
	}

	public List<WebSite> getWebSiteList() {
		return _superMenuService.getWebSiteList();
	}


	
}
