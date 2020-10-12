package kr.or.ddit.db;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MybatisUtilTest {

	@Test
	public void getSqlSessionTest() {
		/***Given***/
		//test하려는 메소드는 static이기때문에 별도의 인스턴스 생성이 필요 없음
		
		/***When***/
		SqlSession sqlSession = MybatisUtil.getSqlSession();

		/***Then***/
		assertNotNull(sqlSession);
	}

}
