package com.hzfc.superadmin.ad.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.hzfc.common.action.SuperAction;
import com.hzfc.superadmin.ad.adpater.WebAdMangerAdpater;
import com.hzfc.superadmin.ad.entity.WebStatictask;
import com.hzfc.superadmin.framework.entity.SysAccount;
import com.hzfc.utils.DateUtil;
import com.hzfc.utils.FileUtil;
import com.hzfc.utils.QueryCondition;
import com.hzfc.utils.TablesNameConstants;
import com.hzfc.web.adpater.WebAdpater;

@SuppressWarnings("serial")
public class WebStatictaskAction extends SuperAction {

	private WebAdMangerAdpater _webAdMangerAdpater;
	
	private WebStatictask webStatictask;
	
	private WebAdpater _webAdpater;
	private int page;
	private int rp;

	private String contentHtml;

	public String toList() {
		setRequestAttribute("stattypelist", _webAdMangerAdpater.selectKeyListByKeycode("WEB_STATICTASK_TIMES"));
		if (page == 0) {
			page = 1;
		}
		return "statictasklist";
	}

	public void getList() {
		SysAccount sysAccount = ((SysAccount) getSessionObj("sessionsuperadmin"));
		Long id = sysAccount.getAccountid();
		
		QueryCondition queryCondition = new QueryCondition();
		// 查询设置当前页
		queryCondition.setCurrentPageNo(page);
		// 设置每页显示数
		queryCondition.getPage().setPagesizeValue(rp);

		if (StringUtils.isNotBlank((String) getParameterValue("keywords"))) {
			queryCondition.setCondition("keywords", "%" + getParameterValue("keywords").toString().trim() + "%");
		}
		if (StringUtils.isNotBlank((String)getParameterValue("stattype"))) {
			queryCondition.setCondition("stattype", getParameterValue("stattype"));
		}
		if (StringUtils.isNotBlank(String.valueOf(id))) {
			queryCondition.setCondition("accountid", String.valueOf(id));
		}

		queryCondition.setCondition("stattypecode", "WEB_STATICTASK_TIMES");
		List<Object> list = _webAdMangerAdpater.selectPageByQueryCondition("WEB_STATICTASK_selectPageByQueryCondition", queryCondition);
		JSONArray items = new JSONArray();
		for (int i = 0; i < list.size(); i++) {
			JSONObject item = new JSONObject();
			WebStatictask w = (WebStatictask) list.get(i);
			item.put("cell", new Object[] { w.getStatictaskid(), w.getStaticurl(),w.getStattypename(), w.getDynamicurl(),  w.getActualdate(), "<a href='javascript:onChange(\"" + w.getStatictaskid() + "\");'>手动静态化</a> " 
					//+ "| <a href='javascript:edit(\"" + w.getStatictaskid() + "\");' >预览</a>"
					});
			items.add(item);
		}
		JSONObject json = new JSONObject();
		json.put("page", page);
		json.put("total", queryCondition.getPage().getTotalrows());
		json.put("rows", items);
		this.renderText(json.toString());
	}

	// 手动静态页面生成
	public void toCreate() {
		if(doCreate()) {
			this.renderText("{'flag':true,'returnMsg':'静态化页面生成成功！'}");
		}
		else {
			this.renderText("{'flag':false,'returnMsg':'生成失败！'}");
		}
	}
	
	public boolean doCreate() {
		webStatictask = (WebStatictask) _webAdMangerAdpater.selectByPrimaryKey(TablesNameConstants.WEB_STATICTASK, webStatictask.getStatictaskid());
		if (isStaticPageSuccess(webStatictask)) {
			webStatictask.setActualdate(DateUtil.getNowTimestamp().toString().substring(0, 19));
			_webAdMangerAdpater.updateByPrimaryKeySelective("WEB_STATICTASK", webStatictask);
			return true;
		} 
		else {
			return false;
		}
	}
	
