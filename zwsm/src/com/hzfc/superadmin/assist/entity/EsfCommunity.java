package com.hzfc.superadmin.assist.entity;

import java.math.BigDecimal;

public class EsfCommunity {
    private Long communityid;

    private Long areaid;

    private String communityname;

    private String communityaddr;

    private String showmap;

    private Long managetypeid;

    private String developer;

    private String propertycom;

    private BigDecimal propertyprice;

    private String doneyear;

    private Integer familyamont;

    private Integer parkingamont;

    private BigDecimal greenamont;

    private BigDecimal plotratio;

    private String buildingamont;

    private String areaamont;

    private Long fitmentid;

    private String floorinfo;

    private String traffic;

    private String metro;

    private String supermarket;

    private String assort;

    private String hospital;

    private String repast;

    private String nurseryschool;

    private String middleschools;

    private String university;

    private String recreation;

    private String featureinfo;

    private String otherinfo;

    private String modtime;

    private Short ischeck;
    
    private String ischeckvalue;

    private Integer visitcount;

    private Long internalid;

    private Long relatedid;

    private Long addid;
    
    private String loginuser;

	private String addtime;

    private String intro;

    private String areaname;
    
    private String managetypeidname;
    
    private String pathone;
    
    private String pathtwo;
    
    private String tempone;
    
    private String temptwo;
    
    private int imgcount;
    
    private String pathonetext;
    
    private String pathtwotext;
    
    private Long oldid;
    
    private String oldname;
    
    private String realnames;
    
    private String realname;
    
    private Long brokerageid;
    
    private String prjx;

    private String prjy;
    
    private String prjid;
    
    private String zhs;
    
    public String getPrjid() {
		return prjid;
	}

	public void setPrjid(String prjid) {
		this.prjid = prjid;
	}

	public String getPrjx() {
		return prjx;
	}

	public void setPrjx(String prjx) {
		this.prjx = prjx;
	}

	public String getPrjy() {
		return prjy;
	}

	public void setPrjy(String prjy) {
		this.prjy = prjy;
	}

	public String getOldname() {
		return oldname;
	}

	public void setOldname(String oldname) {
		this.oldname = oldname;
	}

	public Long getOldid() {
		return oldid;
	}

	public void setOldid(Long oldid) {
		this.oldid = oldid;
	}

	public String getPathonetext() {
		return pathonetext;
	}

	public void setPathonetext(String pathonetext) {
		this.pathonetext = pathonetext;
	}

	public String getPathtwotext() {
		return pathtwotext;
	}

	public void setPathtwotext(String pathtwotext) {
		this.pathtwotext = pathtwotext;
	}

	public int getImgcount() {
		return imgcount;
	}

	public void setImgcount(int imgcount) {
		this.imgcount = imgcount;
	}

	public String getLoginuser() {
		return loginuser;
	}

	public void setLoginuser(String loginuser) {
		this.loginuser = loginuser;
	}
    
    public Long getCommunityid() {
        return communityid;
    }

    public void setCommunityid(Long communityid) {
        this.communityid = communityid;
    }

    public Long getAreaid() {
        return areaid;
    }

    public void setAreaid(Long areaid) {
        this.areaid = areaid;
    }

    public String getCommunityname() {
        return communityname;
    }

    public void setCommunityname(String communityname) {
        this.communityname = communityname == null ? null : communityname.trim();
    }

    public String getCommunityaddr() {
        return communityaddr;
    }

    public void setCommunityaddr(String communityaddr) {
        this.communityaddr = communityaddr == null ? null : communityaddr.trim();
    }

    public String getShowmap() {
        return showmap;
    }

    public void setShowmap(String showmap) {
        this.showmap = showmap == null ? null : showmap.trim();
    }

    public Long getManagetypeid() {
        return managetypeid;
    }

    public void setManagetypeid(Long managetypeid) {
        this.managetypeid = managetypeid;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer == null ? null : developer.trim();
    }

    public String getPropertycom() {
        return propertycom;
    }

    public void setPropertycom(String propertycom) {
        this.propertycom = propertycom == null ? null : propertycom.trim();
    }

    public BigDecimal getPropertyprice() {
        return propertyprice;
    }

    public void setPropertyprice(BigDecimal propertyprice) {
        this.propertyprice = propertyprice;
    }

    public String getDoneyear() {
        return doneyear;
    }

    public void setDoneyear(String doneyear) {
        this.doneyear = doneyear == null ? null : doneyear.trim();
    }

    public Integer getFamilyamont() {
        return familyamont;
    }

    public void setFamilyamont(Integer familyamont) {
        this.familyamont = familyamont;
    }

    public Integer getParkingamont() {
        return parkingamont;
    }

    public void setParkingamont(Integer parkingamont) {
        this.parkingamont = parkingamont;
    }

    public BigDecimal getGreenamont() {
        return greenamont;
    }

    public void setGreenamont(BigDecimal greenamont) {
        this.greenamont = greenamont;
    }

    public BigDecimal getPlotratio() {
        return plotratio;
    }

    public void setPlotratio(BigDecimal plotratio) {
        this.plotratio = plotratio;
    }

