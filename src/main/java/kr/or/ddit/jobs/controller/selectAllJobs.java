package kr.or.ddit.jobs.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.jobs.model.JobsVO;
import kr.or.ddit.jobs.service.JobsService;
import kr.or.ddit.jobs.service.JobsServiceI;

/**
 * Servlet implementation class selectAllJobs
 */
@WebServlet("/selectAllJobs")
public class selectAllJobs extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(selectAllJobs.class);
    private JobsServiceI jobserService;   
    
    @Override
    	public void init() throws ServletException {
    	jobserService = new JobsService();
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<JobsVO> jobs  = jobserService.selectAllJobs();
		request.setAttribute("jobs", jobs);
		request.getRequestDispatcher("/jobs.jsp").forward(request, response);
		
	}


}
