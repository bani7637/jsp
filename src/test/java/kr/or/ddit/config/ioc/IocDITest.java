package kr.or.ddit.config.ioc;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;
import kr.or.ddit.person.model.Person;
//메인메서드 동일
@RunWith(SpringJUnit4ClassRunner.class)

//설정파일 설정
@ContextConfiguration(locations = {"classpath:kr/or/ddit/config/spring/ioc/ioc.xml"})
// ContextConfiguration() => locations ={배열이기때문에 중괄호 필수} / value 자주 쓰임 

public class IocDITest {
	
	//ioc.xml을 바탕으로 스프링 빈이 잘 생성되었는지 확인
	//setter - boardService, constructor-boardServiceC 주입확인
	
	//DI 
	// 생성하지 않고 주입해서 사용@Autowired
	// 스프링 빈중에 호환되는 타입의 빈이 있을 경우에 주입됨
	@Autowired
	ApplicationContext context;
	
	@Resource(name ="boardServiceC")
	BoardService boardServiceC;
	
	@Resource(name ="boardService")
	BoardService boardService;
	
	@Resource(name ="person")
	Person person;
	
	
	// 스프링 컨테이너를 주입받아 DL을 통해 boardService스프링 빈이 제대로 생성되었는지 확인))Test1
	@Test
	public void DItest() {
		/***Given***/
		// 컨테이너를 생성하지않아도 테스트 가능 (어노테이션 설정시)

		/***When***/
		BoardServiceI boardService = context.getBean("boardService", BoardServiceI.class);
		BoardVO boardVO = boardService.getBoard(1);

		/***Then***/
		assertEquals("첫번째글", boardVO.getTitle());
	}

	@Test
	public void DItest2() {
		/***Given***/
		
		/***When***/

		/***Then***/
		assertNotNull(boardServiceC);
		
	}
	
	// 스프링 빈에 주입한 boardRepository 스프링빈은 동일한 빈이므로
	// 두객체의 getter메소드를 통해
	// 얻어온 repository객체는 동일해야함.
	
	@Test
	public void repositoryTest() {
		/***Given***/
		
		/***When***/
		
		/***Then***/
		assertEquals(boardService.getBoardRepository(),boardServiceC.getBoardRepository());
		
	}

	@Test
	public void propertyValueRefTest() {
		/***Given***/
		
		/***When***/
		
		/***Then***/
		assertEquals(30, person.getAge());//property value속성으로 값 지정해줌
		assertEquals("내용", person.getBoardRepository().getBoard(1).getContent());
		
		
		
	}

}
