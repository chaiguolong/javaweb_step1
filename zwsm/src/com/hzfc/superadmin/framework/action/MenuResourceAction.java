package com.hzfc.superadmin.framework.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.hzfc.common.action.SuperAction;
import com.hzfc.superadmin.framework.adpater.MenuResourceAdpater;
import com.hzfc.superadmin.framework.entity.Department;
import com.hzfc.superadmin.framework.entity.Menu;
import com.hzfc.superadmin.framework.entity.Position;
import com.hzfc.superadmin.framework.entity.PositionResource;
import com.hzfc.superadmin.framework.entity.Resource;
import com.hzfc.superadmin.framework.entity.Role;
import com.hzfc.utils.QueryCondition;
import com.hzfc.utils.TablesNameConstants;
import com.hzfc.utils.Ztree;

@SuppressWarnings("serial")
public class MenuResourceAction extends SuperAction{
	
	private MenuResourceAdpater _menuResourceAdpater;
	private Menu menu;
	private Resource resource;
	private PositionResource positionResource;
	private Role role;
	private Department department;
	private Position position;
	private int page; // 当前第几页
	private int rp; // 每页显示条数

	//菜单列表
	public String toTypeList(){
		return "detailslist";
	}
	//菜单明细
	public String toTypeInfo(){
		List<Object> list = _menuResourceAdpater.selectByStatementid("SYS_MENU_selectByStatementidForSelect");
		Menu m = new Menu();
		m.setMenuid(Long.valueOf(0));
		m.setMenuname("顶级菜单");
		m.setTypenamelevel("");
		list.add(0,m);
		setRequestAttribute("resourceMenuList", list);
		if(menu.getMenuid() != null && StringUtils.isNotBlank(menu.getMenuid().toString())){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("menuid", menu.getMenuid().toString());
			resource = (Resource) _menuResourceAdpater.selectObjectByMapParam("SYS_RESOURCE_selectObjectByMapParam", map);
			menu = (Menu) _menuResourceAdpater.selectByPrimaryKey(TablesNameConstants.SYS_MENU, menu.getMenuid());
		}
		return "detailsinfo";
	}
	public String toRoleList(){
		if(page == 0){
			page = 1;
		}
		return "rolelist";
	}
	public String toDepartmentList(){
		if(page == 0){
			page = 1;
		}
		return "departmentlist";
	}
	public String toPositionList(){
		if(page == 0){
			page = 1;
		}
		return "positionlist";
	}
	
	//加载角色权限
	public void loadTreeByRoleid(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("roleid", role.getRoleid().toString());
		JSONObject json = new JSONObject();
		json.put("roleResource", _menuResourceAdpater.selectAllByMapParam("selectRoleResourceByRoleid", map));
		json.put("role", _menuResourceAdpater.selectByPrimaryKey(TablesNameConstants.SYS_ROLE, role.getRoleid()));
		this.renderText(json.toString());
	}
	//加载角色信息
	public void loadRoleByRoleid(){
		this.renderText(JSONObject.fromObject((Role)_menuResourceAdpater.selectByPrimaryKey(TablesNameConstants.SYS_ROLE, role.getRoleid())).toString());
	}
	//新增角色信息
	public void increaseRole(){
		this.renderText(JSONObject.fromObject(new Role()).toString());
	}
	
	//加载部门权限
	public void loadTreeByDepartmentid(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("departmentid", department.getDepartmentid().toString());
		JSONObject json = new JSONObject();
		json.put("departmentResource", _menuResourceAdpater.selectAllByMapParam("selectDepartmentResourceByDepartmentid", map));
		json.put("department", _menuResourceAdpater.selectByPrimaryKey(TablesNameConstants.SYS_DEPARTMENT, department.getDepartmentid()));
		this.renderText(json.toString());
	}
	//加载/新增部门信息
	public void loadDepartmentByDepartmentid(){
		if(department.getDepartmentid() != null && StringUtils.isNotBlank(department.getDepartmentid().toString())){
			this.renderText(JSONObject.fromObject((Department)_menuResourceAdpater.selectByPrimaryKey(TablesNameConstants.SYS_DEPARTMENT, department.getDepartmentid())).toString());
		}
		else {
			this.renderText(JSONObject.fromObject(new Department()).toString());
		}
	}
	
