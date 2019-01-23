package com.itheima.mybatis.mapper;

import java.util.List;

import com.itheima.mybatis.pojo.QueryVo;
import com.itheima.mybatis.pojo.User;

public interface UserMapper_001 {
	//根据用户名模糊查询用户列表
	public List<User> findUserByQueryVo(QueryVo vo);

	//查询数据条数
	public Integer countUser();

	//根据性别和姓名查询用户
	public List<User> selectUserBySexAndUsername(User user);

	//根据多个id查询用户信息
	// public List<User> selectUserByIds(Integer[] ids);
	// public List<User> selectUserByIds(List<Integer> ids);
	public List<User> selectUserByIds(QueryVo vo);


}
