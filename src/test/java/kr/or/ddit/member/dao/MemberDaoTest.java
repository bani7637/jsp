package kr.or.ddit.member.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import kr.or.ddit.member.model.MemberVO;

public class MemberDaoTest {

	@Test
	public void getMemberTest() {
		/***Given***/
		MemberDao memberDao = new MemberDao();
		String userId = "brown";
		
		
		// assertEquals 확인하기위한 membervo 생성
		MemberVO answerMemberVO = new MemberVO();
		answerMemberVO.setUserId("brown");
		answerMemberVO.setPassword("passBrown");
		
		
		/***When***/
		MemberVO memVo = memberDao.getMember(userId);

		/***Then***/
		assertEquals("brown", memVo.getUserId());
		assertEquals("passBrown", memVo.getPassword());
		
		// assertEquals = > 객체 x와 y가 일치함을 확인 => x(예상 값)와 y(실제 값)가 같으면 테스트 통과 
		
		// 새로운 VO, 원래있던 VO => 들어있는 값은 같으나 테스트 실패하는 이유
		// 새로운 VO, 원래있던 VO 를 new 해서 생성했기때문에 다른객체로 인식함
		// => 해결방법 = VOclass에 hashCode() and equals() 메서드 생성
		assertEquals(answerMemberVO, memVo);
	}

}