    public String getBuildingamont() {
        return buildingamont;
    }

    public void setBuildingamont(String buildingamont) {
        this.buildingamont = buildingamont == null ? null : buildingamont.trim();
    }

    public String getAreaamont() {
        return areaamont;
    }

    public void setAreaamont(String areaamont) {
        this.areaamont = areaamont == null ? null : areaamont.trim();
    }

    public Long getFitmentid() {
        return fitmentid;
    }

    public void setFitmentid(Long fitmentid) {
        this.fitmentid = fitmentid;
    }

    public String getFloorinfo() {
        return floorinfo;
    }

    public void setFloorinfo(String floorinfo) {
        this.floorinfo = floorinfo == null ? null : floorinfo.trim();
    }

    public String getTraffic() {
        return traffic;
    }

    public void setTraffic(String traffic) {
        this.traffic = traffic == null ? null : traffic.trim();
    }

    public String getMetro() {
        return metro;
    }

    public void setMetro(String metro) {
        this.metro = metro == null ? null : metro.trim();
    }

    public String getSupermarket() {
        return supermarket;
    }

    public void setSupermarket(String supermarket) {
        this.supermarket = supermarket == null ? null : supermarket.trim();
    }

    public String getAssort() {
        return assort;
    }

    public void setAssort(String assort) {
        this.assort = assort == null ? null : assort.trim();
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital == null ? null : hospital.trim();
    }

    public String getRepast() {
        return repast;
    }

    public void setRepast(String repast) {
        this.repast = repast == null ? null : repast.trim();
    }

    public String getNurseryschool() {
        return nurseryschool;
    }

    public void setNurseryschool(String nurseryschool) {
        this.nurseryschool = nurseryschool == null ? null : nurseryschool.trim();
    }

    public String getMiddleschools() {
        return middleschools;
    }

    public void setMiddleschools(String middleschools) {
        this.middleschools = middleschools == null ? null : middleschools.trim();
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university == null ? null : university.trim();
    }

    public String getRecreation() {
        return recreation;
    }

    public void setRecreation(String recreation) {
        this.recreation = recreation == null ? null : recreation.trim();
    }

    public String getFeatureinfo() {
        return featureinfo;
    }

    public void setFeatureinfo(String featureinfo) {
        this.featureinfo = featureinfo == null ? null : featureinfo.trim();
    }

    public String getOtherinfo() {
        return otherinfo;
    }

    public void setOtherinfo(String otherinfo) {
        this.otherinfo = otherinfo == null ? null : otherinfo.trim();
    }

    public String getModtime() {
        return modtime;
    }

    public void setModtime(String modtime) {
        this.modtime = modtime == null ? null : modtime.trim();
    }

    public Short getIscheck() {
        return ischeck;
    }

    public void setIscheck(Short ischeck) {
        this.ischeck = ischeck;
        if(ischeck == 0){
        	this.ischeckvalue = "<font color=red>未审核</font>";
        }
        if(ischeck == 1){
        	this.ischeckvalue = "<font color=green>审核通过</font>";
        }
        if(ischeck == 2){
        	this.ischeckvalue = "<font color=blue>审核退回</font>";
        }
    }

    public Integer getVisitcount() {
        return visitcount;
    }

    public void setVisitcount(Integer visitcount) {
        this.visitcount = visitcount;
    }

    public Long getInternalid() {
        return internalid;
    }

    public void setInternalid(Long internalid) {
        this.internalid = internalid;
    }

    public Long getRelatedid() {
        return relatedid;
    }

    public void setRelatedid(Long relatedid) {
        this.relatedid = relatedid;
    }

    public Long getAddid() {
        return addid;
    }

    public void setAddid(Long addid) {
        this.addid = addid;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

	public String getAreaname() {
		return areaname;
	}

	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}

	public String getManagetypeidname() {
		return managetypeidname;
	}

	public void setManagetypeidname(String managetypeidname) {
		this.managetypeidname = managetypeidname;
	}

	public String getPathone() {
		return pathone;
	}

	public void setPathone(String pathone) {
		this.pathone = pathone;
	}

	public String getPathtwo() {
		return pathtwo;
	}

	public void setPathtwo(String pathtwo) {
		this.pathtwo = pathtwo;
	}

	public String getTempone() {
		return tempone;
	}

	public void setTempone(String tempone) {
		this.tempone = tempone;
	}

	public String getTemptwo() {
		return temptwo;
	}

	public void setTemptwo(String temptwo) {
		this.temptwo = temptwo;
	}

	public String getRealnames() {
		return realnames;
	}

	public void setRealnames(String realnames) {
		this.realnames = realnames;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getIscheckvalue() {
		return ischeckvalue;
	}

	public void setIscheckvalue(String ischeckvalue) {
		this.ischeckvalue = ischeckvalue;
	}

	public Long getBrokerageid() {
		return brokerageid;
	}

	public void setBrokerageid(Long brokerageid) {
		this.brokerageid = brokerageid;
	}

	public String getZhs() {
		return zhs;
	}

	public void setZhs(String zhs) {
		this.zhs = zhs;
	}

}