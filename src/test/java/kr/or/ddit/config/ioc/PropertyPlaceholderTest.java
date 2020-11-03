package kr.or.ddit.config.ioc;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.config.ioc.Dbproperty;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:kr/or/ddit/config/spring/ioc/property-placeholder.xml"})

public class PropertyPlaceholderTest {
	
	@Resource(name ="dbProperty")
	private Dbproperty dbproperty;
	
	@Test
	public void PropertyPlaceHolderTest() {
		/***Given***/
		

		/***When***/

		/***Then***/
		assertEquals("bani", dbproperty.getUser());
		assertEquals("java", dbproperty.getPass());
	}

}
