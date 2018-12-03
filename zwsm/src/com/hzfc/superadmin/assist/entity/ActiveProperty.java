package com.hzfc.superadmin.assist.entity;

public class ActiveProperty {
    private Long activeid;

    private String propertyname;

    private String propertytype;

    private String showaddr;

    private String propertyaddr;

    private String showimg;

    private String showurl;

    private Short isdisplay;

    private Integer orderid;

    private String modtime;
    
    private String newpath;
    
    private String typeid;
    
    private String typevalues;
    
    public String getTypeid() {
		return typeid;
	}

	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}

	public String getTypevalues() {
		return typevalues;
	}

	public void setTypevalues(String typevalues) {
		this.typevalues = typevalues;
	}

	public Long getActiveid() {
        return activeid;
    }

    public void setActiveid(Long activeid) {
        this.activeid = activeid;
    }

    public String getPropertyname() {
        return propertyname;
    }

    public void setPropertyname(String propertyname) {
        this.propertyname = propertyname == null ? null : propertyname.trim();
    }

    public String getPropertytype() {
        return propertytype;
    }

    public void setPropertytype(String propertytype) {
        this.propertytype = propertytype == null ? null : propertytype.trim();
    }

    public String getShowaddr() {
        return showaddr;
    }

    public void setShowaddr(String showaddr) {
        this.showaddr = showaddr == null ? null : showaddr.trim();
    }

    public String getPropertyaddr() {
        return propertyaddr;
    }

    public void setPropertyaddr(String propertyaddr) {
        this.propertyaddr = propertyaddr == null ? null : propertyaddr.trim();
    }

    public String getShowimg() {
        return showimg;
    }

    public void setShowimg(String showimg) {
        this.showimg = showimg == null ? null : showimg.trim();
    }

    public String getShowurl() {
        return showurl;
    }

    public void setShowurl(String showurl) {
        this.showurl = showurl == null ? null : showurl.trim();
    }

    public Short getIsdisplay() {
        return isdisplay;
    }

    public void setIsdisplay(Short isdisplay) {
        this.isdisplay = isdisplay;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public String getModtime() {
        return modtime;
    }

    public void setModtime(String modtime) {
        this.modtime = modtime == null ? null : modtime.trim();
    }

	public String getNewpath() {
		return newpath;
	}

	public void setNewpath(String newpath) {
		this.newpath = newpath;
	}
}