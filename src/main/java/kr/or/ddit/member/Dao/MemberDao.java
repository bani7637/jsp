package kr.or.ddit.member.Dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.model.MemberVO;

@Repository("MemberDao")
public class MemberDao implements MemberDaoI{
	
	@Override
	public MemberVO getMember(String userid) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		MemberVO memberVo = sqlSession.selectOne("member.getMember", userid);
		sqlSession.close();
		
		return memberVo;
	}

}
