package kr.or.ddit.member.Dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.model.PageVO;

@Repository("memberDao")
public class MemberDao implements MemberDaoI {

	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;

	@Override
	public MemberVO getMember(String userid) {
		MemberVO memberVo = sqlSession.selectOne("member.getMember", userid);
		return memberVo;
	}

	@Override
	public List<MemberVO> selectAllMember() {
		List<MemberVO> memberList = sqlSession.selectList("member.selectAllMember");
		return memberList;
	}

	@Override
	public List<MemberVO> selectMemberPageList(PageVO pv) {
		List<MemberVO> memberList = sqlSession.selectList("member.selectMemberPageList", pv);
		return memberList;
	}

	@Override
	public int selectMemberTotalCount() {
		int totalCnt = sqlSession.selectOne("member.selectMemberTotalCount");
		return totalCnt;
	}

	@Override
	public int insertMember(MemberVO memberVO) {
		int insertCnt = 0;
		insertCnt = sqlSession.insert("member.insertMember", memberVO);
		return insertCnt;
	}

	@Override
	public int deleteMember(String userid) {
		int deleteCnt = 0;
		deleteCnt = sqlSession.delete("member.deleteMember", userid);
		return deleteCnt;
	}

	@Override
	public int updateMember(MemberVO memberVO) {
		int updatetCnt = 0;
		updatetCnt = sqlSession.insert("member.updateMember", memberVO);
		return updatetCnt;
	}

}
