package kr.or.ddit.member.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import kr.or.ddit.member.model.MemberVO;

public class MemberDaoTest2 {

	@Test
	public void selectAllMember() {
		/***Given***/
		MemberDaoI memDao = new MemberDao();


		/***When***/
		List<MemberVO> memList = memDao.selectAllMember();
		
		/***Then***/
		assertEquals(5, memList.size());
		
		
	}

}
