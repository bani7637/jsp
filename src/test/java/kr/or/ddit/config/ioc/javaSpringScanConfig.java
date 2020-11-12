package kr.or.ddit.config.ioc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.context.annotation.Configuration;

import kr.or.ddit.WebTestConfig;
import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.repository.BoardRepositoryI;
import kr.or.ddit.board.service.BoardServiceI;

@Configuration
public class javaSpringScanConfig extends WebTestConfig{
	
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
