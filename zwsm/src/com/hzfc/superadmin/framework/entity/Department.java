package com.hzfc.superadmin.framework.entity;

public class Department {
    private Long departmentid;

    private String departmentname;
    
    private String resourceids;

	public Long getDepartmentid() {
		return departmentid;
	}

	public void setDepartmentid(Long departmentid) {
		this.departmentid = departmentid;
	}

	public String getDepartmentname() {
		return departmentname;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}

	public String getResourceids() {
		return resourceids;
	}

	public void setResourceids(String resourceids) {
		this.resourceids = resourceids;
	}


}