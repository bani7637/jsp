package kr.or.ddit.db;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionPoolServlet extends HttpServlet {
	private static final Logger logger = LoggerFactory.getLogger(ConnectionPoolServlet.class);
	
	@Override
	public void init() throws ServletException {
		
		// connectionPoolServlet이 초기화 될때 커넥션 풀을 생성하여 application영역에 저장
		// 다른 jsp, servlet에서는 application 영역을 통해 커넥션 풀을 접근
		
		// 커넥션 풀 생성
		logger.debug("나오나");
		BasicDataSource bd = new BasicDataSource();
		bd.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		bd.setUrl("jdbc:oracle:thin:@localhost:1521/xe");
		bd.setUsername("bani");
		bd.setPassword("java");
		bd.setInitialSize(20);// 초기화시 커넥션 풀을 몇개 생성 할건지 정해줌
		
		ServletContext sc = getServletContext();
		sc.setAttribute("bd", bd);
	}
}
