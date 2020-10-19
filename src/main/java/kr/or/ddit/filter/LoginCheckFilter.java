package kr.or.ddit.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.member.model.MemberVO;

/**
 * Servlet Filter implementation class LoginCheckFilter
 */
//@WebFilter("/*")
public class LoginCheckFilter implements Filter {
	private static final Logger logger = LoggerFactory.getLogger(LoginCheckFilter.class);
	
    public LoginCheckFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		logger.debug("LoginCheckFilter.dofilter()");
		
		//session에 s_member이름으로 속성이 존재하면 정상적으로 로그인한 케이스
		// 없으면 로그인 하지 않은 상태로 접속시도 
		// get, post login ==>s_member속성없는게 당연
		HttpServletRequest req = (HttpServletRequest)request;
		String uri = req.getRequestURI();
		if(uri.equals("/login")||uri.endsWith(".js")||uri.endsWith(".css")||uri.endsWith(".map")) {
			chain.doFilter(request, response);			
		}
		else {
			HttpSession session = req.getSession();
			session.getAttribute("S_MEMBER");
			MemberVO se_member = (MemberVO)session.getAttribute("S_MEMBER");
			
			//정상로그인상태
			if(se_member!=null) {
				chain.doFilter(request, response);							
			}
			//로그인하지않은 상태(/login화면으로 재요청 지시)
			else {
				HttpServletResponse resp = (HttpServletResponse)response;
				resp.sendRedirect(req.getContextPath()+"/login");
			}
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
