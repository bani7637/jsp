package kr.or.ddit.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//@webServlet 혹은 web.xml url-mapping을 통해 url등록
@RequestMapping("/login")
@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	//localhost/login/view 요청 처리 메소드
	@RequestMapping("/view.do")
	public String getView() {
		logger.debug("getView()");
		return "login/view";
		//viewname을 리턴
		//jsp 파일을 WEB-INF아래에 만듬 => 사용자가 jsp 파일을 건들지 못하도록
	}
}
