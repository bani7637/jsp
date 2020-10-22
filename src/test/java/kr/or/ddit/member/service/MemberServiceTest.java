package kr.or.ddit.member.service;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.member.dao.MemberDao;
import kr.or.ddit.member.model.MemberVO;

public class MemberServiceTest {
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceTest.class);

	@Test
	public void getMemberTest() {
		/***Given***/
		MemberServiceI memberService = new MemberService();
		String userId = "brown";
		
		
		MemberVO answerMemberVO = new MemberVO();
		answerMemberVO.setUserid("brown");
		answerMemberVO.setPass("brownPass");
		
		
		/***When***/
		MemberVO memVo = memberService.getMember(userId);

		/***Then***/
		assertEquals("brown", memVo.getUserid());
		assertEquals("brownPass", memVo.getPass());
		
//		assertEquals(answerMemberVO, memVo);
		
	}
	@Test
	public void localListTest() {
		Locale[] locales = SimpleDateFormat.getAvailableLocales();
		for(Locale locale : locales) {
			logger.debug(locale.toString());
			
		}
		
	}
	@Test
	public void updateMember() {
		/***Given***/
		MemberServiceI memberService = new MemberService();

		MemberVO memberVO = new MemberVO("bani", "test", "test", "test", "test", "test",
				"34940", "d:\\profile\\bani.png", "bani.png");
		/***When***/
		int updateCnt = memberService.updateMember(memberVO);
		/***Then***/
		assertEquals(1, updateCnt);
	}
	
}
