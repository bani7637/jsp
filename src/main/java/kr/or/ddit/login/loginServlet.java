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

@WebServlet("/login")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(loginServlet.class);
	
    //longin 화면에서 사용자가 보낸 아이디 비밀번호를 사용하여 로그인 처리   
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		logger.debug("userId : {}, password : {}", userId, password);
		
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

	//longin 화면을 클라이언트에게 응답으로 생성
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/login.jsp").forward(req, resp);
	}
}
