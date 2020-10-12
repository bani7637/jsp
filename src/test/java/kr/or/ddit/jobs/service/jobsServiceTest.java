package kr.or.ddit.jobs.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.jobs.model.JobsVO;

public class jobsServiceTest {

	@Test
	public void getAllJobsTest() {
		/***Given***/
		JobsServiceI jobsService = new JobsService();
		
		/***When***/
		List<JobsVO> jobList = jobsService.selectAllJobs();
		/***Then***/
		assertEquals(19, jobList.size());
	}

}
