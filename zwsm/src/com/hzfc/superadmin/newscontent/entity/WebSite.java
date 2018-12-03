package com.hzfc.superadmin.newscontent.entity;

public class WebSite {
	
	private long siteid;
	private String sitename;
	private String sitepath;
	private String sqlMapClientId;
	private String visiturl;
	private String descr;
	private int isused;
	private String modtime;
	
	public long getSiteid() {
		return siteid;
	}
	public void setSiteid(long siteid) {
		this.siteid = siteid;
	}
	public String getSitename() {
		return sitename;
	}
	public void setSitename(String sitename) {
		this.sitename = sitename;
	}
	public String getSitepath() {
		return sitepath;
	}
	public void setSitepath(String sitepath) {
		this.sitepath = sitepath;
	}
	public String getSqlMapClientId() {
		return sqlMapClientId;
	}
	public void setSqlMapClientId(String sqlMapClientId) {
		this.sqlMapClientId = sqlMapClientId;
	}
	public String getVisiturl() {
		return visiturl;
	}
	public void setVisiturl(String visiturl) {
		this.visiturl = visiturl;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public int getIsused() {
		return isused;
	}
	public void setIsused(int isused) {
		this.isused = isused;
	}
	public String getModtime() {
		return modtime;
	}
	public void setModtime(String modtime) {
		this.modtime = modtime;
	}

}
