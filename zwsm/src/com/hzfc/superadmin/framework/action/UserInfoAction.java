package com.hzfc.superadmin.framework.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;

import com.hzfc.common.action.SuperAction;
import com.hzfc.superadmin.ad.entity.WebStatictask;
import com.hzfc.superadmin.framework.adpater.UserInfomationAdpater;
import com.hzfc.superadmin.framework.entity.Department;
import com.hzfc.superadmin.framework.entity.UserAccount;
import com.hzfc.superadmin.framework.entity.UserDepartment;
import com.hzfc.superadmin.framework.entity.UserInfo;
import com.hzfc.superadmin.framework.entity.UserPosition;
import com.hzfc.superadmin.framework.entity.UserRole;
import com.hzfc.utils.QueryCondition;
import com.hzfc.utils.TablesNameConstants;

@SuppressWarnings("serial")
public class UserInfoAction extends SuperAction{
	private UserInfomationAdpater _userInfomationAdpater;
	private UserAccount userAccount;
	private UserInfo userInfo;
	private UserRole userRole;
	private Department department;
	private UserDepartment userDepartment;
	private UserPosition userPosition;
	private int page; // 当前第几页
	private int rp; // 每页显示条数
	
	public String toList() {
		if (page == 0) {
			page = 1;
		}
		return "list";
	}
	
	//获取明细页面
	public String toInfo() {
		setRequestAttribute("newsDepartmentList", _userInfomationAdpater.selectByStatementid("SYS_DEPARTMENT_selectByMapForSelect"));
		if(userInfo.getUserextid() != null && StringUtils.isNotBlank(userInfo.getUserextid().toString())){
			//取到明细的同时取到图片列表
			Map<String, String> map = new HashMap<String, String>();
			map.put("accountid", userInfo.getAccountid().toString());	
			userAccount = (UserAccount) _userInfomationAdpater.selectObjectByMapParam("SYS_ACCOUNT_selectUserLoginInfoByContentid", map);
		}
		return "info";
	}
	
	//获取用户信息列表
	public void getList() {

		QueryCondition queryCondition = new QueryCondition();
		// 查询设置当前页
		queryCondition.setCurrentPageNo(page);
		// 设置每页显示数
		queryCondition.getPage().setPagesizeValue(rp);
		
		if (StringUtils.isNotBlank((String) getParameterValue("keywords").toString().trim())) {
			queryCondition.setCondition("keywords", "%" + getParameterValue("keywords").toString().trim() + "%");
		}
		if (StringUtils.isNotBlank((String) getParameterValue("isenable"))) {
			queryCondition.setCondition("isenable", getParameterValue("isenable"));
		}
		List<Object> list = _userInfomationAdpater.selectPageByQueryCondition("SYS_USEREXT_selectPageByUserToAccountQueryCondition", queryCondition);

		JSONArray items = new JSONArray();
		for (int i = 0; i < list.size(); i++) {
			JSONObject item = new JSONObject();
			UserInfo o = (UserInfo) list.get(i);
			item.put("cell", new Object[] {
					o.getUserextid(),
					o.getAccountid(),
					o.getLoginuser(),
					o.getSex() == 1 ? "男" : "女",
					o.getRealname(),
					o.getEmail(),
					o.getMobile(),
					o.getIsenable() == 1 ? "<a href='javascript:checkIsenable(\"" + o.getAccountid() + "\",\"0\");'>启用</a>" :
						"<a href='javascript:checkIsenable(\"" + o.getAccountid()  + "\",\"1\");'>屏蔽</a>",
						" <a href='javascript:edit(\""+ o.getUserextid()+ "\",\""+o.getAccountid()+"\");'>编辑</a> "
						+ "| <a href='javascript:remove(\""+ o.getAccountid() + "\");'>移除</a> " 
					 });
			items.add(item);
		}
		JSONObject json = new JSONObject();
		json.put("page", page);
		json.put("total", queryCondition.getPage().getTotalrows());
		json.put("rows", items);
		this.renderText(json.toString());
	}
	//获取静态化任务已选项
	public void loadStaticList(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("accountid", getParameterValue("accountid").toString());
		JSONObject json = new JSONObject();
		json.put("staticlist", _userInfomationAdpater.selectAllByMapParam("selectStaticTaskRoleByAccountid", map));
		this.renderText(json.toString());
	}
	//获取静态化任务列表
	public void getStaticList(){
		QueryCondition queryCondition = new QueryCondition();
		// 查询设置当前页
		queryCondition.setCurrentPageNo(page);
		// 设置每页显示数
		queryCondition.getPage().setPagesizeValue(rp);
		
		String key = (String) getParameterValue("query");
		if (StringUtils.isNotBlank(key)) {
			queryCondition.setCondition("keywords", "%" + key + "%");
		}
		List<Object> list = _userInfomationAdpater.selectPageByQueryCondition("WEB_STATICTASK_selectListPageByQueryCondition", queryCondition);

		JSONArray items = new JSONArray();
		for (int i = 0; i < list.size(); i++) {
			JSONObject item = new JSONObject();
			WebStatictask w = (WebStatictask) list.get(i);
			item.put("cell", new Object[] {
					w.getStatictaskid(), 
					"<input type=checkbox id=boxs_" + w.getStatictaskid()+ " name=boxs value=" + w.getStatictaskid() + 
					" onchange=\"checkPushGroups(" + w.getStatictaskid()+ ");\" />",
					w.getStaticurl(),
					w.getSitename(),
					w.getDynamicurl(), 
			});
			items.add(item);
		}
		JSONObject json = new JSONObject();
		json.put("page", page);
		json.put("total", queryCondition.getPage().getTotalrows());
		json.put("rows", items);
		this.renderText(json.toString());
	}
	
