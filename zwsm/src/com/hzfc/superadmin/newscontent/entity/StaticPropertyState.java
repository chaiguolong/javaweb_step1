package com.hzfc.superadmin.newscontent.entity;

public class StaticPropertyState implements java.io.Serializable {
	
	private static final long serialVersionUID = 5547360507450536551L;

	private Integer propertystateid;

    private String propertystatename;

    public Integer getPropertystateid() {
        return propertystateid;
    }

    public void setPropertystateid(Integer propertystateid) {
        this.propertystateid = propertystateid;
    }

    public String getPropertystatename() {
        return propertystatename;
    }

    public void setPropertystatename(String propertystatename) {
        this.propertystatename = propertystatename == null ? null : propertystatename.trim();
    }
}