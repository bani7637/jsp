package kr.or.ddit.member.service;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.ModelTestConfig;
import kr.or.ddit.member.model.MemberVO;

public class MemberServiceTest extends ModelTestConfig{

	@Resource(name = "MemberService")
	private MemberServiceI memberservice;
	
	@Test
	public void insertmem_success_Test() {
		/***Given***/
		MemberVO memberVO = new MemberVO("ddit", "123", "대덕", "test", "test", "test", "", "", "");

		/***When***/
		int insertCnt = memberservice.insertMember(memberVO);
		
		/***Then***/
		assertEquals(1, insertCnt);
	}

	//@Test
	public void insertmem_fail_Test() {
		/***Given***/
		MemberVO memberVO = new MemberVO("ddit", "123", "대덕", "test", "test", "test", "", "", "");

		/***When***/
		int insertCnt = memberservice.insertMember(memberVO);
		
		/***Then***/
		assertEquals(1, insertCnt);
	}

	
	
}
