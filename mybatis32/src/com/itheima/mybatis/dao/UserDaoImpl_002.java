package com.itheima.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.itheima.mybatis.dao.UserDao_002;
import com.itheima.mybatis.pojo.User;

public class UserDaoImpl_002 implements UserDao_002{

	public SqlSessionFactory sqlSessionFactory;

	public UserDaoImpl_002(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public User selectUserById(Integer id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession.selectOne("test.findUserById",id);
	}


}



