package com.hzfc.superadmin.framework.adpater.impl;

import java.util.List;

import com.hzfc.common.adpater.impl.SuperAdpaterImpl;
import com.hzfc.superadmin.framework.adpater.MenuResourceAdpater;
import com.hzfc.superadmin.framework.entity.Department;
import com.hzfc.superadmin.framework.entity.Menu;
import com.hzfc.superadmin.framework.entity.Position;
import com.hzfc.superadmin.framework.entity.Resource;
import com.hzfc.superadmin.framework.entity.Role;
import com.hzfc.superadmin.framework.service.MenuResourceService;
import com.hzfc.utils.Ztree;

public class MenuResourceAdpaterImpl extends SuperAdpaterImpl implements MenuResourceAdpater{
	private MenuResourceService _menuResourceService;

	public void saveResourceInfo(String tablename, Menu menu, Resource resource){
		_menuResourceService.saveResourceInfo(tablename, menu, resource);
	}
	
	public void saveRoleInfo(String tablename,Role role){
		_menuResourceService.saveRoleInfo(tablename, role);
	}

	public void saveDepartmentInfo(String tablename, Department department) {
		_menuResourceService.saveDepartmentInfo(tablename, department);
	}
	
	public void saveRoleResourceInfo(String tablename, Role role) {
		_menuResourceService.saveRoleResourceInfo(tablename, role);
	}
	
	public void saveDepartmentResourceInfo(String tablename, Department department) {
		_menuResourceService.saveDepartmentResourceInfo(tablename, department);
	}
	
	public void savePositionResourceInfo(String tablename, Position position) {
		_menuResourceService.savePositionResourceInfo(tablename, position);
	}

	public void savePositionInfo(String tablename, Position position) {
		_menuResourceService.savePositionInfo(tablename, position);
	}
	
	public MenuResourceService getMenuResourceService() {
		return _menuResourceService;
	}

	public void setMenuResourceService(MenuResourceService menuResourceService) {
		_menuResourceService = menuResourceService;
	}
	
	public List<Ztree> getZtreeMenu() {
		return _menuResourceService.getZtreeMenu();
	}

	public boolean selectIsExistMenu(Long menuid,Long resourceid){
		return _menuResourceService.selectIsExistMenu(menuid,resourceid);
	}

	public void deleteMenuResource(Menu menu) {
		_menuResourceService.deleteMenuResource(menu);
	}
	
	public void deleteRole(Role role) {
		_menuResourceService.deleteRole(role);
	}
	
	public void deleteDepartment(Department department) {
		_menuResourceService.deleteDepartment(department);
	}
	
	public void deletePosition(Position position) {
		_menuResourceService.deletePosition(position);
	}

	public boolean selectIsExistDepartment(Long departmentid) {
		return _menuResourceService.selectIsExistDepartment(departmentid);
	}

	public boolean selectIsExistPosition(Long positionid) {
		return _menuResourceService.selectIsExistPosition(positionid);
	}

	public boolean selectIsExistRole(Long roleid) {
		return _menuResourceService.selectIsExistRole(roleid);
	}
}
