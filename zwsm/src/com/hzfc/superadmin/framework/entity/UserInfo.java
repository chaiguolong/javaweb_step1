package com.hzfc.superadmin.framework.entity;

public class UserInfo {
    private Long userextid;

    private Long accountid;

    private String realname;

    private Short sex;

    private String email;

    private String mobile;

    private String address;

    private String postcode;

    private String remark;
    
    private String loginuser;

    private String loginpass;

    private Short isenable;

    public Long getUserextid() {
        return userextid;
    }

    public void setUserextid(Long userextid) {
        this.userextid = userextid;
    }

    public Long getAccountid() {
        return accountid;
    }

    public void setAccountid(Long accountid) {
        this.accountid = accountid;
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
        this.email = email == null ? null : email.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode == null ? null : postcode.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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