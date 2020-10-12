package kr.or.ddit.jobs.dao;

import java.util.List;

import kr.or.ddit.jobs.model.JobsVO;

public interface JobsDaoI {
	List<JobsVO> selectAllJobs();
}
