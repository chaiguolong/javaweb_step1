package com.hzfc.superadmin.framework.entity;

public class UserAccount {
	
	private String departmentname;
    
    private long departmentid;
    
    private long resourceid;
    
    private String Name;
    
    private String roseList;
    
    private String resourceList;
    
    private long roleid;
    
    private String rolename;
    
	//登陆表字段
    private Long accountid;
    
    private String loginuser;

    private String loginpass;
    
    private Short isenable;
    
    //用户拓展信息字段
    private Long userextid;

    private String realname;

    private Short sex;

    private String email;

    private String mobile;

    private String address;

    private String postcode;

    private String remark;
    
    //部门关联字段
    private Long userpositionid;

    private Long positionid;
    
    //职位关联字段
    private Long userdepartmentid;

    private String positionname;
    
	public Long getUserextid() {
		return userextid;
	}

	public void setUserextid(Long userextid) {
		this.userextid = userextid;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public Short getSex() {
		return sex;
	}

	public void setSex(Short sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getUserpositionid() {
		return userpositionid;
	}

	public void setUserpositionid(Long userpositionid) {
		this.userpositionid = userpositionid;
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

	public String getPositionname() {
		return positionname;
	}

	public void setPositionname(String positionname) {
		this.positionname = positionname;
	}

	public long getDepartmentid() {
		return departmentid;
	}

	public void setDepartmentid(long departmentid) {
		this.departmentid = departmentid;
	}

	public String getDepartmentname() {
		return departmentname;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}

	public String getResourceList() {
		return resourceList;
	}

	public void setResourceList(String resourceList) {
		this.resourceList = resourceList;
	}

	public String getRoseList() {
		return roseList;
	}

	public void setRoseList(String roseList) {
		this.roseList = roseList;
	}

	public long getResourceid() {
		return resourceid;
	}

	public void setResourceid(long resourceid) {
		this.resourceid = resourceid;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public long getRoleid() {
		return roleid;
	}

	public void setRoleid(long roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public Long getAccountid() {
        return accountid;
    }

    public void setAccountid(Long accountid) {
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