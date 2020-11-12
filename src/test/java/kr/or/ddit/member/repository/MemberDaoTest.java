package kr.or.ddit.member.repository;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import kr.or.ddit.WebTestConfig;
import kr.or.ddit.member.Dao.MemberDaoI;
import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.model.PageVO;


public class MemberDaoTest extends WebTestConfig{

	
	
	@Resource(name = "memberDao")
	private MemberDaoI memberDao;
	
	@Test
	public void selectAllMemberTest() {
		/***Given***/
		/***When***/
		List<MemberVO> memList = memberDao.selectAllMember();
		/***Then***/
		assertTrue(memList.size()>13);
	}

	@Test
	public void insertmem_success_Test() {
		/***Given***/
		MemberVO memberVO = new MemberVO("temp", "123", "", "", "", "", "", "", "");

		/***When***/
		int insertCnt = memberDao.insertMember(memberVO);
		
		/***Then***/
		assertEquals(1, insertCnt);
	}

	//@Test
	public void insertmem_fail_Test() {
		/***Given***/
		MemberVO memberVO = new MemberVO("ddit", "123", "대덕", "test", "test", "test", "", "", "");

		/***When***/
		int insertCnt = memberDao.insertMember(memberVO);
		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	@Test
	public void getMemberTest() {
		/***Given***/
		String userid="bani";

		/***When***/
		MemberVO answerMemberVO = new MemberVO("bani", "반이슬");

		MemberVO memVo = memberDao.getMember(userid);

		/***Then***/
		assertEquals(answerMemberVO.getUserid(), memVo.getUserid());
		assertEquals(answerMemberVO.getUsernm(), memVo.getUsernm());
	}

	@Test
	public void updateMemberTest() {
		/***Given***/
		MemberVO memberVO = new MemberVO("bani", "test", "test", "test", "test", "test",
				"test", "test", "test");
		/***When***/
		int updateCnt = memberDao.updateMember(memberVO);
		/***Then***/
		assertEquals(1, updateCnt);
	}
	
	@Test
	public void deleteMemberTest() {
		/***Given***/
		String userid = "bani";
		
		/***When***/
		int deleteCnt = memberDao.deleteMember(userid);
		
		/***Then***/
		assertEquals(1, deleteCnt);
	}
	
	
	
	
	
	@Test
	public void selectMemberPageListTest() {
		/***Given***/
		

		/***When***/
		PageVO pv = new PageVO();
		pv.setPage(1);
		pv.setPageSize(5);
		List<MemberVO> db_memList = memberDao.selectMemberPageList(pv);
		
			
		/***Then***/
		assertEquals(5, db_memList.size());
	}
	
	
	
	
	
}
