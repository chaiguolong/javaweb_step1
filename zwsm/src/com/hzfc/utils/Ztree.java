package com.hzfc.utils;

public class Ztree {
    
    private String id;
    private String pid;
    private String name;
    private boolean open;
    private boolean isParent;
    private String rid;
    
    private int openValue;
    private int isParentValue;
    private String iconSkin;
    
    private String clickme; //点击行为
    private String newme; //新增行为
    private String updateme; //修改行为
    private String deleteme; //删除行为
    
    public String getClickme() {
        return clickme;
    }
    public void setClickme(String clickme) {
        this.clickme = clickme;
    }
    public String getNewme() {
        return newme;
    }
    public void setNewme(String newme) {
        this.newme = newme;
    }
    public String getUpdateme() {
        return updateme;
    }
    public void setUpdateme(String updateme) {
        this.updateme = updateme;
    }
    public String getDeleteme() {
        return deleteme;
    }
    public void setDeleteme(String deleteme) {
        this.deleteme = deleteme;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPid() {
        return pid;
    }
    public void setPid(String pid) {
        this.pid = pid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean isOpen() {
        return open;
    }
    public void setOpen(boolean open) {
        this.open = open;
    }
    public boolean isParent() {
        return isParent;
    }
    public void setParent(boolean isParent) {
        this.isParent = isParent;
    }
    public int getOpenValue() {
        return openValue;
    }
    public void setOpenValue(int openValue) {
        this.openValue = openValue;
        if(openValue == 1){
            this.open = true;
        }
        else {
            this.open = false;
        }
    }
    public int getIsParentValue() {
        return isParentValue;
    }
    
    public void setIsParentValue(int isParentValue) {
        this.isParentValue = isParentValue;
        if(isParentValue == 1){
            this.isParent = true;
        }
        else {
            this.isParent = false;
        }
        
        if(isParentValue == 1){
            this.iconSkin = "pIcon01";
        }
        else {
            this.iconSkin = "";
        }
    }
    public String getIconSkin() {
        return iconSkin;
    }
    public void setIconSkin(String iconSkin) {
        this.iconSkin = iconSkin;
    }
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}

}