	//判断用户名是否唯一
	public void checkUsername(){
		String username = (String)getParameterValue("loginuser");
		if(!_userInfomationAdpater.selectisExistUsername(TablesNameConstants.SYS_ACCOUNT, username)){
			this.renderText("{'flag':true,'returnMsg':'用户名已存在！'}");
		}else{
			this.renderText("{'flag':false}");
		}
	}
	
	//二级联动——获取部门下的职务
	public void getPosition(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("departmentid", getParameterValue("departmentid").toString());		
		this.renderText(JSONArray.fromObject(_userInfomationAdpater.selectAllByMapParam("selectPositionByDepartmentid", map )).toString());
	}
	
	//删除关联表、登陆主表、信息拓展表
	public void delete(){
		if (userInfo.getAccountid() != null && StringUtils.isNotBlank(userInfo.getAccountid().toString())) {
			_userInfomationAdpater.deleteUserInfo(userInfo);
			this.renderText("{'flag':true,'returnMsg':'删除成功！'}");
		}
		else {
			this.renderText("{'flag':false,'returnMsg':'操作失败！'}");
		}
	}
	
	//更新_是否屏蔽
	public void check(){
		if (userAccount.getAccountid() != null && StringUtils.isNotBlank(userAccount.getAccountid().toString())) {
			_userInfomationAdpater.updateByPrimaryKeySelective(TablesNameConstants.SYS_ACCOUNT, userAccount);
			this.renderText("{'flag':true}");
		}
		else {
			this.renderText("{'flag':false}");
		}
	}
	
	//保存用户信息
	public void save(){
		_userInfomationAdpater.saveUserExtInfo(userAccount, userInfo, userDepartment, userPosition);
		this.renderText("{'flag':true,'returnMsg':'操作成功！'}");
	}
	
	//角色查询
	public void getRoseList(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("keyword", getParameterValue("keyword").toString());		
		this.renderText(JSONArray.fromObject(_userInfomationAdpater.selectAllByMapParam("getRoleListByKeyword", map )).toString());
	}
	
	//取已关联的角色信息
	public void getLinkedRoleList(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("accountid", getParameterValue("accountid").toString());		
		this.renderText(JSONArray.fromObject(_userInfomationAdpater.selectAllByMapParam("getLinkedRoleListByContentid", map)).toString());
	}
	
	//资源关联查询
	public void getResourceList(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("keywords", getParameterValue("keywords").toString());		
		this.renderText(JSONArray.fromObject(_userInfomationAdpater.selectAllByMapParam("getResourceListByKeyword", map )).toString());
	}
	
	//取已关联的角色信息
	public void getLinkedResourceList(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("accountid", getParameterValue("accountid").toString());	
		this.renderText(JSONArray.fromObject(_userInfomationAdpater.selectAllByMapParam("getLinkedResourceListByContentid", map)).toString());
	}
	
	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public UserInfomationAdpater getUserInfomationAdpater() {
		return _userInfomationAdpater;
	}

	public void setUserInfomationAdpater(UserInfomationAdpater userInfomationAdpater) {
		_userInfomationAdpater = userInfomationAdpater;
	}

	public UserAccount getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
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

	public UserDepartment getUserDepartment() {
		return userDepartment;
	}

	public void setUserDepartment(UserDepartment userDepartment) {
		this.userDepartment = userDepartment;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public UserPosition getUserPosition() {
		return userPosition;
	}

	public void setUserPosition(UserPosition userPosition) {
		this.userPosition = userPosition;
	}

}
