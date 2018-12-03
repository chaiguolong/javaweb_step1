package com.hzfc.superadmin.assist.entity;

public class TempCommunity {
    private Long id;

    private String xqmc;

    private String xqdz;

    private Integer zzjcnf;

    private Integer zwjcnf;

    private Long bkid;

    private Integer xzqh;

    private String giszb;

    private String cjsj;

    private String bz;

    private Integer shbz;
    
    private Short ischeck;
    
    private Long communityid;
    
    private String communityname;
    
    private Long addid;
    
    private String loginuser;
    
    private String signdate;
    
    private String zhs;
    
    public Long getCommunityid() {
		return communityid;
	}

	public void setCommunityid(Long communityid) {
		this.communityid = communityid;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getXqmc() {
        return xqmc;
    }

    public void setXqmc(String xqmc) {
        this.xqmc = xqmc == null ? null : xqmc.trim();
    }

    public String getXqdz() {
        return xqdz;
    }

    public void setXqdz(String xqdz) {
        this.xqdz = xqdz == null ? null : xqdz.trim();
    }

    public Integer getZzjcnf() {
        return zzjcnf;
    }

    public void setZzjcnf(Integer zzjcnf) {
        this.zzjcnf = zzjcnf;
    }

    public Integer getZwjcnf() {
        return zwjcnf;
    }

    public void setZwjcnf(Integer zwjcnf) {
        this.zwjcnf = zwjcnf;
    }

    public Long getBkid() {
        return bkid;
    }

    public void setBkid(Long bkid) {
        this.bkid = bkid;
    }

    public Integer getXzqh() {
        return xzqh;
    }

    public void setXzqh(Integer xzqh) {
        this.xzqh = xzqh;
    }

    public String getGiszb() {
        return giszb;
    }

    public void setGiszb(String giszb) {
        this.giszb = giszb == null ? null : giszb.trim();
    }

    public String getCjsj() {
        return cjsj;
    }

    public void setCjsj(String cjsj) {
        this.cjsj = cjsj == null ? null : cjsj.trim();
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz == null ? null : bz.trim();
    }

    public Integer getShbz() {
        return shbz;
    }

    public void setShbz(Integer shbz) {
        this.shbz = shbz;
    }

	public Short getIscheck() {
		return ischeck;
	}

	public void setIscheck(Short ischeck) {
		this.ischeck = ischeck;
	}

	public String getCommunityname() {
		return communityname;
	}

	public void setCommunityname(String communityname) {
		this.communityname = communityname;
	}

	public Long getAddid() {
		return addid;
	}

	public void setAddid(Long addid) {
		this.addid = addid;
	}

	public String getLoginuser() {
		return loginuser;
	}

	public void setLoginuser(String loginuser) {
		this.loginuser = loginuser;
	}

	public String getsigndate() {
		return signdate;
	}

	public void setsigndate(String signDate) {
		signdate = signDate;
	}

	public String getZhs() {
		return zhs;
	}

	public void setZhs(String zhs) {
		this.zhs = zhs;
	}
    
}