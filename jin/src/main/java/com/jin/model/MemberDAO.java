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
	
<<<<<<< HEAD
	public MemberDTO loginCheck(MemberDTO dto) {
		
		MemberDTO member = sqlSession.selectOne("com.jin.database.MemberMapper.logincheck1", dto);
=======
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
>>>>>>> branch 'master' of https://github.com/yourvita/criring.git
		return member;
	}
	
	public int loginCount(MemberDTO dto) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int result = sqlSession.selectOne("loginCount", dto);
		
		sqlSession.close();
		return result;
	}
}
