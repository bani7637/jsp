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
//설정파일이 java일때 
@ContextConfiguration(classes = {JavaSpringConfig.class} )

public class JavaSpringConfigTest {

	@Resource(name = "boardRepository")
	private BoardRepositoryI boardRepository;
	
	@Resource(name = "boardService")
	private BoardServiceI boardSerivice;
	
	@Test
	public void beanTest() {
		/***Given***/
		

		/***When***/
		BoardVO boardVO = boardSerivice.getBoard(1);
		/***Then***/
		assertNotNull(boardRepository);
		assertNotNull(boardSerivice);
		assertEquals("첫번째글", boardVO.getTitle());
	}
}
