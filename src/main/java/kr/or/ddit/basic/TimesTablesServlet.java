package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TimesTablesServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");

		PrintWriter writer = resp.getWriter();

		writer.println("<html>");
		writer.println("	<head></head>");
		writer.println("	<body>");
		writer.println("	<table border='1'>");
		
		for(int i=2; i<10; i++) {
			writer.println("	<tr>");
		
		for(int x=1; x<10; x++ ) {
			writer.println("	<td>"+x+"*"+i+"="+x*i+"</td>");			
		}
		writer.println("	</tr>");
		}
		writer.println("	<table>");
		writer.println("	</table>");
		writer.println("	</body>");
		writer.println("</html>");
		writer.flush();
		writer.close();
	}
}
