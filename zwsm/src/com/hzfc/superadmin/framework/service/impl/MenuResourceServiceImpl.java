package com.hzfc.superadmin.framework.service.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.hzfc.common.service.impl.SuperServiceImpl;
import com.hzfc.superadmin.framework.dao.MenuResourceDao;
import com.hzfc.superadmin.framework.entity.Department;
import com.hzfc.superadmin.framework.entity.DepartmentResource;
import com.hzfc.superadmin.framework.entity.Menu;
import com.hzfc.superadmin.framework.entity.Position;
import com.hzfc.superadmin.framework.entity.PositionResource;
import com.hzfc.superadmin.framework.entity.Resource;
import com.hzfc.superadmin.framework.entity.Role;
import com.hzfc.superadmin.framework.entity.RoleResource;
import com.hzfc.superadmin.framework.service.MenuResourceService;
import com.hzfc.utils.TablesNameConstants;
import com.hzfc.utils.Ztree;

public class MenuResourceServiceImpl extends SuperServiceImpl implements MenuResourceService{
	private MenuResourceDao _menuResourceDao;
	
	//菜单新增/修改
	public void saveResourceInfo(String tablename, Menu menu, Resource resource) {
		if(menu.getMenuid() != null && StringUtils.isNotBlank(menu.getMenuid().toString())){
			_menuResourceDao.updateByPrimaryKeySelective(TablesNameConstants.SYS_MENU, menu);
			_menuResourceDao.updateByPrimaryKeySelective(TablesNameConstants.SYS_RESOURCE, resource);
		}
		else{
			menu.setMenuid(_menuResourceDao.getOracleSequencesBySeqName("HIBERNATE_SEQUENCE"));
			_menuResourceDao.insert(TablesNameConstants.SYS_MENU, menu);
			resource.setMenuid(menu.getMenuid());			
			_menuResourceDao.insert(TablesNameConstants.SYS_RESOURCE, resource);
		}
	}
	//角色新增/修改
	public void saveRoleInfo(String tablename,Role role){
		if(role.getRoleid() != 0 && role.getRoleid() != null && StringUtils.isNotBlank(role.getRoleid().toString())){
			_menuResourceDao.updateByPrimaryKeySelective(TablesNameConstants.SYS_ROLE, role);
		}
		else{
			_menuResourceDao.insert(tablename, role);
		}
	}
	//角色权限新增/修改
	public void saveRoleResourceInfo(String tablename, Role role){
		if(role.getRoleid() != null && StringUtils.isNotBlank(role.getRoleid().toString())){
			_menuResourceDao.deleteByUserDefined("deleteRoleResourceByRoleid", role.getRoleid());
		}
		RoleResource rr = new RoleResource();
		rr.setRoleid(role.getRoleid());
		for(String s : role.getResourceids().split(",")){
			rr.setResourceid(Long.valueOf(s));
			_menuResourceDao.insert(TablesNameConstants.SYS_ROLERESOURCE, rr);
		}
	}
	//部门新增/修改
	public void saveDepartmentInfo(String tablename, Department department) {
		if(department.getDepartmentid() != 0 && department.getDepartmentid() != null && StringUtils.isNotBlank(department.getDepartmentid().toString())){
			_menuResourceDao.updateByPrimaryKeySelective(TablesNameConstants.SYS_DEPARTMENT, department);
		}
		else{
			_menuResourceDao.insert(tablename, department);
		}
	}
	//部门权限新增/修改
	public void saveDepartmentResourceInfo(String tablename, Department department){
		if(department.getDepartmentid() != null && StringUtils.isNotBlank(department.getDepartmentid().toString())){
			_menuResourceDao.deleteByUserDefined("deleteDepartmentResourceByDepartmentid", department.getDepartmentid());
		}
		DepartmentResource dr = new DepartmentResource();
		dr.setDepartmentid(department.getDepartmentid());
		for(String s : department.getResourceids().split(",")){
			dr.setResourceid(Long.valueOf(s));
			_menuResourceDao.insert(TablesNameConstants.SYS_DEPARTMENTRESOURCE, dr);
		}
	}
	//职务新增/修改
	public void savePositionInfo(String tablename, Position position) {
		if(position.getPositionid() != 0 && position.getPositionid() != null && StringUtils.isNotBlank(position.getPositionid().toString())){
			_menuResourceDao.updateByPrimaryKeySelective(TablesNameConstants.SYS_POSITION, position);
		}
		else{
			_menuResourceDao.insert(tablename, position);
		}
	}
	//职务权限新增/修改
	public void savePositionResourceInfo(String tablename, Position position){
		if(position.getPositionid() != null && StringUtils.isNotBlank(position.getPositionid().toString())){
			_menuResourceDao.deleteByUserDefined("deletePositionResourceByPositionid", position.getPositionid());
		}
		PositionResource pr = new PositionResource();
		pr.setPositionid(position.getPositionid());
		for(String s : position.getResourceids().split(",")){
			pr.setResourceid(Long.valueOf(s));
			_menuResourceDao.insert(TablesNameConstants.SYS_POSITIONRESOURCE, pr);
		}
	}
	//删除菜单栏目时查看是否有子栏目及被赋予权限
	public boolean selectIsExistMenu(Long menuid,Long resourceid) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("resourceid", resourceid);
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("menuid", menuid);
		List<Object> list  = _menuResourceDao.selectAllByMapParam("checkSubmenu",map2);
		if(!list.isEmpty()){
			return false;
		}
		List<Object> list1 = _menuResourceDao.selectAllByMapParam("selectIsExistRoleResource", map);
		if(!list1.isEmpty()){
			return false;
		}
		List<Object> list2 = _menuResourceDao.selectAllByMapParam("selectIsExistDepartmentResource", map);
		if(!list2.isEmpty()){
			return false;
		}
		List<Object> list3 = _menuResourceDao.selectAllByMapParam("selectIsExistPositionResource", map);
		if(!list3.isEmpty()){
			return false;
		}
		return true;
	}
	//删除角色时检测用户角色关联表、角色资源关联表信息是否存在
	public boolean selectIsExistRole(Long roleid) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("roleid", roleid);
		List<Object> list1 = _menuResourceDao.selectAllByMapParam("selectIsExistUserRole", map);
		if(list1.isEmpty()){
			return true;
		}
		else{
			return false;
		}
	}
	//删除职务时检测用户职务关联表、职务资源关联表信息是否存在
	public boolean selectIsExistPosition(Long positionid) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("positionid", positionid);
		List<Object> list1 = _menuResourceDao.selectAllByMapParam("selectIsExistUserPosition", map);
		if(list1.isEmpty()){
			return true;
		}
		else{
			return false;
		}
	}
	//删除部门时检测用户部门关联表、部门资源关联表信息是否存在
	public boolean selectIsExistDepartment(Long departmentid) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("departmentid", departmentid);
		List<Object> list1 = _menuResourceDao.selectAllByMapParam("selectIsExistUserDepartment", map);
		List<Object> list2 = _menuResourceDao.selectAllByMapParam("selectIsExistDepartmentPosition", map);
		if(list1.isEmpty() && list2.isEmpty()){
			return true;
		}
		else{
			return false;
		}
	}
	//删除菜单，同时删除相关资源
	public void deleteMenuResource(Menu menu) {
		_menuResourceDao.deleteByUserDefined("deleteResourceByMenuid", menu.getMenuid());
		_menuResourceDao.deleteByPrimaryKey(TablesNameConstants.SYS_MENU, menu.getMenuid());
	}
	//删除角色
	public void deleteRole(Role role) {
		_menuResourceDao.deleteByUserDefined("deleteRoleResourceByRoleid", role.getRoleid());
		_menuResourceDao.deleteByPrimaryKey(TablesNameConstants.SYS_ROLE, role.getRoleid());
	}
	//删除部门
	public void deleteDepartment(Department department) {
		_menuResourceDao.deleteByUserDefined("deleteDepartmentResourceByDepartmentid", department.getDepartmentid());
		_menuResourceDao.deleteByPrimaryKey(TablesNameConstants.SYS_DEPARTMENT, department.getDepartmentid());
	}
	//删除职务
	public void deletePosition(Position position) {
		_menuResourceDao.deleteByUserDefined("deletePositionResourceByPositionid", position.getPositionid());
		_menuResourceDao.deleteByPrimaryKey(TablesNameConstants.SYS_POSITION, position.getPositionid());
	}
	//树结构
	public List<Ztree> getZtreeMenu() {
		return _menuResourceDao.getZtreeMenu();
	}
	
	//set get方法

	public MenuResourceDao getMenuResourceDao() {
		return _menuResourceDao;
	}

	public void setMenuResourceDao(MenuResourceDao menuResourceDao) {
		_menuResourceDao = menuResourceDao;
	}
	
}
