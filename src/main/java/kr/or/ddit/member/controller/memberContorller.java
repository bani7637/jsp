package kr.or.ddit.member.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.validation.Valid;

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
		//return "member/memberList";
		//tiles-definition에 지정한 이름으로 설정
		return "tiles/member/memberList_content";
	}
	
	
	@RequestMapping(path = "/memUpdate", method = { RequestMethod.GET })
	public String updateMember_view(String userid, Model model) {
		MemberVO db_memberVO = memberService.getMember(userid);
		model.addAttribute("memberVO", db_memberVO);
		return "tiles/member/memupdate";
	}

	@RequestMapping(path = "/memUpdate", method = { RequestMethod.POST })
	public String updateMember(MemberVO memberVO, @RequestPart("realfilename") MultipartFile multipartFile) {

		String realfilename = multipartFile.getOriginalFilename();
		String fileName = UUID.randomUUID().toString();
		String filePath = "";
		String ext = FileUploadUtil.getExtenstion(realfilename);

		if (realfilename.getBytes().length!=0) {
			filePath = "D:\\profile\\" + fileName + "." + ext;
			File uploadFile = new File("D:\\profile\\" + multipartFile.getOriginalFilename());
			
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
			return "tiles/member/memupdate";
		}

	}

	@RequestMapping(path = "/memberRegist", method = { RequestMethod.GET })
	public String regMember_view() {
		return "tiles/member/memberRegist";
	}

	@RequestMapping(path = "/memberRegist", method = { RequestMethod.POST })
	public String regMember(@Valid MemberVO memberVO, BindingResult br, @RequestPart("realfilename") MultipartFile multipartFile) {
	//public String regMember(@Valid JSRMemberVo memberVO, BindingResult br, @RequestPart("realfilename") MultipartFile multipartFile) {
		
		
		
		//new MemberVoValidator().validate(memberVO, br);
		
		// 에러가 있을 경우(검증을 통과하지 못한 경우) 사용자 등록 화면으로 이동
		if(br.hasErrors()) {
			return "tiles/member/memberRegist";
		}
		

	
		String realfilename = multipartFile.getOriginalFilename();
		String fileName = UUID.randomUUID().toString();
		String filePath = "";
		String ext = FileUploadUtil.getExtenstion(realfilename);
		
		if (realfilename.getBytes().length!=0 ) {
			filePath = "D:\\profile\\" + fileName + "." + ext;
		}
		
		File uploadFile = new File("D:\\profile\\" + fileName+"."+ext);
		try {
			multipartFile.transferTo(uploadFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}

		MemberVO memberVO3 = new MemberVO(memberVO.getUserid(), memberVO.getPass(), memberVO.getUsernm(),
				memberVO.getAlias(), memberVO.getAddr1(), memberVO.getAddr2(), memberVO.getZipcode(), filePath,
				realfilename);
		int res = memberService.insertMember(memberVO3);
		if (res == 1) {
			return "redirect:/member/memberList";
		} else {
			return "tiles/member/memberRegist";
		}
	}

	@RequestMapping("/memDelete")
	public String memDelete(String userid) {
		//session.getAttribute("userid");

		int res = memberService.deleteMember(userid);
		if (res == 1) {
			return "redirect:/member/memberList";
			
		} else {
			return "tiles/member/memupdate";
		}
	}
	
	@RequestMapping("/listAjaxPage")
	public String listAjaxPage() {
		return "tiles/member/listAjaxPage";
	}
	
	//페이지 요청 list와 다르게 page, pageSize 파라미터가 반드시 존재한다는 가정으로 작성
	//jsonview로 응답
	@RequestMapping("/listAjax")
	public String listAjax(PageVO pageVo, Model model) {
		logger.debug("pageVO : {}", pageVo);
		
		Map<String, Object>map = memberService.selectMemberPageList(pageVo);
		model.addAttribute("memList", map.get("memberList"));
		model.addAttribute("pages", map.get("pages"));
		model.addAttribute("pageSize", map.get("pageSize"));
		
		return "jsonView";
	}
	
	// 응답을 html => jsp로 생성
	@RequestMapping("/listAjaxHTML")
	public String listAjaxHTML(PageVO pageVo, Model model) {
		logger.debug("pageVO : {}", pageVo);
		
		Map<String, Object>map = memberService.selectMemberPageList(pageVo);
		model.addAttribute("memList", map.get("memberList"));
		model.addAttribute("pages", map.get("pages"));
		model.addAttribute("pageSize", map.get("pageSize"));
		
		return "member/listAjaxHTML";
	}
	
	@RequestMapping("/member")
	public String getMember(String userid, Model model) {
		MemberVO memberVO = memberService.getMember(userid);
		model.addAttribute("memberVO", memberVO);
		return "tiles/member/member";
	}
	
	@RequestMapping("/memberAjaxPage")
	public String memberAjaxPage() {
		
		return "tiles/member/memberAjax";
	}
	
	@RequestMapping("/getmemberAjax")
	public String getmemberAjax(String userid, Model model) {
		MemberVO memberVO = memberService.getMember(userid);
		model.addAttribute("memberVO", memberVO);
		return "jsonView";
	}
}