package com.hzfc.superadmin.ad.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.hzfc.utils.DateUtil;
import com.hzfc.common.action.SuperAction;
import com.hzfc.superadmin.ad.adpater.WebAdMangerAdpater;
import com.hzfc.superadmin.ad.entity.WebAdInfo;
import com.hzfc.superadmin.ad.entity.WebAdType;
import com.hzfc.utils.FileOperUtils;
import com.hzfc.utils.QueryCondition;
import com.hzfc.utils.TablesNameConstants;



@SuppressWarnings("serial")
public class WebAdMangerAction extends SuperAction{

	private WebAdMangerAdpater _webAdMangerAdpater;
	
	private WebAdType webAdType;
	private WebAdInfo webAdInfo;
	
	private int page; 
	
	private int rp; 
	
	//***************广告位类型***************//
	
	public String toTypeList(){
		setRequestAttribute("websiteList", _webAdMangerAdpater.selectByStatementid("T_WEBSITE_selectByStatementidForSelect"));
		//页面索引
		setRequestAttribute("seatlist", _webAdMangerAdpater.selectKeyListByKeycode("WEB_ADTYPE_SEATINFO"));
		if(page == 0){
			page = 1;
		}
		return "typelist";
	}
	
	public void getTypeList() {
		
		QueryCondition queryCondition = new QueryCondition();
		// 查询设置当前页
		queryCondition.setCurrentPageNo(page);
		
		// 设置每页显示数
		queryCondition.getPage().setPagesizeValue(rp);
		
		if (StringUtils.isNotBlank((String) getParameterValue("keywords")) || StringUtils.isNotBlank((String) getParameterValue("seatinfo"))) {
			String keywords = "";
			if(StringUtils.isNotBlank((String) getParameterValue("keywords"))){
				if(StringUtils.isNotBlank((String) getParameterValue("seatinfo"))){
					String[] key = getParameterValue("keywords").toString().split(" ");
					keywords = "WEB_ADTYPE.SEATINFO like " 
									+ "'%" + getParameterValue("seatinfo").toString() + "%'";
					for (int i=0; i<key.length; i++){
						keywords = keywords + " and WEB_ADTYPE.SEATINFO like " + "'%" + key[i] + "%'";
					}
				}else{
					String[] key = getParameterValue("keywords").toString().split(" ");
					for (int i=1; i<key.length; i++){
						keywords = keywords + " and WEB_ADTYPE.SEATINFO like " + "'%" + key[i] + "%'";
					}
					keywords = "WEB_ADTYPE.SEATINFO like " + "'%" + key[0] + "%'" + keywords;
				}
			}else{
				keywords = "WEB_ADTYPE.SEATINFO like " + "'%" + getParameterValue("seatinfo").toString() + "%'";
			}
			
			queryCondition.setCondition("keywords", keywords);
			
			//queryCondition.setCondition("keywords", "%" + getParameterValue("keywords").toString().trim() + "%");
		}
//		if (StringUtils.isNotBlank((String) getParameterValue("siteid"))) {
//			queryCondition.setCondition("siteid", getParameterValue("siteid"));
//		}
		
		List<Object> list = _webAdMangerAdpater.selectPageByQueryCondition("WEB_ADTYPE_selectPageByQueryCondition", queryCondition);
		JSONArray items = new JSONArray();
		for (int i = 0; i < list.size(); i++) {
			JSONObject item = new JSONObject();
			WebAdType e = (WebAdType) list.get(i);
			
			item.put(
					"cell",
					new Object[] {
							e.getAdtypeid(),
							e.getSeatinfo(),
							e.getOrderid(),
							e.getUpdatetime(),
							"<a href='javascript:edit(\""
							+ e.getAdtypeid()
							+ "\");'>编辑</a> | <a href='javascript:check(\""+ e.getAdtypeid() 
							+ "\");' >查看广告</a>"
					});
			items.add(item);
		}
		JSONObject json = new JSONObject();
		json.put("page", page);
		json.put("total", queryCondition.getPage().getTotalrows());
		json.put("rows", items);
		this.renderText(json.toString());
	}
	
	public String toTypeInfo(){
		//数据准备
		//setRequestAttribute("webAdTypeList", _webAdMangerAdpater.selectAllByMapParam("WEB_ADTYPE_selectAllByMapParamForSelect", new HashMap()));
		//setRequestAttribute("websiteList", _webAdMangerAdpater.selectByStatementid("T_WEBSITE_selectByStatementidForSelect"));
		if(webAdType.getAdtypeid() != null && StringUtils.isNotBlank(webAdType.getAdtypeid().toString())){
			webAdType = (WebAdType) _webAdMangerAdpater.selectByPrimaryKey(TablesNameConstants.WEB_ADTYPE, webAdType.getAdtypeid());
		}
		return "typeinfo";
	}
	
