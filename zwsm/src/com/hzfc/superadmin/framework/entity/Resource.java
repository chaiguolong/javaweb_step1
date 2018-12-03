package com.hzfc.superadmin.framework.entity;

public class Resource {
    private Long resourceid;

    private String name;

    private String type;

    private String definestring;

    private String remark;

    private Long isuse;

    private Long ismenu;

    private Long menuid;

    private Long categoryid;

	public Long getResourceid() {
		return resourceid;
	}

	public void setResourceid(Long resourceid) {
		this.resourceid = resourceid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDefinestring() {
		return definestring;
	}

	public void setDefinestring(String definestring) {
		this.definestring = definestring;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getIsuse() {
		return isuse;
	}

	public void setIsuse(Long isuse) {
		this.isuse = isuse;
	}

	public Long getIsmenu() {
		return ismenu;
	}

	public void setIsmenu(Long ismenu) {
		this.ismenu = ismenu;
	}

	public Long getMenuid() {
		return menuid;
	}

	public void setMenuid(Long menuid) {
		this.menuid = menuid;
	}

	public Long getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Long categoryid) {
		this.categoryid = categoryid;
	}

  
}