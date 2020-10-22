package kr.or.ddit.member.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.member.controller.member;
import kr.or.ddit.member.model.MemberVO;

public class MemberDaoTest2 {
	MemberDaoI memberDao;
	
	@Before
	//test 메서드 실행전 실행됨
	public void setup() {
		/***Given***/
		memberDao = new MemberDao(); //재사용가능
		
		String userid = "bani";
//		memberDao.deleteMember(userid);
		
		/***When***/

		/***Then***/
	}
	
	
	@Test
	public void selectAllMember() {
		/***Given***/

		/***When***/
		List<MemberVO> memList = memberDao.selectAllMember();
		
		/***Then***/
		assertEquals(15, memList.size());
		
		
	}
	
	
	
	@Test
	public void selectMemberTotalCountTest() {
		/***Given***/
		
		/***When***/
		int cnt = memberDao.selectMemberTotalCount();
		
		/***Then***/
		assertEquals(15, cnt);
		
		
	}
	
	@Test
	public void insertMemberDaoTest() {
		/***Given***/
		MemberVO memberVO = new MemberVO("bani", "123", "반", "test", "대전중구", "영민빌딩",
				"34940", "d:\\profile\\bani.png", "bani.png");
		/***When***/
		int insertCnt = memberDao.insertMember(memberVO);
		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	@Test
	public void updateMemberDaoTest() {
		/***Given***/
		MemberVO memberVO = new MemberVO("bani", "test", "test", "test", "test", "test",
				"34940", "d:\\profile\\bani.png", "bani.png");
		/***When***/
		int updateCnt = memberDao.updateMember(memberVO);
		/***Then***/
		assertEquals(1, updateCnt);
	}
	@Test
	public void deleteMemberTest() {
		/***Given***/
		
		String userid = "bani";
		memberDao.deleteMember(userid);
		
		/***When***/

		/***Then***/
	}
	
	
}
