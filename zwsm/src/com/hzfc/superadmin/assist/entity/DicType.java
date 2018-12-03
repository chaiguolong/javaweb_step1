package com.hzfc.superadmin.assist.entity;

public class DicType {
    private Long codeid;

    private String codetype;

    private String codename;

    private Short orderid;

    private String modtime;

    private String codermk;

    public Long getCodeid() {
        return codeid;
    }

    public void setCodeid(Long codeid) {
        this.codeid = codeid;
    }

    public String getCodetype() {
        return codetype;
    }

    public void setCodetype(String codetype) {
        this.codetype = codetype == null ? null : codetype.trim();
    }

    public String getCodename() {
        return codename;
    }

    public void setCodename(String codename) {
        this.codename = codename == null ? null : codename.trim();
    }

    public Short getOrderid() {
        return orderid;
    }

    public void setOrderid(Short orderid) {
        this.orderid = orderid;
    }

    public String getModtime() {
        return modtime;
    }

    public void setModtime(String modtime) {
        this.modtime = modtime == null ? null : modtime.trim();
    }

    public String getCodermk() {
        return codermk;
    }

    public void setCodermk(String codermk) {
        this.codermk = codermk == null ? null : codermk.trim();
    }
}