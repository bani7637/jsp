package kr.or.ddit.cookie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CookieSplit {

	// cookieStrim 문자열 변수에 담긴 값은 쿠기 이름 = 쿠키값 형태로 구성
	// 구성된 쿠키 이름과 같은 상황에 따라 변경될 수 있음
	private String cookieString = "USERNM=brown;REMEMBERME=Y;TEST=T;";
	private static final Logger logger = LoggerFactory.getLogger(CookieSplit.class);

	public static void main(String[] args) {
		CookieSplit cookieSplit = new CookieSplit();
		logger.debug(cookieSplit.getCookieValue("USERNM")); // 기대되는 값 brown
		logger.debug(cookieSplit.getCookieValue("REMEMBERME")); // 기대되는값 Y
		logger.debug(cookieSplit.getCookieValue("xxx")); // 기대되는값 ""(WHITE SPACE)
	}

	// cookieString 필드를 분석하여 메소드 인자로 넘어온 cookieName에 해당하는 쿠키가 있을경우
	// 해당 쿠키의 값을 반환하는 메소드
	public String getCookieValue(String cookieName) {
		String c[] = cookieString.split(";|=");
		String k1 = "";
		for(int i=0;i<c.length;i++) {
			if (c[i].equals(cookieName)) {
				k1 = c[i+1];
			}
		}
		return k1;

	}
}
