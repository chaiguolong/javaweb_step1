package com.hzfc.superadmin.framework.entity;

public class Position {
    private Long positionid;

    private Long departmentid;

    private String positionname;
    
    private String resourceids;

    public Long getPositionid() {
        return positionid;
    }

    public void setPositionid(Long positionid) {
        this.positionid = positionid;
    }

    public Long getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Long departmentid) {
        this.departmentid = departmentid;
    }

    public String getPositionname() {
        return positionname;
    }

    public void setPositionname(String positionname) {
        this.positionname = positionname == null ? null : positionname.trim();
    }

	public String getResourceids() {
		return resourceids;
	}

	public void setResourceids(String resourceids) {
		this.resourceids = resourceids;
	}
    
}