package com.hzfc.superadmin.newscontent.entity;

public class NewsContent {
	
    private Long contentid;

    private Long categoryid;
    
    private String categoryids;

    private String title;

    private String webshowdate;

    private String source;

    private String descr;

    private String thumbnail;

    private String tag;

    private String staticurl;

    private Long relatednextid;

    private String entrydate;

    private String releasetime;

    private Short releasemark;

    private String uploadattachment;

    private Long researchid;

    private Short hotflag;

    private Short recommendflag;

    private Long districtid;

    private Long areaid;

    private Long housetypeid;

    private Short focusflag;

    private String gotourl;

    private String releasename;

    private String content;
    
    private String releasemarkvalue;
    
    private String propertyList;
    
    private String researchtitle;
    
    private Long levelno;

	public Long getLevelno() {
		return levelno;
	}

	public void setLevelno(Long levelno) {
		this.levelno = levelno;
	}

	public String getResearchtitle() {
		return researchtitle;
	}

	public void setResearchtitle(String researchtitle) {
		this.researchtitle = researchtitle;
	}

	public String getPropertyList() {
		return propertyList;
	}

	public void setPropertyList(String propertyList) {
		this.propertyList = propertyList;
	}

	public String getCategoryids() {
		return categoryids;
	}

	public void setCategoryids(String categoryids) {
		this.categoryids = categoryids;
	}

	public String getReleasemarkvalue() {
		return releasemarkvalue;
	}

	public void setReleasemarkvalue(String releasemarkvalue) {
		this.releasemarkvalue = releasemarkvalue;
	}

	public Long getContentid() {
        return contentid;
    }

    public void setContentid(Long contentid) {
        this.contentid = contentid;
    }

    public Long getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Long categoryid) {
        this.categoryid = categoryid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getWebshowdate() {
        return webshowdate;
    }

    public void setWebshowdate(String webshowdate) {
        this.webshowdate = webshowdate == null ? null : webshowdate.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr == null ? null : descr.trim();
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail == null ? null : thumbnail.trim();
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    public String getStaticurl() {
        return staticurl;
    }

    public void setStaticurl(String staticurl) {
        this.staticurl = staticurl == null ? null : staticurl.trim();
    }

    public Long getRelatednextid() {
        return relatednextid;
    }

    public void setRelatednextid(Long relatednextid) {
        this.relatednextid = relatednextid;
    }

    public String getEntrydate() {
        return entrydate;
    }

    public void setEntrydate(String entrydate) {
        this.entrydate = entrydate == null ? null : entrydate.trim();
    }

    public String getReleasetime() {
        return releasetime;
    }

    public void setReleasetime(String releasetime) {
        this.releasetime = releasetime == null ? null : releasetime.trim();
    }

    public Short getReleasemark() {
        return releasemark;
    }

    public void setReleasemark(Short releasemark) {
        this.releasemark = releasemark;
        if(releasemark == -3){
        	releasemarkvalue = "<font color=red>退回</font>";
        }
        if(releasemark == -2){
        	releasemarkvalue = "待提交";
        }
        if(releasemark == -1){
        	releasemarkvalue = "<font color=orange>待审核</font>";
        }
        if(releasemark == 0){
        	releasemarkvalue = "<font color=blue>待发布</font>";
        }
        if(releasemark == 1){
        	releasemarkvalue = "<font color=green>已发布</font>";
        }
    }

    public String getUploadattachment() {
        return uploadattachment;
    }

    public void setUploadattachment(String uploadattachment) {
        this.uploadattachment = uploadattachment == null ? null : uploadattachment.trim();
    }

    public Long getResearchid() {
        return researchid;
    }

    public void setResearchid(Long researchid) {
        this.researchid = researchid;
    }

    public Short getHotflag() {
        return hotflag;
    }

    public void setHotflag(Short hotflag) {
        this.hotflag = hotflag;
    }

    public Short getRecommendflag() {
        return recommendflag;
    }

    public void setRecommendflag(Short recommendflag) {
        this.recommendflag = recommendflag;
    }

    public Long getDistrictid() {
        return districtid;
    }

    public void setDistrictid(Long districtid) {
        this.districtid = districtid;
    }

    public Long getAreaid() {
        return areaid;
    }

    public void setAreaid(Long areaid) {
        this.areaid = areaid;
    }

    public Long getHousetypeid() {
        return housetypeid;
    }

    public void setHousetypeid(Long housetypeid) {
        this.housetypeid = housetypeid;
    }

    public Short getFocusflag() {
        return focusflag;
    }

    public void setFocusflag(Short focusflag) {
        this.focusflag = focusflag;
    }

    public String getGotourl() {
        return gotourl;
    }

    public void setGotourl(String gotourl) {
        this.gotourl = gotourl == null ? null : gotourl.trim();
    }

    public String getReleasename() {
        return releasename;
    }

    public void setReleasename(String releasename) {
        this.releasename = releasename == null ? null : releasename.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}