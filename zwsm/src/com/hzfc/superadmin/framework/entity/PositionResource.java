package com.hzfc.superadmin.framework.entity;

public class PositionResource {
    private Long positionresourceid;

    private Long positionid;

    private Long resourceid;
    
    private Long menuid;

    public Long getPositionresourceid() {
        return positionresourceid;
    }

    public void setPositionresourceid(Long positionresourceid) {
        this.positionresourceid = positionresourceid;
    }

    public Long getPositionid() {
        return positionid;
    }

    public void setPositionid(Long positionid) {
        this.positionid = positionid;
    }

    public Long getResourceid() {
        return resourceid;
    }

    public void setResourceid(Long resourceid) {
        this.resourceid = resourceid;
    }

	public Long getMenuid() {
		return menuid;
	}

	public void setMenuid(Long menuid) {
		this.menuid = menuid;
	}

}