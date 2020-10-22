package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.catalina.connector.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.FileUpload.FileUploadUtil;
import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;

/**
 * Servlet implementation class MemberRegistServlet
 */
@WebServlet("/memberRegist")
@MultipartConfig
public class MemberRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private MemberServiceI memberService;
	private static final Logger logger = LoggerFactory.getLogger(MemberRegistServlet.class);
	
	@Override
	public void init() throws ServletException {
		memberService = new MemberService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/member/memberRegist.jsp").forward(request, response);
	}
	
	//doXXX메서드에는 request, response 인자말고 다른 객체를 인자로 받아서 쓸수 있음=>  spring
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userid = request.getParameter("userid");
		String usernm = request.getParameter("usernm");
		String alias = request.getParameter("alias");
		String pass = request.getParameter("pass");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String zipcode = request.getParameter("zipcode");
		logger.debug("parameter: {}, {}, {}, {}, {}, {}, {}", userid, usernm, alias, pass, addr1, addr2, zipcode);
		
		Part profile = request.getPart("realFilename");
		logger.debug("file : {}",profile.getHeader("Content-Disposition"));
		
		String realFilename = FileUploadUtil.getFilename(profile.getHeader("Content-Disposition"));
		String fileName = UUID.randomUUID().toString();
		String filePath ="";
		String ext = FileUploadUtil.getExtenstion(realFilename);
		
		if(profile.getSize()>0) {
			filePath = "D:\\profile\\"+fileName+"."+ext;
			profile.write(filePath);
		}
		// 사용자 정보등록
		
		MemberVO memberVO = new MemberVO(userid, pass,  usernm,  alias,  addr1,  addr2,  zipcode, filePath, realFilename);
		int res = memberService.insertMember(memberVO);
		//1건이 입력되어있을때, 1건이아닐때 비정상
		
		if(res == 1) {
			response.sendRedirect(request.getContextPath()+"/getpage");
		}else {
			//화면요청
		doGet(request, response);
		}
	}

	
}
