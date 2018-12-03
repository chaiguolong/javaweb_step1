package com.hzfc.web.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.hzfc.common.action.SuperAction;
import com.hzfc.utils.Page;
import com.hzfc.web.adpater.WebDjAdpater;
import com.hzfc.web.entity.Category;
import com.hzfc.web.entity.Content;
import com.hzfc.web.entity.ContentCategory;

/**
 * 党建action
 *
 */
@SuppressWarnings("serial")
public class WebDjAction extends SuperAction {

	private static final long ROOT_ID = 101l;
	private static List<Object> _menulist;
	/**
	 * 左侧菜单栏
	 */
	private List<Object> _leftlist;
	private List<Object> _contentlist;
	private Content _content;
	private Category _self;
	private String _cid;
	private String _tid;
	private Page _page;
	
	private WebDjAdpater _webDjAdpater;
	
	public List<Object> getMenulist() {
		return _menulist;
	}

	@SuppressWarnings("static-access")
	public void setMenulist(List<Object> menulist) {
		this._menulist = menulist;
	}

	public List<Object> getLeftlist() {
		return _leftlist;
	}

	public void setLeftlist(List<Object> leftlist) {
		this._leftlist = leftlist;
	}

	public List<Object> getContentlist() {
		return _contentlist;
	}

	public void setContentlist(List<Object> contentlist) {
		this._contentlist = contentlist;
	}

	public Content getContent() {
		return _content;
	}

	public void setContent(Content content) {
		this._content = content;
	}

	public Category getSelf() {
		return _self;
	}

	public void setSelf(Category self) {
		_self = self;
	}

	public String getCid() {
		return _cid;
	}

	public void setCid(String cid) {
		_cid = cid;
	}

	public String getTid() {
		return _tid;
	}

	public void setTid(String tid) {
		_tid = tid;
	}

	public Page getPage() {
		return _page;
	}

	public void setPage(Page page) {
		_page = page;
	}

	public WebDjAdpater getWebDjAdpater() {
		return _webDjAdpater;
	}

	public void setWebDjAdpater(WebDjAdpater webDjAdpater) {
		_webDjAdpater = webDjAdpater;
	}

	public String index() {
		loadMenu();
		Map<Object, Object> argMap = new HashMap<Object, Object>();
		argMap.put("categoryid", ROOT_ID);
		// 获取所有新闻,在前台便立时进行区分
		_contentlist = _webDjAdpater.selectContentListByMap(argMap);
		List<Object> relatelist = _webDjAdpater.selectContentCategoryListForIndex();
		loadContent(relatelist, _menulist);
		return "index";
	}
	
	public String newslist() {
		loadMenu();
		loadLeftMenu();
		Map<Object, Object> argMap = new HashMap<Object, Object>();
		long categoryid = ROOT_ID;
		if(StringUtils.isNotBlank(_tid)) {
			categoryid = new Long(_tid);
			_self = _webDjAdpater.selectCategoryByCategoryid(categoryid);
		}
		else if(StringUtils.isNotBlank(_cid)){
			categoryid = new Long(_cid);
		}
		else {
			return index();
		}
		argMap.put("categoryid", categoryid);
		_contentlist = _webDjAdpater.selectContentListByMap(argMap);
		boolean ismenu = false;
		if(_self.getPid() == ROOT_ID) {
			argMap = new HashMap<Object, Object>();
			argMap.put("pid", _self.getCategoryid());
			List<Object> templist = _webDjAdpater.selectCategoryListByMap(argMap);
			if (templist != null && templist.size() != 0) {
				ismenu = true;
			}
		}
		if(ismenu) {
			// 如果是顶级目录且有下级目录,那么就分栏显示各个子目录
			List<Object> categorylist = _webDjAdpater.selectCategoryListByMap(argMap);
			setRequestAttribute("categorylist", categorylist);
			List<Object> relatelist = _webDjAdpater.selectContentCategoryListForNewslist(_self.getCategoryid());
			loadContent(relatelist, categorylist);
		}
		else {
			// 具体目录的话就显示具体内容,包括分页
			loadPage(_contentlist.size());
		}
		setRequestAttribute("ismenu", ismenu);
		return "newslist";
	}
	
