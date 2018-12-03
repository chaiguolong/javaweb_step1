package com.hzfc.superadmin.newscontent.entity;


public class StaticPropertyTag implements java.io.Serializable {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long tagid;

    private String tagname;
    
    private Integer PASSTIME;


	public Long getTagid() {
		return tagid;
	}

	public void setTagid(Long tagid) {
		this.tagid = tagid;
	}

	public String getTagname() {
		return tagname;
	}

	public void setTagname(String tagname) {
		this.tagname = tagname;
	}

	public Integer getPASSTIME() {
		return PASSTIME;
	}

	public void setPASSTIME(Integer pASSTIME) {
		PASSTIME = pASSTIME;
	}

	
}