package kr.or.ddit.mvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.or.ddit.member.model.MemberVO;

public class SessionChekInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// 사용자가 정상적으로 접속 했는지 체크
		// loginController컨트롤러를 통해 정상적으로 접속 했을 경우
		// Session에 S_MEMBER속성이 존재함.
		HttpSession session = request.getSession();
		MemberVO memberVO = (MemberVO)session.getAttribute("S_MEMBER");
		
		if(memberVO==null) {
			response.sendRedirect("/login/view");
			return false;
		}
		
		return true;
	}
}
