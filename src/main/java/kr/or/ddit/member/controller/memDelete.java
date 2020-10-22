package kr.or.ddit.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;

/**
 * Servlet implementation class memDelete
 */
@WebServlet("/memDelete")
public class memDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberServiceI memberService;
	private static final Logger logger = LoggerFactory.getLogger(memDelete.class);
	
	@Override
	public void init() throws ServletException {
		memberService = new MemberService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		int res = memberService.deleteMember(userid);
		logger.debug("userid :{}", userid);
		if(res>=1) {
			response.sendRedirect(request.getContextPath()+"/getpage");
		}else {
			request.getRequestDispatcher("/member/memupdate.jsp").forward(request, response);
		}
	}

}
