package com.jin.model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jin.database.SqlSessionManager;

public class MemberDAO {
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();
	SqlSession sqlSession = sqlSessionFactory.openSession(true);
	
	public int joinMember(MemberDTO dto) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int result = sqlSession.insert("joinMember", dto);
		sqlSession.close();
		return result;
	}
	
	public int joinStore(StoreDTO dto) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int result = sqlSession.insert("joinStore", dto);
		sqlSession.close();
		return result;
	}
	
	public MemberDTO loginChk(MemberDTO dto) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		MemberDTO member = null;
		member = sqlSession.selectOne("loginChk", dto);
		sqlSession.close();
		return member;
	}
	
	public int loginCount(MemberDTO dto) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int result = sqlSession.selectOne("loginCount", dto);
		
		sqlSession.close();
		return result;
	}
}
