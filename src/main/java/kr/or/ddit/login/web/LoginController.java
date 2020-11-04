package kr.or.ddit.login.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;

//@webServlet 혹은 web.xml url-mapping을 통해 url등록
@SessionAttributes("rangers")
@RequestMapping("/login")
@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Resource(name = "MemberService")
	private MemberServiceI memberService;

	
	// 모든 요청 메서드를 처리하기전에 가장 먼저 실행
	@ModelAttribute("rangers")
	public List<String> ranger(){
		logger.debug("ranger()");
		List<String> rangers = new ArrayList<String>();
		rangers.add("brown");
		rangers.add("cony");
		rangers.add("sally");
		
		return rangers;
	}
	
	
	
	
	// localhost/login/view 요청 처리 메소드
	// 요청 메소드가 get 일때만 처리
	@RequestMapping(path = "/view", method = { RequestMethod.GET })
	public String getView() {
		logger.debug("LoginController.getView()");

		return "login/view";
		// viewname을 리턴
		// jsp 파일을 WEB-INF아래에 만듬 => 사용자가 jsp 파일을 건들지 못하도록
	}

	// 파라미터 이름과 동일한 이름의 메소드 인자를 선언하면 스프링 프레임워크가 자동으로 바인딩해줌
	// -> 파라미터를 받을 수 있음
	// 값을 담을 수 있는 객체를 메소드 인자로 선언한 경우에도 필드명과 파라미터 명이 동일하면
	// 자동으로 바인딩 처리를 해준다.
	// 이때 값을 담는 객체를 스프링 프레임워크에서는 command 객체라고 명명한다.

	// Model : view 객체에서 응답을 생성할때 참조할 데이터를 담는 객체
	// jsp/servlet 기반의 request 역할을 담당

	@RequestMapping(path = "/process", params = { "userid" })
	public String process(String userid, String pass, MemberVO memberVO, HttpSession session, Model model,
			@RequestParam(name = "email", required = false, defaultValue = "brown@line.kr") String user_id) {

		logger.debug("LoginController.process() {} / {} / {}", userid, pass, memberVO);
		logger.debug("user_id : {}", user_id);

		MemberVO dbmemVO = memberService.getMember(userid);

		if (dbmemVO != null && pass.equals(dbmemVO.getPass())) {
			logger.debug("getMember() {}", dbmemVO);
			session.setAttribute("S_MEMBER", dbmemVO);

			// jsp/servlet 기반의
			// request.setAttribute("to_day", new Date());와 동일함
			model.addAttribute("to_day", new Date());

			return "main";
		} else {
			logger.debug("getMember() : 회원정보없음!");
			model.addAttribute("msg", "fail");
			return "login/view";
		}
	}
	
	//localhost/login/unt/h
	@RequestMapping("/unt/{unt_cd}")
	public String untMain(@PathVariable("unt_cd") String unt_cd) {
		logger.debug("unt_cd : {}", unt_cd);
		return "main";
	}
	
	//localhost/login/mavView
	@RequestMapping("/mavView")
	public ModelAndView mavView(@ModelAttribute("rangers") List<String> rangers,
			@ModelAttribute("test") MemberVO memberVO) {
		ModelAndView mav = new ModelAndView();
		
		logger.debug("mavView/rangers : {}", rangers);
		//viewName 설정
		mav.setViewName("main");
		
		mav.getModel().put("msg", "success");
		mav.getModelMap().addAttribute("msg", "fail");
		
		return mav;
	}
}
