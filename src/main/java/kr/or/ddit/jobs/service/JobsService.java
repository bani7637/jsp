package kr.or.ddit.jobs.service;

import java.util.List;

import kr.or.ddit.jobs.dao.JobsDao;
import kr.or.ddit.jobs.dao.JobsDaoI;
import kr.or.ddit.jobs.model.JobsVO;

public class JobsService implements JobsServiceI{

	@Override
	public List<JobsVO> selectAllJobs() {
		JobsDaoI jobsDao = new JobsDao();
		return jobsDao.selectAllJobs();
	}

}
