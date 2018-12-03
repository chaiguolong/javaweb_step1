package com.hzfc.superadmin.newscontent.adpater;

import java.util.List;

import com.hzfc.common.adpater.SuperAdpater;
import com.hzfc.superadmin.newscontent.entity.ContentCategory;
import com.hzfc.superadmin.newscontent.entity.NewsContent;
import com.hzfc.utils.Ztree;

public interface NewsContentAdpater extends SuperAdpater{

	boolean deleteType(Long categoryid);

	void deleteNewsContent(Long contentid);

	List<Ztree> getZtreeCategory();

	List<ContentCategory> selectContentCategoryByContentid(Long contentid);

	void saveContentInfo(NewsContent newsContent, String loginuser);
	
	void saveContentSingleInfo(NewsContent newsContent, String loginuser);
}
