package com.hzfc.web.action;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.hzfc.common.action.SuperAction;
import com.hzfc.utils.QueryCondition;
import com.hzfc.web.adpater.WebAdpater;
import com.hzfc.web.entity.Category;
import com.hzfc.web.entity.Content;

@SuppressWarnings("serial")
public class WebFdcxhAction extends SuperAction{
	private WebAdpater _webAdpater;
	
	private Content content;
	
	//分页用
	private int page; // 当前第几页
	
	private int allpages;//总页数
	
	private int rp; // 每页显示条数
	
	private String pageinfo;//分页信息
	
	private String prev;
	
	private String next;
	
	private int allcounts;//总记录数
	
	private String categoryid;
	/**
	 * 房地产协会详情页
	 * 
	 * @return
	 */
	public String news() {
		String contentidStr = (String) getParameterValue("contentid");
		String categoryidStr = (String) getParameterValue("categoryid");
		try {
			long contentid = new Long(contentidStr);
			long categoryid = new Long(categoryidStr);
			content = (Content) _webAdpater.selectContentByContentid(contentid);
			Category category = _webAdpater.selectCategoryByCategoryid(categoryid);
			Map<Object, Object> map = new HashMap<Object, Object>();
			map.put("categoryid", categoryid);
			map.put("counts", "3");
			setRequestAttribute("contentlist", _webAdpater.selectContentinfoByMap(map));
			setRequestAttribute("category", category);
			return "news";
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "404";
	}
	
	/**
	 * 房地产协会列表页
	 * 
	 * @return
	 */
	public String newslist() {
		try {
			long categoryids = new Integer(categoryid);
			Map<Object, Object> map = new HashMap<Object, Object>();
			// 获取同级目录
			Category self = _webAdpater.selectCategoryByCategoryid(categoryids);
			// 获取父目录
			Category parent = _webAdpater.selectCategoryByCategoryid(self.getPid());
			// 装填
			map.put("categoryid", categoryids);
			map.put("sid", categoryids);
			map.put("counts", "10");
			List<Object> categorylist = _webAdpater.selectFdcxhCategoryList(map);
			
			if(page == 0){//当前页
				page = 1;
			}
			
			if(rp == 0){//每页记录数
				rp = 10;
			}
			
			QueryCondition queryCondition = new QueryCondition();
			
			//查询设置当前页
			queryCondition.setCurrentPageNo(page);
			
			//设置每页显示数
			queryCondition.getPage().setPagesizeValue(rp);
			
			//关键字
			if(StringUtils.isNotBlank(categoryid)){
				queryCondition.setCondition("categoryid", categoryid);
			}
			
			List<Object> contentlist = _webAdpater.selectPageByQueryCondition("WEB_INF_CONTENT_selectFdcPageByQueryCondition", queryCondition);
			
			allcounts = queryCondition.getPage().getTotalrows();//总记录数
			
			pageinfo = queryCondition.getPageInfoForHtml();//分页情况
			
			setRequestAttribute("categoryid", categoryids);
			setRequestAttribute("self", self);
			setRequestAttribute("parent", parent);
			setRequestAttribute("categorylist", categorylist);
			setRequestAttribute("contentlist", contentlist);
			return "newslist";
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "404";
	}
	
	public WebAdpater getWebAdpater() {
		return _webAdpater;
	}

	public void setWebAdpater(WebAdpater webAdpater) {
		_webAdpater = webAdpater;
	}

	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getAllpages() {
		return allpages;
	}

	public void setAllpages(int allpages) {
		this.allpages = allpages;
	}

	public int getRp() {
		return rp;
	}

	public void setRp(int rp) {
		this.rp = rp;
	}

	public String getPageinfo() {
		return pageinfo;
	}

	public void setPageinfo(String pageinfo) {
		this.pageinfo = pageinfo;
	}

	public String getPrev() {
		return prev;
	}

	public void setPrev(String prev) {
		this.prev = prev;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public int getAllcounts() {
		return allcounts;
	}

	public void setAllcounts(int allcounts) {
		this.allcounts = allcounts;
	}

	public String getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(String categoryid) {
		this.categoryid = categoryid;
	}
	
}