	public void saveType() {
		if (webAdType.getAdtypeid() != null && StringUtils.isNotBlank(webAdType.getAdtypeid().toString())) {
			webAdType.setUpdatetime("sysdate");
			_webAdMangerAdpater.updateByPrimaryKeySelective(TablesNameConstants.WEB_ADTYPE, webAdType);
		}else {
			webAdType.setWebseatid((long)0);
			_webAdMangerAdpater.insert(TablesNameConstants.WEB_ADTYPE, webAdType);
		}
		this.renderText("{'flag':true,'returnMsg':'保存成功！'}");
	}
	
	public void deleteType(){
		if(_webAdMangerAdpater.deleteType(Long.valueOf((String)getParameterValue("adtypeid")))){
			this.renderText("{'flag':true,'returnMsg':'删除成功！'}");
		}
		else {
			this.renderText("{'flag':false,'returnMsg':'分类仍在使用，操作失败！'}");
		}
	}
	
	//获取广告位位置
	public void getTypeOtherList() {
		
		QueryCondition queryCondition = new QueryCondition();
		queryCondition.setCurrentPageNo(page);
		queryCondition.getPage().setPagesizeValue(rp);
		String key = (String) getParameterValue("query");
		
		if (StringUtils.isNotBlank(key)) {
			queryCondition.setCondition("keywords", "%" + key + "%");
		}
		
		List<Object> list = _webAdMangerAdpater.selectPageByQueryCondition("WEB_ADTYPE_selectSeatinfoPageByQueryCondition", queryCondition);
		JSONArray items = new JSONArray();
		for (int i = 0; i < list.size(); i++) {
			JSONObject item = new JSONObject();
			WebAdType e = (WebAdType) list.get(i);
			item.put(
					"cell",
					new Object[] {
							e.getAdtypeid(),
							e.getSeatinfo(),
							"<a href='javascript:select(\""
							+ e.getAdtypeid()
							+ "\" ,\"" + e.getSeatinfo() + "\" );'>选择</a>"
					});
			items.add(item);
		}
		JSONObject json = new JSONObject();
		json.put("page", page);
		json.put("total", queryCondition.getPage().getTotalrows());
		json.put("rows", items);
		this.renderText(json.toString());
	}
	
	
	//***************广告信息***************//
	
	public String toInfoList(){
		if(page == 0){
			page = 1;
		}
		return "adinfolist";
	}
	
	public void getInfoList() {
		
		QueryCondition queryCondition = new QueryCondition();
		// 查询设置当前页
		queryCondition.setCurrentPageNo(page);
		// 设置每页显示数
		queryCondition.getPage().setPagesizeValue(rp);
		
		if (StringUtils.isNotBlank((String) getParameterValue("adtypeid"))) {
			queryCondition.setCondition("adtypeid", getParameterValue("adtypeid"));
		}
		if (StringUtils.isNotBlank((String) getParameterValue("keywords"))) {
			queryCondition.setCondition("keywords", "%" + getParameterValue("keywords").toString().trim() + "%");
		}
		if (StringUtils.isNotBlank((String) getParameterValue("rsstype"))) {
			queryCondition.setCondition("rsstype", getParameterValue("rsstype"));
		}
		if (StringUtils.isNotBlank((String) getParameterValue("isdisplay"))) {
			queryCondition.setCondition("isdisplay", getParameterValue("isdisplay"));
		}
		if (StringUtils.isNotBlank((String)getParameterValue("starttime"))) {
			queryCondition.setCondition("starttime", getParameterValue("starttime"));
		}
		if (StringUtils.isNotBlank((String) getParameterValue("endtime"))) {
			queryCondition.setCondition("endtime",  getParameterValue("endtime").toString().trim());
		}
		
		
		List<Object> list = _webAdMangerAdpater.selectPageByQueryCondition(
				"WEB_ADINFO_selectPageByQueryCondition", queryCondition);
		JSONArray items = new JSONArray();
		for (int i = 0; i < list.size(); i++) {
			JSONObject item = new JSONObject();
			WebAdInfo e = (WebAdInfo) list.get(i);
			
			item.put(
					"cell",
					new Object[] {
							e.getAdid(),
							//e.getAdtypeid(),
							e.getRsstype() == 1 ? "图片" :"Flash",
							e.getSeatinfo(),
							e.getDescr(),
							e.getOrderid(),
							e.getIsdisplay() == 1 ? "<a href='javascript:checkDisplay(\"" + e.getAdid() + "\",\"0\");'>显示</a>" :
								"<a href='javascript:checkDisplay(\"" + e.getAdid() + "\",\"1\");'>未显示</a>",
							e.getBegintime(),
							e.getEndtime(),
							//e.getLinkurl(),
							"<a href='javascript:edit(\""
							+ e.getAdid()
							+ "\");'>编辑</a> | <a href='javascript:remove(\""
							+ e.getAdid() + "\");' >移除</a>"
							
					});
			items.add(item);
		}
		JSONObject json = new JSONObject();
		json.put("page", page);
		json.put("total", queryCondition.getPage().getTotalrows());
		json.put("rows", items);
		this.renderText(json.toString());
	}
	
