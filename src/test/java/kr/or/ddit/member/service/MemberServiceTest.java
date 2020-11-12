package kr.or.ddit.member.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.WebTestConfig;
import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.model.PageVO;

public class MemberServiceTest extends WebTestConfig{

	@Resource(name = "MemberService")
	private MemberServiceI memberservice;
	
	@Test
	public void insertmem_success_Test() {
		/***Given***/
		MemberVO memberVO = new MemberVO("temp", "123", "", "", "", "", "", "", "");

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
	
	@Test
	public void getMemberTest() {
		/***Given***/
		String userid="bani";

		/***When***/
		MemberVO answerMemberVO = new MemberVO();
		answerMemberVO.setUserid("bani");
		answerMemberVO.setPass("1234");

		MemberVO memVo = memberservice.getMember(userid);
		

		/***Then***/
		assertEquals("bani", memVo.getUserid());
		assertEquals("1234", memVo.getPass());
	}

	@Test
	public void updateMemberTest() {
		/***Given***/
		MemberVO memberVO = new MemberVO("bani", "test", "test", "test", "test", "test",
				"test", "test", "test");
		/***When***/
		int updateCnt = memberservice.updateMember(memberVO);
		/***Then***/
		assertEquals(1, updateCnt);
	}
	
	@Test
	public void updateMember_fail_Test() {
		/***Given***/
		MemberVO memberVO = new MemberVO("ttttttt", "test", "test", "test", "test", "test",
				"test", "test", "test");
		/***When***/
		int updateCnt = memberservice.updateMember(memberVO);
		/***Then***/
		assertEquals(0, updateCnt);
	}
	
	@Test
	public void deleteMemberTest() {
		/***Given***/
		String userid = "bani";
		
		/***When***/
		int deleteCnt = memberservice.deleteMember(userid);
		
		/***Then***/
		assertEquals(1, deleteCnt);
	}
	
	@Test
	public void selectAllMemberTest() {
		/***Given***/
		
		/***When***/
		List<MemberVO>memList  = memberservice.selectAllMember();
		
		/***Then***/
		assertEquals(16, memList.size());
	}
	
	
	
	@Test
	public void selectMemberPageListTest() {
		/***Given***/
		

		/***When***/
		PageVO pv = new PageVO();
		pv.setPage(1);
		pv.setPageSize(5);
		Map<String, Object>map = memberservice.selectMemberPageList(pv);
		
		List<MemberVO> db_memList = (List<MemberVO>) map.get("memberList");
		int db_page = (int) map.get("pages");
		int pageSize = (int) map.get("pageSize");
		
		/***Then***/
		assertEquals(5, db_memList.size());
		assertEquals(4, db_page);
		assertEquals(5, pageSize);
	}
	
}
