package com.itheima.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.itheima.mybatis.dao.UserDao_003;
import com.itheima.mybatis.pojo.User;

public class UserDaoImpl_003 implements UserDao_003{
	public SqlSessionFactory sqlSessionFactory;

	public UserDaoImpl_003(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public User selectUserById(Integer id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession.selectOne("test.findUserById",id);
	}


}



