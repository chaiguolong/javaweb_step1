package com.hzfc.superadmin.newscontent.entity;

public class PropertyContent {
    private Long propertycontentid;

    private Long contentid;

    private Short relatedtype;

    private Long relatedid;
    
    private Long propertyid;
    
    private String propertyname;
    
    private String title;
    
    public Long getPropertyid() {
		return propertyid;
	}

	public void setPropertyid(Long propertyid) {
		this.propertyid = propertyid;
	}

	public String getPropertyname() {
		return propertyname;
	}

	public void setPropertyname(String propertyname) {
		this.propertyname = propertyname;
	}

    public Long getPropertycontentid() {
        return propertycontentid;
    }

    public void setPropertycontentid(Long propertycontentid) {
        this.propertycontentid = propertycontentid;
    }

    public Long getContentid() {
        return contentid;
    }

    public void setContentid(Long contentid) {
        this.contentid = contentid;
    }

    public Short getRelatedtype() {
        return relatedtype;
    }

    public void setRelatedtype(Short relatedtype) {
        this.relatedtype = relatedtype;
    }

    public Long getRelatedid() {
        return relatedid;
    }

    public void setRelatedid(Long relatedid) {
        this.relatedid = relatedid;
    }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}