package com.hzfc.superadmin.framework.service.impl;

import org.apache.commons.lang.StringUtils;

import com.hzfc.common.service.impl.SuperServiceImpl;
import com.hzfc.superadmin.framework.dao.UserInfomationDao;
import com.hzfc.superadmin.framework.entity.UserAccount;
import com.hzfc.superadmin.framework.entity.UserDepartment;
import com.hzfc.superadmin.framework.entity.UserInfo;
import com.hzfc.superadmin.framework.entity.UserPosition;
import com.hzfc.superadmin.framework.entity.UserRole;
import com.hzfc.superadmin.framework.entity.Userresource;
import com.hzfc.superadmin.framework.service.UserInfomationService;
import com.hzfc.utils.MD5;
import com.hzfc.utils.TablesNameConstants;

public class UserInfomationServiceImpl extends SuperServiceImpl implements UserInfomationService{
	private UserInfomationDao _userInfomationDao;
	
	public UserInfomationDao getUserInfomationDao() {
		return _userInfomationDao;
	}

	public void setUserInfomationDao(UserInfomationDao userInfomationDao) {
		_userInfomationDao = userInfomationDao;
	}
	
	public void saveUserExtInfo(UserAccount userAccount, UserInfo userInfo, UserDepartment userDepartment, UserPosition userPosition) {
		MD5 md = new MD5();
		if(userAccount.getAccountid() != null && StringUtils.isNotBlank(userAccount.getAccountid().toString())){
			if(userAccount.getLoginpass() != null && StringUtils.isNotBlank(userAccount.getLoginpass().toString())){
				//修改密码
				userAccount.setLoginpass(md.getMD5ofStr(userAccount.getLoginpass()));
			}else{
				//进入编辑页面不填写密码
				UserAccount at =(UserAccount)_userInfomationDao.selectByPrimaryKey(TablesNameConstants.SYS_ACCOUNT, userAccount.getAccountid());
				userAccount.setLoginpass(at.getLoginpass());
			}
			//全删全插
			_userInfomationDao.deleteByUserDefined("deleteUserPositionContentByContentid", userAccount.getAccountid()); //删除职务关联表
			_userInfomationDao.deleteByUserDefined("deleteDepartmentContentByContentid", userAccount.getAccountid());   //删除部门关联表
			_userInfomationDao.deleteByPrimaryKey(TablesNameConstants.SYS_USEREXT, userInfo.getUserextid()); 			//删除用户拓展表
			_userInfomationDao.deleteByUserDefined("deleteRoleContentByContentid", userAccount.getAccountid());			//删除角色关联表
			_userInfomationDao.deleteByUserDefined("deleteResourceContentByContentid", userAccount.getAccountid());		//删除直接关联表
			_userInfomationDao.updateByPrimaryKeySelective(TablesNameConstants.SYS_ACCOUNT, userAccount);	//更新账号登陆表
		}
		else{
			userAccount.setLoginpass(md.getMD5ofStr(userAccount.getLoginpass()));
			//两表关联新增，取sequence
			userAccount.setAccountid(_userInfomationDao.getOracleSequencesBySeqName("HIBERNATE_SEQUENCE"));
			_userInfomationDao.insert(TablesNameConstants.SYS_ACCOUNT, userAccount);
		}
		
		if(StringUtils.isNotBlank(userAccount.getRoseList())){
			UserRole ur = new UserRole();
			ur.setAccountid(userAccount.getAccountid());
			for(String s : userAccount.getRoseList().split(",")){
				ur.setRoleid(Long.valueOf(s));
				_userInfomationDao.insert(TablesNameConstants.SYS_USERROLE, ur);
			}
		}
		if(StringUtils.isNotBlank(userAccount.getResourceList())){
			Userresource ur = new Userresource();
			ur.setAccountid(userAccount.getAccountid());
			for(String s : userAccount.getResourceList().split(",")){
				ur.setResourceid(Long.valueOf(s));
				_userInfomationDao.insert(TablesNameConstants.SYS_USERRESOURCE, ur);
			}
		}
		userInfo.setAccountid(userAccount.getAccountid());
		userDepartment.setAccountid(userAccount.getAccountid());
		userPosition.setAccountid(userAccount.getAccountid());
		userPosition.setPositionid(userDepartment.getPositionid());
		_userInfomationDao.insert(TablesNameConstants.SYS_USERPOSITION, userPosition);
		_userInfomationDao.insert(TablesNameConstants.SYS_USERDEPARTMENT, userDepartment);
		_userInfomationDao.insert(TablesNameConstants.SYS_USEREXT, userInfo);
	}
	
	//删除关联表、登陆主表、信息拓展表
	public void deleteUserInfo(UserInfo userInfo){
		_userInfomationDao.deleteByUserDefined("deleteUserPositionContentByContentid", userInfo.getAccountid());
		_userInfomationDao.deleteByUserDefined("deleteRoleContentByContentid", userInfo.getAccountid());
		_userInfomationDao.deleteByUserDefined("deleteDepartmentContentByContentid", userInfo.getAccountid());
		_userInfomationDao.deleteByUserDefined("deleteResourceContentByContentid", userInfo.getAccountid());
		_userInfomationDao.deleteByUserDefined("deleteUserextContentByContentid", userInfo.getAccountid());
		_userInfomationDao.deleteByPrimaryKey(TablesNameConstants.SYS_ACCOUNT, userInfo.getAccountid());
	}
	
	public boolean selectisExistUsername(String tablename, String username){
		return _userInfomationDao.selectisExistUsername(tablename, username);
	}
	
}
