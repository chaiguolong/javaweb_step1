package com.hzfc.superadmin.newscontent.adpater.impl;

import java.util.List;

import com.hzfc.common.adpater.impl.SuperAdpaterImpl;
import com.hzfc.superadmin.newscontent.adpater.NewsContentAdpater;
import com.hzfc.superadmin.newscontent.entity.ContentCategory;
import com.hzfc.superadmin.newscontent.entity.NewsContent;
import com.hzfc.superadmin.newscontent.service.NewsContentService;
import com.hzfc.utils.Ztree;

public class NewsContentAdpaterImpl extends SuperAdpaterImpl implements NewsContentAdpater{

	private NewsContentService _newsContentService;

	public NewsContentService getNewsContentService() {
		return _newsContentService;
	}

	public void setNewsContentService(NewsContentService newsContentService) {
		_newsContentService = newsContentService;
	}

	public boolean deleteType(Long categoryid) {
		return _newsContentService.deleteType(categoryid);
	}

	public void deleteNewsContent(Long contentid) {
		_newsContentService.deleteNewsContent(contentid);
		
	}
	
	public List<ContentCategory> selectContentCategoryByContentid(Long contentid) {
		return _newsContentService.selectContentCategoryByContentid(contentid);
	}

	public List<Ztree> getZtreeCategory() {
		return _newsContentService.getZtreeCategory();
	}

	public void saveContentInfo(NewsContent newsContent, String loginuser) {
		_newsContentService.saveContentInfo(newsContent, loginuser);
		
	}

	public void saveContentSingleInfo(NewsContent newsContent, String loginuser) {
		_newsContentService.saveContentSingleInfo(newsContent, loginuser);
		
	}
	
}
