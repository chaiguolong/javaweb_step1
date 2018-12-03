package com.hzfc.superadmin.framework.entity;

public class Role {
    private Long roleid;

    private String rolename;

    private String roleremark;
    
    private String resourceids;

    public Long getRoleid() {
        return roleid;
    }

    public void setRoleid(Long roleid) {
        this.roleid = roleid;
    }

    public Object getRolename() {
        return rolename;
    }

	public String getRoleremark() {
		return roleremark;
	}

	public void setRoleremark(String roleremark) {
		this.roleremark = roleremark;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getResourceids() {
		return resourceids;
	}

	public void setResourceids(String resourceids) {
		this.resourceids = resourceids;
	}

}