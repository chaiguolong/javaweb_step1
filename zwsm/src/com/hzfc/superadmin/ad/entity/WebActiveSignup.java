package com.hzfc.superadmin.ad.entity;

public class WebActiveSignup {
    private Long activeid;

    private String typename;

    private String signname;

    private String signemail;

    private String signtel;

    private String unitname;

    private String intent;

    private String ipfrom;

    private String signtime;

    private String rmk;
    
    private String checkcode;
    
    public String getCheckcode() {
		return checkcode;
	}

	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}

	public Long getActiveid() {
        return activeid;
    }

    public void setActiveid(Long activeid) {
        this.activeid = activeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }

    public String getSignname() {
        return signname;
    }

    public void setSignname(String signname) {
        this.signname = signname == null ? null : signname.trim();
    }

    public String getSignemail() {
        return signemail;
    }

    public void setSignemail(String signemail) {
        this.signemail = signemail == null ? null : signemail.trim();
    }

    public String getSigntel() {
        return signtel;
    }

    public void setSigntel(String signtel) {
        this.signtel = signtel == null ? null : signtel.trim();
    }

    public String getUnitname() {
        return unitname;
    }

    public void setUnitname(String unitname) {
        this.unitname = unitname == null ? null : unitname.trim();
    }

    public String getIntent() {
        return intent;
    }

    public void setIntent(String intent) {
        this.intent = intent == null ? null : intent.trim();
    }

    public String getIpfrom() {
        return ipfrom;
    }

    public void setIpfrom(String ipfrom) {
        this.ipfrom = ipfrom == null ? null : ipfrom.trim();
    }

    public String getSigntime() {
        return signtime;
    }

    public void setSigntime(String signtime) {
        this.signtime = signtime == null ? null : signtime.trim();
    }

    public String getRmk() {
        return rmk;
    }

    public void setRmk(String rmk) {
        this.rmk = rmk == null ? null : rmk.trim();
    }
}