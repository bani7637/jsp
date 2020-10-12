package kr.or.ddit.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.model.MemberVO;

public class MemberDao implements MemberDaoI{

	//ctrl + 1
	@Override
	public MemberVO getMember(String userId) {
		// 원래는 db에서 데이터를 조회하는 로직이 있어야하지만 controller기능에 집중
		// Mock(가짜)
//		
//		MemberVO memberVo = new MemberVO();
//		
//		memberVo.setUserId("brown");
//		memberVo.setPassword("passBrown");
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		// select 결과가 한개일때 selectOne
		MemberVO memberVo = sqlSession.selectOne("member.getMember", userId);
		
		
		// select 결과가 여러개일때 selectList
		// sqlSession.selectList(statement, parameter)
		
		return memberVo;
	}

	@Override
	public List<MemberVO> selectAllMember() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		List<MemberVO> memberList = sqlSession.selectList("member.selectAllMember");
		return memberList;
	}
	
	 

	
}
