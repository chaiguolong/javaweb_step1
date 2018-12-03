package com.hzfc.superadmin.newscontent.dao.impl;

import java.util.List;

import com.hzfc.common.dao.impl.SuperDaoImpl;
import com.hzfc.superadmin.newscontent.dao.NewsContentDao;
import com.hzfc.superadmin.newscontent.entity.ContentCategory;
import com.hzfc.superadmin.newscontent.entity.NewsCategory;
import com.hzfc.utils.Ztree;

public class NewsContentDaoImpl extends SuperDaoImpl implements NewsContentDao{

	@SuppressWarnings("unchecked")
	public boolean hasChildrenNewsCategoryByCategoryid(Long categoryid) {
		List<NewsCategory> list = this.getSqlMapClientTemplate().queryForList("hasChildrenNewsCategoryByCategoryid", categoryid);
		if(list.isEmpty()){
			return false;
		}
		else {
			return true;
		}
	}

	@SuppressWarnings("unchecked")
	public boolean hasUesdNewsCategoryByCategoryid(Long categoryid) {
		List<ContentCategory> list = this.getSqlMapClientTemplate().queryForList("hasUesdNewsCategoryByCategoryid", categoryid);
		if(list.isEmpty()){
			return false;
		}
		else {
			return true;
		}
	}

	public void deleteContentCommentByContentid(Long contentid) {
		this.getSqlMapClientTemplate().delete("deleteContentCommentByContentid", contentid);
	}

	@SuppressWarnings("unchecked")
	public List<Ztree> getZtreeCategory() {
		return this.getSqlMapClientTemplate().queryForList("getZtreeCategory");
	}

	@SuppressWarnings("unchecked")
	public List<ContentCategory> selectContentCategoryByContentid(Long contentid) {
		return this.getSqlMapClientTemplate().queryForList("selectContentCategoryByContentid", contentid);
	}

	public void deleteContentCategoryByContentid(Long contentid) {
		this.getSqlMapClientTemplate().delete("deleteContentCategoryByContentid", contentid);
		
	}

	public void deletePropertyContentByContentid(Long contentid) {
		this.getSqlMapClientTemplate().delete("deletePropertyContentByContentid", contentid);
	}

}
