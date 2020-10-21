package kr.or.ddit.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.member.model.MemberVO;

public class SessionAttributeListener implements HttpSessionAttributeListener{
	private static final Logger logger = LoggerFactory.getLogger(SessionAttributeListener.class);
	private Map<String, MemberVO> userMap = new HashMap<>();
			//  userid , memberVO
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		if("S_MEMBER".equals(event.getName()));
		
		MemberVO memberVo =(MemberVO)event.getValue();
		logger.debug("사용자 로그인: {}",memberVo.getUserid());
		
		userMap.put(memberVo.getUserid(),memberVo);
		
		ServletContext sc = event.getSession().getServletContext();
		sc.setAttribute("userMap", userMap);
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		if("S_MEMBER".equals(event.getName())) {
		MemberVO memberVO = (MemberVO)event.getValue();
		userMap.remove(memberVO.getUserid());
//		ServletContext sc = event.getSession().getServletContext();
//		sc.setAttribute("userMap", userMap);
//		위 코드를 안하는 이유는 이미 userMap이 힙영역에 저장되어있기때문에 다시 설정할필요없음
		
		}
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		
	}

}
