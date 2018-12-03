package com.hzfc.superadmin.assist.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;


import com.hzfc.common.action.SuperAction;
import com.hzfc.superadmin.assist.adpater.AssistAdpater;
import com.hzfc.superadmin.assist.entity.DicItems;
import com.hzfc.superadmin.assist.entity.DicType;
import com.hzfc.utils.QueryCondition;
import com.hzfc.utils.TablesNameConstants;

@SuppressWarnings("serial")
public class DicAction extends SuperAction{
	
	private AssistAdpater _assistAdpater;
	private DicType dicType;
	private DicItems dicItems;
	private String codetype;
	private int page;//当前第几页
	private int rp;//每页显示条数

	public String toList(){
		if(page == 0){
			page = 1;
		}
		return "list";
	}
	
	public String toItemsList(){		
		if(page == 0){
			page = 1;
		}
		return "itemslist";
	}
	
	public String toItemsListBack(){
		if(dicType.getCodeid() != null && StringUtils.isNotBlank(dicType.getCodeid().toString())){
			dicType = (DicType) _assistAdpater.selectByPrimaryKey(TablesNameConstants.T_ESF_CODETYPE, dicType.getCodeid());
		}
		
		if(page == 0){
			page = 1;
		}
		return "itemslist";
	}
	
	public void getList(){
		QueryCondition queryCondition = new QueryCondition();
		queryCondition.setCurrentPageNo(page);
		queryCondition.getPage().setPagesizeValue(rp);
		
		if(StringUtils.isNotBlank((String)getParameterValue("starttime"))){
			queryCondition.setCondition("starttime", getParameterValue("starttime"));
		}
		if(StringUtils.isNotBlank((String)getParameterValue("endtime"))){
			queryCondition.setCondition("endtime", getParameterValue("endtime"));
		}
		if (StringUtils.isNotBlank((String) getParameterValue("keywords").toString().trim())) {
			queryCondition.setCondition("keywords", "%" + getParameterValue("keywords").toString().trim() + "%");
		}
		
		List<Object> list = _assistAdpater.selectPageByQueryCondition("T_ESF_CODETYPE_selectPageByQueryCondition", queryCondition);
		JSONArray items = new JSONArray();
		for(int i=0;i<list.size();i++){
			JSONObject item = new JSONObject();
			DicType dicTypes = (DicType)list.get(i);
			item.put("cell", 
					new Object[]{
						dicTypes.getCodetype(),
						dicTypes.getCodename(),
						dicTypes.getOrderid(),
						dicTypes.getModtime(),
						
						"<a href='javascript:check(\""
						+ dicTypes.getCodeid()
						+ "\");'>查看</a> | <a href='javascript:edit(\""
						+ dicTypes.getCodeid()
						+ "\");'>编辑</a>"
			});
			items.add(item);		
		}
		JSONObject json = new JSONObject();
		json.put("page", page);
		json.put("total", queryCondition.getPage().getTotalrows());
		json.put("rows", items);
		this.renderText(json.toString());
		
	}
	
	public String toInfo(){
		if(dicType.getCodeid() != null && StringUtils.isNotBlank(dicType.getCodeid().toString())){
			dicType = (DicType) _assistAdpater.selectByPrimaryKey(TablesNameConstants.T_ESF_CODETYPE, dicType.getCodeid());
		}
		return "info";
	}
	
	public String toItemsInfo(){
		if(dicType.getCodeid() != null && StringUtils.isNotBlank(dicType.getCodeid().toString())){
			dicType = (DicType) _assistAdpater.selectByPrimaryKey(TablesNameConstants.T_ESF_CODETYPE, dicType.getCodeid());
		}
		
		if(dicItems.getItemid() != null && StringUtils.isNotBlank(dicItems.getItemid().toString())){
			dicItems = (DicItems) _assistAdpater.selectByPrimaryKey(TablesNameConstants.T_ESF_CODEITEMS, dicItems.getItemid());			
		}
		
		return "infoItems";
	}
	
	public void delete(){
		if(dicType.getCodeid() != null && StringUtils.isNotBlank(dicType.getCodeid().toString())){
			_assistAdpater.deleteByPrimaryKey(TablesNameConstants.T_ESF_CODETYPE, dicType.getCodeid());
			this.renderText("{'flag':true,'returnMsg':'删除成功！'}");
		}else{
			this.renderText("{'flag':true,'returnMsg':'操作失败！'}");
		}
	}
	
