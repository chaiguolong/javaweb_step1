package com.hzfc.superadmin.newscontent.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.hzfc.utils.DateUtil;
import com.hzfc.common.action.SuperAction;
import com.hzfc.superadmin.framework.entity.SysAccount;
import com.hzfc.superadmin.newscontent.adpater.NewsContentAdpater;
import com.hzfc.superadmin.newscontent.entity.ContentComment;
import com.hzfc.superadmin.newscontent.entity.NewsContent;
import com.hzfc.utils.FileOperUtils;
import com.hzfc.utils.QueryCondition;
import com.hzfc.utils.TablesNameConstants;
import com.hzfc.utils.ZipFileUtil;
import com.hzfc.utils.Ztree;

@SuppressWarnings("serial")
public class NewsContentAction extends SuperAction {
	
	private NewsContentAdpater _newsContentAdpater;
	
	private NewsContent newsContent;
	
	private ContentComment contentComment;

	private int page; // 当前第几页
	
	private int rp; // 每页显示条数
	
	private String categoryid;
	
	public String getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(String categoryid) {
		this.categoryid = categoryid;
	}

	public ContentComment getContentComment() {
		return contentComment;
	}

	public void setContentComment(ContentComment contentComment) {
		this.contentComment = contentComment;
	}

	public NewsContentAdpater getNewsContentAdpater() {
		return _newsContentAdpater;
	}

	public void setNewsContentAdpater(NewsContentAdpater newsContentAdpater) {
		_newsContentAdpater = newsContentAdpater;
	}

	public NewsContent getNewsContent() {
		return newsContent;
	}

