package com.hzfc.superadmin.assist.entity;

public class Mobilevisit {
    private String typename;

    private Long visitcount;

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }

    public Long getVisitcount() {
        return visitcount;
    }

    public void setVisitcount(Long visitcount) {
        this.visitcount = visitcount;
    }
}