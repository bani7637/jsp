package kr.or.ddit.config.ioc;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.ioc.CollectionBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:kr/or/ddit/config/spring/ioc/collection.xml" })
public class IocCollectionTest {

	@Resource(name = "collectionBean")
	private CollectionBean collection;

	@Test
	public void MapTest() {
		/*** Given ***/
		Map<String, String> map;
		
		/*** When ***/
		map = collection.getMap();
		
		/*** Then ***/
		assertEquals("brown", map.get("name"));
	}

	@Test
	public void setTest() {
		/*** Given ***/
		Set<String> set;
		
		/*** When ***/
		set = collection.getSet();
		
		/*** Then ***/
		assertEquals(3, set.size());
	}

	@Test
	public void ListTest() {
		/*** Given ***/
		List<String> list;
		
		/*** When ***/
		list = collection.getList();
		
		/*** Then ***/
		assertEquals(3, list.size());
	}

	@Test
	public void propertiesTest() {
		/*** Given ***/
		Properties properties;
		
		/*** When ***/
		properties = collection.getProperties();
		
		/*** Then ***/	
		assertEquals("bani", properties.get("jdbc.user"));
		assertEquals("java", properties.get("jdbc.pass"));

	}

}
