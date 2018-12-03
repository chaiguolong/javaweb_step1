package com.hzfc.superadmin.newscontent.action;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;

import com.hzfc.common.action.SuperAction;
import com.hzfc.superadmin.newscontent.adpater.NewsContentAdpater;
import com.hzfc.superadmin.newscontent.entity.NewsCategory;
import com.hzfc.utils.QueryCondition;
import com.hzfc.utils.TablesNameConstants;

@SuppressWarnings("serial")
public class NewsCategoryAction extends SuperAction{
	
	private NewsContentAdpater _newsContentAdpater;
	
	private NewsCategory newsCategory;
	
	private int page; // 当前第几页
	
	private int rp; // 每页显示条数

	//新闻分类页面
	public String toTypeList(){
		if(page == 0){
			page = 1;
		}
		return "categorylist";
	}
	
	public void getTypeList() {
		
		QueryCondition queryCondition = new QueryCondition();
		// 查询设置当前页
		queryCondition.setCurrentPageNo(page);
		// 设置每页显示数
		queryCondition.getPage().setPagesizeValue(rp);
		
		List<Object> list = _newsContentAdpater.selectAllByMapParam(
				"INF_CATEGORY_selectAllByMapParam", queryCondition.getConditionMap());
		JSONArray items = new JSONArray();
		for (int i = 0; i < list.size(); i++) {
			JSONObject item = new JSONObject();
			String space = "";
			NewsCategory e = (NewsCategory) list.get(i);
			for (int t = 1; t < e.getLevelno(); t++) {
				space += "&nbsp;&nbsp;&nbsp;&nbsp;";
			}
			item.put(
					"cell",
					new Object[] {
							e.getCategoryid(),
							space + (e.getLevelno() != 1 ? "<img src=\"/super/common/flexigrid/css/images/level.gif\" />"
									: "") + e.getName(),
							e.getSortnumber(),
							e.getIsdisplay() == 1 ? "<a href='javascript:checkDisplay(\"" + e.getCategoryid() + "\",\"0\");'>显示</a>" :
								"<a href='javascript:checkDisplay(\"" + e.getCategoryid() + "\",\"1\");'>未显示</a>",
							e.getReamrk(),
							"<a href='javascript:edit(\"" + e.getCategoryid() + "\");'>编辑</a> | " +
							"<a href='javascript:remove(\"" + e.getCategoryid() + "\");' >移除</a>" 
							//| + "<a href='javascript:edit(\"" + e.getCategoryid() + "\");'>查看资讯</a>"
					});
			items.add(item);
		}
		JSONObject json = new JSONObject();
		json.put("page", page);
		json.put("total", 500);
		json.put("rows", items);
		this.renderText(json.toString());
	}
	
	public String toTypeInfo(){
		//数据准备
		setRequestAttribute("newsCategoryList", _newsContentAdpater.selectByStatementid("INF_CATEGORY_selectByStatementidForSelect"));

		if(newsCategory.getCategoryid() != null && StringUtils.isNotBlank(newsCategory.getCategoryid().toString())){
			newsCategory = (NewsCategory) _newsContentAdpater.selectByPrimaryKey(TablesNameConstants.INF_CATEGORY, newsCategory.getCategoryid());
		}
		return "categoryinfo";
	}
	
	public void saveType() {
		if (newsCategory.getCategoryid() != null && StringUtils.isNotBlank(newsCategory.getCategoryid().toString())) {
			_newsContentAdpater.updateByPrimaryKeySelective(TablesNameConstants.INF_CATEGORY, newsCategory);
		} else {
			_newsContentAdpater.insert(TablesNameConstants.INF_CATEGORY, newsCategory);
		}
		this.renderText("{'flag':true,'returnMsg':'保存成功！'}");
	}
	
	public void deleteType(){
		if(_newsContentAdpater.deleteType(Long.valueOf((String)getParameterValue("categoryid")))){
			this.renderText("{'flag':true,'returnMsg':'删除成功！'}");
		}
		else {
			this.renderText("{'flag':false,'returnMsg':'分类仍在使用，操作失败！'}");
		}
	}
	
	public void checkDisplay(){
		if (newsCategory.getCategoryid() != null && StringUtils.isNotBlank(newsCategory.getCategoryid().toString())) {
			_newsContentAdpater.updateByPrimaryKeySelective(TablesNameConstants.INF_CATEGORY, newsCategory);
			this.renderText("{'flag':true}");
		}
		else {
			this.renderText("{'flag':false}");
		}
	}
	
	public NewsContentAdpater getNewsContentAdpater() {
		return _newsContentAdpater;
	}

	public void setNewsContentAdpater(NewsContentAdpater newsContentAdpater) {
		_newsContentAdpater = newsContentAdpater;
	}
	
	public NewsCategory getNewsCategory() {
		return newsCategory;
	}

	public void setNewsCategory(NewsCategory newsCategory) {
		this.newsCategory = newsCategory;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRp() {
		return rp;
	}

	public void setRp(int rp) {
		this.rp = rp;
	}
}
