package com.hzfc.web.entity;

public class Category {
    private Long categoryid;

    private Long pid;

    private String name;

    private Short isdisplay;

    private Short issingle;

    private Long sortnumber;

    private String reamrk;

    private Long websiteid;
    
    private String url;

    public Long getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Long categoryid) {
        this.categoryid = categoryid;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getIsdisplay() {
        return isdisplay;
    }

    public void setIsdisplay(Short isdisplay) {
        this.isdisplay = isdisplay;
    }

    public Short getIssingle() {
        return issingle;
    }

    public void setIssingle(Short issingle) {
        this.issingle = issingle;
    }

    public Long getSortnumber() {
        return sortnumber;
    }

    public void setSortnumber(Long sortnumber) {
        this.sortnumber = sortnumber;
    }

    public String getReamrk() {
        return reamrk;
    }

    public void setReamrk(String reamrk) {
        this.reamrk = reamrk;
    }

    public Long getWebsiteid() {
        return websiteid;
    }

    public void setWebsiteid(Long websiteid) {
        this.websiteid = websiteid;
    }

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
    
}