	public boolean isStaticPageSuccess(WebStatictask webStatictask) {
		try {
			// 房地产协会头部下拉框
			if ("/fdcxh/template/fdcxh_top_link.ftl".equals(webStatictask.getDynamicurl())) {
				HashMap<String, Object> rootMap = new HashMap<String, Object>();
				Map<Object, Object> map = new HashMap<Object, Object>();
				map.put("menu", true);
				rootMap.put("categorylist", _webAdpater.selectFdcxhCategoryList(map));
				return GenerateHtml(rootMap, webStatictask.getDynamicurl(), webStatictask.getStaticpath());
			}
			// 房地产协会头部下拉框
			if ("/zjxh/template/zjxh_top_link.ftl".equals(webStatictask.getDynamicurl())) {
				HashMap<String, Object> rootMap = new HashMap<String, Object>();
				Map<Object, Object> map = new HashMap<Object, Object>();
				map.put("menu", true);
				rootMap.put("categorylist", _webAdpater.selectZjxhCategoryList(map));
				return GenerateHtml(rootMap, webStatictask.getDynamicurl(), webStatictask.getStaticpath());
			}
			if ("/template/index.ftl".equals(webStatictask.getDynamicurl())) {
				getLzgg();
				// 调用index方法执行具体操作
				return index(webStatictask.getDynamicurl(), "/index.jsp");
			}
			// 房地产协会首页静态化模板
			if ("/fdcxh/template/fdcxh_index.ftl".equals(webStatictask
					.getDynamicurl())) {
				return fdcxh(webStatictask.getDynamicurl(), webStatictask
						.getStaticpath());
			}
			// 房地产协会首页静态化模板
			if ("/zjxh/template/zjxh_index.ftl".equals(webStatictask
					.getDynamicurl())) {
				return zjxh(webStatictask.getDynamicurl(), webStatictask
						.getStaticpath());
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	private boolean index(String template, String target) {
		// 重新创建文件
		HashMap<String, Object> rootMap = new HashMap<String, Object>();
		HashMap<Object, Object> argMap = new HashMap<Object, Object>();
		// 获取菜单
		argMap.put("menu", true);
		List<Object> categorylist = _webAdpater.selectCategoryList(argMap);
		//二手房模块广告位
		argMap.put("adtypeid", "28020150"); 
		argMap.put("counts", "5"); 
		rootMap.put("lstWebAd", _webAdMangerAdpater.selectAllByMapParam("selectWebAdInfoByAdTypeIdByOrder", argMap));
		argMap.put("adtypeid", "28024470"); 
		argMap.put("counts", "2"); 
		rootMap.put("lsttopWebAd", _webAdMangerAdpater.selectAllByMapParam("selectWebAdInfoByAdTypeIdByOrder", argMap));
		// 获得房管快讯
		argMap = new HashMap<Object, Object>();
		argMap.put("categoryid", 13);
		List<Object> kuaixunlist = _webAdpater.selectContentListByMap(argMap);
		// 通知公告
		argMap = new HashMap<Object, Object>();
		argMap.put("categoryid", 14);
		List<Object> tongzhilist = _webAdpater.selectContentListByMap(argMap);
		
		//白蚁防治列表
		argMap.put("categoryid", 28027158);
		List<Object> byfzlist = _webAdpater.selectContentListByMap(argMap);
		
		argMap.put("categoryid", 28020203);
		List<Object> gongshilist = _webAdpater.selectContentListByMap(argMap);
		
		//中介机构
		argMap.put("categoryid", 28022201);
		List<Object> zhongjiejglist = _webAdpater.selectContentListByMap(argMap);
		//物业服务
		argMap.put("categoryid", 28022202);
		List<Object> wuyefwlist = _webAdpater.selectContentListByMap(argMap);
		//开发公司
		argMap.put("categoryid", 28022204);
		List<Object> developerlist = _webAdpater.selectContentListByMap(argMap);
		// 今日/上月成交
		List<Object> dailylist = _webAdpater.selectStatisticForDay();
		List<Object> monthlylist = _webAdpater.selectStatisticForMonth();
		// 二手房签约
	    List<Object> useddailylist = _webAdpater.selectUsedStatisticForDay();
		// 最新预售证公示
		List<Object> preselllist = _webAdpater.selectPresellNew15();
		// 办事指南
		argMap = new HashMap<Object, Object>();
		argMap.put("pid", 11);
		List<Object> banshilist = _webAdpater.selectContentListByMap(argMap);
		List<Object> banshigxlist = _webAdpater.selectContentCategoryList(argMap);
		argMap.put("isdisplay", 1);
		List<Object> banshizhinanlist = _webAdpater.selectCategoryList(argMap);
		// 法律法规
		argMap = new HashMap<Object, Object>();
		argMap.put("pid", 9);
		List<Object> falvlist = _webAdpater.selectContentListByMap(argMap);
		List<Object> guanxilist = _webAdpater.selectContentCategoryList(argMap);
		argMap.put("isdisplay", 1);
		List<Object> falvmenulist = _webAdpater.selectCategoryList(argMap);
		
		// 右边
		// 咨询常见问题
		List<Object> complaintlist = _webAdpater.selectComplaintList(null);
		// 开发公司
//		List<Object> developerlist = _webAdpater.selectDeveloperList();
//		argMap = new HashMap<Object, Object>();
		
		// 网上调查,改为房地产协会中的信息
		argMap = new HashMap<Object, Object>();
		argMap.put("categoryid", 28020229);
		List<Object> fdcxhlist = _webAdpater.selectContentListByMap(argMap);
		
		//白蚁防治
		argMap.put("releasemark", "1");//发布标记
		argMap.put("counts", "1");
		argMap.put("categoryid", 28027158);
		rootMap.put("byfz", _webAdpater.selectContentinfoByMap(argMap));
		rootMap.put("byfzid", 28027158);

		// 装填
		rootMap.put("categorylist", categorylist);
		rootMap.put("kuaixunlist", kuaixunlist);
		rootMap.put("tongzhilist", tongzhilist);
		rootMap.put("gongshilist", gongshilist);
		rootMap.put("dailylist", dailylist);
		rootMap.put("monthlylist", monthlylist);
		rootMap.put("useddailylist", useddailylist);
		rootMap.put("preselllist", preselllist);
		rootMap.put("banshigxlist", banshigxlist);
		rootMap.put("banshizhinanlist", banshizhinanlist);
		rootMap.put("banshilist", banshilist);
		rootMap.put("falvmenulist", falvmenulist);
		rootMap.put("falvlist", falvlist);
		rootMap.put("zhongjiejglist", zhongjiejglist);
		rootMap.put("wuyefwlist", wuyefwlist);
		rootMap.put("guanxilist", guanxilist);
		rootMap.put("complaintlist", complaintlist);
		rootMap.put("developerlist", developerlist);
		rootMap.put("fdcxhlist", fdcxhlist);
		rootMap.put("byfzlist", byfzlist);
		
		return GenerateHtml(rootMap, template, target);
	}
	
	/**
	 * 获取领证公告的方法
	 */
	private void getLzgg() {
		Thread lzgg = new Thread(new LzggThread());
		lzgg.start();
	}

	/**
	 * 获取领证公告的新线程
	 * 
	 */
	class LzggThread implements Runnable {
		@Override
		public void run() {
			HashMap<String, Object> rootMap = new HashMap<String, Object>();
			// 领证公告
			List<String> noticelist = _webAdpater.selectNoticeList();
			rootMap.put("noticelist", noticelist);
			GenerateHtml(rootMap, "/template/lzgg.js.ftl", "/js/lzgg.js");
			Thread self = Thread.currentThread();
			if(self.isAlive()) {
				try{
					self.interrupt();
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}
	
	private boolean fdcxh(String template, String target) {
		HashMap<String, Object> rootMap = new HashMap<String, Object>();
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("releasemark", "1");//发布标记
		//协会介绍——第一排右侧
		map.put("counts", "1");
		map.put("categoryid", 28020177);
		rootMap.put("xhjj", _webAdpater.selectContentinfoByMap(map));
		map.put("categoryid", 28020178);
		rootMap.put("xhzc", _webAdpater.selectContentinfoByMap(map));
		map.put("categoryid", 28020179);
		rootMap.put("zzjg", _webAdpater.selectContentinfoByMap(map));
		//公告通知——第二排左侧
		map.put("counts", "7");
		map.put("categoryid", 28020181);
		rootMap.put("ggtz", _webAdpater.selectContentinfoByMap(map));
		//房产新闻——第二排中间
		map.put("categoryid", 28020229);
		rootMap.put("fcxw", _webAdpater.selectContentinfoByMap(map));
		//楼市——第二排右侧
		map.put("categoryid", 28020232);
		rootMap.put("lsrpid",28020232);
		rootMap.put("lsrp", _webAdpater.selectContentinfoByMap(map));
		map.put("categoryid", 28020231);
		rootMap.put("xslsid",28020231);
		rootMap.put("xsls", _webAdpater.selectContentinfoByMap(map));
		//会员——第三排左侧
		map.put("categoryid", 28020240);
		rootMap.put("hydtid",28020240);
		rootMap.put("hydt", _webAdpater.selectContentinfoByMap(map));
		map.put("categoryid", 28020241);
		rootMap.put("hyfcid",28020241);
		rootMap.put("hyfc", _webAdpater.selectContentinfoByMap(map));
		map.put("categoryid", 28020243);
		rootMap.put("rhznid",28020243);
		rootMap.put("rhzn", _webAdpater.selectContentinfoByMap(map));
		//协会——第三排中间
		map.put("categoryid", 28020182);
		rootMap.put("xhywid",28020182);
		rootMap.put("xhyw", _webAdpater.selectContentinfoByMap(map));
		map.put("categoryid", 28020183);
		rootMap.put("xhtxid",28020183);
		rootMap.put("xhtx", _webAdpater.selectContentinfoByMap(map));
		map.put("categoryid", 28020184);
		rootMap.put("hwgkid",28020184);
		rootMap.put("hwgk", _webAdpater.selectContentinfoByMap(map));
		//政策法规——第三排右侧
		map.put("categoryid", 28020230);
		rootMap.put("zcfg", _webAdpater.selectContentinfoByMap(map));
		//培训信息——底部左侧
		map.put("categoryid", 28020245);
		rootMap.put("pxxx", _webAdpater.selectContentinfoByMap(map));
		//下载中心——底部右侧
		map.put("categoryid", 28020246);
		rootMap.put("xzzx", _webAdpater.selectContentinfoByMap(map));
		//最新资讯——第一排左侧
		map.put("categoryid", 28020228);//房产资讯
		rootMap.put("fdcnewinfo", _webAdpater.selectContentinfoByMap(map));
		map.put("recommendflag", 1);//推荐
		map.put("hotflag", 1);//热点
		map.put("categoryid", 28020168);//查找协会动态
		rootMap.put("hotlink", _webAdpater.selectContentinfoByMap(map));
		map.put("categoryid", 28020228);//查找房产资讯_头条
		rootMap.put("fdcnewinfohead", _webAdpater.selectContentinfoByMap(map));
		//模块广告位
		map = new HashMap<Object, Object>();
		map.put("adtypeid", "28020591"); 
		map.put("counts", "5"); 
		rootMap.put("fdcxhWebAd", _webAdMangerAdpater.selectAllByMapParam("selectWebAdInfoByAdTypeIdByOrder", map));
		//获取菜单
		rootMap.put("xhgsid", 28020167);//协会概述
		rootMap.put("xhdtid", 28020168);//协会动态
		rootMap.put("fczxid", 28020228);//房产资讯
		rootMap.put("xhyhid", 28020239);//会员之家
		rootMap.put("xhfwid", 28020244);//协会服务
		return GenerateHtml(rootMap, template, target);
	}
	
	private boolean zjxh(String template, String target) {
		HashMap<String, Object> rootMap = new HashMap<String, Object>();
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("releasemark", "1");//发布标记
		// 模块广告位
		map = new HashMap<Object, Object>();
		map.put("adtypeid", "28020592");
		map.put("counts", 5);
		rootMap.put("fdcxhWebAd", _webAdMangerAdpater.selectAllByMapParam("selectWebAdInfoByAdTypeIdByOrder", map));
		map.put("counts", 8);
		map.put("categoryid", 1000);
		rootMap.put("toplist", _webAdpater.selectContentinfoByMap(map));
		// 政策法规
		map.put("counts", 7);
		map.put("categoryid", 1001);
		rootMap.put("zcfglist", _webAdpater.selectContentinfoByMap(map));
		// 协会新闻
		map.put("categoryid", 1002);
		rootMap.put("xsxwlist", _webAdpater.selectContentinfoByMap(map));
		// 通知公告
		map.put("categoryid", 1003);
		rootMap.put("tzgglist", _webAdpater.selectContentinfoByMap(map));
		// 会员单位
		map.put("categoryid", 1004);
		rootMap.put("hydwlist", _webAdpater.selectContentinfoByMap(map));
		// 资料下载
		map.put("categoryid", 1005);
		rootMap.put("zlxzlist", _webAdpater.selectContentinfoByMap(map));
		return GenerateHtml(rootMap, template, target);
	}
	// 预览编辑
	public String toEdit() {
		ServletContext svtContext = ServletActionContext.getServletContext();
		String FilePath = svtContext.getRealPath("/");
		webStatictask = (WebStatictask) _webAdMangerAdpater.selectByPrimaryKey(TablesNameConstants.WEB_STATICTASK, webStatictask.getStatictaskid());
		if (webStatictask != null) {
			contentHtml = FileUtil.FileRead(FilePath + webStatictask.getStaticpath(), "UTF-8");
		}
		return "statictaskinfo";
	}

	// 编辑生成的结果
	public void save() {
		// 保存编辑静态化html到硬盘中
		ServletContext svtContext = ServletActionContext.getServletContext();
		String FilePath = svtContext.getRealPath("/");
		if (webStatictask != null) {
			webStatictask = (WebStatictask) _webAdMangerAdpater.selectByPrimaryKey(TablesNameConstants.WEB_STATICTASK, webStatictask.getStatictaskid());
			FileUtil.FileWrite(contentHtml, FilePath + webStatictask.getStaticpath(), "UTF-8");
		}
		this.renderText("{'flag':true,'returnMsg':'保存修改成功！'}");
	}
	
	public WebStatictask getWebStatictask() {
		return webStatictask;
	}

	public void setWebStatictask(WebStatictask webStatictask) {
		this.webStatictask = webStatictask;
	}

	public WebAdMangerAdpater getWebAdMangerAdpater() {
		return _webAdMangerAdpater;
	}

	public void setWebAdMangerAdpater(WebAdMangerAdpater webAdMangerAdpater) {
		_webAdMangerAdpater = webAdMangerAdpater;
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

	public String getContentHtml() {
		return contentHtml;
	}

	public void setContentHtml(String contentHtml) {
		this.contentHtml = contentHtml;
	}

	public WebAdpater getWebAdpater() {
		return _webAdpater;
	}

	public void setWebAdpater(WebAdpater webAdpater) {
		_webAdpater = webAdpater;
	}
	
}
