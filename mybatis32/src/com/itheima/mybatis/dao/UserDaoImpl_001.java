package com.itheima.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.itheima.mybatis.dao.UserDao_001;
import com.itheima.mybatis.pojo.User;

public class UserDaoImpl_001 implements UserDao_001{
	private SqlSessionFactory sqlSessionFactory;

	//注入
	public UserDaoImpl_001(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public User selectUserById(Integer id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = sqlSession.selectOne("test.findUserById",id);
		return user;

	}


}



