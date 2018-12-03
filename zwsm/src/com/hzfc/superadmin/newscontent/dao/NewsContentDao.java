package com.hzfc.superadmin.newscontent.dao;

import java.util.List;

import com.hzfc.common.dao.SuperDao;
import com.hzfc.superadmin.newscontent.entity.ContentCategory;
import com.hzfc.utils.Ztree;

public interface NewsContentDao extends SuperDao{

	boolean hasChildrenNewsCategoryByCategoryid(Long categoryid);

	boolean hasUesdNewsCategoryByCategoryid(Long categoryid);

	void deleteContentCommentByContentid(Long contentid);

	List<Ztree> getZtreeCategory();

	List<ContentCategory> selectContentCategoryByContentid(Long contentid);

	void deleteContentCategoryByContentid(Long contentid);

	void deletePropertyContentByContentid(Long contentid);

}
