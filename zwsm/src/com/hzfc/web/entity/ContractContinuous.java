package com.hzfc.web.entity;

import java.math.BigDecimal;

public class ContractContinuous {
	private Long fh_nm;

	private String devname;

	private BigDecimal presell_id;

	private String fw_zl;

	private String ld;

	private BigDecimal lxydcs;

	private BigDecimal ysxmid;

	public Long getFh_nm() {
		return fh_nm;
	}

	public void setFh_nm(Long fh_nm) {
		this.fh_nm = fh_nm;
	}

	public String getDevname() {
		return devname;
	}

	public void setDevname(String devname) {
		this.devname = devname == null ? null : devname.trim();
	}

	public BigDecimal getPresell_id() {
		return presell_id;
	}

	public void setPresell_id(BigDecimal presell_id) {
		this.presell_id = presell_id;
	}

	public String getFw_zl() {
		return fw_zl;
	}

	public void setFw_zl(String fw_zl) {
		this.fw_zl = fw_zl == null ? null : fw_zl.trim();
	}

	public String getLd() {
		return ld;
	}

	public void setLd(String ld) {
		this.ld = ld == null ? null : ld.trim();
	}

	public BigDecimal getLxydcs() {
		return lxydcs;
	}

	public void setLxydcs(BigDecimal lxydcs) {
		this.lxydcs = lxydcs;
	}

	public BigDecimal getYsxmid() {
		return ysxmid;
	}

	public void setYsxmid(BigDecimal ysxmid) {
		this.ysxmid = ysxmid;
	}
}