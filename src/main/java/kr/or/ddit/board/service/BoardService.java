package kr.or.ddit.board.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.repository.BoardRepositoryI;

@Service("boardService")
//<bean id ="boardService"/> 동일
public class BoardService implements BoardServiceI{
	
	@Resource(name = "boardRepository")
	private BoardRepositoryI boardRepository;

	
	public BoardRepositoryI getBoardRepository() {
		return boardRepository;
	}

	public void setBoardRepository(BoardRepositoryI boardRepository) {
		this.boardRepository = boardRepository;
	}

	//기본생성자
	public BoardService() {
	}

	//인자값 있는 생성자
	public BoardService(BoardRepositoryI boardRepository) {
		this.boardRepository = boardRepository;
	}

	@Override
	public BoardVO getBoard(int boardNo) {
		return boardRepository.getBoard(boardNo);
	}

	
}
