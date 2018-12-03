package com.hzfc.superadmin.framework.service;

import java.util.List;
import java.util.Map;

import com.hzfc.superadmin.framework.entity.SuperMenu;
import com.hzfc.superadmin.framework.entity.SysAccount;
import com.hzfc.superadmin.newscontent.entity.WebSite;

public interface SuperMenuService {

	List<SuperMenu> getTopMenuByAccountid(long accountid);

	List<SuperMenu> getLeftMenuByArgMap(Map<String, Object> argMap, boolean flag);

	SysAccount getSysAccountForLoginByLoginname(Map<String, Object> argMap);

	void updateSysAccountPassword(SysAccount account);

	List<WebSite> getWebSiteList();
}
