package com.hzfc.superadmin.assist.entity;

public class EsfSchools {
    private Long schoolid;

    private String schoolname;

    private Long schooltype;

    private String schoolfeature;

    private String schooladdr;

    private String schooltel;

    private String showimg;

    private String showlink;

    private String showmap;

    private String modtime;

    private Integer orderid;

    private Short isdisplay;

    private String schoolrmk;
    
    private String newpath;
    
    private String schooltypename;
    
    private String schoolfeaturename;
    
    private String communityname;

    public Long getSchoolid() {
        return schoolid;
    }

    public void setSchoolid(Long schoolid) {
        this.schoolid = schoolid;
    }

    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname == null ? null : schoolname.trim();
    }

    public Long getSchooltype() {
        return schooltype;
    }

    public void setSchooltype(Long schooltype) {
        this.schooltype = schooltype;
    }

    public String getSchoolfeature() {
        return schoolfeature;
    }

    public void setSchoolfeature(String schoolfeature) {
        this.schoolfeature = schoolfeature == null ? null : schoolfeature.trim();
    }

    public String getSchooladdr() {
        return schooladdr;
    }

    public void setSchooladdr(String schooladdr) {
        this.schooladdr = schooladdr == null ? null : schooladdr.trim();
    }

    public String getSchooltel() {
        return schooltel;
    }

    public void setSchooltel(String schooltel) {
        this.schooltel = schooltel == null ? null : schooltel.trim();
    }

    public String getShowimg() {
        return showimg;
    }

    public void setShowimg(String showimg) {
        this.showimg = showimg == null ? null : showimg.trim();
    }

    public String getShowlink() {
        return showlink;
    }

    public void setShowlink(String showlink) {
        this.showlink = showlink == null ? null : showlink.trim();
    }

    public String getShowmap() {
        return showmap;
    }

    public void setShowmap(String showmap) {
        this.showmap = showmap == null ? null : showmap.trim();
    }

    public String getModtime() {
        return modtime;
    }

    public void setModtime(String modtime) {
        this.modtime = modtime == null ? null : modtime.trim();
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Short getIsdisplay() {
        return isdisplay;
    }

    public void setIsdisplay(Short isdisplay) {
        this.isdisplay = isdisplay;
    }

    public String getSchoolrmk() {
        return schoolrmk;
    }

    public void setSchoolrmk(String schoolrmk) {
        this.schoolrmk = schoolrmk == null ? null : schoolrmk.trim();
    }

	public String getNewpath() {
		return newpath;
	}

	public void setNewpath(String newpath) {
		this.newpath = newpath;
	}

	public String getSchooltypename() {
		return schooltypename;
	}

	public void setSchooltypename(String schooltypename) {
		this.schooltypename = schooltypename;
	}

	public String getSchoolfeaturename() {
		return schoolfeaturename;
	}

	public void setSchoolfeaturename(String schoolfeaturename) {
		this.schoolfeaturename = schoolfeaturename;
	}

	public String getCommunityname() {
		return communityname;
	}

	public void setCommunityname(String communityname) {
		this.communityname = communityname;
	}

	
    
}