	public void setNewsContent(NewsContent newsContent) {
		this.newsContent = newsContent;
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
	
	public String toContentLista(){
		SysAccount sysAccount = ((SysAccount) getSessionObj("sessionsuperadmin"));
		if(sysAccount != null){
			setRequestAttribute("sid", sysAccount.getSiteid());
			setRequestAttribute("newsCategoryList", _newsContentAdpater.selectAllByMapParam("INF_CATEGORY_selectByStatementidForSelect", new HashMap()));
			if(page == 0){
				page = 1;
			}
			return "contentlista";
		}
		else{
			return "404";
		}
	}
	
	public String toContentListb(){
		SysAccount sysAccount = ((SysAccount) getSessionObj("sessionsuperadmin"));
		if(sysAccount != null){
			setRequestAttribute("sid", sysAccount.getSiteid());
			setRequestAttribute("newsCategoryList", _newsContentAdpater.selectAllByMapParam("INF_CATEGORY_selectByStatementidForSelect", new HashMap()));
			if(page == 0){
				page = 1;
			}
			return "contentlistb";
		}
		else{
			return "404";
		}
	}
	
	public String toContentListc(){
		SysAccount sysAccount = ((SysAccount) getSessionObj("sessionsuperadmin"));
		if(sysAccount != null){
			setRequestAttribute("sid", sysAccount.getSiteid());
			setRequestAttribute("newsCategoryList", _newsContentAdpater.selectAllByMapParam("INF_CATEGORY_selectByStatementidForSelect", new HashMap()));
			if(page == 0){
				page = 1;
			}
			return "contentlistc";
		}
		else{
			return "404";
		}
	}
	
	public String toContentListd(){
		SysAccount sysAccount = ((SysAccount) getSessionObj("sessionsuperadmin"));
		if(sysAccount != null){
			setRequestAttribute("sid", sysAccount.getSiteid());
			setRequestAttribute("newsCategoryList", _newsContentAdpater.selectAllByMapParam("INF_CATEGORY_selectByStatementidForSelect", new HashMap()));
			if(page == 0){
				page = 1;
			}
			return "contentlistd";
		}
		else{
			return "404";
		}
	}
	
	//资讯评论
	public String toContentCommentList(){
		if(page == 0){
			page = 1;
		}
		return "contentcommentlist";
	}
	
	//新闻列表页面
	public String toContentList(){
		SysAccount sysAccount = ((SysAccount) getSessionObj("sessionsuperadmin"));
		if(sysAccount != null){
			setRequestAttribute("newsCategoryList", _newsContentAdpater.selectAllByMapParam("INF_CATEGORY_selectByStatementidForSelect", new HashMap()));
			if(page == 0){
				page = 1;
			}
			return "contentlist";
		}
		else{
			return "404";
		}
	}
	
	//新闻列表
	public void getNewsContentList(){
		QueryCondition queryCondition = new QueryCondition();
		// 查询设置当前页
		queryCondition.setCurrentPageNo(page);
		// 设置每页显示数
		queryCondition.getPage().setPagesizeValue(rp);
		
		if (StringUtils.isNotBlank((String) getParameterValue("state"))) {
			queryCondition.setCondition("state", getParameterValue("state"));
		}
		if (StringUtils.isNotBlank((String) getParameterValue("categoryid"))) {
			queryCondition.setCondition("categoryid", getParameterValue("categoryid"));
		}
		if (StringUtils.isNotBlank((String) getParameterValue("hotflag"))) {
			queryCondition.setCondition("hotflag", getParameterValue("hotflag"));
		}
		if (StringUtils.isNotBlank((String) getParameterValue("recommendflag"))) {
			queryCondition.setCondition("recommendflag", getParameterValue("recommendflag"));
		}
		if (StringUtils.isNotBlank((String) getParameterValue("releasemark"))) {
			queryCondition.setCondition("releasemark", getParameterValue("releasemark"));
		}
		if (StringUtils.isNotBlank((String)getParameterValue("starttime"))) {
			queryCondition.setCondition("starttime", getParameterValue("starttime"));
		}
		if (StringUtils.isNotBlank((String) getParameterValue("endtime"))) {
			queryCondition.setCondition("endtime", getParameterValue("endtime"));
		}
		if (StringUtils.isNotBlank((String) getParameterValue("keywords").toString().trim())) {
			queryCondition.setCondition("keywords", "%" + getParameterValue("keywords").toString().trim() + "%");
		}
		
		List<Object> list = _newsContentAdpater.selectPageByQueryCondition(
				"INF_CONTENT_selectPageByQueryCondition", queryCondition);
		String btn = "";
		JSONArray items = new JSONArray();
		for (int i = 0; i < list.size(); i++) {
			JSONObject item = new JSONObject();
			NewsContent n = (NewsContent) list.get(i);
			btn = "";
//			btn = "<a href='javascript:look(\"" + n.getContentid() + "\");'>预览</a>";
			btn += "<a href='javascript:edit(\""
			+ n.getContentid() + "\");'>编辑</a>";
			//btn +="| <a title=\"静态化资讯\" href='javascript:removeFile(\"" + "upload/newspic/newsdetail/" + n.getContentid() + "/\");'>静态</a>";
			item.put(
					"cell",
					new Object[] {
						n.getContentid(),
						n.getTitle(),
						n.getRecommendflag() == 1 ? "推荐" : "不推荐",
						n.getHotflag() == 1 ? "热门" : "不热门",
						n.getReleasemarkvalue(),
						n.getEntrydate(),
						n.getWebshowdate(),
						n.getReleasename(),
						btn + (n.getReleasemark() == 1 ? " | <a title=\"取消发布\" href='javascript:cancel(\""
						+ n.getContentid() + "\");'>取消</a>" : " | <a title=\"删除资讯\" href='javascript:remove(\""
						+ n.getContentid() + "\");'>删除</a>")
					});
			items.add(item);
		}
		JSONObject json = new JSONObject();
		json.put("page", page);
		json.put("total", queryCondition.getPage().getTotalrows());
		json.put("rows", items);
		this.renderText(json.toString());
	}
	
	//评论列表
	public void getNewsContentCommentList(){
		QueryCondition queryCondition = new QueryCondition();
		// 查询设置当前页
		queryCondition.setCurrentPageNo(page);
		// 设置每页显示数
		queryCondition.getPage().setPagesizeValue(rp);
		
		if (StringUtils.isNotBlank((String)getParameterValue("starttime"))) {
			queryCondition.setCondition("starttime", getParameterValue("starttime"));
		}
		if (StringUtils.isNotBlank((String) getParameterValue("endtime"))) {
			queryCondition.setCondition("endtime", getParameterValue("endtime"));
		}
		if (StringUtils.isNotBlank((String) getParameterValue("keywords").toString().trim())) {
			queryCondition.setCondition("keywords", "%" + getParameterValue("keywords").toString().trim() + "%");
		}
		
		List<Object> list = _newsContentAdpater.selectPageByQueryCondition(
				"INF_CONTENTCOMMENT_selectPageByQueryCondition", queryCondition);
		JSONArray items = new JSONArray();
		for (int i = 0; i < list.size(); i++) {
			JSONObject item = new JSONObject();
			ContentComment n = (ContentComment) list.get(i);
			item.put(
					"cell",
					new Object[] {
						n.getContentcommentid(),
						n.getTitle(),
						n.getCommenttitle(),
						n.getCommenttime(),
						n.getAgreecount(),
						n.getNegativecount(),
						n.getCommentremark(),
						("<a title=\"删除评论\" href='javascript:deleteNewsContentComment(\""+ n.getContentcommentid() + "\");'>删除</a>")
					});
			items.add(item);
		}
		JSONObject json = new JSONObject();
		json.put("page", page);
		json.put("total", queryCondition.getPage().getTotalrows());
		json.put("rows", items);
		this.renderText(json.toString());
	}
	
	//列表修改状态
	public void updateNewsContent(){
		if (newsContent.getContentid() != null && StringUtils.isNotBlank(newsContent.getContentid().toString())) {
			_newsContentAdpater.updateByPrimaryKeySelective(TablesNameConstants.INF_CONTENT, newsContent);
			this.renderText("{'flag':true,'returnMsg':'操作成功！'}");
		}
		else {
			this.renderText("{'flag':false,'returnMsg':'操作失败！'}");
		}
	}
	//删除资讯评论
	public void deleteNewsContentComment(){
		if (contentComment.getContentcommentid() != null && StringUtils.isNotBlank(contentComment.getContentcommentid().toString())) {
			_newsContentAdpater.deleteByPrimaryKey(TablesNameConstants.INF_CONTENTCOMMENT, contentComment.getContentcommentid());
			this.renderText("{'flag':true,'returnMsg':'操作成功！'}");
		}
		else {
			this.renderText("{'flag':false,'returnMsg':'操作失败！'}");
		}
	}
	//列表删除资讯
	public void deleteNewsContent(){
		if (newsContent.getContentid() != null && StringUtils.isNotBlank(newsContent.getContentid().toString())) {
			_newsContentAdpater.deleteNewsContent(newsContent.getContentid());
			//删除静态文件
			ZipFileUtil.delFolder(getWebRootDir() + "upload/newspic/newsdetail/" + newsContent.getContentid());
			this.renderText("{'flag':true,'returnMsg':'操作成功！'}");
		}
		else {
			this.renderText("{'flag':false,'returnMsg':'操作失败！'}");
		}
	}
	
	public String toContentInfo(){
		//数据准备
		setRequestAttribute("mode", getParameterValue("mode"));
		if(newsContent.getContentid() != null && StringUtils.isNotBlank(newsContent.getContentid().toString())){
			newsContent = (NewsContent) _newsContentAdpater.selectByPrimaryKey(TablesNameConstants.INF_CONTENT, newsContent.getContentid());
			setRequestAttribute("categoryidlist", _newsContentAdpater.selectContentCategoryByContentid(newsContent.getContentid()));
		}
		return "contentinfo";
	}
	
	//加载树
	public void getZtreeCategory(){
		List<Ztree> list = _newsContentAdpater.getZtreeCategory();
		this.renderText(JSONArray.fromObject(list).toString());
	}
	
	//保存资讯
	public void saveContentInfo(){
		SysAccount sysAccount = ((SysAccount) getSessionObj("sessionsuperadmin"));
		
		if(sysAccount != null){
			if(StringUtils.isNotBlank(newsContent.getThumbnail()) && newsContent.getThumbnail().indexOf("tempfile")>=0){
				FileOperUtils fileOperUtils = new FileOperUtils();
				String newpath = newsContent.getThumbnail().replaceAll("tempfile", "newspic/newsThumbnail/" + DateUtil.getDateFromDate(new Date(), "yyyyMMdd").toString());
				fileOperUtils.copyfile(getWebRootDir() + newsContent.getThumbnail(), getWebRootDir() + newpath);
				newsContent.setThumbnail(newpath);
			}
			
			if(StringUtils.isNotBlank(newsContent.getUploadattachment()) && newsContent.getUploadattachment().indexOf("tempfile")>=0){
				FileOperUtils fileOperUtils = new FileOperUtils();
				String newpath = newsContent.getUploadattachment().replaceAll("tempfile", "newspic/newsAttachment/" + DateUtil.getDateFromDate(new Date(), "yyyyMMdd").toString());
				fileOperUtils.copyfile(getWebRootDir() + newsContent.getUploadattachment(), getWebRootDir() + newpath);
				newsContent.setUploadattachment(newpath);
			}
			_newsContentAdpater.saveContentInfo(newsContent, sysAccount.getLoginuser());
			this.renderText("{'flag':true,'returnMsg':'操作成功！'}");
		}
		else {
			this.renderText("{'flag':false,'returnMsg':'请重新登录！'}");
		}
	}
	
	//资讯单页管理
	//资讯单页页面
	public String toSingleList(){
		SysAccount sysAccount = ((SysAccount) getSessionObj("sessionsuperadmin"));
		if(sysAccount != null){
			if(page == 0){
				page = 1;
			}
			setRequestAttribute("categoryid", getParameterValue("categoryid"));
			return "contentsinglelist";
		}
		else{
			return "404";
		}
	}
	
	//列表
	public void getNewsContentSingleList(){
		QueryCondition queryCondition = new QueryCondition();
		// 查询设置当前页
		queryCondition.setCurrentPageNo(page);
		// 设置每页显示数
		queryCondition.getPage().setPagesizeValue(rp);
		
		queryCondition.setCondition("categoryid", getParameterValue("categoryid"));
		
		if (StringUtils.isNotBlank((String) getParameterValue("state"))) {
			queryCondition.setCondition("state", getParameterValue("state"));
		}
		if (StringUtils.isNotBlank((String) getParameterValue("hotflag"))) {
			queryCondition.setCondition("hotflag", getParameterValue("hotflag"));
		}
		if (StringUtils.isNotBlank((String) getParameterValue("recommendflag"))) {
			queryCondition.setCondition("recommendflag", getParameterValue("recommendflag"));
		}
		if (StringUtils.isNotBlank((String) getParameterValue("releasemark"))) {
			queryCondition.setCondition("releasemark", getParameterValue("releasemark"));
		}
		if (StringUtils.isNotBlank((String)getParameterValue("starttime"))) {
			queryCondition.setCondition("starttime", getParameterValue("starttime"));
		}
		if (StringUtils.isNotBlank((String) getParameterValue("endtime"))) {
			queryCondition.setCondition("endtime", getParameterValue("endtime"));
		}
		if (StringUtils.isNotBlank((String) getParameterValue("keywords").toString().trim())) {
			queryCondition.setCondition("keywords", "%" + getParameterValue("keywords").toString().trim() + "%");
		}
		
		List<Object> list = _newsContentAdpater.selectPageByQueryCondition(
				"INF_CONTENT_selectPageByQueryCondition", queryCondition);
		String btn = "";
		JSONArray items = new JSONArray();
		for (int i = 0; i < list.size(); i++) {
			JSONObject item = new JSONObject();
			NewsContent n = (NewsContent) list.get(i);
			btn = "";
//			btn = "<a href='javascript:look(\"" + n.getContentid() + "\");'>预览</a>";
			if(n.getReleasemark() != 1){
				btn += "<a href='javascript:edit(\""
				+ n.getContentid() + "\");'>编辑</a> ";
			}
//			btn +="<a title=\"静态化资讯\" href='javascript:removeFile(\"" + "upload/newspic/newsdetail/" + n.getContentid() + "/\");'>静态</a>";
			item.put(
					"cell",
					new Object[] {
						n.getContentid(),
						n.getTitle(),
						n.getRecommendflag() == 1 ? "推荐" : "不推荐",
						n.getHotflag() == 1 ? "热门" : "不热门",
						n.getReleasemarkvalue(),
						n.getEntrydate(),
						n.getWebshowdate(),
						n.getReleasename(),
						btn + (n.getReleasemark() == 1 ? "  <a title=\"取消发布\" href='javascript:cancel(\""
						+ n.getContentid() + "\");'>取消</a>" : " | <a title=\"删除资讯\" href='javascript:remove(\""
						+ n.getContentid() + "\");'>删除</a>")
					});
			items.add(item);
		}
		JSONObject json = new JSONObject();
		json.put("page", page);
		json.put("total", queryCondition.getPage().getTotalrows());
		json.put("rows", items);
		this.renderText(json.toString());
	}
	
	public String toContentSingleInfo(){
		//数据准备
		setRequestAttribute("mode", getParameterValue("mode"));
		if(newsContent.getContentid() != null && StringUtils.isNotBlank(newsContent.getContentid().toString())){
			newsContent = (NewsContent) _newsContentAdpater.selectByPrimaryKey(TablesNameConstants.INF_CONTENT, newsContent.getContentid());
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("categoryid", getParameterValue("categoryid").toString());	
		setRequestAttribute("categoryidlist", _newsContentAdpater.selectAllByMapParam("INF_CATEGORY_selectAllcategoryid", map));
		setRequestAttribute("categoryid", getParameterValue("categoryid"));
		return "contentsingleinfo";
	}
	
	//保存资讯
	public void saveContentSingleInfo(){
		SysAccount sysAccount = ((SysAccount) getSessionObj("sessionsuperadmin"));
		if(sysAccount != null){
			if(StringUtils.isNotBlank(newsContent.getThumbnail()) && newsContent.getThumbnail().indexOf("tempfile")>=0){
				FileOperUtils fileOperUtils = new FileOperUtils();
				String newpath = newsContent.getThumbnail().replaceAll("tempfile", "newspic/newsThumbnail/" + DateUtil.getDateFromDate(new Date(), "yyyyMMdd").toString());
				fileOperUtils.copyfile(getWebRootDir() + newsContent.getThumbnail(), getWebRootDir() + newpath);
				newsContent.setThumbnail(newpath);
			}
			
			if(StringUtils.isNotBlank(newsContent.getUploadattachment()) && newsContent.getUploadattachment().indexOf("tempfile")>=0){
				FileOperUtils fileOperUtils = new FileOperUtils();
				String newpath = newsContent.getUploadattachment().replaceAll("tempfile", "newspic/newsAttachment/" + DateUtil.getDateFromDate(new Date(), "yyyyMMdd").toString());
				fileOperUtils.copyfile(getWebRootDir() + newsContent.getUploadattachment(), getWebRootDir() + newpath);
				newsContent.setUploadattachment(newpath);
			}
			_newsContentAdpater.saveContentSingleInfo(newsContent, sysAccount.getLoginuser());
			this.renderText("{'flag':true,'returnMsg':'操作成功！'}");
		}
		else {
			this.renderText("{'flag':false,'returnMsg':'请重新登录！'}");
		}
	}
}
