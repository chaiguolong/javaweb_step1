package com.hzfc.superadmin.framework.entity;

public class UserDepartment {
    private Long userdepartmentid;

    private Long accountid;

    private Long departmentid;
    
    private String positionname;
    
    private Long positionid;
    
    public String getPositionname() {
		return positionname;
	}

	public void setPositionname(String positionname) {
		this.positionname = positionname;
	}

	public Long getPositionid() {
		return positionid;
	}

	public void setPositionid(Long positionid) {
		this.positionid = positionid;
	}

	public Long getUserdepartmentid() {
        return userdepartmentid;
    }

    public void setUserdepartmentid(Long userdepartmentid) {
        this.userdepartmentid = userdepartmentid;
    }

    public Long getAccountid() {
        return accountid;
    }

    public void setAccountid(Long accountid) {
        this.accountid = accountid;
    }

    public Long getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Long departmentid) {
        this.departmentid = departmentid;
    }
}