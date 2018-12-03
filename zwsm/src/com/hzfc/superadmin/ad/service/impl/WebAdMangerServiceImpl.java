package com.hzfc.superadmin.ad.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.hzfc.common.service.impl.SuperServiceImpl;
import com.hzfc.superadmin.ad.dao.WebAdMangerDao;
import com.hzfc.superadmin.ad.entity.WebAdInfo;
import com.hzfc.superadmin.ad.entity.WebStatictask;
import com.hzfc.superadmin.ad.service.WebAdMangerService;
import com.hzfc.superadmin.assist.entity.RessInfo;
import com.hzfc.utils.QueryCondition;
import com.hzfc.utils.TablesNameConstants;

public class WebAdMangerServiceImpl extends SuperServiceImpl implements WebAdMangerService{
	
	private WebAdMangerDao _webAdMangerDao;
	
	public boolean deleteType(Long typeid) {
		
		if(_webAdMangerDao.checkAdTypeUsedForWebAdInfo(typeid)){//判断分类是否被引用
			return false;
		}
		else {
		   _webAdMangerDao.deleteByPrimaryKey(TablesNameConstants.WEB_ADTYPE, typeid);
			return true;
		}
	}
	
	public boolean deleteAdInfo(Long typeid) {
		_webAdMangerDao.deleteByPrimaryKey(TablesNameConstants.WEB_ADINFO, typeid);
		return true;
	}
	
	public List<Object> selectMyAllByMapParam(String statementid,
			QueryCondition queryCondition) {
		return _webAdMangerDao.selectMyAllByMapParam(statementid, queryCondition);
	}
    //广告的图片上传
	public void saveAdInfo(String tablename, WebAdInfo webAdInfo) {
		//判断新增或者修改
		if(webAdInfo.getAdid() != null && StringUtils.isNotBlank(webAdInfo.getAdid().toString())){
			//修改的怎么操作
			if(StringUtils.isNotBlank(webAdInfo.getNewpath())){
				//是否更新过新的地址
				//保持旧的地址到一个图片资源回收站里,用于定期删除未引用的图片
				RessInfo ri = new RessInfo();
				ri.setRealpath(webAdInfo.getAdpath());
				ri.setIsdelete((short) 1);
				ri.setIscheckpass((short) 0);
				ri.setOrderid((short) 0);
				ri.setIsdisplay((short) 0);
				ri.setAddtime("sysdate");
				ri.setModtime("sysdate");
				_webAdMangerDao.insert("T_ESF_RESSINFO", ri);
				webAdInfo.setAdpath(webAdInfo.getNewpath());
			}
			//修改保持
			_webAdMangerDao.updateByPrimaryKeySelective(tablename, webAdInfo);				
		}
		else {
			//新增怎么操作
			webAdInfo.setAdpath(webAdInfo.getNewpath());
			_webAdMangerDao.insert(tablename, webAdInfo);
		}
	}
	public void updateModel(WebStatictask webStatictask) {
		_webAdMangerDao.updateModel(webStatictask);
	}
	
	public WebAdMangerDao getWebAdMangerDao() {
		return _webAdMangerDao;
	}

	public void setWebAdMangerDao(WebAdMangerDao webAdMangerDao) {
		_webAdMangerDao = webAdMangerDao;
	}

	
}