	//加载职务权限
	public void loadTreeByPositionid(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("positionid", position.getPositionid().toString());
		JSONObject json = new JSONObject();
		json.put("positionResource", _menuResourceAdpater.selectAllByMapParam("selectPositionResourceByPositionid", map));
		json.put("position", _menuResourceAdpater.selectByPrimaryKey(TablesNameConstants.SYS_POSITION, position.getPositionid()));
		this.renderText(json.toString());
	}
	//加载/新增职务信息
	public void loadPositionByPositionid(){
		if(position.getPositionid() != null && StringUtils.isNotBlank(position.getPositionid().toString())){
			JSONObject json = new JSONObject();
			json.put("position", _menuResourceAdpater.selectByPrimaryKey(TablesNameConstants.SYS_POSITION, position.getPositionid()));
			json.put("resourceDepartmentList", _menuResourceAdpater.selectByStatementid("SYS_DEPARTMENT_selectByStatementidForSelect"));
			this.renderText(json.toString());
		}
		else {
			JSONObject json = new JSONObject();
			json.put("position",new Position());
			json.put("resourceDepartmentList", _menuResourceAdpater.selectByStatementid("SYS_DEPARTMENT_selectByStatementidForSelect"));
			this.renderText(json.toString());
		}
	}
	
	//菜单列表
	public void getTypeList() {
		List<Object> list = _menuResourceAdpater.selectByStatementid("SYS_MENU_selectAllByMapParam");
		JSONArray items = new JSONArray();
		String space = "";
		for (int i = 0; i < list.size(); i++) {
			JSONObject item = new JSONObject();
			Menu e = (Menu) list.get(i);
			space = "";
			for (int t = 1; t < e.getLevelid(); t++) {
				space += "&nbsp;&nbsp;&nbsp;&nbsp;";
			}
			item.put(
					"cell",
					new Object[] {
							e.getMenuid(),
							e.getPid(),
							space
							+ (e.getLevelid() != 1 ? "<img src=\"/super/common/flexigrid/css/images/level.gif\" />"
									: "") + e.getMenuname(),
							e.getSortnumber(),
							e.getDefinestring(),
							"<a href='javascript:edit(\""
							+ e.getMenuid()
							+ "\");'>编辑</a> | <a href='javascript:remove(\""
							+ e.getMenuid() + "\");' >移除</a>"
					});
			items.add(item);
		}
		JSONObject json = new JSONObject();
		json.put("page", page);
		json.put("total", 500);
		json.put("rows", items);
		this.renderText(json.toString());
	}
	//角色列表
	public void getRoleList() {
		QueryCondition queryCondition = new QueryCondition();
		// 查询设置当前页
		queryCondition.setCurrentPageNo(page);
		// 设置每页显示数
		queryCondition.getPage().setPagesizeValue(rp);
		
		if (StringUtils.isNotBlank((String) getParameterValue("keywords").toString().trim())) {
			queryCondition.setCondition("keywords", "%" + getParameterValue("keywords").toString().trim() + "%");
		}
		List<Object> list = _menuResourceAdpater.selectPageByQueryCondition("SYS_ROLE_selectPageByQueryCondition", queryCondition);
		JSONArray items = new JSONArray();
		for (int i = 0; i < list.size(); i++) {
			JSONObject item = new JSONObject();
			Role e = (Role) list.get(i);
			item.put(
					"cell",
					new Object[] {
							e.getRoleid(),
							e.getRolename(),
							e.getRoleremark(),
							"<a href='javascript:eidtRealRole(\"" + e.getRoleid()+ "\");'>编辑</a> " + " | " +
							"<a href='javascript:eidtRealTree(\""+ e.getRoleid()+ "\");'>权限</a> " + " | " +
							"<a href='javascript:remove(\""+ e.getRoleid() + "\");' >移除</a>"
					});
			items.add(item);
		}
		JSONObject json = new JSONObject();
		json.put("page", page);
		json.put("total", queryCondition.getPage().getTotalrows());
		json.put("rows", items);
		this.renderText(json.toString());
	}
	//部门列表
	public void getDepartmentList() {
		QueryCondition queryCondition = new QueryCondition();
		// 查询设置当前页
		queryCondition.setCurrentPageNo(page);
		// 设置每页显示数
		queryCondition.getPage().setPagesizeValue(rp);
		
		if (StringUtils.isNotBlank((String) getParameterValue("keywords").toString().trim())) {
			queryCondition.setCondition("keywords", "%" + getParameterValue("keywords").toString().trim() + "%");
		}
		List<Object> list = _menuResourceAdpater.selectPageByQueryCondition("SYS_DEPARTMENT_selectPageByQueryCondition", queryCondition);
		JSONArray items = new JSONArray();
		for (int i = 0; i < list.size(); i++) {
			JSONObject item = new JSONObject();
			Department e = (Department) list.get(i);
			item.put(
					"cell",
					new Object[] {
							e.getDepartmentid(),
							e.getDepartmentname(),
							"<a href='javascript:eidtRealDepartment(\"" + e.getDepartmentid()+ "\");'>编辑</a> " + " | " +
							"<a href='javascript:eidtRealTree(\""+ e.getDepartmentid()+ "\");'>权限</a> " + " | " +
							"<a href='javascript:remove(\""+ e.getDepartmentid() + "\");' >移除</a>"
					});
			items.add(item);
		}
		JSONObject json = new JSONObject();
		json.put("page", page);
		json.put("total", queryCondition.getPage().getTotalrows());
		json.put("rows", items);
		this.renderText(json.toString());
	}
	//职务列表
	public void getPositionList() {
		QueryCondition queryCondition = new QueryCondition();
		// 查询设置当前页
		queryCondition.setCurrentPageNo(page);
		// 设置每页显示数
		queryCondition.getPage().setPagesizeValue(rp);
		
		if (StringUtils.isNotBlank((String) getParameterValue("keywords").toString().trim())) {
			queryCondition.setCondition("keywords", "%" + getParameterValue("keywords").toString().trim() + "%");
		}
		List<Object> list = _menuResourceAdpater.selectPageByQueryCondition("SYS_POSITION_selectPageByQueryCondition", queryCondition);
		JSONArray items = new JSONArray();
		for (int i = 0; i < list.size(); i++) {
			JSONObject item = new JSONObject();
			Position e = (Position) list.get(i);
			item.put(
					"cell",
					new Object[] {
							e.getPositionid(),
							e.getDepartmentid(),
							e.getPositionname(),
							"<a href='javascript:eidtRealPosition(\"" + e.getPositionid()+ "\");'>编辑</a> " + " | " +
							"<a href='javascript:eidtRealTree(\""+ e.getPositionid()+ "\");'>权限</a> " + " | " +
							"<a href='javascript:remove(\""+ e.getPositionid() + "\");' >移除</a>"
					});
			items.add(item);
		}
		JSONObject json = new JSONObject();
		json.put("page", page);
		json.put("total", queryCondition.getPage().getTotalrows());
		json.put("rows", items);
		this.renderText(json.toString());
	}
	//加载树框架
	public void getZtreeMenu(){
		List<Ztree> list = _menuResourceAdpater.getZtreeMenu();
		this.renderText(JSONArray.fromObject(list).toString());
	}
	
