package kr.or.ddit.mvc.redirect.web;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/redirect")
@Controller
public class RedirectController {
	private static final Logger logger = LoggerFactory.getLogger(RedirectController.class);

	// 요청시 /login/view.jsp로 리다이렉트 처리
	// localhost/redirect/process  => localhost/login/view
	@RequestMapping("/process")
	public String process(Model model, HttpSession session, RedirectAttributes ra) {
		
		logger.debug("RedirectController.process()");
		
		// 리다이렉트되면 처음요청은 사라지니까 model에 담아도 사용못함
		model.addAttribute("msg", "hello world");
		// 세션에 담으면 다음 요청에서 사용할 수 있지만 계속 사용해야함 1회성이아님 삭제하는 로직있어야함
		session.setAttribute("msg_session", "hello_sessionWorld");
		
		//리다이렉트 된 페이지에서 일회에 한해 사용할 수 있는 속성
		ra.addFlashAttribute("msg_ra", "hello world_ ra");//사용@@
		ra.addAttribute("msg_ra_attr", "brown");
		
		// 리다이텍스 모델 객체에 추가된 속성을 리다이렉트 주소의 파라미터로 추가한다.(get)
		// "redirect:/login/view" ==> /login/view?msg=hello, world
		
		return "redirect:/login/view";
	}
	
	
	
	
	
}
