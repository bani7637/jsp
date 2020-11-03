package kr.or.ddit.config.ioc;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.repository.BoardRepositoryI;
import kr.or.ddit.board.service.BoardServiceI;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:kr/or/ddit/config/spring/ioc/component-scan.xml"})
public class componentScanTest {

	@Resource(name = "boardRepository")
	private BoardRepositoryI boardRepository;
	
	@Resource(name = "boardService")
	private BoardServiceI boardSerivice;
	
	@Test
	public void componentTest() {
		/***Given***/
		

		/***When***/
		BoardVO boardVO = boardSerivice.getBoard(1);
		/***Then***/
		assertNotNull(boardRepository);
		assertNotNull(boardSerivice);
		assertEquals("첫번째글", boardVO.getTitle());
	}

}