	public String news() {
		loadMenu();
		loadLeftMenu();
		if(StringUtils.isNotBlank(_tid)) {
			try {
				long tid = new Long(_tid);
				_content = _webDjAdpater.selectContentByContentid(tid);
				if(_content == null) {
					return index();
				}
			}
			catch(NumberFormatException ex) {
				ex.printStackTrace();
				return index();
			}
		}
		else {
			return index();
		}
		boolean ismenu = false;
		if(_self.getPid() == ROOT_ID) {
			HashMap<Object, Object> argMap = new HashMap<Object, Object>();
			argMap.put("pid", _self.getCategoryid());
			List<Object> templist = _webDjAdpater.selectCategoryListByMap(argMap);
			if (templist != null && templist.size() != 0) {
				ismenu = true;
			}
		}
		setRequestAttribute("ismenu", ismenu);
		return "news";
	}
	
	@SuppressWarnings("unchecked")
	public String search() {
		setRequestAttribute("title", "搜索");
		_self = new Category();
		_self.setName("搜索");
		setRequestAttribute("ismenu", false);
		setRequestAttribute("issearch", true);
		Map<Object, Object> argMap = new HashMap<Object, Object>();
		argMap.put("categoryid", 101L);
		String keyword = (String) getParameterValue("keyword");
		if (keyword != null) {
			argMap.put("keyword", "%" + keyword + "%");
			getSession().put("search_dj_keyword", keyword);
		}
		else {
			argMap.put("keyword", "%" + (String) getSession().get("search_dj_keyword") + "%");
		}
		_contentlist = _webDjAdpater.selectContentListByMap(argMap);
		loadPage(_contentlist.size());
		return "newslist";
	}
	
	/**
	 * 为contentlist中的数据装填categoryid的值
	 * 
	 * @param relatelist
	 *            contentCategorylist关联列表
	 * @param categorylist
	 *            菜单列表
	 */
	private void loadContent(List<Object> relatelist, List<Object> categorylist) {
		for (int i = 0; i < _contentlist.size(); i++) {
			Content content = (Content) _contentlist.get(i);
			boolean is_find = false;
			for (int j = 0; j < relatelist.size(); j++) {
				ContentCategory relate = (ContentCategory) relatelist.get(j);
				if (content.getContentid().longValue() == relate.getContentid().longValue()) {
					if (relate.getCategoryid() == 158L) {
						content.setCategoryid(158L);
					}
					for (int k = 0; k < categorylist.size(); k++) {
						Category menu = (Category) categorylist.get(k);
						if (menu.getCategoryid().longValue() == relate.getCategoryid().longValue()) {
							content.setCategoryid(menu.getCategoryid());
							is_find = true;
							break;
						}
					}
				}
				if (is_find) {
					break;
				}
			}
		}
	}
	
	/**
	 * 读取顶部菜单
	 */
	private void loadMenu() {
		if (_menulist == null || _menulist.size() == 0) {
			_menulist = _webDjAdpater.selectTopMenuList();
		}
	}
	
	/**
	 * 加载左侧菜单
	 */
	private void loadLeftMenu() {
		// 获取左侧菜单栏
		// 进入点有两个,一个是根目录,一个是次级目录,不存在三级目录进入的情况
		long categoryid = 1L;
		try {
			categoryid = new Long(_cid);
		} catch (NumberFormatException ex) {
			ex.printStackTrace();

		}
		_self = _webDjAdpater.selectCategoryByCategoryid(categoryid);
		if (_self != null) {
			Map<Object, Object> argMap = new HashMap<Object, Object>();
			// 为根目录时
			if (_self.getPid() == ROOT_ID) {
				argMap.put("dj_pid", _self.getCategoryid());
				setRequestAttribute("title", _self.getName());
			} else {
				// 为二级目录时
				argMap.put("dj_pid", _self.getPid());
				Category temp = _webDjAdpater.selectCategoryByCategoryid(_self
						.getPid());
				if (temp != null) {
					setRequestAttribute("title", temp.getName());
				}
			}
			_leftlist = _webDjAdpater.selectCategoryListByMap(argMap);
		}
	}
	
	private void loadPage(int totalrows) {
		if (_page == null) {
			_page = new Page();
		}
		int pageno = 1;
		try {
			String pagenoStr = (String) getParameterValue("pageno");
			if (pagenoStr != null) {
				pageno = new Integer(pagenoStr);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		_page.setPageno(pageno);
		_page.setTotalrows(totalrows);
		_page.init();
	}
}
