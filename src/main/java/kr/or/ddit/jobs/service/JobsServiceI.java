package kr.or.ddit.jobs.service;

import java.util.List;

import kr.or.ddit.jobs.model.JobsVO;

public interface JobsServiceI {
	List<JobsVO> selectAllJobs();
}
