package com.hzfc.superadmin.ad.entity;


public class WebStatictask {
    private Long statictaskid;

    private String dynamicurl;

    private String staticurl;

    private String staticpath;

    private String plandate;

    private String actualdate;

    private String statichtml;

    private Long siteid;

    private String sitename;

    private String temppoint;

    private String stattype;

    private String stattypename;

    public Long getStatictaskid() {
        return statictaskid;
    }

    public void setStatictaskid(Long statictaskid) {
        this.statictaskid = statictaskid;
    }

    public String getDynamicurl() {
        return dynamicurl;
    }

    public void setDynamicurl(String dynamicurl) {
        this.dynamicurl = dynamicurl == null ? null : dynamicurl.trim();
    }

    public String getStaticurl() {
        return staticurl;
    }

    public void setStaticurl(String staticurl) {
        this.staticurl = staticurl == null ? null : staticurl.trim();
    }

    public String getStaticpath() {
        return staticpath;
    }

    public void setStaticpath(String staticpath) {
        this.staticpath = staticpath == null ? null : staticpath.trim();
    }

    public String getPlandate() {
        return plandate;
    }

    public void setPlandate(String plandate) {
        this.plandate = plandate == null ? null : plandate.trim();
    }

   

	public String getActualdate() {
		return actualdate;
	}

	public void setActualdate(String actualdate) {
		this.actualdate = actualdate;
	}

	public String getStatichtml() {
        return statichtml;
    }

    public void setStatichtml(String statichtml) {
        this.statichtml = statichtml == null ? null : statichtml.trim();
    }

	public Long getSiteid() {
		return siteid;
	}

	public void setSiteid(Long siteid) {
		this.siteid = siteid;
	}

	public String getSitename() {
		return sitename;
	}

	public void setSitename(String sitename) {
		this.sitename = sitename;
	}

	public String getTemppoint() {
		return temppoint;
	}

	public void setTemppoint(String temppoint) {
		this.temppoint = temppoint;
	}

	public String getStattype() {
		return stattype;
	}

	public void setStattype(String stattype) {
		this.stattype = stattype;
	}

	public String getStattypename() {
		return stattypename;
	}

	public void setStattypename(String stattypename) {
		this.stattypename = stattypename;
	}
}