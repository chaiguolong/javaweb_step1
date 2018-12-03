package com.hzfc.superadmin.ad.entity;

public class WebAdInfo {
    private Long adid;

    private Long adtypeid;

    private Short rsstype;

    private String adpath;

    private String descr;

    private Short orderid;

    private Short isdisplay;

    private String begintime;

    private String endtime;

    private String linkurl;
    
    private String seatinfo;
    
    private String newpath;

    public Long getAdid() {
        return adid;
    }

    public void setAdid(Long adid) {
        this.adid = adid;
    }

    public Long getAdtypeid() {
        return adtypeid;
    }

    public void setAdtypeid(Long adtypeid) {
        this.adtypeid = adtypeid;
    }

    public Short getRsstype() {
        return rsstype;
    }

    public void setRsstype(Short rsstype) {
        this.rsstype = rsstype;
    }

    public String getAdpath() {
        return adpath;
    }

    public void setAdpath(String adpath) {
        this.adpath = adpath == null ? null : adpath.trim();
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr == null ? null : descr.trim();
    }

    public Short getOrderid() {
        return orderid;
    }

    public void setOrderid(Short orderid) {
        this.orderid = orderid;
    }

    public Short getIsdisplay() {
        return isdisplay;
    }

    public void setIsdisplay(Short isdisplay) {
        this.isdisplay = isdisplay;
    }

    public String getBegintime() {
        return begintime;
    }

    public void setBegintime(String begintime) {
        this.begintime = begintime == null ? null : begintime.trim();
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime == null ? null : endtime.trim();
    }

    public String getLinkurl() {
        return linkurl;
    }

    public void setLinkurl(String linkurl) {
        this.linkurl = linkurl == null ? null : linkurl.trim();
    }

	public String getSeatinfo() {
		return seatinfo;
	}

	public void setSeatinfo(String seatinfo) {
		this.seatinfo = seatinfo;
	}

	public String getNewpath() {
		return newpath;
	}

	public void setNewpath(String newpath) {
		this.newpath = newpath;
	}
}