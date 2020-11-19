package kr.or.ddit.chat;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class echoHandler extends TextWebSocketHandler {

	private static final Logger logger = LoggerFactory.getLogger(echoHandler.class);
	private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		sessionList.add(session);
		logger.debug("{} 연결성공", session.getId());
		logger.debug("채팅방 입장자 "+ session.getPrincipal().getName());
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		logger.debug("{}로 부터  {} 받음", session.getId(), message.getPayload());
		
		for(WebSocketSession sess : sessionList) {
			sess.sendMessage(new TextMessage(session.getPrincipal().getName()+"|"+message.getPayload()));
		}
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		sessionList.remove(session);
		logger.debug("{}",session.getId());
		logger.debug("채팅방 퇴장자 : "+session.getPrincipal().getName());
	}
	
	
}
