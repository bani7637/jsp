package kr.or.ddit.member.Dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.model.PageVO;

@Repository("MemberDao")
public class MemberDao implements MemberDaoI{
	
	@Override
	public MemberVO getMember(String userid) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		MemberVO memberVo = sqlSession.selectOne("member.getMember", userid);
		sqlSession.close();
		
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
