package kr.or.ddit.member.controller;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.DebugGraphics;

import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;

@WebServlet("/profileDownload")
public class profileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberServiceI memberService;
	
	@Override
		public void init() throws ServletException {
			memberService = new MemberService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid = request.getParameter("userid");
		
		//db에서 사용자 filename 확인 경로 확인후
		MemberVO memberVO = memberService.getMember(userid);
		
		response.setHeader("Content-Disposition", "attachment; filename=\""+memberVO.getRealFilename()+"\"");
		response.setContentType("application/octet-stream"); 
		
		//파일 입출력을 통해 응답생성
		//파일 읽기 
		//응답생성 - contentType을(img, ..) 지정해주는것이 맞지만 안해줘도 크롬이 알아서 판단(부하가걸림)

		FileInputStream fis = new FileInputStream(memberVO.getFilename());
		
		ServletOutputStream sos = response.getOutputStream();
		
		byte[] buffer = new byte[512];
		
		while(fis.read(buffer)!=-1) {
			sos.write(buffer);
		}
		
		fis.close();
		
		sos.flush();
		sos.close();
	}

}
