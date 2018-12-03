package com.hzfc.superadmin.assist.entity;

public class EsfArea {
    private Long areaid;

    private Long pareaid;

    private String areaname;

    private String areapy;

    private Short orderid;

    private Short isapply;

    private Short isdisplay;

    private String modtime;

    private String arearmk;
    
    private int levelid;
    
    private String areanamelevel;
    
    private String pname;    

    public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getLevelid() {
		return levelid;
	}

	public void setLevelid(int levelid) {
		this.levelid = levelid;
		for(int i = 0; i < levelid ; i++){
			if(i==0) this.areanamelevel = "";
			else this.areanamelevel += "　　";//全角空格
		}
	}

	public Long getAreaid() {
        return areaid;
    }

    public void setAreaid(Long areaid) {
        this.areaid = areaid;
    }

    public Long getPareaid() {
        return pareaid;
    }

    public void setPareaid(Long pareaid) {
        this.pareaid = pareaid;
    }

    public String getAreaname() {
        return areaname;
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname == null ? null : areaname.trim();
    }

    public String getAreapy() {
        return areapy;
    }

    public void setAreapy(String areapy) {
        this.areapy = areapy == null ? null : areapy.trim();
    }

    public Short getOrderid() {
        return orderid;
    }

    public void setOrderid(Short orderid) {
        this.orderid = orderid;
    }

    public Short getIsapply() {
        return isapply;
    }

    public void setIsapply(Short isapply) {
        this.isapply = isapply;
    }

    public Short getIsdisplay() {
        return isdisplay;
    }

    public void setIsdisplay(Short isdisplay) {
        this.isdisplay = isdisplay;
    }

    public String getModtime() {
        return modtime;
    }

    public void setModtime(String modtime) {
        this.modtime = modtime == null ? null : modtime.trim();
    }

    public String getArearmk() {
        return arearmk;
    }

    public void setArearmk(String arearmk) {
        this.arearmk = arearmk == null ? null : arearmk.trim();
    }

	public String getAreanamelevel() {
		return areanamelevel;
	}

	public void setAreanamelevel(String areanamelevel) {
		this.areanamelevel = areanamelevel;
	}
    
}