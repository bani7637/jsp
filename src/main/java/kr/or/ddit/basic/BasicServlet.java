package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 서블릿을 생성하는 방법
// 1. HttpServlet을 상속한다.
// 2. doXXX메소드를 구현한다.
// 3. servlet은 정적자료와 다르게 이름이 없다.
//    localhost/BasicServlet.java
//    url -> 서블릿 매핑하는 작업
//    url에 직접 이름을 생성해줘야한다.(web.xml)
public class BasicServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		
		// writer객체를 통해 Html 문서를 생성한다.
		PrintWriter writer = resp.getWriter();
		
		// Html
		writer.println("<html>");
		writer.println("	<head></head>");		
		writer.println("	<body>현재시간 :"+ new Date() +"</body>");
		writer.println("</html>");
		writer.flush();
		writer.close();
		// void타입
		
	}
	
	
}
