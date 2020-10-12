package kr.or.ddit.jobs.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.jobs.model.JobsVO;

public class JobsDaoTest {

	@Test
	public void getAllJobsTest() {
		/***Given***/
		JobsDaoI jobsDao = new JobsDao();

		/***When***/
		List<JobsVO> jobList = jobsDao.selectAllJobs();
		
		/***Then***/
		assertEquals(19, jobList.size());
	}

}
