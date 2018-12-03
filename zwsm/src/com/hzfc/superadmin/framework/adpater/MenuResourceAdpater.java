package com.hzfc.superadmin.framework.adpater;

import java.util.List;

import com.hzfc.common.adpater.SuperAdpater;
import com.hzfc.superadmin.framework.entity.Department;
import com.hzfc.superadmin.framework.entity.Menu;
import com.hzfc.superadmin.framework.entity.Position;
import com.hzfc.superadmin.framework.entity.Resource;
import com.hzfc.superadmin.framework.entity.Role;
import com.hzfc.utils.Ztree;

public interface MenuResourceAdpater extends SuperAdpater{
	public void saveResourceInfo(String tablename, Menu menu, Resource resource);
	
	public void saveRoleInfo(String tablename,Role role);
	
	public void saveDepartmentInfo(String tablename,Department department);
	
	public void saveDepartmentResourceInfo(String tablename,Department department);
	
	public void saveRoleResourceInfo(String tablename,Role role);
	
	public void savePositionResourceInfo(String tablename,Position position);
	
	public void savePositionInfo(String tablename,Position position);
	
	List<Ztree> getZtreeMenu();
	
	public boolean selectIsExistMenu(Long menuid,Long resourceid);
	
	public void deleteMenuResource(Menu menu);
	
	public void deleteRole(Role role);
	
	public void deleteDepartment(Department department);
	
	public void deletePosition(Position position);
	
	public boolean selectIsExistRole(Long roleid);
	
	public boolean selectIsExistDepartment(Long departmentid);
	
	public boolean selectIsExistPosition(Long positionid);
}
