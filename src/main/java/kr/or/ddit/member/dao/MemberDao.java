package kr.or.ddit.member.dao;

import kr.or.ddit.member.model.MemberVO;

public class MemberDao implements MemberDaoI{

	//ctrl + 1
	@Override
	public MemberVO getMember(String userId) {
		// 원래는 db에서 데이터를 조회하는 로직이 있어야하지만 controller기능에 집중
		// Mock(가짜)
		
		MemberVO memberVo = new MemberVO();
		
		memberVo.setUserId("brown");
		memberVo.setPassword("passBrown");
		
		return memberVo;
	}

	
}
