package com.hzfc.web.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.hzfc.common.action.SuperAction;
import com.hzfc.utils.Page;
import com.hzfc.web.adpater.WebAdpater;
import com.hzfc.web.entity.Category;
import com.hzfc.web.entity.Complaint;
import com.hzfc.web.entity.Content;
import com.hzfc.web.entity.ContentCategory;

@SuppressWarnings("serial")
public class WebAction extends SuperAction {
	
	private WebAdpater _webAdpater;

	private Content _content;
	private String _parentLabel;
	private String _selfLabel;
	private String _parentLabelUrl;
	private Complaint _complaint;
	private String _keyword;
	private String _selfLabelUrl;
	
	private Page _page;
	
	public WebAdpater getWebAdpater() {
		return _webAdpater;
	}

	public void setWebAdpater(WebAdpater webAdpater) {
		_webAdpater = webAdpater;
	}

	public Content getContent() {
		return _content;
	}

	public void setContent(Content content) {
		_content = content;
	}

	public String getParentLabel() {
		return _parentLabel;
	}

	public void setParentLabel(String parentLabel) {
		_parentLabel = parentLabel;
	}

	public String getParentLabelUrl() {
		return _parentLabelUrl;
	}

	public void setParentLabelUrl(String parentLabelUrl) {
		_parentLabelUrl = parentLabelUrl;
	}

	public String getSelfLabel() {
		return _selfLabel;
	}

	public void setSelfLabel(String selfLabel) {
		_selfLabel = selfLabel;
	}

	public Complaint getComplaint() {
		return _complaint;
	}

	public void setComplaint(Complaint complaint) {
		_complaint = complaint;
	}

	public Page getPage() {
		return _page;
	}

	public void setPage(Page page) {
		this._page = page;
	}

	public String getKeyword() {
		return _keyword;
	}

	public void setKeyword(String keyword) {
		if(checkLegal(keyword)){
			this._keyword = keyword;
		}else{
			if(StringUtils.isBlank(keyword)){
				this._keyword = "";
			}else{
				this._keyword = "404";
			}
		}
	}

	public String getSelfLabelUrl() {
		return _selfLabelUrl;
	}

	public void setSelfLabelUrl(String selfLabelUrl) {
		_selfLabelUrl = selfLabelUrl;
	}

