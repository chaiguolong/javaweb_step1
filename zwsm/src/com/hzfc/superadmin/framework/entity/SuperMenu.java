package com.hzfc.superadmin.framework.entity;

public class SuperMenu {
	
	private Long menuid;

    private Long pid;

    private String menuname;

    private Long sortnumber;
    
    private Long resourceid;

    private String name;

    private String type;

    private String definestring;

    private Short isuse;

    private Short ismenu;
    
    private Long categoryid;
    
    private int levelid;

	public int getLevelid() {
		return levelid;
	}

	public void setLevelid(int levelid) {
		this.levelid = levelid;
	}

	public Long getMenuid() {
		return menuid;
	}

	public void setMenuid(Long menuid) {
		this.menuid = menuid;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getMenuname() {
		return menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}

	public Long getSortnumber() {
		return sortnumber;
	}

	public void setSortnumber(Long sortnumber) {
		this.sortnumber = sortnumber;
	}

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

	public Short getIsuse() {
		return isuse;
	}

	public void setIsuse(Short isuse) {
		this.isuse = isuse;
	}

	public Short getIsmenu() {
		return ismenu;
	}

	public void setIsmenu(Short ismenu) {
		this.ismenu = ismenu;
	}

	public Long getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Long categoryid) {
		this.categoryid = categoryid;
	}
	
}
