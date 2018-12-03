package com.hzfc.superadmin.newscontent.entity;

public class StaticArea implements java.io.Serializable {

	private static final long serialVersionUID = -2493936255728874019L;
	
	private Long areaid;
	private String areano;
	private String areaname;
	private int areatype;
	
	public Long getAreaid() {
		return areaid;
	}
	public void setAreaid(Long areaid) {
		this.areaid = areaid;
	}
	public String getAreano() {
		return areano;
	}
	public void setAreano(String areano) {
		this.areano = areano;
	}
	public String getAreaname() {
		return areaname;
	}
	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}
	public int getAreatype() {
		return areatype;
	}
	public void setAreatype(int areatype) {
		this.areatype = areatype;
	}
}