	//菜单删除
	public void deleteType(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("menuid", menu.getMenuid().toString());
		resource = (Resource) _menuResourceAdpater.selectObjectByMapParam("SYS_RESOURCE_selectObjectByMapParam", map);
		boolean flag = _menuResourceAdpater.selectIsExistMenu(menu.getMenuid(),resource.getResourceid());
		if(flag){
			if (menu.getMenuid() != null && StringUtils.isNotBlank(menu.getMenuid().toString())){
				_menuResourceAdpater.deleteMenuResource(menu);
				this.renderText("{'flag':true,'returnMsg':'删除成功！'}");
			}
			else {
				this.renderText("{'flag':false,'returnMsg':'操作失败！'}");
			}
		}
		else{
			this.renderText("{'flag':false,'returnMsg':'该栏目正在被使用，无法删除！'}");
		}
	}
	//角色删除
	public void deleteRole(){
		boolean flag = _menuResourceAdpater.selectIsExistRole(role.getRoleid());
		if(flag){
			if (role.getRoleid() != null && StringUtils.isNotBlank(role.getRoleid().toString())){
				_menuResourceAdpater.deleteRole(role);
				this.renderText("{'flag':true,'returnMsg':'删除成功！'}");
			}
			else {
				this.renderText("{'flag':false,'returnMsg':'操作失败！'}");
			}
		}
		else{
			this.renderText("{'flag':false,'returnMsg':'该用户正在被使用，无法删除！'}");
		}
	}
	//部门删除
	public void deleteDepartment(){
		boolean flag = _menuResourceAdpater.selectIsExistDepartment(department.getDepartmentid());
		if(flag){
				if (department.getDepartmentid() != null && StringUtils.isNotBlank(department.getDepartmentid().toString())){
					_menuResourceAdpater.deleteDepartment(department);
					this.renderText("{'flag':true,'returnMsg':'删除成功！'}");
				}
				else {
					this.renderText("{'flag':false,'returnMsg':'操作失败！'}");
				}
		}
		else{
			this.renderText("{'flag':false,'returnMsg':'该部门正在被使用，无法删除！'}");
		}
	}
	//职务删除
	public void deletePosition(){
		boolean flag = _menuResourceAdpater.selectIsExistPosition(position.getPositionid());
		if(flag){
			if (position.getPositionid() != null && StringUtils.isNotBlank(position.getPositionid().toString())){
				_menuResourceAdpater.deletePosition(position);
				this.renderText("{'flag':true,'returnMsg':'删除成功！'}");
			}
			else {
				this.renderText("{'flag':false,'returnMsg':'操作失败！'}");
			}
		}
		else{
			this.renderText("{'flag':false,'returnMsg':'该职务正在被使用，无法删除！'}");
		}
	}
	
