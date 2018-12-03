package com.hzfc.superadmin.assist.entity;

public class Tzskzjgcinfo {
    private Integer infonm;

    private Integer cqname;

    private String locate;

    private String xqname;

    private String lpmc;

    private String ghxkz;

    private String sgxkz;

    private String tdsyz;

    private Short tdsyqgettype;

    private String tdsyb;

    private String tdsye;

    private String imported;

    private String dmlocate;
    
    private String zh;

    private Integer zhnm;

    private Integer xqid;
    
    private String signdate;
    

    public Integer getzhnm() {
		return zhnm;
	}

	public void setzhnm(Integer zhNm) {
		zhnm = zhNm;
	}

	public Integer getinfonm() {
        return infonm;
    }

    public void setinfonm(Integer infonm) {
        this.infonm = infonm;
    }

    public Integer getcqname() {
        return cqname;
    }

    public void setcqname(Integer cqname) {
        this.cqname = cqname;
    }

    public String getLocate() {
        return locate;
    }

    public void setLocate(String locate) {
        this.locate = locate == null ? null : locate.trim();
    }

    public String getxqname() {
        return xqname;
    }

    public void setxqname(String xqname) {
        this.xqname = xqname == null ? null : xqname.trim();
    }

    public String getLpmc() {
        return lpmc;
    }

    public void setLpmc(String lpmc) {
        this.lpmc = lpmc == null ? null : lpmc.trim();
    }

    public String getGhxkz() {
        return ghxkz;
    }

    public void setGhxkz(String ghxkz) {
        this.ghxkz = ghxkz == null ? null : ghxkz.trim();
    }

    public String getSgxkz() {
        return sgxkz;
    }

    public void setSgxkz(String sgxkz) {
        this.sgxkz = sgxkz == null ? null : sgxkz.trim();
    }

    public String getTdsyz() {
        return tdsyz;
    }

    public void setTdsyz(String tdsyz) {
        this.tdsyz = tdsyz == null ? null : tdsyz.trim();
    }

    public Short gettdsyqgettype() {
        return tdsyqgettype;
    }

    public void settdsyqgettype(Short tdsyqgettype) {
        this.tdsyqgettype = tdsyqgettype;
    }

    public String gettdsyb() {
        return tdsyb;
    }

    public void settdsyb(String tdsyb) {
        this.tdsyb = tdsyb == null ? null : tdsyb.trim();
    }

    public String gettdsye() {
        return tdsye;
    }

    public void settdsye(String tdsye) {
        this.tdsye = tdsye == null ? null : tdsye.trim();
    }

    public String getImported() {
        return imported;
    }

    public void setImported(String imported) {
        this.imported = imported == null ? null : imported.trim();
    }

    public String getDmlocate() {
        return dmlocate;
    }

    public void setDmlocate(String dmlocate) {
        this.dmlocate = dmlocate == null ? null : dmlocate.trim();
    }

	public String getZh() {
		return zh;
	}

	public void setZh(String zh) {
		this.zh = zh;
	}

	public Integer getxqid() {
		return xqid;
	}

	public void setxqid(Integer xqId) {
		xqid = xqId;
	}

	public String getsigndate() {
		return signdate;
	}

	public void setsigndate(String signDate) {
		signdate = signDate;
	}
}