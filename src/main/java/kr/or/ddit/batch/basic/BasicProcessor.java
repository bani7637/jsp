package kr.or.ddit.batch.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

//@Component scan 방식으로 사용하려면 component로 사용할것!
public class BasicProcessor implements ItemProcessor<String, String>{

	private static final Logger logger = LoggerFactory.getLogger(BasicProcessor.class);
	
	@Override
	public String process(String item) throws Exception {
	logger.debug("=============Processer=============");	
	logger.debug("process :{},{}", item, item+"_modified");	
		return item+"_modified";
	}

}