	//菜单保存
	public void saveType() {
		_menuResourceAdpater.saveResourceInfo(TablesNameConstants.SYS_MENU, menu,resource);
		this.renderText("{'flag':true,'returnMsg':'保存成功！'}");
	}
	//角色保存
	public void saveRole(){
		_menuResourceAdpater.saveRoleInfo(TablesNameConstants.SYS_ROLE, role);
		this.renderText("{'flag':true,'returnMsg':'保存成功！'}");
	}
	//部门保存
	public void saveDepartment(){
		_menuResourceAdpater.saveDepartmentInfo(TablesNameConstants.SYS_DEPARTMENT, department);
		this.renderText("{'flag':true,'returnMsg':'保存成功！'}");	
	}
	//职务保存
	public void savePosition(){
		_menuResourceAdpater.savePositionInfo(TablesNameConstants.SYS_POSITION, position);
		this.renderText("{'flag':true,'returnMsg':'保存成功！'}");
	}
	
	//角色资源关联保存
	public void saveRoleResource(){
		_menuResourceAdpater.saveRoleResourceInfo(TablesNameConstants.SYS_ROLERESOURCE, role);
		this.renderText("{'flag':true,'returnMsg':'保存成功！'}");	
	}
	//部门资源关联保存
	public void saveDepartmentResource(){
		_menuResourceAdpater.saveDepartmentResourceInfo(TablesNameConstants.SYS_DEPARTMENTRESOURCE, department);
		this.renderText("{'flag':true,'returnMsg':'保存成功！'}");	
	}
	//职务资源关联保存
	public void savePositionResource(){
		_menuResourceAdpater.savePositionResourceInfo(TablesNameConstants.SYS_POSITIONRESOURCE, position);
		this.renderText("{'flag':true,'returnMsg':'保存成功！'}");
	}
	
	//set get方法
	public MenuResourceAdpater getMenuResourceAdpater() { 
		return _menuResourceAdpater;
	}

	public void setMenuResourceAdpater(MenuResourceAdpater menuResourceAdpater) {
		this._menuResourceAdpater = menuResourceAdpater;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
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
	public Resource getResource() {
		return resource;
	}
	public void setResource(Resource resource) {
		this.resource = resource;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public PositionResource getPositionResource() {
		return positionResource;
	}
	public void setPositionResource(PositionResource positionResource) {
		this.positionResource = positionResource;
	}

}
