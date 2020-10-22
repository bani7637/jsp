package kr.or.ddit.member.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.model.PageVO;

public interface MemberDaoI {

	//
	MemberVO getMember(String userId);
	
	List<MemberVO> selectAllMember();
	
	List<MemberVO> selectMemberPageList(PageVO pv);
	
	int selectMemberTotalCount();
	
	int insertMember(MemberVO memberVO);
	
	int deleteMember(String userid);
	
	int updateMember(MemberVO memberVO);
	
}
