package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.FileUpload.FileUploadUtil;
import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;
import oracle.net.aso.s;

/**
 * Servlet implementation class memberUpdate
 */
@WebServlet("/memUpdate")
@MultipartConfig
public class memberUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MemberServiceI memberService;
	private static final Logger logger = LoggerFactory.getLogger(memberUpdate.class);

	@Override
	public void init() throws ServletException {
		memberService = new MemberService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userid = request.getParameter("userid");
		MemberVO memberVO = memberService.getMember(userid);
		request.setAttribute("memberVO", memberVO);
		request.getRequestDispatcher("/member/memupdate.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userid = request.getParameter("userid");
		String usernm = request.getParameter("usernm");
		String alias = request.getParameter("alias");
		String pass = request.getParameter("pass");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String zipcode = request.getParameter("zipcode");
		
		Part profile = request.getPart("realFilename");

		String realFilename = FileUploadUtil.getFilename(profile.getHeader("Content-Disposition"));
		String fileName = UUID.randomUUID().toString();
		String ext = FileUploadUtil.getExtenstion(realFilename);
		String filePath ="";
		
		if (realFilename == null|| realFilename.equals("")) {
			MemberVO memberVO = memberService.getMember(userid);
			realFilename = memberVO.getRealFilename();
			filePath = memberVO.getFilename();

		}
		if (profile.getSize() > 0) {
			filePath = "D:\\profile\\"+fileName+"."+ext;
			profile.write(filePath);
		}
			

			
		

		MemberVO memberVO = new MemberVO(userid, pass, usernm, alias, addr1, addr2, zipcode, filePath, realFilename);

		int res = memberService.updateMember(memberVO);
		// 1건이 입력되어있을때, 1건이아닐때 비정상

		if (res == 1) {
			response.sendRedirect(request.getContextPath() + "/member?userid="+userid+"");
		} else {
			// 화면요청
			doGet(request, response);
		}
	}

}
