package com.hzfc.superadmin.framework.dao;

import java.util.List;
import java.util.Map;

import com.hzfc.superadmin.assist.entity.RessInfo;
import com.hzfc.superadmin.framework.entity.SuperMenu;
import com.hzfc.superadmin.framework.entity.SysAccount;
import com.hzfc.superadmin.newscontent.entity.WebSite;

public interface SuperMenuDao {

	List<SuperMenu> getTopMenuByAccountid(long accountid);

	List<SuperMenu> getLeftMenuByArgMap(Map<String, Object> argMap);

	List<SuperMenu> getLeftMenuByArgMapAndInf(
			Map<String, Object> argMap);

	SysAccount getSysAccountForLoginByLoginname(Map<String, Object> argMap);

	void updateSysAccountPassword(SysAccount account);

	List<WebSite> getWebSiteList();

}
