package com.hzfc.superadmin.framework.entity;

public class DepartmentResource {
    private Long departmentresourceid;

    private Long departmentid;

    private Long resourceid;
    
    private Long menuid;

    public Long getDepartmentresourceid() {
        return departmentresourceid;
    }

    public void setDepartmentresourceid(Long departmentresourceid) {
        this.departmentresourceid = departmentresourceid;
    }

    public Long getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Long departmentid) {
        this.departmentid = departmentid;
    }

    public Long getResourceid() {
        return resourceid;
    }

    public void setResourceid(Long resourceid) {
        this.resourceid = resourceid;
    }

	public Long getMenuid() {
		return menuid;
	}

	public void setMenuid(Long menuid) {
		this.menuid = menuid;
	}

}
