package kr.or.ddit.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;

/**
 * Servlet implementation class memberUpdate
 */
@WebServlet("/memUpdate")
public class memberUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private MemberServiceI memberService;
	
	@Override
	public void init() throws ServletException {
		memberService = new MemberService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		MemberVO memberVO = memberService.getMember(userid);
		request.setAttribute("memberVO", memberVO);
		request.getRequestDispatcher("/member/memupdate.jsp").forward(request, response);	
	}
	

}
