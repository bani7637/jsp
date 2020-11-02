package kr.or.ddit.login;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;


@WebServlet("/login")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(loginServlet.class);

	/////////////////////////////////////////di안되는경우///////////////////
	//서블릿의 제어권은 톰캣이 가지고있기때문에 서블릿에 주입이 안됨!
	@Resource(name ="boardService")
	private BoardServiceI BoardService;
	////////////////////////////////////////////////////////////////////
	
	@Override
	public void init() throws ServletException {	
	}
	
  

	//login 화면을 클라이언트에게 응답으로 생성
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("RequestCounterFilter 전처리 끝, loginservlet-doGet ");
		logger.debug("UNT_CD parameter : {}", req.getParameter("UNT_CD"));
		req.getRequestDispatcher("/login.jsp").forward(req, resp);
	}
}
