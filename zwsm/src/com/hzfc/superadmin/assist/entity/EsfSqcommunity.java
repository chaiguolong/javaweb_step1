package com.hzfc.superadmin.assist.entity;

public class EsfSqcommunity {
    private Long applyid;

    private String communityname;

    private Long areaid;

    private Short applystate;

    private String applicat;

    private String applytime;

    private String verifytime;

    private String applymk;

    private String arearmk;

    public Long getApplyid() {
        return applyid;
    }

    public void setApplyid(Long applyid) {
        this.applyid = applyid;
    }

    public String getCommunityname() {
        return communityname;
    }

    public void setCommunityname(String communityname) {
        this.communityname = communityname == null ? null : communityname.trim();
    }

    public Long getAreaid() {
        return areaid;
    }

    public void setAreaid(Long areaid) {
        this.areaid = areaid;
    }

    public Short getApplystate() {
        return applystate;
    }

    public void setApplystate(Short applystate) {
        this.applystate = applystate;
    }

    public String getApplicat() {
        return applicat;
    }

    public void setApplicat(String applicat) {
        this.applicat = applicat == null ? null : applicat.trim();
    }

    public String getApplytime() {
        return applytime;
    }

    public void setApplytime(String applytime) {
        this.applytime = applytime == null ? null : applytime.trim();
    }

    public String getVerifytime() {
        return verifytime;
    }

    public void setVerifytime(String verifytime) {
        this.verifytime = verifytime == null ? null : verifytime.trim();
    }

    public String getArearmk() {
        return arearmk;
    }

    public void setArearmk(String arearmk) {
        this.arearmk = arearmk == null ? null : arearmk.trim();
    }

	public String getApplymk() {
		return applymk;
	}

	public void setApplymk(String applymk) {
		this.applymk = applymk;
	}
}