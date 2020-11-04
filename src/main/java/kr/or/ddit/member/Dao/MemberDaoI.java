package kr.or.ddit.member.Dao;

import kr.or.ddit.member.model.MemberVO;

public interface MemberDaoI {
	MemberVO getMember(String userid);
}
