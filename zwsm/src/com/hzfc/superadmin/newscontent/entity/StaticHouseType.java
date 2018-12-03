package com.hzfc.superadmin.newscontent.entity;

public class StaticHouseType implements java.io.Serializable {
	
	private static final long serialVersionUID = -2820802706039815114L;
	
	private Long housetypeid;
	private String housetypename;
	private String fldname;
	private Long valueid;
	
	public Long getHousetypeid() {
		return housetypeid;
	}
	public void setHousetypeid(Long housetypeid) {
		this.housetypeid = housetypeid;
	}
	public String getHousetypename() {
		return housetypename;
	}
	public void setHousetypename(String housetypename) {
		this.housetypename = housetypename;
	}
	public String getFldname() {
		return fldname;
	}
	public void setFldname(String fldname) {
		this.fldname = fldname;
	}
	public Long getValueid() {
		return valueid;
	}
	public void setValueid(Long valueid) {
		this.valueid = valueid;
	}
}
