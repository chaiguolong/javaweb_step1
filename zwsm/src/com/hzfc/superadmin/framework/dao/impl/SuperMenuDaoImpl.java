package com.hzfc.superadmin.framework.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.hzfc.superadmin.framework.dao.SuperMenuDao;
import com.hzfc.superadmin.framework.entity.SuperMenu;
import com.hzfc.superadmin.framework.entity.SysAccount;
import com.hzfc.superadmin.newscontent.entity.WebSite;

public class SuperMenuDaoImpl extends SqlMapClientDaoSupport implements SuperMenuDao{

	@SuppressWarnings("unchecked")
	public List<SuperMenu> getTopMenuByAccountid(long accountid) {
		List<SuperMenu> list = getSqlMapClientTemplate().queryForList("getTopMenuByAccountid", accountid);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<SuperMenu> getLeftMenuByArgMap(Map<String, Object> argMap) {
		List<SuperMenu> list = getSqlMapClientTemplate().queryForList("getLeftMenuByArgMap", argMap);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<SuperMenu> getLeftMenuByArgMapAndInf(
			Map<String, Object> argMap) {
		List<SuperMenu> list = getSqlMapClientTemplate().queryForList("getLeftMenuByArgMapAndInf", argMap);
		return list;
	}

	@SuppressWarnings("unchecked")
	public SysAccount getSysAccountForLoginByLoginname(Map<String, Object> argMap) {
		List<SysAccount> list = getSqlMapClientTemplate().queryForList("getSysAccountForLoginByLoginname", argMap);
		if(list.isEmpty()){
			return null;
		}
		
		return list.get(0);
	}

	public void updateSysAccountPassword(SysAccount account) {
		getSqlMapClientTemplate().update("updateSysAccountPassword", account);
	}


	@SuppressWarnings("unchecked")
	public List<WebSite> getWebSiteList() {
		List<WebSite> list = getSqlMapClientTemplate().queryForList("T_WEBSITE_selectByStatementidForSelect");
		return list;
	}

}
