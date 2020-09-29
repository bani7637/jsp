package kr.or.ddit.delegate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class RedirectrServlet
 */
@WebServlet("/redirectServlet")
public class RedirectrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	//인자로 입력한 클래스의 패키지 확인 : kr.or.ddit.delegate.RedirectServlet
	private static Logger logger = LoggerFactory.getLogger(RedirectrServlet.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// servlet은 응답을 만들어 내는 역할이 아니라 요청을 받아 로직을 처리한 후 
		// jsp에게 화면을 응답 생성위임한다.
		
		//문자열 결합만 조심하자 "redirectServlet" "doGet()"
		logger.debug("redirectServlet {} {}", "doGet()", "test");
		// 응답을 다른 jsp에게 위임하는 첫번째 방법 : redirect
		// response객체의 sendRedirect 메소드를 통해 클라이언트에게 재요청을 보낸 주소를 알려준다.
		
		//클라이언트 최초요청 : http://localhosr/redirectServlet
		//서버에서redirectrServlet의 service메서드 호출
		//		클라이언트가 보낸 요청이 get방식이기 때문에 service => doGet()호출
		//		response객체를 이용하여 다른jsp파일로 클라이언트에게 재요청 보낼것을 안내 
		// 		클라이언트가 최초 요청에 대한응답(redirect 응답)을 받고서 서버의 안내대로 
		// 		http://localhosr/redirectServlet.jsp로 재요청.
		// 그래서 최종적으로 클라이언트의 주소줄에는 jsp요청에 대한 주소가 남는다.
		// 클라이언트 입장에서는 서버로 요청을 총 2번 보내게 된다.
		// contextPath : jsp => /delegate/redirectView.jsp
		// contextPath : ROOT(/) => jsp/delegate/redirectView.jsp
		
		List<String>rangers = new ArrayList<String>();
		rangers.add("brown");
		rangers.add("sally");
		rangers.add("cony");
		
		request.setAttribute("rangers", rangers);
		
		// 서버가 redirect로 응답을 할 경우 클라이언트는 해당 주소로 새로운 요청을 보내기 때문에 
		// servlet에서 request 스코프에 설정한 속성은 사용할 수 없기 때문에 에러발생
		
		// response.sendRedirect(request.getContextPath()+"/delegate/redirectView.jsp");
		response.sendRedirect("/delegate/redirectView.jsp");
		
		
		
	
	}

	

}