	/**
	 * 房管资讯列表
	 * 
	 * @return
	 */
	public String newslist() {
		loadMenu();
		String categoryidStr = filterLegal((String) getParameterValue("categoryid"));
		if("404".equals(categoryidStr)){
			return "404";
		}
		try {
			long categoryid = new Integer(categoryidStr);
			loadLabel(categoryid);
			Map<Object, Object> argMap = new HashMap<Object, Object>();
			argMap.put("categoryid", categoryid);
			argMap.put("isdisplay", "1");
			argMap.put("sid", categoryid);
			// 获取同级目录
			List<Object> categorylist = _webAdpater.selectCategoryList(argMap);
			Category self = _webAdpater.selectCategoryByCategoryid(categoryid);
			
			// 判断父目录级别,如果是最高级了就搜索子目录,如果有就显示,没有就显示新闻列且显示第一篇新闻
			
			// 获取父目录
			Category parent = _webAdpater.selectCategoryByCategoryid(self.getPid());
			
			if("根目录".equals(parent.getName())) {
				parent.setName("首页");
			}
			
			// 获取新闻
			List<Object> newslist = _webAdpater.selectContentListByMap(argMap);
			
			//检查是否有下级目录
			argMap = new HashMap<Object, Object>();
			argMap.put("isdisplay", "1");
			List<Object> sonlist;
			//判断是否为顶级目录
			if(parent.getPid() == 1L) {
				argMap.put("pid", categoryid);
				sonlist = _webAdpater.selectCategoryList(argMap);
			}
			else {
				argMap = new HashMap<Object, Object>();
				argMap.put("pid", parent.getCategoryid());
				sonlist = _webAdpater.selectCategoryList(argMap);
				argMap = new HashMap<Object, Object>();
				argMap.put("sid", parent.getCategoryid());
				categorylist = _webAdpater.selectCategoryList(argMap);
				categoryid = parent.getCategoryid();
			}
			if(sonlist != null && sonlist.size() > 0) {
				setRequestAttribute("ismenu", true);
				setRequestAttribute("sonlist", sonlist);
			}
			else {
				if (self.getCategoryid() == 13L || self.getCategoryid() == 14L || self.getCategoryid() == 28027158L) {
					setRequestAttribute("ismenu", true);
				} else {
					setRequestAttribute("ismenu", false);
				}
				if(newslist != null && newslist.size() > 0) {
					Long contentid = ((Content) newslist.get(0)).getContentid();
					Content content = _webAdpater.selectContentByContentid(contentid);
					setRequestAttribute("content", content);
				}
			}
			
			loadPage(newslist.size());
			// 装填
			setRequestAttribute("self", self);
			setRequestAttribute("newslist", newslist);
			setRequestAttribute("categorylist", categorylist);
			setRequestAttribute("parent", parent);
			setRequestAttribute("categoryid", categoryid);
			return "newslist";
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "404";
	}
	
	/**
	 * 机构信息
	 * 
	 * @return
	 */
	public String agency() {
		loadMenu();
		loadLabel(8L);
		Map<Object, Object> argMap = new HashMap<Object, Object>();
		// 显示左边大项
		argMap.put("pid", 3);
		List<Object> left = _webAdpater.selectCategoryList(argMap);
		for (int i = 0; i < left.size(); i++) {
			if (((Category) left.get(i)).getCategoryid() == 8) {
				setRequestAttribute("menu_index", i);
				break;
			}
		}
		// 显示下属机构
		argMap.put("pid", 8);
		List<Object> agency = _webAdpater.selectCategoryList(argMap);
		// 显示右上列表
		List<Object> tags;
		if (agency != null && agency.size() > 0) {
			Long categoryid = 0L;
			try {
				String categoryidStr = filterLegal((String) getParameterValue("agencyid"));
				//字符串过滤，如果有非法字符，跳转到404页面
				if("404".equals(categoryidStr)){
					return "404";
				}
				if (StringUtils.isNotBlank(categoryidStr)) {
					categoryid = new Long(categoryidStr);
				} else {
					categoryid = ((Category) agency.get(0)).getCategoryid();
				}
			} catch (NumberFormatException ex) {
				categoryid = ((Category) agency.get(0)).getCategoryid();
			}
			tags = _webAdpater.selectAgencyInfo(categoryid);
		} else {
			tags = _webAdpater.selectAgencyInfo();
		}

		setRequestAttribute("left", left);
		setRequestAttribute("agency", agency);
		setRequestAttribute("tags", tags);
		return "agency";
	}

	/**
	 * 政策法规
	 * 
	 * @return
	 */
	public String law() {
		loadMenu();
		loadLabel(9L);
		Map<Object, Object> argMap = new HashMap<Object, Object>();
		// 显示左边大项
		argMap.put("pid", 3);
		argMap.put("isdisplay", "1");
		List<Object> left = _webAdpater.selectCategoryList(argMap);
		for (int i = 0; i < left.size(); i++) {
			if (((Category) left.get(i)).getCategoryid() == 9) {
				setRequestAttribute("menu_index", i);
				break;
			}
		}
		// 显示法律
		argMap.put("pid", 9);

		List<Object> lawtype = _webAdpater.selectCategoryList(argMap);
		List<Object> laws = null;
		if (lawtype != null && lawtype.size() > 0) {
			Long lawid = 0L;
			try {
				String lawidStr = filterLegal((String) getParameterValue("lawid"));
				//字符串过滤，如果有非法字符，跳转到404页面
				if("404".equals(lawidStr)){
					return "404";
				}
				if (StringUtils.isNotBlank(lawidStr)) {
					lawid = new Long(lawidStr);
				} else {
					lawid = ((Category) lawtype.get(0)).getCategoryid();
				}
			} catch (NumberFormatException ex) {
				lawid = ((Category) lawtype.get(0)).getCategoryid();
			}
			argMap = new HashMap<Object, Object>();
			argMap.put("categoryid", lawid);
			laws = _webAdpater.selectContentListByMap(argMap);
		} else {
			laws = _webAdpater.selectContentListByMap(argMap);
		}
		loadPage(laws.size());
		//如果page.getPageno()为404，则跳到404页面
		if(_page.getPageno() == -1){
			return "404";
		}
		setRequestAttribute("left", left);
		setRequestAttribute("lawtype", lawtype);
		setRequestAttribute("laws", laws);
		return "law";
	}
	
	/**
	 * 资讯详细页
	 * 
	 * @return
	 */
	public String news() {
		loadMenu();
		String contentidStr = (String) getParameterValue("contentid");
		String categoryidStr = (String) getParameterValue("categoryid");
		try {
			long contentid = new Long(contentidStr);
			long categoryid = 13l;
			if (categoryidStr != null) {
				categoryid = new Long(categoryidStr);
			} else {
				Map<Object, Object> argMap = new HashMap<Object, Object>();
				argMap.put("contentid", contentid);
				List<Object> selflist = _webAdpater
						.selectContentCategoryList(argMap);
				if (selflist != null && selflist.size() > 0) {
					categoryid = ((ContentCategory) selflist.get(0))
							.getCategoryid();
				}
			}
			_content = _webAdpater.selectContentByContentid(contentid);
			Category self = _webAdpater.selectCategoryByCategoryid(categoryid);
			Category parent = _webAdpater.selectCategoryByCategoryid(self
					.getPid());
			setRequestAttribute("self", self);
			setRequestAttribute("parent", parent);
			Map<Object, Object> argMap = new HashMap<Object, Object>();
			argMap.put("categoryid", self.getCategoryid());
			List<Object> contentlist = _webAdpater
					.selectContentListByMap(argMap);
			setRequestAttribute("contentlist", contentlist);
			return "news";
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "404";
	}
	
	/**
	 * 法律正文页面
	 * 
	 * @return
	 */
	public String lawcontent() {
		loadMenu();
		String contentidStr = (String) getParameterValue("contentid");
		try {
			long contentid = new Long(contentidStr);
			_content = _webAdpater.selectContentByContentid(contentid);
			Category self = _webAdpater.selectCategoryByCategoryid(19L);
			loadLabel(self.getPid());
			return "lawcontent";
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "404";
	}

	/**
	 * 诚信档案
	 * 
	 * @return
	 */
	public String credit() {
		loadMenu();
		List<Object> revokelist = _webAdpater.selectRevokeList(null);
		List<Object> continuouslist = _webAdpater.selectContinuousList(null);
		List<Object> complaintlist = _webAdpater.selectComplaintList(null);
		setRequestAttribute("revokelist", revokelist);
		setRequestAttribute("continuouslist", continuouslist);
		setRequestAttribute("complaintlist", complaintlist);
		loadRight();
		return "credit";
	}
	
	/**
	 * 取消预定列表
	 * 
	 * @return
	 */
	public String revokelist() {
		setRequestAttribute("type", "revoke");
		loadMenu();
		Map<Object, Object> map = new HashMap<Object, Object>();
		String devname = (String) getParameterValue("devname");
		String fw_zl = (String) getParameterValue("fw_zl");
		String gfr = (String) getParameterValue("gfr");
		String is_search = "";
		if(StringUtils.isNotBlank(devname)) {
			is_search += "devname=" + devname;
		}
		else if(StringUtils.isNotBlank(fw_zl)) {
			is_search += "fw_zl=" + fw_zl;
		}
		else if(StringUtils.isNotBlank(gfr)) {
			is_search += "gfr=" + gfr;
		}
		setRequestAttribute("is_search", is_search);
		map.put("devname_htid", devname);
		map.put("fw_zl_htid", fw_zl);
		map.put("gfr_htid", gfr);
		List<Object> revokelist = _webAdpater.selectRevokeList(map);
		loadPage(revokelist.size());
		setRequestAttribute("revokelist", revokelist);
		loadRight();
		return "creditlist";
	}
	
	/**
	 * 连续预定列表
	 * 
	 * @return
	 */
	public String continuouslist() {
		setRequestAttribute("type", "continuous");
		loadMenu();
		Map<Object, Object> map = new HashMap<Object, Object>();
		String fw_zl = (String) getParameterValue("fw_zl");
		String is_search = "";
		if(StringUtils.isNotBlank(fw_zl)) {
			is_search += "fw_zl=" + fw_zl;
		}
		setRequestAttribute("is_search", is_search);
		map.put("fw_zl_fh_nm", fw_zl);
		List<Object> continuouslist = _webAdpater.selectContinuousList(map);
		loadPage(continuouslist.size());
		setRequestAttribute("continuouslist", continuouslist);
		loadRight();
		return "creditlist";
	}
	
	/**
	 * 预售证公示期
	 * 
	 */
	public String preselllist(){
		loadMenu();
		List<Object> preselllist = _webAdpater.selectPresellAllNew();
		loadPage(preselllist.size());
		setRequestAttribute("preselllist", preselllist);
		loadRight();
		return "preselllist";
	}
	
	/**
	 * 投诉列表页面
	 * 
	 * @return
	 */
	public String complaintlist() {
		setRequestAttribute("type", "complaint");
		loadMenu();
		List<Object> complaintlist = _webAdpater.selectComplaintList(null);
		loadPage(complaintlist.size());
		setRequestAttribute("complaintlist", complaintlist);
		loadRight();
		return "creditlist";
	}

	/**
	 * 
	 */
	private void loadRight() {
		Map<Object, Object> argMap = new HashMap<Object, Object>();
		argMap.put("categoryid", 14);
		List<Object> tongzhilist = _webAdpater.selectContentListByMap(argMap);
		argMap.put("categoryid", 13);
		List<Object> kuaixunlist = _webAdpater.selectContentListByMap(argMap);
		setRequestAttribute("tongzhilist", tongzhilist);
		setRequestAttribute("kuaixunlist", kuaixunlist);
	}
	
	/**
	 * 投诉详情页面
	 * 
	 * @return
	 */
	public String complaint() {
		loadMenu();
		String id = (String) getParameterValue("complaintid");
		try {
			Long complaintid = new Long(id);
			_complaint = _webAdpater.selectComplaintByComplaintid(complaintid);
		} catch (Exception ex) {
			ex.printStackTrace();
			return "complaintlist";
		}
		return "complaint";
	}

	/**
	 * 投诉编辑页面
	 * 
	 * @return
	 */
	public String editcomplaint() {
		loadMenu();
		return "editcomplaint";
	}

	/**
	 * 提交投诉
	 * 
	 * @return
	 */
	public String savecomplaint() {
		try {
			_webAdpater.insertComplaint(_complaint);
			renderText("true");
		} catch (Exception ex) {
			ex.printStackTrace();
			renderText("false");
		}
		return null;
	}

	/**
	 * 搜索
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String search() {
		loadMenu();
		Map<Object, Object> argMap = new HashMap<Object, Object>();
		if (_keyword != null) {
			if("404".equals(_keyword)){
				return "404";
			}else{
				argMap.put("keyword", "%" + _keyword + "%");
				getSession().put("search_keyword", _keyword);
			}
		}
		else {
			argMap.put("keyword", "%" + (String) getSession().get("search_keyword") + "%");
		}
		List<Object> contentlist = _webAdpater.selectContentListByMap(argMap);
		loadPage(contentlist.size());
		//如果page.getPageno()为404，则跳到404页面
		if(_page.getPageno() == -1){
			return "404";
		}
		setRequestAttribute("contentlist", contentlist);
		return "search";
	}

	/**
	 * 办证查询结果
	 * 
	 * @return
	 */
	public String planquery() {
		String name = filterLegal((String) getParameterValue("bzcx_name"));
		String slbh = filterLegal((String) getParameterValue("bzcx_slbh"));
		//非法字符过滤
		if("404".equals(name) || "404".equals(slbh)){
			return "404";
		}else{
			String json = _webAdpater.planquery(name, slbh);
			if(json != null) {
				renderText(json);
			}
		}
		return null;
	}
	
	/**
	 * 办证查询
	 * 
	 * @return
	 */
	public String bzcx() {
		loadMenu();
		long categoryid = 10L;
		loadLabel(categoryid);
		Map<Object, Object> argMap = new HashMap<Object, Object>();
		argMap.put("categoryid", categoryid);
		argMap.put("isdisplay", "1");
		argMap.put("sid", categoryid);
		// 获取同级目录
		List<Object> categorylist = _webAdpater.selectCategoryList(argMap);

		// 装填
		setRequestAttribute("categorylist", categorylist);
		return "bzcx";
	}

	/**
	 * 
	 * @param selfid
	 *            自身id
	 * @param sourcetype
	 *            默认为1
	 */
	private void loadLabel(Long selfid) {
		loadLabel(selfid, 1);
	}
	/**
	 * 
	 * @param selfid
	 *            自身id
	 * @param sourcetype
	 *            来源id,1=news,2=law
	 */
	private void loadLabel(Long selfid, int sourcetype) {
		Category self = _webAdpater.selectCategoryByCategoryid(selfid);
		Category parent = _webAdpater.selectCategoryByCategoryid(self.getPid());
		_selfLabel = self.getName();
		if("根目录".equals(parent.getName())) {
			_parentLabel = "";
			_parentLabelUrl = "/index.jsp";
		}
		else {
			_parentLabel = parent.getName();
			_parentLabelUrl = parent.getUrl();
		}
		if ("".equals(_parentLabelUrl) || "#".equals(_parentLabelUrl)) {
			_parentLabelUrl = "newslist.jspx?categoryid="
					+ parent.getCategoryid();
		}
		if ("".equals(_selfLabelUrl) || "#".equals(_selfLabelUrl)) {
			switch (sourcetype) {
			default:
			case 1:
				_selfLabelUrl = "newslist.jspx?categoryid="
						+ self.getCategoryid();
				break;
			case 2:
				_selfLabelUrl = "law.jspx?lawid=" + self.getCategoryid();
				break;
			}
		}
	}

	private void loadMenu() {
		Map<Object, Object> argMap = new HashMap<Object, Object>();
		// 获取菜单
		argMap.put("menu", true);
		List<Object> categorylist = _webAdpater.selectCategoryList(argMap);
		setRequestAttribute("menulist", categorylist);
	}

	private void loadPage(int totalrows) {
		if (_page == null) {
			_page = new Page();
		}
		int pageno = 1;
		String pagenoStr = "";
		try {
			pagenoStr = filterLegal((String) getParameterValue("pageno"));
			if (pagenoStr != null) {
				pageno = new Integer(pagenoStr);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		_page.setPageno(pageno);
		_page.setTotalrows(totalrows);
		_page.init();
		//如果读取页面的pagenoStr为非法字符则，将-1赋值给pageno
		if("404".equals(pagenoStr)){
			_page.setPageno(-1);
		}
	}
}
