package com.hzfc.superadmin.assist.entity;

public class EsfCommunitySchool {
    private Long linkid;

    private Long communityid;

    private Long schoolid;

    private String communityname; 

    private String communityaddr;

    public Long getLinkid() {
        return linkid;
    }

    public void setLinkid(Long linkid) {
        this.linkid = linkid;
    }

    public Long getCommunityid() {
        return communityid;
    }

    public void setCommunityid(Long communityid) {
        this.communityid = communityid;
    }

    public Long getSchoolid() {
        return schoolid;
    }

    public void setSchoolid(Long schoolid) {
        this.schoolid = schoolid;
    }

	public String getCommunityname() {
		return communityname;
	}

	public void setCommunityname(String communityname) {
		this.communityname = communityname;
	}

	public String getCommunityaddr() {
		return communityaddr;
	}

	public void setCommunityaddr(String communityaddr) {
		this.communityaddr = communityaddr;
	}
}