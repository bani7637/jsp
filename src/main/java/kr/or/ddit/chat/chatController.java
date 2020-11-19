package kr.or.ddit.chat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.member.model.MemberVO;

@Controller
@RequestMapping("/chat")
public class chatController {
	
	@RequestMapping(value = "/chatting.do", method = { RequestMethod.GET })
	public ModelAndView chat(ModelAndView mv) {
		mv.setViewName("chat/chattingview");
		return mv;
	}

	
	
	
}
