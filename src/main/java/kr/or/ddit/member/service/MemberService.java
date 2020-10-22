package kr.or.ddit.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.member.dao.MemberDao;
import kr.or.ddit.member.dao.MemberDaoI;
import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.model.PageVO;

public class MemberService implements MemberServiceI {
	private static final Logger logger = LoggerFactory.getLogger(MemberService.class);

	private MemberDaoI memberDao;
	
	public MemberService() {
		memberDao = new MemberDao();
	}
	
	@Override
	public MemberVO getMember(String userId) {
		return memberDao.getMember(userId);
	}

	@Override
	public List<MemberVO> selectAllMember() {
		return memberDao.selectAllMember();
	}
	@Override
	public Map<String, Object> selectMemberPageList(PageVO pv) {
		Map<String, Object>map = new HashMap<>();
		map.put("memberList", memberDao.selectMemberPageList(pv));
		// 15건, 페이지 사이즈를 7로 가정했을때 3개의 페이지가 나와야함
		// 15/7 =2.14...올림하여 3개의 페이지가 필요
		int totalCnt = memberDao.selectMemberTotalCount();
		int pages = (int)Math.ceil((double)(totalCnt)/pv.getPageSize());
		int pageSize = pv.getPageSize();
		map.put("pages", pages);
		map.put("pageSize",pageSize);
		return map;
	}

	@Override
	public int insertMember(MemberVO memberVO) {
		return memberDao.insertMember(memberVO);
	}

	@Override
	public int deleteMember(String userid) {
		return memberDao.deleteMember(userid);
	}

	@Override
	public int updateMember(MemberVO memberVO) {
		return memberDao.updateMember(memberVO);
	}

	

	



}
