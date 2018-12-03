package com.hzfc.superadmin.assist.entity;

public class DicItems {
    private Long itemid;

    private Long codeid;

    private String codetype;

    private String itemname;

    private String itemvalue;

    private Short orderid;

    private Short isapply;

    private Short isdisplay;

    private Short isdelete;

    private String modtime;

    private String itemrmk;

    public Long getItemid() {
        return itemid;
    }

    public void setItemid(Long itemid) {
        this.itemid = itemid;
    }

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

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname == null ? null : itemname.trim();
    }

    public String getItemvalue() {
        return itemvalue;
    }

    public void setItemvalue(String itemvalue) {
        this.itemvalue = itemvalue == null ? null : itemvalue.trim();
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

    public Short getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Short isdelete) {
        this.isdelete = isdelete;
    }

    public String getModtime() {
        return modtime;
    }

    public void setModtime(String modtime) {
        this.modtime = modtime == null ? null : modtime.trim();
    }

    public String getItemrmk() {
        return itemrmk;
    }

    public void setItemrmk(String itemrmk) {
        this.itemrmk = itemrmk == null ? null : itemrmk.trim();
    }
}