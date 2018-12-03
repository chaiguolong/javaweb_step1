package com.hzfc.superadmin.ad.dao;

import java.util.List;

import com.hzfc.common.dao.SuperDao;
import com.hzfc.superadmin.ad.entity.WebAdType;
import com.hzfc.superadmin.ad.entity.WebStatictask;
import com.hzfc.utils.QueryCondition;

public interface WebAdMangerDao extends SuperDao{
    int deleteByPrimaryKey(Long adtypeid);

    void insert(WebAdType record);

    void insertSelective(WebAdType record);

    WebAdType selectByPrimaryKey(Long adtypeid);

    int updateByPrimaryKeySelective(WebAdType record);

    int updateByPrimaryKey(WebAdType record);
    
    boolean checkAdTypeUsedForWebAdInfo(Long typeid);

	List<Object> selectMyAllByMapParam(String statementid,
			QueryCondition queryCondition);

	void updateModel(WebStatictask webStatictask);
}