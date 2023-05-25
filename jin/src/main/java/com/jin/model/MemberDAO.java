package com.jin.model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jin.database.SqlSessionManager;

public class MemberDAO {
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();
	SqlSession sqlSession = sqlSessionFactory.openSession(true);
	
	public int joinMember(MemberDTO dto) {
		int result = sqlSession.insert("com.jin.database.MemberMapper.joinMember", dto);
		sqlSession.close();
		return result;
	}
	
	public MemberDTO loginChk(String email, String Pw) {
		
		MemberDTO member = sqlSession.selectOne("com.jin.database.userMapper.loginCheck", new MemberDTO(email, Pw));
		sqlSession.close();
		return member;
	}
}
