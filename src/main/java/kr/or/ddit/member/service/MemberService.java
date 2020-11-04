package kr.or.ddit.member.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.member.Dao.MemberDao;
import kr.or.ddit.member.Dao.MemberDaoI;
import kr.or.ddit.member.model.MemberVO;
@Service("MemberService")
public class MemberService implements MemberServiceI{

	//재사용하기 위해서 꼭 해야할것! 
	@Resource(name = "MemberDao")	
	private MemberDaoI memberDao;
	
	public MemberService() {
		memberDao = new MemberDao();
	}
	

	@Override
	public MemberVO getMember(String userid) {
		return memberDao.getMember(userid);
	}

}
