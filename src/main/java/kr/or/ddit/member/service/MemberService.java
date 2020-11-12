package kr.or.ddit.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.member.Dao.MemberDaoI;
import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.model.PageVO;

@Transactional
@Service("MemberService")
public class MemberService implements MemberServiceI{
	private static final Logger logger = LoggerFactory.getLogger(MemberService.class);

	//재사용하기 위해서 꼭 해야할것! 
	@Resource(name = "memberDao")	
	private MemberDaoI memberDao;
	
	public MemberService() {
		//memberDao = new MemberDao();
	}
	

	@Override
	public MemberVO getMember(String userid) {
		return memberDao.getMember(userid);
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
		
//		logger.debug("1번째 insert 시작 전");
//		memberDao.insertMember(memberVO);
//		logger.debug("1번째 insert 종료 후");
//		logger.debug("-----------------------");
//
//		logger.debug("2번째 insert 시작 전");
//		memberDao.insertMember(memberVO);
//		logger.debug("2번째 insert 종료 후");
//		
//		return 1;
		
//		1번째 쿼리는 정상적으로 성공하지만 2번째 쿼리에서 동일한 데이터를 입력하여
//		primary key 제약조건에 의해 sql 실행 실패
//		트랜잭션 설정을 service 레벨에 설정을 하였기 때문에 서비스 메서드에서 실행된 모든 쿼리를 
//		자동으로 롤백처리 => 1번 쿼리 적용x
		
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
