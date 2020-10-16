package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;

import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.model.PageVO;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;

/**
 * Servlet implementation class MemberGetPage
 */
@WebServlet("/getpage")
public class MemberGetPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberServiceI memberService;
	
	@Override
	public void init() throws ServletException {
		memberService = new MemberService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page_str = request.getParameter("page");
		int page = page_str == null ? 1 : Integer.parseInt(page_str);
		request.setAttribute("page", page);

		String page_size = request.getParameter("pageSize");
		int pageSize = page_size == null ? 5 : Integer.parseInt(page_size);
		request.setAttribute("pageSize", pageSize);
		
		PageVO pv = new PageVO();
		pv.setPage(page);
		pv.setPageSize(pageSize);
		
		Map<String, Object>map = memberService.selectMemberPageList(pv);
		
		request.setAttribute("memList", map.get("memberList"));
		request.setAttribute("pages", map.get("pages"));
		request.setAttribute("pageSize", map.get("pageSize"));
		
		request.getRequestDispatcher("/member/memberList.jsp").forward(request, response);
	
	}


}