	public void checkDisplay(){
		if (webAdInfo.getAdid() != null && StringUtils.isNotBlank(webAdInfo.getAdid().toString())) {
			_webAdMangerAdpater.updateByPrimaryKeySelective(TablesNameConstants.WEB_ADINFO,webAdInfo);
			this.renderText("{'flag':true}");
		}
		else {
			this.renderText("{'flag':false}");
		}
	}
	
	public String toAdInfo(){
		
		/*
		if(webAdInfo.getAdid() != null && StringUtils.isNotBlank(webAdInfo.getAdid().toString())){
			//修改广告记录的时候 可选择的位置为空闲位置和当前自己的位置
			webAdInfo = (WebAdInfo) _webAdMangerAdpater.selectByPrimaryKey(TablesNameConstants.WEB_ADINFO, webAdInfo.getAdid());
			QueryCondition queryCondition = new QueryCondition();
			queryCondition.setCondition("adtypeid",  webAdInfo.getAdtypeid());
			
			List<Object> list = _webAdMangerAdpater.selectMyAllByMapParam("WEB_ADTYPE_selectAllByMapParamForAdInfoSelect", queryCondition);
			setRequestAttribute("webAdTypeList", list);
			
		}else{
			//新增广告记录的时候 可选择的位置只是空闲的位置
			setRequestAttribute("webAdTypeList", _webAdMangerAdpater.selectAllByMapParam("WEB_ADTYPE_selectAllByMapParamForAdInfoSelect", new HashMap()));
		}
		*/
		setRequestAttribute("webAdTypeList", _webAdMangerAdpater.selectAllByMapParam("WEB_ADTYPE_selectAllByMapParamForSelect", new HashMap()));
		if(webAdInfo.getAdid() != null && StringUtils.isNotBlank(webAdInfo.getAdid().toString())){
			webAdInfo = (WebAdInfo) _webAdMangerAdpater.selectByPrimaryKey(TablesNameConstants.WEB_ADINFO, webAdInfo.getAdid());
		}
		return "adinfo";
	}
	
	//广告的图片上传
	public void saveAdInfo() {
		
		if(StringUtils.isNotBlank(webAdInfo.getNewpath())){
			//复制广告资源去WEBAD目录下删除零时目录下文件
			FileOperUtils fileOpenUtils = new FileOperUtils();
			String newpath = webAdInfo.getNewpath().replaceAll("tempfile", "webad/"+ DateUtil.getDateFromDate(new Date(), "yyyyMMdd").toString());
			fileOpenUtils.copyfile(getWebRootDir() + webAdInfo.getNewpath(), getWebRootDir() + newpath);
			webAdInfo.setNewpath(newpath);
		}
			_webAdMangerAdpater.saveAdInfo(TablesNameConstants.WEB_ADINFO, webAdInfo);
			this.renderText("{'flag':true,'returnMsg':'保存成功！'}");
		}
	
	public void deleteAdInfo(){
		
		webAdInfo = (WebAdInfo) _webAdMangerAdpater.selectByPrimaryKey(TablesNameConstants.WEB_ADINFO, Long.valueOf((String)getParameterValue("adid")));
		if(StringUtils.isNotBlank(webAdInfo.getAdpath())){
			//删除此记录时候连同广告资源一起删除
			FileOperUtils fileOpenUtils = new FileOperUtils();
			fileOpenUtils.remove(webAdInfo.getAdpath());
		}
		if(_webAdMangerAdpater.deleteAdInfo(Long.valueOf((String)getParameterValue("adid")))){
			this.renderText("{'flag':true,'returnMsg':'删除成功！'}");
		}
	}
	
	//***************set get方法***************//
	
	public WebAdMangerAdpater getWebAdMangerAdpater() {
		return _webAdMangerAdpater;
	}

	public void setWebAdMangerAdpater(WebAdMangerAdpater adMangerAdpater) {
		_webAdMangerAdpater = adMangerAdpater;
	}

	public WebAdType getWebAdType() {
		return webAdType;
	}

	public void setWebAdType(WebAdType webAdType) {
		this.webAdType = webAdType;
	}
	
	public WebAdInfo getWebAdInfo() {
		return webAdInfo;
	}

	public void setWebAdInfo(WebAdInfo webAdInfo) {
		this.webAdInfo = webAdInfo;
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
