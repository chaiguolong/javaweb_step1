package com.hzfc.superadmin.ad.entity;

public class WebAdType {
    private Long adtypeid;

    private Long webseatid;

    private String seatinfo;

    private Integer orderid;

    private String typermk;

    private String updatetime;
    
    private String adtypeinpage;
    
    private String sitename;

    public Long getAdtypeid() {
        return adtypeid;
    }

    public void setAdtypeid(Long adtypeid) {
        this.adtypeid = adtypeid;
    }

    public Long getWebseatid() {
        return webseatid;
    }

    public void setWebseatid(Long webseatid) {
        this.webseatid = webseatid;
    }

    public String getSeatinfo() {
        return seatinfo;
    }

    public void setSeatinfo(String seatinfo) {
        this.seatinfo = seatinfo == null ? null : seatinfo.trim();
        int i = seatinfo.indexOf("_");
        if(i>0){
        	 this.adtypeinpage = seatinfo.substring(0, i);
        }
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public String getTypermk() {
        return typermk;
    }

    public void setTypermk(String typermk) {
        this.typermk = typermk == null ? null : typermk.trim();
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime == null ? null : updatetime.trim();
    }

	public String getAdtypeinpage() {
		return adtypeinpage;
	}

	public void setAdtypeinpage(String adtypeinpage) {
		this.adtypeinpage = adtypeinpage;
	}

	public String getSitename() {
		return sitename;
	}

	public void setSitename(String sitename) {
		this.sitename = sitename;
	}

	
}