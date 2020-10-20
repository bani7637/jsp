package kr.or.ddit.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;

@WebServlet("/login")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(loginServlet.class);
	
	//
	private MemberServiceI memService;
	
	@Override
	public void init() throws ServletException {	
		memService = new MemberService();
	}
	
    //longin 화면에서 사용자가 보낸 아이디 비밀번호를 사용하여 로그인 처리   
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		logger.debug("userId : {}, password : {}", userId, password);
		
		// 파라미터로 온 userId가 db상에 존재하는지 확인하고, 비밀번홎가 데이터베이스에 저장된 비밀번호와 일치하는지 확인
		MemberVO memvo = memService.getMember(userId);
		
		// db에 등록된 회원이 없는 경우 또는 db에 등록된 회원이고, 비밀번호가 일치하지 않는 경우 다시로그인 페이지로이동
		if(memvo == null || !memvo.getPass().equals(password)) {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		// db에 등록된 회원이고, 비밀번호가 일치하는 경우 메인페이지 이동
		else if(memvo.getPass().equals(password)) {
			request.getSession().setAttribute("S_MEMBER", memvo);
			request.getRequestDispatcher("/main.jsp").forward(request, response);			
		}
		
		
		
		//쿠키정보 확인
		Cookie[]cookies = request.getCookies();
		for(Cookie cookie : cookies) {
			logger.debug("cookieName : {}, value : {}", cookie.getName(), cookie.getValue());
		}
		Cookie cookie = new Cookie("SERVERCOOKIE", "COOKIEVALUE");	
		cookie.setMaxAge(60*60*24);
		
		//응답할때 쿠키도 가져가라구
		response.addCookie(cookie);
		
	}

	//login 화면을 클라이언트에게 응답으로 생성
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		logger.debug("RequestCounterFilter 전처리 끝, loginservlet ");
		req.getRequestDispatcher("/login.jsp").forward(req, resp);
	}
}
