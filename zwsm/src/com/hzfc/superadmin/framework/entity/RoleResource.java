package com.hzfc.superadmin.framework.entity;

public class RoleResource {
    private Long roleresourceid;

    private Long roleid;

    private Long resourceid;
    
    private Long menuid;

    public Long getRoleresourceid() {
        return roleresourceid;
    }

    public void setRoleresourceid(Long roleresourceid) {
        this.roleresourceid = roleresourceid;
    }

    public Long getRoleid() {
        return roleid;
    }

    public void setRoleid(Long roleid) {
        this.roleid = roleid;
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