package kr.or.ddit.member.repository;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.ModelTestConfig;
import kr.or.ddit.WebTestConfig;
import kr.or.ddit.member.Dao.MemberDaoI;
import kr.or.ddit.member.model.MemberVO;


public class MemberDaoTest extends ModelTestConfig{

	
	
	@Resource(name = "MemberDao")
	private MemberDaoI memberDao;
	
	@Test
	public void selectAllMemberTest() {
		/***Given***/
		/***When***/
		List<MemberVO> memList = memberDao.selectAllMember();
		/***Then***/
		assertTrue(memList.size()>13);
	}

}
