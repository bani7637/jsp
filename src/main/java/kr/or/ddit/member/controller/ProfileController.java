package kr.or.ddit.member.controller;

import java.io.FileInputStream;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberServiceI;

@RequestMapping("/profile")
@Controller
public class ProfileController {
	@Resource(name = "MemberService")
	MemberServiceI memberService;

	@RequestMapping("/profileImgView")
	public String profileImgGet_View(String userid, Model model) throws IOException {
		// 응답으로 생성하려고 하는 것 :  이미지 파일을 읽어서 outputStream 객체에 쓰는 것
		MemberVO memVo = memberService.getMember(userid);
		model.addAttribute("filepath", memVo.getFilename());
		
		//메서드가 호출될때마다 뷰를 생성 
		//빈객체를 생성해서 사용하면 매번 생성안해도됨!jsonView처럼!
		return "progileImgView";
	}
	
	@RequestMapping("/profileDownload")
	public String profileDownload(String userid, Model model) throws IOException {
		// 응답으로 생성하려고 하는 것 :  이미지 파일을 읽어서 outputStream 객체에 쓰는 것
		MemberVO memVo = memberService.getMember(userid);
		model.addAttribute("filepath", memVo.getFilename());
		model.addAttribute("realfilename",memVo.getRealFilename());
		
		//메서드가 호출될때마다 뷰를 생성 
		//빈객체를 생성해서 사용하면 매번 생성안해도됨!jsonView처럼!
		return "downloadImgView";
	}

	@RequestMapping("/profileImg")
	public void profileImgGet(String userid, HttpServletResponse response) throws IOException {

		response.setContentType("image/png");

		MemberVO memberVO = memberService.getMember(userid);

		FileInputStream fis = new FileInputStream(memberVO.getFilename());

		ServletOutputStream sos = response.getOutputStream();

		byte[] buffer = new byte[512];

		while (fis.read(buffer) != -1) {
			sos.write(buffer);
		}

		fis.close();

		sos.flush();
		sos.close();
	}
}
