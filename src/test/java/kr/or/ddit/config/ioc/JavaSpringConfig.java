package kr.or.ddit.config.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kr.or.ddit.board.repository.BoardRepository;
import kr.or.ddit.board.repository.BoardRepositoryI;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;

@Configuration
public class JavaSpringConfig {
	
	//boardRepository, boardService
	//메소드 이름 => 스프링 빈이름
	// 만약 xml이었다면...
	// <bean id ="boardRepository(메소드이름)" class="BoardRepository"/>
	@Bean
	public BoardRepositoryI boardRepository() {
		// 타입은 BoardRepositoryI말고 구현체인 BoardRepository가 와도 됨
		return new BoardRepository();
		//반복생성 하는 것처럼 보이지만 반복생성 하지 않고 초기에 생성된 객체로 사용함**
	}
	
	// 만약 xml이었다면...
	// <bean id ="boardService(메소드이름)" class="boardService"/>
	@Bean
	public BoardService boardService() {
		BoardService boardService = new BoardService();
		//1)boardService.setBoardRepository(new BoardRepository());
		//	직접 new 연산자를 통해 생성한 객체는 스프링 빈이 아니다.
		//	@Bean 어노테이션이 붙은 메소드를 호출해야 스프링 컨테이너에서 관리되는 스프링빈을 얻을 수 있음
		
		boardService.setBoardRepository(boardRepository());
		return boardService;
	}
}
