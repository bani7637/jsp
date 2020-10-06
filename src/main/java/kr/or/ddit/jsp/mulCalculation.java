package kr.or.ddit.jsp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class sumCalculation
 */
@WebServlet("/mulCalculation")
public class mulCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final Logger logger = LoggerFactory.getLogger(mulCalculation.class);

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int param1 = Integer.parseInt(request.getParameter("param1"));
		int param2 = Integer.parseInt(request.getParameter("param2"));
		HttpSession session = request.getSession();
		
		int mulResult = param1*param2;
		
		logger.debug("mulResult {}", mulResult);
		
		session.setAttribute("mulResult", mulResult);
		request.getRequestDispatcher("/jsp/mulResult.jsp").forward(request, response);
	}
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/jsp/mulInput.jsp").forward(req, resp);
	}
}
