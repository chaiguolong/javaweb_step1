package com.hzfc.superadmin.framework.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import net.sf.json.JSONArray;

import com.hzfc.common.action.SuperAction;
import com.hzfc.superadmin.framework.adpater.SuperMenuAdpater;
import com.hzfc.superadmin.framework.entity.SuperMenu;
import com.hzfc.superadmin.framework.entity.SysAccount;
import com.hzfc.utils.MD5;
import com.hzfc.utils.TablesNameConstants;

@SuppressWarnings("serial")
public class FrameworkAction extends SuperAction{
	
	private SuperMenuAdpater _superMenuAdpater;
	
	//加载顶部菜单
	public void loadTopMenu(){
		List<SuperMenu> list = new ArrayList<SuperMenu>();
		if(true){
			SysAccount sysAccount = ((SysAccount)getSessionObj("sessionsuperadmin"));
			list = _superMenuAdpater.getTopMenuByAccountid(sysAccount.getAccountid());
		}
		this.renderText(JSONArray.fromObject(list).toString());
	}
	
	//加载左侧菜单
	public void loadLeftMenu(){
		Map<String, Object> argMap = new HashMap<String, Object>();
		List<SuperMenu> list = new ArrayList<SuperMenu>();
		SysAccount sysAccount = ((SysAccount)getSessionObj("sessionsuperadmin"));
		if(sysAccount != null){
			argMap.put("accountid", sysAccount.getAccountid());
			argMap.put("pid", getParameterValue("pid"));
			boolean flag = false;
			if("19".equals(getParameterValue("pid"))){
				flag = true;
			}
			list = _superMenuAdpater.getLeftMenuByArgMap(argMap, flag);
		}
		this.renderText(JSONArray.fromObject(list).toString());
	}
	
	public String checkLogin(){
		SysAccount sysAccount = ((SysAccount) getSessionObj("sessionsuperadmin"));
		if(sysAccount != null){
			setRequestAttribute("sysAccount", sysAccount);
			//加载站点
			setRequestAttribute("websitelist", _superMenuAdpater.getWebSiteList());
			return "main";
		}
		else {
			return "login";
		}
	}
	
	
	public void doLogin(){
		String loginname = (String) getParameterValue("loginname");
		String loginpwd = (String) getParameterValue("loginpwd");
		String checkCode = (String) getParameterValue("checkCode");
		if (checkStr(loginname)) {
		    this.renderText("{'flag':false,'returnMsg':'登录名错误！'}");
		}
		else if (checkStr(loginpwd)) {
		    this.renderText("{'flag':false,'returnMsg':'登录密码错误！'}");
		}
		// 校验验证码
		else if (!getSessionObj("superlogincode").equals(checkCode)) {
		    this.renderText("{'flag':false,'returnMsg':'验证码错误！'}");
		}
		else {
			MD5 md5 = new MD5();
			Map<String, Object> argMap = new HashMap<String, Object>();
			//设置当前主站站点
			//argMap.put("websiteid", TablesNameConstants.MAIN_WEBSITEID);
			argMap.put("loginname", loginname);
			SysAccount session = _superMenuAdpater.getSysAccountForLoginByLoginname(argMap);
			if (session == null) {
				this.renderText("{'flag':false,'returnMsg':'无效的登录账号！'}");
			}
			else {
				if (session.getIsenable() == 0) {
					this.renderText("{'flag':false,'returnMsg':'无效的登录账号！'}");
				}
				else if (session.getLoginpass().equals(md5.getMD5ofStr(loginpwd))) {
					//默认获取当前站点
					setSessionObj("sessionsuperadmin", session);
					this.renderText("{'flag':true}");
				}
				else {
					this.renderText("{'flag':false,'returnMsg':'登录密码错误！'}");
				}
			}
		}
	}

	public void doExit(){
		setSessionObj("sessionsuperadmin", null);
		this.renderText("{'flag':true}");
	}
	
	public String toPassword(){
		SysAccount sysAccount = ((SysAccount) getSessionObj("sessionsuperadmin"));
		if(sysAccount != null){
			setRequestAttribute("sysAccount", sysAccount);
			return "password";
		}
		else {
			return "login";
		}
	}
	
	public void savePassword(){
		String oldpwd = (String) getParameterValue("oldpwd");
		String newpwd = (String) getParameterValue("loginpwd");
		String loginpwdcheck = (String) getParameterValue("loginpwdcheck");
		String loginuser = (String) getParameterValue("loginuser");
		if (checkStr(oldpwd)) {
		    this.renderText("{'flag':false,'returnMsg':'旧密码无效！'}");
		}
		else if (checkStr(newpwd)) {
		    this.renderText("{'flag':false,'returnMsg':'新密码无效！'}");
		}
		else if (!newpwd.equals(loginpwdcheck)) {
		    this.renderText("{'flag':false,'returnMsg':'确认密码错误！'}");
		}
		else {
			MD5 md5 = new MD5();
			Map<String, Object> argMap = new HashMap<String, Object>();
			//设置当前主站站点
			//argMap.put("websiteid", TablesNameConstants.MAIN_WEBSITEID);
			argMap.put("loginname", loginuser);
			SysAccount session = _superMenuAdpater.getSysAccountForLoginByLoginname(argMap);
			if (!md5.getMD5ofStr(oldpwd).equals(session.getLoginpass())) {
				this.renderText("{'flag':false,'returnMsg':'旧密码错误！'}");
			}
			else {
				session.setLoginpass(md5.getMD5ofStr(newpwd));
				_superMenuAdpater.updateSysAccountPassword(session);
				this.renderText("{'flag':true,'returnMsg':'密码修改成功！'}");
			}
		}
		
	}
	
	//切换站点
	public void changedWebSite(){
		SysAccount sysAccount = ((SysAccount) getSessionObj("sessionsuperadmin"));
		if(sysAccount != null){
			String siteid = (String) getParameterValue("siteid");
			String sitename = (String) getParameterValue("sitename");
			String sqlMapClientId = (String) getParameterValue("sqlMapClientId");
			sysAccount.setSiteid(siteid);
			sysAccount.setSitename(sitename);
			sysAccount.setSqlMapClientId(sqlMapClientId);
			setSessionObj("sessionsuperadmin", sysAccount);
			this.renderText("{'flag':true}");
		}
		else {
			this.renderText("{'flag':false}");
		}
	}
	

	// 校验非法字符
    public boolean checkStr(String str) {
		if (StringUtils.isBlank(str.trim())) {
		    return true;
		}
		String inj_str = "‘,*,%,;,/,+,&,|,(,),$,!,[,]";
		String[] inj_stra = inj_str.split(",");
		for (int i = 0; i < inj_stra.length; i++) {
		    if (str.indexOf(inj_stra[i]) >= 0) {
		    	return true;
		    }
		}
		return false;
    }
    
	public SuperMenuAdpater getSuperMenuAdpater() {
		return _superMenuAdpater;
	}

	public void setSuperMenuAdpater(SuperMenuAdpater superMenuAdpater) {
		_superMenuAdpater = superMenuAdpater;
	}
	
}
