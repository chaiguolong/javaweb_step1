package com.hzfc.superadmin.newscontent.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


import com.hzfc.common.action.SuperAction;
import com.hzfc.superadmin.framework.entity.SysAccount;
import com.hzfc.superadmin.newscontent.adpater.NewsContentAdpater;
import com.hzfc.superadmin.newscontent.entity.Complaint;
import com.hzfc.utils.QueryCondition;
import com.hzfc.utils.TablesNameConstants;

@SuppressWarnings("serial")
public class ComplaintAction extends SuperAction{
	
	private NewsContentAdpater _newsContentAdpater;
	
	private int page; // 当前第几页
	
	private int rp; // 每页显示条数
	
	private Complaint complaint;
	
	public String toCateList(){
		SysAccount sysAccount = ((SysAccount) getSessionObj("sessionsuperadmin"));
		if(sysAccount != null){
			if(page == 0){
				page = 1;
			}
			return "catelist";
		}
		else{
			return "404";
		}
	}
	
	public String toCateInfo(){
		SysAccount sysAccount = ((SysAccount) getSessionObj("sessionsuperadmin"));
		if(sysAccount != null){
			complaint = (Complaint)_newsContentAdpater.selectByPrimaryKey(TablesNameConstants.WEB_COMPLAINT, complaint.getComplaintid());
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			complaint.setTstime(df.format(new Date()));
			if(page == 0){
				page = 1;
			}
			return "cateinfo";
		}
		else{
			return "404";
		}
	}
	//新闻列表
	public void getCateList(){
		QueryCondition queryCondition = new QueryCondition();
		// 查询设置当前页
		queryCondition.setCurrentPageNo(page);
		// 设置每页显示数
		queryCondition.getPage().setPagesizeValue(rp);
		
		if (StringUtils.isNotBlank((String) getParameterValue("isdisplay"))) {
			queryCondition.setCondition("isdisplay", getParameterValue("isdisplay"));
		}
		if (StringUtils.isNotBlank((String) getParameterValue("state"))) {
			queryCondition.setCondition("state", getParameterValue("state"));
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
				"WEB_COMPLAINT_selectPageByQueryCondition", queryCondition);
		JSONArray items = new JSONArray();
		for (int i = 0; i < list.size(); i++) {
			JSONObject item = new JSONObject();
			Complaint n = (Complaint) list.get(i);
			item.put(
					"cell",
					new Object[] {
						n.getComplaintid(),
						n.getInfotitle(),
						n.getAddtime(),
						n.getComplaintname(),
						n.getDevelopername(),
						n.getIsdisplay() == 0 ? "<a href='javascript:isdisplay(\"" + n.getComplaintid() + "\",\"1\");'>不显示</a>" :
							"<a href='javascript:isdisplay(\"" + n.getComplaintid() + "\",\"0\");'>显示</a>",
						n.getState() == 0 ? "<font color=grey>未解答</font>" : "<font color=red>已解答</font>",
						n.getReplyname(),
						n.getReplytime(),
						"<a href='javascript:edit(\"" + n.getComplaintid() + "\");'>编辑</a> " + " | " +
						"<a href='javascript:remove(\""+ n.getComplaintid() + "\");' >删除</a>"
					});
			items.add(item);
		}
		JSONObject json = new JSONObject();
		json.put("page", page);
		json.put("total", queryCondition.getPage().getTotalrows());
		json.put("rows", items);
		this.renderText(json.toString());
	}
	
	
	//保存
	public void saveType(){
		SysAccount sysAccount = ((SysAccount) getSessionObj("sessionsuperadmin"));
		if(sysAccount != null){
			if (complaint.getComplaintid() != null && StringUtils.isNotBlank(complaint.getComplaintid().toString())) {
				complaint.setReplyname(sysAccount.getLoginuser());
				_newsContentAdpater.updateByPrimaryKeySelective(TablesNameConstants.WEB_COMPLAINT, complaint);
				this.renderText("{'flag':true,'returnMsg':'保存成功！'}");	
			}
			else{
				this.renderText("{'flag':false,'returnMsg':'保存失败！'}");
			}
		}else {
			this.renderText("{'flag':false,'returnMsg':'请重新登录！'}");
		}
	}
	
	//显示
	public void isdisplay(){
		if (complaint.getComplaintid() != null && StringUtils.isNotBlank(complaint.getComplaintid().toString())) {
			_newsContentAdpater.updateByPrimaryKeySelective(TablesNameConstants.WEB_COMPLAINT, complaint);
			this.renderText("{'flag':true}");
		}
		else {
			this.renderText("{'flag':false}");
		}
	}
	
	public void deleteType(){
		if (complaint.getComplaintid() != null && StringUtils.isNotBlank(complaint.getComplaintid().toString())) {
			_newsContentAdpater.deleteByPrimaryKey(TablesNameConstants.WEB_COMPLAINT, complaint.getComplaintid());
			this.renderText("{'flag':true,'returnMsg':'操作成功！'}");
		}
		else {
			this.renderText("{'flag':false,'returnMsg':'操作失败！'}");
		}
	}
	
	public Complaint getComplaint() {
		return complaint;
	}

	public void setComplaint(Complaint complaint) {
		this.complaint = complaint;
	}

	public NewsContentAdpater getNewsContentAdpater() {
		return _newsContentAdpater;
	}

	public void setNewsContentAdpater(NewsContentAdpater newsContentAdpater) {
		_newsContentAdpater = newsContentAdpater;
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
