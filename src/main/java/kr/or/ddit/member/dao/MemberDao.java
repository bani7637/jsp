package kr.or.ddit.member.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.model.PageVO;

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
		sqlSession.close();
		
		// select 결과가 여러개일때 selectList
		// sqlSession.selectList(statement, parameter)
		
		return memberVo;
	}

	@Override
	public List<MemberVO> selectAllMember() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		List<MemberVO> memberList = sqlSession.selectList("member.selectAllMember");
		
		sqlSession.close();
		return memberList;
	}

	@Override
	public List<MemberVO> selectMemberPageList(PageVO pv) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		List<MemberVO> memberList = sqlSession.selectList("member.selectMemberPageList",pv);
		sqlSession.close();
		return memberList;
	}

	@Override
	public int selectMemberTotalCount() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int totalCnt = sqlSession.selectOne("member.selectMemberTotalCount");
		sqlSession.close();
		return totalCnt;
	}

	@Override
	public int insertMember(MemberVO memberVO) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int insertCnt = 0;
		try {
			insertCnt = sqlSession.insert("member.insertMember", memberVO);
		} catch (Exception e) {
			
		}
		
		//정상적으로 실행했는지 확인하고 commit, rollback을 해줌
		if(insertCnt ==1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		return insertCnt;
	}

	@Override
	public int deleteMember(String userid) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		int deleteCnt = sqlSession.delete("member.deleteMember",userid);
		
		if(deleteCnt ==1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return deleteCnt;
	}

	@Override
	public int updateMember(MemberVO memberVO) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int updatetCnt = 0;
		try {
			updatetCnt = sqlSession.insert("member.updateMember", memberVO);
		} catch (Exception e) {
			
		}
		
		//정상적으로 실행했는지 확인하고 commit, rollback을 해줌
		if(updatetCnt ==1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		return updatetCnt;
	}

	

	
	 

	
}
