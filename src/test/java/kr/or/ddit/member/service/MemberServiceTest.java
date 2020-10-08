package kr.or.ddit.member.service;

import static org.junit.Assert.*;

import org.junit.Test;

import kr.or.ddit.member.dao.MemberDao;
import kr.or.ddit.member.model.MemberVO;

public class MemberServiceTest {

	@Test
	public void getMemberTest() {
		/***Given***/
		MemberServiceI memberService = new MemberService();
		String userId = "brown";
		
		
		MemberVO answerMemberVO = new MemberVO();
		answerMemberVO.setUserId("brown");
		answerMemberVO.setPassword("passBrown");
		
		
		/***When***/
		MemberVO memVo = memberService.getMember(userId);

		/***Then***/
		assertEquals("brown", memVo.getUserId());
		assertEquals("passBrown", memVo.getPassword());
		
		assertEquals(answerMemberVO, memVo);
		
	}
}
