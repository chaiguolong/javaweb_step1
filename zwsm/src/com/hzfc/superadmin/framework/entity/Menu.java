package com.hzfc.superadmin.framework.entity;

public class Menu {
    private Long menuid;

    private Long pid;
    
    private String menuids;

    private String menuname;

    private Long sortnumber;
    
	private int levelid;
	
	private String typenamelevel;
	
	private Long resourceid;
	
	private String type;
    
    private String definestring;
    
    private String remark;
    
    private Long isuse;
    
    public void setLevelid(int levelid) {
		this.levelid = levelid;
		for(int i = 0; i < levelid ; i++){
			if(i==0){ this.typenamelevel = "　　";}
			else this.typenamelevel += "　　";//全角空格
		}
	}
    
	public int getLevelid() {
		return levelid;
	}

	public String getTypenamelevel() {
		return typenamelevel;
	}

	public void setTypenamelevel(String typenamelevel) {
		this.typenamelevel = typenamelevel;
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

	public String getDefinestring() {
		return definestring;
	}

	public void setDefinestring(String definestring) {
		this.definestring = definestring;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public Long getResourceid() {
		return resourceid;
	}

	public void setResourceid(Long resourceid) {
		this.resourceid = resourceid;
	}

	public String getMenuids() {
		return menuids;
	}

	public void setMenuids(String menuids) {
		this.menuids = menuids;
	}
	
}