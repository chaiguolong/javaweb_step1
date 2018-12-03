package com.hzfc.superadmin.ad.dao.impl;


import java.util.List;

import com.hzfc.common.dao.impl.SuperDaoImpl;
import com.hzfc.superadmin.ad.dao.WebAdMangerDao;
import com.hzfc.superadmin.ad.entity.WebAdInfo;
import com.hzfc.superadmin.ad.entity.WebAdType;
import com.hzfc.superadmin.ad.entity.WebStatictask;
import com.hzfc.utils.QueryCondition;


public class WebAdMangerDaoImpl extends SuperDaoImpl implements WebAdMangerDao {

    public WebAdMangerDaoImpl() {
        super();
    }

    public int deleteByPrimaryKey(Long adtypeid) {
    	WebAdType key = new WebAdType();
        key.setAdtypeid(adtypeid);
        int rows = getSqlMapClientTemplate().delete("WEB_ADTYPE_deleteByPrimaryKey", key);
        return rows;
    }

    public void insert(WebAdType record) {
        getSqlMapClientTemplate().insert("WEB_ADTYPE_insert", record);
    }

    public void insertSelective(WebAdType record) {
        getSqlMapClientTemplate().insert("WEB_ADTYPE_insertSelective", record);
    }

    public WebAdType selectByPrimaryKey(Long adtypeid) {
    	WebAdType key = new WebAdType();
        key.setAdtypeid(adtypeid);
        WebAdType record = (WebAdType) getSqlMapClientTemplate().queryForObject("WEB_ADTYPE_selectByPrimaryKey", key);
        return record;
    }

    public int updateByPrimaryKeySelective(WebAdType record) {
        int rows = getSqlMapClientTemplate().update("WEB_ADTYPE_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(WebAdType record) {
        int rows = getSqlMapClientTemplate().update("WEB_ADTYPE_updateByPrimaryKey", record);
        return rows;
    }

	public boolean checkAdTypeUsedForWebAdInfo(Long typeid) {
		List<WebAdInfo> list = this.getSqlMapClientTemplate().queryForList("checkAdTypeUsedForWebAdInfo", typeid);
		if(list.isEmpty()){
			return false;
		}
		else {
			return true;
		}
		
	}
	public List<Object> selectMyAllByMapParam(String statementid,
			QueryCondition queryCondition) {
		return getSqlMapClientTemplate().queryForList(statementid,queryCondition.getConditionMap());
	}

	public void updateModel(WebStatictask webStatictask) {
		getSqlMapClientTemplate().update("updateModel",webStatictask);
	}
}