	public void deleteItem(){
		if(dicItems.getItemid() != null && StringUtils.isNotBlank(dicItems.getItemid().toString())){
			_assistAdpater.deleteByPrimaryKey(TablesNameConstants.T_ESF_CODEITEMS, dicItems.getItemid());
			this.renderText("{'flag':true,'returnMsg':'删除成功！'}");
		}else{
			this.renderText("{'flag':true,'returnMsg':'操作失败！'}");
		}
	}
	public void save(){
		if(dicType.getCodeid() != null && StringUtils.isNotBlank(dicType.getCodeid().toString())){
			_assistAdpater.updateByPrimaryKey(TablesNameConstants.T_ESF_CODETYPE, dicType);
		}else{
			_assistAdpater.insert(TablesNameConstants.T_ESF_CODETYPE, dicType);			
		}
		this.renderText("{'flag':true,'returnMsg':'保存成功！'}");		
	}
	
	public void saveItems(){
		if(dicItems.getItemid() != null && StringUtils.isNotBlank(dicItems.getItemid().toString())){
			_assistAdpater.updateByPrimaryKey(TablesNameConstants.T_ESF_CODEITEMS, dicItems);
		}else{
			_assistAdpater.insert(TablesNameConstants.T_ESF_CODEITEMS, dicItems);
		}
		this.renderText("{'flag':true,'returnMsg':'保存成功！'}");
	}
	
	public void checkInfo(){
		QueryCondition queryCondition = new QueryCondition();
		queryCondition.setCurrentPageNo(page);
		queryCondition.getPage().setPagesizeValue(rp);
		queryCondition.setCondition("codeid", getParameterValue("codeid"));	
		List<Object> list = _assistAdpater.selectPageByQueryCondition("T_ESF_CODEITEMS_selectPageByQueryCondition", queryCondition);
		JSONArray items = new JSONArray();
		for(int i=0;i<list.size();i++){
			JSONObject item = new JSONObject();
			DicItems dicItems = (DicItems)list.get(i);
			if(dicItems.getIsdelete() == 1){
				item.put("cell", 
						new Object[]{
							dicItems.getCodetype(),
							dicItems.getItemname(),
							dicItems.getItemvalue(),
							dicItems.getOrderid(),
							dicItems.getIsapply() == 1 ? "使用" : "不使用",
							dicItems.getIsdisplay() == 1 ? "显示" : "不显示",
							dicItems.getModtime(),
							"<a href='javascript:edit(\""
							+ dicItems.getItemid()
							+ "\");'>编辑</a> | <a href='javascript:remove(\""
							+ dicItems.getItemid() + "\");' >移除</a>"
				});
			}else{
				item.put("cell", 
						new Object[]{
							dicItems.getCodetype(),
							dicItems.getItemname(),
							dicItems.getItemvalue(),
							dicItems.getOrderid(),
							dicItems.getIsapply() == 1 ? "使用" : "不使用",
							dicItems.getIsdisplay() == 1 ? "显示" : "不显示",
							dicItems.getModtime(),
							"<a href='javascript:edit(\""
							+ dicItems.getItemid()
							+ "\");'>编辑</a>"
				});
			}
			
			items.add(item);		
		}
		JSONObject json = new JSONObject();
		json.put("page", page);
		json.put("total", queryCondition.getPage().getTotalrows());
		json.put("rows", items);
		this.renderText(json.toString());
		
	}

	public void checkDicType(){
		codetype = (String)getParameterValue("codetype");
		//flag true数据库数据为空
		boolean flag = _assistAdpater.isExistCodetype(TablesNameConstants.T_ESF_CODETYPE, codetype);
		if(!flag){
			this.renderText("{'flag':true,'returnMsg':'类型编码已存在！'}");
		}else{
			this.renderText("{'flag':false}");
		}
	}
	
	public void checkItemvalueIsOnly(){
		Map<String , String> map = new HashMap<String, String>();
		String itemvalue = (String)getParameterValue("itemvalue");
		String codetype = (String)getParameterValue("codetype");
		map.put("itemvalue", itemvalue);
		map.put("codetype", codetype);
		DicItems d = _assistAdpater.selectExistCodeItemByItemvalue(map);
		if(d != null){
			this.renderText("{'flag':true,'returnMsg':'值重复！'}");
		}else{
			this.renderText("{'flag':false}");
		}
	}
	

	public AssistAdpater getAssistAdpater() {
		return _assistAdpater;
	}

	public void setAssistAdpater(AssistAdpater assistAdpater) {
		_assistAdpater = assistAdpater;
	}

	public DicType getDicType() {
		return dicType;
	}

	public void setDicType(DicType dicType) {
		this.dicType = dicType;
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

	public DicItems getDicItems() {
		return dicItems;
	}

	public void setDicItems(DicItems dicItems) {
		this.dicItems = dicItems;
	}

	public String getCodetype() {
		return codetype;
	}

	public void setCodetype(String codetype) {
		this.codetype = codetype;
	}

	

}
