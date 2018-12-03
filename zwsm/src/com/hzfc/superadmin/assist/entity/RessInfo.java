package com.hzfc.superadmin.assist.entity;

public class RessInfo {
    private Long ressid;

    private Long linkid;

    private Long ressvest;

    private Long restypeid;

    private Long classid;

    private String tagname;

    private String linkurl;

    private String realpath;

    private String descr;

    private Short ischeckpass;

    private Short isdisplay;

    private Short orderid;

    private Short isdelete;

    private String addtime;

    private String modtime;
    
    private String ressvestname;

    private String restypeidname;

    private String classidname;
    
    private String newpath;
    
    public String getNewpath() {
		return newpath;
	}

	public void setNewpath(String newpath) {
		this.newpath = newpath;
	}

	public Long getRessid() {
        return ressid;
    }

    public void setRessid(Long ressid) {
        this.ressid = ressid;
    }

    public Long getLinkid() {
        return linkid;
    }

    public void setLinkid(Long linkid) {
        this.linkid = linkid;
    }

    public Long getRessvest() {
        return ressvest;
    }

    public void setRessvest(Long ressvest) {
        this.ressvest = ressvest;
    }

    public Long getRestypeid() {
        return restypeid;
    }

    public void setRestypeid(Long restypeid) {
        this.restypeid = restypeid;
    }

    public Long getClassid() {
        return classid;
    }

    public void setClassid(Long classid) {
        this.classid = classid;
    }

    public String getTagname() {
        return tagname;
    }

    public void setTagname(String tagname) {
        this.tagname = tagname == null ? null : tagname.trim();
    }

    public String getLinkurl() {
        return linkurl;
    }

    public void setLinkurl(String linkurl) {
        this.linkurl = linkurl == null ? null : linkurl.trim();
    }

    public String getRealpath() {
        return realpath;
    }

    public void setRealpath(String realpath) {
        this.realpath = realpath == null ? null : realpath.trim();
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr == null ? null : descr.trim();
    }

    public Short getIscheckpass() {
        return ischeckpass;
    }

    public void setIscheckpass(Short ischeckpass) {
        this.ischeckpass = ischeckpass;
    }

    public Short getIsdisplay() {
        return isdisplay;
    }

    public void setIsdisplay(Short isdisplay) {
        this.isdisplay = isdisplay;
    }

    public Short getOrderid() {
        return orderid;
    }

    public void setOrderid(Short orderid) {
        this.orderid = orderid;
    }

    public Short getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Short isdelete) {
        this.isdelete = isdelete;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }

    public String getModtime() {
        return modtime;
    }

    public void setModtime(String modtime) {
        this.modtime = modtime == null ? null : modtime.trim();
    }

	public String getRessvestname() {
		return ressvestname;
	}

	public void setRessvestname(String ressvestname) {
		this.ressvestname = ressvestname;
	}

	public String getRestypeidname() {
		return restypeidname;
	}

	public void setRestypeidname(String restypeidname) {
		this.restypeidname = restypeidname;
	}

	public String getClassidname() {
		return classidname;
	}

	public void setClassidname(String classidname) {
		this.classidname = classidname;
	}

}