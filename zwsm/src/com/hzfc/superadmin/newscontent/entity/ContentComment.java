package com.hzfc.superadmin.newscontent.entity;

public class ContentComment {
    private Long contentcommentid;

    private Long contentid;
    
    private String title;

    private String commenttitle;

    private String commentremark;

    private String commenttime;

    private Long agreecount;

    private Long negativecount;

    public Long getContentcommentid() {
        return contentcommentid;
    }

    public void setContentcommentid(Long contentcommentid) {
        this.contentcommentid = contentcommentid;
    }

    public Long getContentid() {
        return contentid;
    }

    public void setContentid(Long contentid) {
        this.contentid = contentid;
    }

    public String getCommenttitle() {
        return commenttitle;
    }

    public void setCommenttitle(String commenttitle) {
        this.commenttitle = commenttitle == null ? null : commenttitle.trim();
    }

    public String getCommentremark() {
        return commentremark;
    }

    public void setCommentremark(String commentremark) {
        this.commentremark = commentremark == null ? null : commentremark.trim();
    }

    public String getCommenttime() {
        return commenttime;
    }

    public void setCommenttime(String commenttime) {
        this.commenttime = commenttime == null ? null : commenttime.trim();
    }

    public Long getAgreecount() {
        return agreecount;
    }

    public void setAgreecount(Long agreecount) {
        this.agreecount = agreecount;
    }

    public Long getNegativecount() {
        return negativecount;
    }

    public void setNegativecount(Long negativecount) {
        this.negativecount = negativecount;
    }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
    
}