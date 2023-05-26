package com.jin.model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jin.database.SqlSessionManager;

public class StoreDAO {
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();
	SqlSession sqlSession = sqlSessionFactory.openSession(true);
	
	public int insertLaundry(LaundryDTO ldto) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int result = 0;
		result = sqlSession.insert("com.jin.database.MemberMapper.registLaundry",ldto);
		sqlSession.close();
		return result;
	}
}
