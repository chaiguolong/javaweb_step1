package com.hzfc.superadmin.newscontent.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.hzfc.common.service.impl.SuperServiceImpl;
import com.hzfc.superadmin.newscontent.dao.NewsContentDao;
import com.hzfc.superadmin.newscontent.entity.ContentCategory;
import com.hzfc.superadmin.newscontent.entity.NewsContent;
import com.hzfc.superadmin.newscontent.service.NewsContentService;
import com.hzfc.utils.TablesNameConstants;
import com.hzfc.utils.Ztree;

public class NewsContentServiceImpl extends SuperServiceImpl implements NewsContentService{

	private NewsContentDao _newsContentDao;

	public NewsContentDao getNewsContentDao() {
		return _newsContentDao;
	}

	public void setNewsContentDao(NewsContentDao newsContentDao) {
		_newsContentDao = newsContentDao;
	}

	public boolean deleteType(Long categoryid) {
		//判断是否有下级分类
		if(_newsContentDao.hasChildrenNewsCategoryByCategoryid(categoryid)){
			return false;
		}
		//判断分类是否被文章引用
		if(_newsContentDao.hasUesdNewsCategoryByCategoryid(categoryid)){
			return false;
		}
		_newsContentDao.deleteByPrimaryKey(TablesNameConstants.INF_CATEGORY, categoryid);
		return true;
	}

	public void deleteNewsContent(Long contentid) {
		_newsContentDao.deleteContentCategoryByContentid(contentid);
		_newsContentDao.deleteByPrimaryKey(TablesNameConstants.INF_CONTENT, contentid);
	}

	public List<Ztree> getZtreeCategory() {
		return _newsContentDao.getZtreeCategory();
	}

	public List<ContentCategory> selectContentCategoryByContentid(Long contentid) {
		return _newsContentDao.selectContentCategoryByContentid(contentid);
	}

	public void saveContentInfo(NewsContent newsContent, String loginuser) {
		newsContent.setReleasename(loginuser);
		if(newsContent.getContentid() == null || StringUtils.isBlank(newsContent.getContentid().toString())){
			newsContent.setContentid(_newsContentDao.getOracleSequencesBySeqName("HIBERNATE_SEQUENCE"));
			newsContent.setCategoryid(Long.valueOf(0));
			_newsContentDao.insert(TablesNameConstants.INF_CONTENT, newsContent);
		}
		else {
			//删除已归属栏目
			if(newsContent.getReleasemark() == 1){
				newsContent.setReleasetime("sysdate");
			}
			_newsContentDao.deleteContentCategoryByContentid(newsContent.getContentid());
			_newsContentDao.updateByPrimaryKeySelective(TablesNameConstants.INF_CONTENT, newsContent);
		}
		
		ContentCategory cc = new ContentCategory();
		cc.setContentid(newsContent.getContentid());
		for(String s : newsContent.getCategoryids().split(",")){
			cc.setCategoryid(Long.valueOf(s));
			_newsContentDao.insert(TablesNameConstants.INF_CONTENTCATEGORY, cc);
		}
		
	}
	
	public void saveContentSingleInfo(NewsContent newsContent, String loginuser) {
		newsContent.setReleasename(loginuser);
		if(newsContent.getContentid() == null || StringUtils.isBlank(newsContent.getContentid().toString())){
			newsContent.setContentid(_newsContentDao.getOracleSequencesBySeqName("HIBERNATE_SEQUENCE"));
			newsContent.setCategoryid(Long.valueOf(0));
			_newsContentDao.insert(TablesNameConstants.INF_CONTENT, newsContent);
		}
		else {
			//删除已归属栏目
			if(newsContent.getReleasemark() == 1){
				newsContent.setReleasetime("sysdate");
			}
			_newsContentDao.deleteContentCategoryByContentid(newsContent.getContentid());
			_newsContentDao.updateByPrimaryKeySelective(TablesNameConstants.INF_CONTENT, newsContent);
		}
		ContentCategory cc = new ContentCategory();
		cc.setContentid(newsContent.getContentid());
		for(String s : newsContent.getCategoryids().replaceAll("\n", "").replaceAll("\t", "").split(",")){
			cc.setCategoryid(Long.valueOf(s));
			_newsContentDao.insert(TablesNameConstants.INF_CONTENTCATEGORY, cc);
		}
	}
}
