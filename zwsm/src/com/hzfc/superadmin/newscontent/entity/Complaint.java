package com.hzfc.superadmin.newscontent.entity;

public class Complaint {
    private Long complaintid;

    private String complaintname;

    private String telno;

    private String addtime;

    private String developername;

    private String propertyname;

    private String infotitle;

    private String infocontent;

    private Short isdisplay;

    private Short state;

    private String replytime;

    private String replycontent;

    private String replyname;
    
    private String Tstime;

    public String getTstime() {
		return Tstime;
	}

	public void setTstime(String tstime) {
		Tstime = tstime;
	}

	public Long getComplaintid() {
        return complaintid;
    }

    public void setComplaintid(Long complaintid) {
        this.complaintid = complaintid;
    }

    public String getComplaintname() {
        return complaintname;
    }

    public void setComplaintname(String complaintname) {
        this.complaintname = complaintname == null ? null : complaintname.trim();
    }

    public String getTelno() {
        return telno;
    }

    public void setTelno(String telno) {
        this.telno = telno == null ? null : telno.trim();
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }

    public String getDevelopername() {
        return developername;
    }

    public void setDevelopername(String developername) {
        this.developername = developername == null ? null : developername.trim();
    }

    public String getPropertyname() {
        return propertyname;
    }

    public void setPropertyname(String propertyname) {
        this.propertyname = propertyname == null ? null : propertyname.trim();
    }

    public String getInfotitle() {
        return infotitle;
    }

    public void setInfotitle(String infotitle) {
        this.infotitle = infotitle == null ? null : infotitle.trim();
    }

    public String getInfocontent() {
        return infocontent;
    }

    public void setInfocontent(String infocontent) {
        this.infocontent = infocontent == null ? null : infocontent.trim();
    }

    public Short getIsdisplay() {
        return isdisplay;
    }

    public void setIsdisplay(Short isdisplay) {
        this.isdisplay = isdisplay;
    }

    public Short getState() {
        return state;
    }

    public void setState(Short state) {
        this.state = state;
    }

    public String getReplytime() {
        return replytime;
    }

    public void setReplytime(String replytime) {
        this.replytime = replytime == null ? null : replytime.trim();
    }

    public String getReplycontent() {
        return replycontent;
    }

    public void setReplycontent(String replycontent) {
        this.replycontent = replycontent == null ? null : replycontent.trim();
    }

    public String getReplyname() {
        return replyname;
    }

    public void setReplyname(String replyname) {
        this.replyname = replyname == null ? null : replyname.trim();
    }
}