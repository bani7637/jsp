package kr.or.ddit.login.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberServiceI;

//@webServlet 혹은 web.xml url-mapping을 통해 url등록
@SessionAttributes("rangers")
@RequestMapping("/login")
@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Resource(name = "MemberService")
	private MemberServiceI memberService;
	//인터페이스로 해야지 aop할 수 있음 
	
	// 모든 요청 메서드를 처리하기전에 가장 먼저 실행
	@ModelAttribute("rangers")
	public List<String> ranger(){
		List<String> rangers = new ArrayList<String>();
		rangers.add("brown");
		rangers.add("cony");
		rangers.add("sally");
		logger.debug("rangers: {}", rangers );
		
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
	public String process(String userid, String pass, MemberVO memberVO,@RequestBody String body, HttpSession session, Model model,
			@RequestParam(name = "email", required = false, defaultValue = "brown@line.kr") String user_id) {
		
		logger.debug("LoginController.process() {} / {} / {}", userid, pass, memberVO);
		MemberVO dbmemVO = memberService.getMember(userid);
		logger.debug("body :{}",body);
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
	
	//localhost/login/json
	//콘트롤러 메서드 호출 순서
	//ranger() ==> model객체에 rangers라는 이름의 속성이 저장 ==> json()
	//model객체 속성이 존재(rangers)
	@RequestMapping("/json")
	public String json() {
		
		return "jsonView";	//<bean id="jsonView" class="MappingJackson2JsonView"
		// view resolver 현재 2개등록함
		// 우선순위는 0순위 beanNameViewResolver
		//			1순위 InternalResourceViewResolver
		// 0순위에서 viewName 해당하는 빈이 있는지 찾음
		// 만약 해당하는 bean(view)이 있으면 해당 view결과를 생성
		// 0순위에서 해당빈을 찾지못하면
		// 1순위로 이동
		// prefix, surfix 설정에 따라 /WEB-INF/views/jsonView.jsp
		// 1순위에는 view이름에 해당하는 자원이 존재 유무를 확인하지 않고 무조건 forwarding
		// viewResolver순위를 가장 후순위로 미뤄야함
		
	}
}
