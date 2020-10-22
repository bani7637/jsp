package kr.or.ddit.file;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.FileUpload.FileUploadUtil;
import kr.or.ddit.cookie.CookieSplit;

public class fileUpload {
	private static final Logger logger = LoggerFactory.getLogger(fileUpload.class);

	@Test
	public void getFileNameTest() {
		/***Given***/
		String contentDisposition = "form-data; name=\"img\"; filename=\"pixaday.jpg\"";

		/***When***/
		String filename = FileUploadUtil.getFilename(contentDisposition);
		
		/***Then***/
		assertEquals("pixaday.jpg", filename);
	}

	@Test
	public void UUIDTest() {
		/***Given***/
		
		/***When***/
		String uuid = UUID.randomUUID().toString();
		logger.debug("uuid : {}",uuid);
		/***Then***/
	}
	
}
