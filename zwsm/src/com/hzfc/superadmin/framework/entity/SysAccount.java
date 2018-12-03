package com.hzfc.superadmin.framework.entity;

public class SysAccount implements java.io.Serializable {
	
	private static final long serialVersionUID = -2077546110433508239L;
	
	private long accountid;
	private String loginuser;
	private String loginpass;
	private Short isenable;
	
	private String siteid;
	private String sitename;
	private String sqlMapClientId;
	
	public String getSiteid() {
		return siteid;
	}

	public void setSiteid(String siteid) {
		this.siteid = siteid;
	}

	public String getSitename() {
		return sitename;
	}

	public void setSitename(String sitename) {
		this.sitename = sitename;
	}

	public String getSqlMapClientId() {
		return sqlMapClientId;
	}

	public void setSqlMapClientId(String sqlMapClientId) {
		this.sqlMapClientId = sqlMapClientId;
	}

	public long getAccountid() {
		return accountid;
	}

	public void setAccountid(long accountid) {
		this.accountid = accountid;
	}

	public String getLoginuser() {
		return loginuser;
	}

	public void setLoginuser(String loginuser) {
		this.loginuser = loginuser;
	}

	public String getLoginpass() {
		return loginpass;
	}

	public void setLoginpass(String loginpass) {
		this.loginpass = loginpass;
	}

	public Short getIsenable() {
		return isenable;
	}

	public void setIsenable(Short isenable) {
		this.isenable = isenable;
	}

}
