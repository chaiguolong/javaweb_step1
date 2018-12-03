package com.hzfc.superadmin.newscontent.entity;

public class NewsCategory implements java.io.Serializable{
	
	private static final long serialVersionUID = -3483857203946518837L;

	private Long categoryid;

    private Long pid;

    private String name;

    private Short isdisplay;

    private Short issingle;

    private Short sortnumber;

    private String reamrk;

    private Long websiteid;
    
    private int levelno;
    
    private String sitename;
    
    private String typenamelevel;
    
    private String url;
    
    public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTypenamelevel() {
		return typenamelevel;
	}

	public void setTypenamelevel(String typenamelevel) {
		this.typenamelevel = typenamelevel;
	}

	public String getSitename() {
		return sitename;
	}

	public void setSitename(String sitename) {
		this.sitename = sitename;
	}

	public int getLevelno() {
		return levelno;
	}

	public void setLevelno(int levelno) {
		this.levelno = levelno;
		for(int i = 0; i < levelno ; i++){
			if(i==0) this.typenamelevel = "";
			else this.typenamelevel += "　　";//全角空格
		}
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

	public Short getSortnumber() {
		return sortnumber;
	}

	public void setSortnumber(Short sortnumber) {
		this.sortnumber = sortnumber;
	}

	public String getReamrk() {
		return reamrk;
	}

	public void setReamrk(String reamrk) {
		this.reamrk = reamrk;
	}

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

	public Long getWebsiteid() {
		return websiteid;
	}

	public void setWebsiteid(Long websiteid) {
		this.websiteid = websiteid;
	}

}