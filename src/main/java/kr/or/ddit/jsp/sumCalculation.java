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
@WebServlet("/sumCalculation")
public class sumCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final Logger logger = LoggerFactory.getLogger(sumCalculation.class);

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int start = Integer.parseInt(request.getParameter("start"));
		int end = Integer.parseInt(request.getParameter("end"));
		HttpSession session = request.getSession();
		
		int sumResult = 0; 
		for(int i=start; i<=end; i++) {
			sumResult += i;
		}
		
		logger.debug("sumResult {}", sumResult);
		
		session.setAttribute("sumResult", sumResult);
		request.getRequestDispatcher("/jsp/sumResult.jsp").forward(request, response);
	}
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/jsp/input.jsp").forward(req, resp);
	}
}
