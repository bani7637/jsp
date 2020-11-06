package kr.or.ddit.member.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.FileUpload.FileUploadUtil;
import kr.or.ddit.login.web.LoginController;
import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.model.PageVO;
import kr.or.ddit.member.service.MemberServiceI;

@RequestMapping("/member")
@Controller
public class memberContorller {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Resource(name = "MemberService")
	private MemberServiceI memberService;

	@RequestMapping("/member")
	public String getMember(String userid, Model model) {
		MemberVO memberVO = memberService.getMember(userid);
		model.addAttribute("memberVO", memberVO);
		return "member/member";
	}

	@RequestMapping("/memberList")
	public String getMemList(Model model, @RequestParam(name ="page", required=false, defaultValue="1") int page,
				@RequestParam(name ="pageSize", required=false, defaultValue="5") int pageSize) {
		PageVO pv = new PageVO();
		pv.setPage(page);
		pv.setPageSize(pageSize);
		Map<String, Object>map = memberService.selectMemberPageList(pv);
		model.addAttribute("memList", map.get("memberList"));
		model.addAttribute("pages", map.get("pages"));
		model.addAttribute("pageSize", map.get("pageSize"));
		logger.debug("memList:{}", map.get("pages"));
		return "member/memberList";
	}
	
	
	@RequestMapping(path = "/memUpdate", method = { RequestMethod.GET })
	public String updateMember_view(String userid, Model model) {
		MemberVO db_memberVO = memberService.getMember(userid);
		model.addAttribute("memberVO", db_memberVO);
		return "member/memupdate";
	}

	@RequestMapping(path = "/memUpdate", method = { RequestMethod.POST })
	public String updateMember(MemberVO memberVO, @RequestPart("realfilename") MultipartFile multipartFile) {

		String realfilename = multipartFile.getOriginalFilename();
		String fileName = UUID.randomUUID().toString();
		String filePath = "";
		String ext = FileUploadUtil.getExtenstion(realfilename);

		if (realfilename.getBytes().length!=0) {
			filePath = "d:\\upload_Spring\\" + fileName + "." + ext;
			File uploadFile = new File("d:\\upload_Spring\\" + multipartFile.getOriginalFilename());

			try {
				multipartFile.transferTo(uploadFile);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}

		if (realfilename == null || realfilename.equals("")) {
			MemberVO memberVOtest = memberService.getMember(memberVO.getUserid());
			realfilename = memberVOtest.getRealFilename();
			filePath = memberVOtest.getFilename();
		}
		
		MemberVO memberVO3 = new MemberVO(memberVO.getUserid(), memberVO.getPass(), memberVO.getUsernm(),
				memberVO.getAlias(), memberVO.getAddr1(), memberVO.getAddr2(), memberVO.getZipcode(), filePath,
				realfilename);

		int res = memberService.updateMember(memberVO3);
		if (res == 1) {
			return "redirect:/member/memberList";
		} else {
			return "member/memupdate";
		}

	}

	@RequestMapping(path = "/memberRegist", method = { RequestMethod.GET })
	public String regMember_view() {
		return "member/memberRegist";
	}

	@RequestMapping(path = "/memberRegist", method = { RequestMethod.POST })
	public String regMember(MemberVO memberVO, @RequestPart("realfilename") MultipartFile multipartFile) {
		File uploadFile = new File("d:\\upload_Spring\\" + multipartFile.getOriginalFilename());

		try {
			multipartFile.transferTo(uploadFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}

		String realfilename = multipartFile.getOriginalFilename();
		String fileName = UUID.randomUUID().toString();
		String filePath = "";
		String ext = FileUploadUtil.getExtenstion(realfilename);
		
		if (realfilename.getBytes().length!=0 ) {
			filePath = "d:\\upload_Spring\\" + fileName + "." + ext;
		}

		MemberVO memberVO3 = new MemberVO(memberVO.getUserid(), memberVO.getPass(), memberVO.getUsernm(),
				memberVO.getAlias(), memberVO.getAddr1(), memberVO.getAddr2(), memberVO.getZipcode(), filePath,
				realfilename);
		int res = memberService.insertMember(memberVO3);
		if (res == 1) {
			return "redirect:/member/memberList";
		} else {
			return "member/memberRegist";
		}
	}

	@RequestMapping("/memDelete")
	public String memDelete(String userid) {
		int res = memberService.deleteMember(userid);
		if (res == 1) {
			return "redirect:/member/memberList";
		} else {
			return "member/memupdate";
		}
	}
	
	

}