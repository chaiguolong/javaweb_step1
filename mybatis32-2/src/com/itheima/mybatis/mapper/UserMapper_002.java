package com.itheima.mybatis.mapper;

import java.util.List;

import com.itheima.mybatis.pojo.QueryVo;
import com.itheima.mybatis.pojo.User;

public interface UserMapper_002 {
	//根据QueryVo模糊查询List列表
	public List<User> findUserByQueryVo(QueryVo vo);
	
	//查询用户数量
	public Integer countUser();

	//根据用户性别和姓名查询用户
	public List<User> selectUserBySexAndUsername(User user);

	//根据多个id查询用户信息
	public List<User> selectUserByIds(QueryVo vo);
	// public List<User> selectUserByIds(Integer[] ids);
	// public List<User> selectUserByIds(List<Integer> ids);
}
