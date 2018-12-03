package com.hzfc.web.entity;

import java.math.BigDecimal;

public class ContractRevoke {
	private Long agg_nm;

	private Long devid;

	private BigDecimal gfrid;

	private String tfdate;

	private String fw_zl;

	private String gfr;

	private String gfr_cid;

	private String reg_date;

	private Long fh_nm;

	private String prjname;

	private Long devcode;

	private String devname;

	private Long presell_id;

	private Long presell_code;

	private Long zh_nm;

	private BigDecimal htid;

	public String getTfdate() {
		return tfdate;
	}

	public void setTfdate(String tfdate) {
		this.tfdate = tfdate == null ? null : tfdate.trim();
	}

	public String getFw_zl() {
		return fw_zl;
	}

	public void setFw_zl(String fw_zl) {
		this.fw_zl = fw_zl == null ? null : fw_zl.trim();
	}

	public String getGfr() {
		return gfr;
	}

	public void setGfr(String gfr) {
		this.gfr = gfr == null ? null : gfr.trim();
	}

	public String getGfr_cid() {
		return gfr_cid;
	}

	public void setGfr_cid(String gfr_cid) {
		this.gfr_cid = gfr_cid == null ? null : gfr_cid.trim();
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date == null ? null : reg_date.trim();
	}

	public Long getFh_nm() {
		return fh_nm;
	}

	public void setFh_nm(Long fh_nm) {
		this.fh_nm = fh_nm;
	}

	public String getPrjname() {
		return prjname;
	}

	public void setPrjname(String prjname) {
		this.prjname = prjname == null ? null : prjname.trim();
	}

	public Long getDevcode() {
		return devcode;
	}

	public void setDevcode(Long devcode) {
		this.devcode = devcode;
	}

	public String getDevname() {
		return devname;
	}

	public void setDevname(String devname) {
		this.devname = devname == null ? null : devname.trim();
	}

	public Long getPresell_id() {
		return presell_id;
	}

	public void setPresell_id(Long presell_id) {
		this.presell_id = presell_id;
	}

	public Long getPresell_code() {
		return presell_code;
	}

	public void setPresell_code(Long presell_code) {
		this.presell_code = presell_code;
	}

	public Long getZh_nm() {
		return zh_nm;
	}

	public void setZh_nm(Long zh_nm) {
		this.zh_nm = zh_nm;
	}

	public BigDecimal getHtid() {
		return htid;
	}

	public void setHtid(BigDecimal htid) {
		this.htid = htid;
	}

	public Long getAgg_nm() {
		return agg_nm;
	}

	public void setAgg_nm(Long agg_nm) {
		this.agg_nm = agg_nm;
	}

	public Long getDevid() {
		return devid;
	}

	public void setDevid(Long devid) {
		this.devid = devid;
	}

	public BigDecimal getGfrid() {
		return gfrid;
	}

	public void setGfrid(BigDecimal gfrid) {
		this.gfrid = gfrid;
	}
}